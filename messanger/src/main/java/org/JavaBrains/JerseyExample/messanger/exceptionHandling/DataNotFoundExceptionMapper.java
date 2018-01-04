package org.JavaBrains.JerseyExample.messanger.exceptionHandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.JavaBrains.JerseyExample.messanger.model.ErrorMessage;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage errorMsg = new ErrorMessage(ex.getMessage(),404,"http://google.com"); 
		return Response.status(Status.NOT_FOUND).entity(errorMsg).build();
	}

}
