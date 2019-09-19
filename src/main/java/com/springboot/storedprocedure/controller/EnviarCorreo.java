package com.springboot.storedprocedure.controller;

import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.storedprocedure.model.Usuario;
import com.springboot.storedprocedure.repository.Usuariodao;
import com.springboot.storedprocedure.request.enviarEmailRequest;
import com.springboot.storedprocedure.request.id_restauracion_;
import com.springboot.storedprocedure.request.inicioSesionRequest;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/email")
public class EnviarCorreo {
	
	
	@Autowired
    private JavaMailSender mailSender;

	@Autowired
	Usuariodao Usudao;
	
	@PostMapping(value= "/")
	public String verificarcorreo2(@Valid @RequestBody enviarEmailRequest em) {

		SimpleMailMessage email = new SimpleMailMessage();
		
		String password = Usudao.restablecerCorreo(em.getEmail());
		if(password.equals("NO_DATA_FOUND"))
			return "0";
		
		email.setTo(em.getEmail());
        email.setSubject("Restauración de contrasña");
        email.setText("Su contraseña es: "+password+"  Por favor no olvide su contraseña" );
        
        mailSender.send(email);
		return "Se envio la contraseña a tu correo "+em.getEmail()+" ---Su contraseña es : "+password;
		
		
	}
	
	
	@PostMapping(value= "/send")
	public String MandarCorreo(@Valid @RequestBody enviarEmailRequest em) {

		SimpleMailMessage email = new SimpleMailMessage();
		
		Long id= new Long ("123456");
		
		Iterable<Usuario> datos = Usudao.get_datos_pass(id);
		
		
		String password = Usudao.restablecerCorreo(em.getEmail());
		if(password.equals("NO_DATA_FOUND"))
			return "0";
		
		email.setTo(em.getEmail());
        email.setSubject("Restauración de contrasña");
        email.setText("Su contraseña es: "+password+"  Por favor no olvide su contraseña" );
        
        mailSender.send(email);
		return "Se envio la contraseña a tu correo "+em.getEmail()+" ---Su contraseña es : "+password;
		
		
	}
	
	
	
	@PostMapping(value= "/enviar")
	public String enviarCorreo(@Valid @RequestBody id_restauracion_ em) {

		SimpleMailMessage email = new SimpleMailMessage();
		
		Long id= new Long (em.getId());
		
		String  nombre = Usudao.get_nombre_for_correo(id);
		String  correo = Usudao.get_email_for_correo(id);
		String  password = Usudao.get_password_for_correo(id);
		
		
		if(password.equals("0"))
			return "0";
		
		email.setTo(correo);
        email.setSubject("Restauración de contrasña");
        email.setText("Hola "+nombre +" Su contraseña es: "+password+"  Por favor no olvide su contraseña" );
        
        mailSender.send(email);
		return correo;
		
		
	}
	
	
	

	
	
}