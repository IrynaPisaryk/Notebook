package com.epam.command;

import java.util.HashMap;
import java.util.Map;

public class Request {

	private Map<String, Object[]> parameters = new HashMap<String, Object[]>();
	private String key;

	public void setParam(String key, Object... obj) {
		Object[] af = new Object[3];
		for (int i = 0; i < obj.length; i++) {
			af[i] = obj[i];
		}
		parameters.put(key, af);
		this.key = key;
	}

	public void setParam(String key) {
		parameters.put(key, null);
	}

	public Object[] getParam(String key) {
		return parameters.get(key);
	}

	public String getKey() {
		return key;
	}
}
