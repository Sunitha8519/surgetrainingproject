package com.aem.geeks.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service=Servlet.class)
@SlingServletPaths(
        value = {"/bin/pages"}
)
public class Studentservlet extends SlingSafeMethodsServlet{
@Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws IOException{
        final ResourceResolver resourceResolver = req.getResourceResolver();
        Page page = resourceResolver.adaptTo(PageManager.class).getPage("/content/aemgeeks/us/en");
        JSONArray pagesArray = new JSONArray();
         
            Iterator<Page> childPages = page.listChildren();
            while (childPages.hasNext()) {
                Page childPage = childPages.next();
                JSONObject pageObject = new JSONObject();
                try {
                    pageObject.put(childPage.getTitle(), childPage.getPath().toString());
                    pagesArray.put(pageObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                
            }
        resp.getWriter().write(pagesArray.toString());
}
    
}
