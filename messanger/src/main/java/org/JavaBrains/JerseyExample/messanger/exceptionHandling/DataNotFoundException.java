package org.JavaBrains.JerseyExample.messanger.exceptionHandling;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7918027786317421056L;
	
	
	public DataNotFoundException(String string){
		super(string);
	}


}
	