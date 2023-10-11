package com.aem.geeks.core.models;


import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables=Resource.class)
public class Student {
	@Inject
	public String studentname;
	
	@Inject
	public String sname;
	
	@Inject
	public String studentid;
	
	public String getStudentname()
	{
		return studentname;
	}
	
	public String getSname()
	{
		return studentname;
	}
	public String getStudentid()
	{
		return studentid;
	}

}


