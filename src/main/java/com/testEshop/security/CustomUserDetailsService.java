package com.testEshop.security;

import com.testEshop.model.entity.Client;
import com.testEshop.model.entity.ClientProfile;
import com.testEshop.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vastl271nko on 06.09.16.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private ClientService clientService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String ssoId)
            throws UsernameNotFoundException {
        Client client = clientService.findBySSO(ssoId);
        logger.info("User : {}", client);
        if(client==null){
            logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(client.getSsoId(), client.getPassword(),
                true, true, true, true, getGrantedAuthorities(client));
    }


    private List<GrantedAuthority> getGrantedAuthorities(Client client){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(ClientProfile userProfile : client.getClientProfiles()){
            logger.info("UserProfile : {}", userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        logger.info("authorities : {}", authorities);
        return authorities;
    }

}
