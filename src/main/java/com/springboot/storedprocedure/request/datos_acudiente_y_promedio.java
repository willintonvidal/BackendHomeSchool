package com.springboot.storedprocedure.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class datos_acudiente_y_promedio {
    @NotBlank
    @Email
    private String correo;

    @NotBlank
    private String nom_acudiente;
    
    @NotBlank
    private String nom_estudiante;
    
    @NotBlank
    private String promedio;
    
    @NotBlank
    private String materia;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNom_acudiente() {
		return nom_acudiente;
	}

	public void setNom_acudiente(String nom_acudiente) {
		this.nom_acudiente = nom_acudiente;
	}

	public String getNom_estudiante() {
		return nom_estudiante;
	}

	public void setNom_estudiante(String nom_estudiante) {
		this.nom_estudiante = nom_estudiante;
	}

	public String getPromedio() {
		return promedio;
	}

	public void setPromedio(String promedio) {
		this.promedio = promedio;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}


    
}