package com.microlecture.manager;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public final class JSONUtil {
	
	public static String beanToJSON(Object obj){
		Gson gson = new Gson();		
		return gson.toJson(obj);
	}

	public static Object JSONToBean(String json,Class<?> classOfT){
		//System.out.println(json);
		Gson gson = new Gson();		
		return gson.fromJson(json.trim(), classOfT);
	}
	/*public static TypeToken<Object> JSONToList(String json,Type type){
		Gson gson = new Gson();	
		return gson.fromJson(json, type);
	}*/
	public static Object JSONToList(String json,Type type){
		Gson gson = new Gson();		
		return gson.fromJson(json,type);
	}
}
