package cn.edu.sjtu.petclinic.web.controller;

public final class ViewNames {

	public static final String JSON_VIEW = "json1";
	
	/* veterinarain and petowner shared views */
	public static final String FORWARD_LOGIN = "login";
	public static final String REDIRECT_LOGIN = "redirect:/login";
	
	/* veterinarian views */
	public static final String REDIRECT_VETERINARIAN_HOME = "redirect:/veterinarian/home";
	
	/* petowner views */
	public static final String REDIRECT_PETOWNER_HOME = "redirect:/petowner/home";
	
	/* admin views */
	public static final String FORWARD_ADMIN_LOGIN = "admin/login";
	public static final String REDIRECT_ADMIN_LOGIN = "redirect:/adminLogin";
	public static final String REDIRECT_ADMIN_HOME = "redirect:/admin/home";
	public static final String FORWARD_ADMIN_CLINIC_FORM_STEP1 = "admin/clinic/form/step1";
	public static final String FORWARD_ADMIN_CLINIC_FORM_STEP2 = "admin/clinic/form/step2";
	public static final String FORWARD_ADMIN_CLINIC_FORM_MESSAGE = "admin/clinic/form/message";
	public static final String FORWARD_ADMIN_CLINIC_QUERY_FORM = "admin/clinic/query/form";
	public static final String FORWARD_ADMIN_CLINIC_QUERY_RESULT = "admin/clinic/query/result";
	
}
