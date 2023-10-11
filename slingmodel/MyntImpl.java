package com.aem.geeks.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.geeks.core.models.Myttr;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters =Myttr.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MyntImpl implements Myttr{
    @ValueMapValue
    public String text;
    @ValueMapValue
    public String location;
    
    public String getText() {
        return text;
    }
    public String getLocation() {
        return location;
    }  
}
