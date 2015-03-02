package com.epam.command;
import java.util.HashMap;
import java.util.Map;

public class Request {

	private Map<String, Object[]> parameters = new HashMap<String, Object[]>();
	
	public void setParam(String key, Object ...obj){
		Object[] af = new Object[2];
		for(int i = 0; i < obj.length; i++){
			af[i] = obj[i];
		}
		parameters.put(key, af);
	}

	public void setParam(String key){
		Object[] defaultObj = new Object[0];
		parameters.put(key, defaultObj);
	}
	
	public Object[] getParam(String key){
		return parameters.get(key);
	}

	
	
}
