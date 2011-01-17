package cn.edu.sjtu.petclinic.service;

import cn.edu.sjtu.petclinic.dto.EmailRequest;

public interface EmailService {

	public void sendEmail(EmailRequest emailRequest);
	
}
