package com.epam.command;
import java.util.HashMap;
import java.util.Map;

public class Response {

	private Map<String, Object> responses = new HashMap<String, Object>();
	
	public Response(String key, Object obj){
		responses.put(key, obj);
	}
	
	public Object getParam(String key){
		return responses.get(key);
		
	}	
}
