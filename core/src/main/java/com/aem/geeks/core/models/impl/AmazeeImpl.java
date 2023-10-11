package com.aem.geeks.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.geeks.core.models.Amaz;

@Model(adaptables=SlingHttpServletRequest.class,adapters=Amaz.class)
public class AmazeeImpl implements Amaz {
    @ValueMapValue
    public String text;
    @ValueMapValue
    public String image;
    public String getText() {
        return text;
    }
    public String getImage() {
        return image;
    }
        
    

    
}
