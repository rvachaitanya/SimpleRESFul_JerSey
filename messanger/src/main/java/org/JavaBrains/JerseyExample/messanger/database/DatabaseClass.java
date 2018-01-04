package org.JavaBrains.JerseyExample.messanger.database;

import java.util.HashMap;
import java.util.Map;

import org.JavaBrains.JerseyExample.messanger.model.Message;
import org.JavaBrains.JerseyExample.messanger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long,Message> message = new HashMap<>();
	private static Map<String,Profile> profile = new HashMap<>();
	
	public static Map<Long, Message> getMessage() {
		return message;
	}
	public static Map<String, Profile> getProfile() {
		return profile;
	}

	
	
}
