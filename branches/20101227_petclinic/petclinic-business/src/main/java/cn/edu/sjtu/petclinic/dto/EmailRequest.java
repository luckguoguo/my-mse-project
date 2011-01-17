package cn.edu.sjtu.petclinic.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EmailRequest implements Serializable {

	private static final long serialVersionUID = -7177543463020064295L;

	private String fromEmailAddress;
	
	private String toEmailAddress;
	
	private Map<String, Object> model = new HashMap<String, Object>();
	
	public String getFromEmailAddress() {
		return fromEmailAddress;
	}

	public void setFromEmailAddress(String fromEmailAddress) {
		this.fromEmailAddress = fromEmailAddress;
	}

	public String getToEmailAddress() {
		return toEmailAddress;
	}

	public void setToEmailAddress(String toEmailAddress) {
		this.toEmailAddress = toEmailAddress;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
}
