package com.jihad.example.Todolist.utils;



import org.springframework.http.HttpStatus;

import lombok.Data;


@Data
public class APIResponse {

	
	  private HttpStatus status;
	    private String message;
	    private String token;
	    
	
    public APIResponse( String message,HttpStatus status, String token) {
        this.status = status;
        this.message = message;
        this.token=token;
    }


	public APIResponse(String message, HttpStatus status) {
		 this.status = status;
	        this.message = message;
	}


}