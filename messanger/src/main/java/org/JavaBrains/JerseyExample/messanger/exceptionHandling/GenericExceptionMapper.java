package org.JavaBrains.JerseyExample.messanger.exceptionHandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.JavaBrains.JerseyExample.messanger.model.ErrorMessage;


public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable arg0) {
		// TODO Auto-generated method stub
		ErrorMessage errorMsg = new ErrorMessage(arg0.getMessage(),500,"http://www.google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMsg).build();
	}
	
}
