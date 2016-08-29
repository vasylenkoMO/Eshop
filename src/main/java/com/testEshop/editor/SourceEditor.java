package com.testEshop.editor;

import com.testEshop.model.entity.Source;
import com.testEshop.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/**
 * Created by vastl271nko on 29.08.16.
 */
@Component
public class SourceEditor extends PropertyEditorSupport {

    @Autowired
    private SourceService sourceService;

    @Override
    public void setAsText(String text) {
        Source source = this.sourceService.findBySourceName(text);

        this.setValue(source);
    }
}
