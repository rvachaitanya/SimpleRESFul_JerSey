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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.JavaBrains.JerseyExample.messanger.model.Message;
import org.JavaBrains.JerseyExample.messanger.service.MessageService;

@Path("/message")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value ={MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public class MessageResource {
	
	public MessageService msg = new MessageService();
	
	@GET
	public List<Message> getMessage(@QueryParam("year") int year,
									@QueryParam("start") int start,
									@QueryParam("size") int size){
		if(year>0){
			return msg.getAllMessagesForYear(year);
		}
		if(start>=0 && size>0){
			return msg.getAllMessagesPaginated(start, size);
		}
		return msg.getAllMessages();
	}
	
	@POST
	public Message  postMessage(Message message){
		return msg.setMessage(message);
	}
	
	
	@PUT
	@Path("{messageId}")
	public Message updateMessage(@PathParam("messageId") long id,Message message){
		message.setId(id);
		return msg.updateMessage(message);
	}
	
	@DELETE
	@Path("{messageId}")
	public void removeData(@PathParam("messageId") long id, Message message){
		msg.removeMessage(id);
	}
	
	@GET
	@Path("{messageId}/comment")
	public String test(){
		return "test";
	}
}
