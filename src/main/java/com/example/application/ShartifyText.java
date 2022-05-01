package com.example.application;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;

@Tag("random-text")
@JsModule("./shartious.js")
public class ShartifyText extends LitTemplate {

    public ShartifyText(String text){
        setStartText(text);
    }

    public String getText(){
        return getElement().getProperty("text");
    }

    public String getStartText(){
        return getElement().getProperty("startText");
    }

    public void setStartText(String text){
        getElement().setProperty("startText", text);
        getElement().setProperty("text", text);
    }

}
