package com.springboot.storedprocedure.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class id_restauracion_ {
	
	@NotBlank
    @Size(min=1, max = 60)
    private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

		
		
    
    
    
	
	
    

    
	

}
