package org.JavaBrains.JerseyExample.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.JavaBrains.JerseyExample.messanger.database.DatabaseClass;
import org.JavaBrains.JerseyExample.messanger.model.Profile;

public class ProfileService {
	private Map<String,Profile> profiles = DatabaseClass.getProfile();
	
	public ProfileService(){
		profiles.put("rva", new Profile(1L,"rva","chaitanya","Develoepr"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profile){
		return profiles.get(profile);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
 }
