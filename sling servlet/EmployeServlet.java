package com.aem.geeks.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.json.JsonObject;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
@Component(service=Servlet.class)
@SlingServletPaths(value={"/bin/employe"})

public class EmployeServlet extends SlingSafeMethodsServlet {
    @Reference
    protected void doGet(SlingHttpServletRequest req,SlingHttpServletResponse res) throws IOException{
        ResourceResolver resourceResolver = req.getResourceResolver();
        String Path=req.getParameter("Path");

        Page page =  resourceResolver.adaptTo(PageManager.class).getPage(Path);
        JSONArray jsonArray=new JSONArray();
        Iterator<Page> listChildren = page.listChildren();
        while(listChildren.hasNext()){
            Page listChild=listChildren.next();
             JSONObject JsonObject = new JSONObject();
             try {
                JsonObject.put(listChild.getTitle(),listChild.getPath().toString());
                jsonArray.put(JsonObject);
            } catch (JSONException e){
               e.printStackTrace();  
            }
                
            } 
        
            res.setContentType("application/json");
            res.getWriter().write(jsonArray.toString());
        }
    }



