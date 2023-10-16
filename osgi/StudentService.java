package com.aem.geeks.core.services;

import java.util.Iterator;

import org.apache.sling.api.SlingHttpServletRequest;

import com.day.cq.wcm.api.Page;

public interface StudentService {
    Iterator<Page> getlistChildren(SlingHttpServletRequest req);
}
