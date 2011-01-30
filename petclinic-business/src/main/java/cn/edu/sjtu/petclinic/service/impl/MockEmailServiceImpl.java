package cn.edu.sjtu.petclinic.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.sjtu.petclinic.dto.EmailRequest;
import cn.edu.sjtu.petclinic.service.EmailService;

@Service
public class MockEmailServiceImpl extends AbstractService implements EmailService {

	@Override
	public void sendEmail(EmailRequest emailRequest) {
		// TODO Auto-generated method stub
		
	}

}
