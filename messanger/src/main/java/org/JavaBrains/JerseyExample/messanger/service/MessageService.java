package org.JavaBrains.JerseyExample.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.JavaBrains.JerseyExample.messanger.database.DatabaseClass;
import org.JavaBrains.JerseyExample.messanger.exceptionHandling.DataNotFoundException;
import org.JavaBrains.JerseyExample.messanger.model.Message;
import org.JavaBrains.JerseyExample.messanger.resources.MessageResource;
import org.JavaBrains.JerseyExample.messanger.resources.ProfileResource;


public class MessageService {
	
	private Map<Long,Message> message = DatabaseClass.getMessage();
	
	public MessageService(){
		message.put(1L,new Message(1,"Hello World","rva"));
		message.put(2L,new Message(2,"hibernate","chaitu"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(message.values());
	}
	
	public Message getMessage(long id){
		Message msg = message.get(id);
		if(msg == null){
			throw new DataNotFoundException("Message with "+id+" is not found");
		}
		return message.get(id);
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messageForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message: message.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size){
		ArrayList<Message> list = new ArrayList<Message>(message.values());
		if(start+size> list.size())return new ArrayList<Message>();
		return list.subList(start, start+size);
	}
	
	public Message setMessage(Message msg){
		msg.setId(message.size()+1);
		message.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg){
		if(msg.getId()<=0) return null;
		message.put(msg.getId(),msg);
		return msg;
	}
	
	public Message removeMessage(long id){
		return message.remove(id);
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(long messageId, UriInfo uriInfo ){
		Message localmsg = getMessage(messageId);
		localmsg.addLink(getUri(uriInfo, localmsg), "self");
		//localmsg.addLink(getUriProfile(uriInfo, localmsg), "profile");
		return localmsg;
	}

	/*private String getUriProfile(UriInfo uriInfo, Message localmsg) {
		String uri = uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(localmsg.getAuthor()).build().toString();
		return uri ;
	}*/

	private String getUri(UriInfo uriInfo, Message localmsg) {
		String uri =uriInfo.getBaseUriBuilder().path(MessageResource.class).path(Long.toString(localmsg.getId())).build().toString();
		return uri;
	}
}
