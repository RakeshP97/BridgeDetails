package com.bridge.model;

import java.io.Serializable;

public class Bridge implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String length;
	private String height;
	private String width;
	private String gpsLocation;
	public Bridge()
	{
		name ="";
		length="";
		height="";
		width="";
		gpsLocation="";
		
	}
	public Bridge(String name, String length,String height, String width, String gpsLocation)
	{
		this.name = name;
		this.length = length;
		this.height = height;
		this.width = width;
		this.gpsLocation = gpsLocation;
		
	}
	
	
	
	
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getGpsLocation() {
		return gpsLocation;
	}
	public void setGpsLocation(String gpsLocation) {
		this.gpsLocation = gpsLocation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	
	  @Override
	    public String toString() {
	        return "Bridge [id=" + name + ", firstName=" + length + "]";
	    }

}
