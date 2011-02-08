package cn.edu.sjtu.petclinic.service.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.petclinic.dto.EmailRequest;
import cn.edu.sjtu.petclinic.service.EmailService;

@Service
public class MockEmailServiceImpl extends AbstractService implements EmailService {

	@Override
	public void sendEmail(EmailRequest emailRequest) {
		log.info(ToStringBuilder.reflectionToString(emailRequest, ToStringStyle.MULTI_LINE_STYLE));
	}

}
