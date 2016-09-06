package com.testEshop.converter;

import com.testEshop.model.entity.ClientProfile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by vastl271nko on 06.09.16.
 */
@Component
public class RoleToClientConverter implements Converter<Object, ClientProfile> {
    @Override
    public ClientProfile convert(Object o) {
        return null;
    }
}
