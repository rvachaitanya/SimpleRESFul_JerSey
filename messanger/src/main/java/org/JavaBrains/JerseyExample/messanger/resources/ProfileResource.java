package org.JavaBrains.JerseyExample.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.JavaBrains.JerseyExample.messanger.model.Profile;
import org.JavaBrains.JerseyExample.messanger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profService= new ProfileService();
	
	@GET
	public List<Profile> getProfiles(){
		return profService.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return profService.addProfile(profile); 
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName){
			return profService.getProfile(profileName);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile){
		profile.setProfileName(profileName);
		return profService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName){
		profService.removeProfile(profileName);
	}

}
