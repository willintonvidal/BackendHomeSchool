package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class promedio_tema_request {
    @NotBlank
    private String id;

    @NotBlank
    private String tem_id;
    
    @NotBlank
    private String mat_id;

	public String getMat_id() {
		return mat_id;
	}

	public void setMat_id(String mat_id) {
		this.mat_id = mat_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTem_id() {
		return tem_id;
	}

	public void setTem_id(String tem_id) {
		this.tem_id = tem_id;
	}
    
    

   
}