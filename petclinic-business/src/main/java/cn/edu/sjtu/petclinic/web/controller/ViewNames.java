package cn.edu.sjtu.petclinic.web.controller;

public final class ViewNames {

	public static final String JSON_VIEW = "json1";
	
	/* veterinarain and petowner shared views */
	public static final String FORWARD_LOGIN = "login";
	public static final String REDIRECT_LOGIN = "redirect:/login";
	public static final String FORWARD_REGISTER = "register";
	public static final String FORWARD_REQUEST_TEMPPASSWORD_FORM = "requestTempPassword/form";
	public static final String FORWARD_REQUEST_TEMPPASSWORD_FORM_MESSAGE = "requestTempPassword/form/message";
	public static final String FORWARD_CLINIC_QUERY_FORM = "clinic/query/form";
	public static final String FORWARD_CLINIC_QUERY_RESULT = "clinic/query/result";
	public static final String FORWARD_CLINIC_QUERY_DETAIL = "clinic/query/detail";
	public static final String FORWARD_VETERINARIAN_QUERY_FORM = "veterinarian/query/form";
	public static final String FORWARD_VETERINARIAN_QUERY_RESULT = "veterinarian/query/result";
	public static final String FORWARD_VETERINARIAN_QUERY_DETAIL = "veterinarian/query/detail";
	
	/* veterinarian views */
	public static final String REDIRECT_VETERINARIAN_HOME = "redirect:/veterinarian/home";
	public static final String FORWARD_VETERINARIAN_PROFILE = "veterinarian/profile";
	public static final String FORWARD_VETERINARIAN_PASSWORD_FORM = "veterinarian/password/form";
	public static final String FORWARD_VETERINARIAN_PASSWORD_FORM_MESSAGE = "veterinarian/password/form/message";
	public static final String FORWARD_VETERINARIAN_INTERROGATION_QUERY_FORM = "veterinarian/interrogation/query/form";
	public static final String FORWARD_VETERINARIAN_INTERROGATION_QUERY_RESULT = "veterinarian/interrogation/query/result";
	public static final String FORWARD_VETERINARIAN_INTERROGATION_QUERY_DETAIL = "veterinarian/interrogation/query/detail";
	public static final String FORWARD_VETERINARIAN_DIAGNOSIS_FORM = "veterinarian/diagnosis/form";
	public static final String FORWARD_VETERINARIAN_DIAGNOSIS_FORM_ERROR = "veterinarian/diagnosis/form/error";
	public static final String FORWARD_VETERINARIAN_DIAGNOSIS_FORM_MESSAGE = "veterinarian/diagnosis/form/message";
	public static final String FORWARD_VETERINARIAN_DIAGNOSIS_QUERY_FORM = "veterinarian/diagnosis/query/form";
	public static final String FORWARD_VETERINARIAN_DIAGNOSIS_QUERY_RESULT = "veterinarian/diagnosis/query/result";
	public static final String FORWARD_VETERINARIAN_DIAGNOSIS_QUERY_DETAIL = "veterinarian/diagnosis/query/detail";
	public static final String FORWARD_VETERINARIAN_PETOWNER_PROFILE = "veterinarian/petowner/profile";
	public static final String FORWARD_VETERINARIAN_DAILYOUTPATIENT_FORM = "veterinarian/dailyoutpatient/form";
	public static final String FORWARD_VETERINARIAN_DAILYOUTPATIENT_FORM_MESSAGE = "veterinarian/dailyoutpatient/form/message";
	public static final String FORWARD_VETERINARIAN_DAILYOUTPATIENT_QUERY_FORM = "veterinarian/dailyoutpatient/query/form";
	public static final String FORWARD_VETERINARIAN_DAILYOUTPATIENT_QUERY_RESULT = "veterinarian/dailyoutpatient/query/result";
	public static final String FORWARD_VETERINARIAN_DAILYOUTPATIENT_APPOINTMENTS = "veterinarian/dailyoutpatient/appointments";
	
	/* petowner views */
	public static final String REDIRECT_PETOWNER_HOME = "redirect:/petowner/home";
	public static final String FORWARD_PETOWNER_PROFILE = "petowner/profile";
	public static final String FORWARD_PETOWNER_PASSWORD_FORM = "petowner/password/form";
	public static final String FORWARD_PETOWNER_PASSWORD_FORM_MESSAGE = "petowner/password/form/message";
	public static final String FORWARD_PETOWNER_PET_FORM = "petowner/pet/form";
	public static final String FORWARD_PETOWNER_PET_FORM_MESSAGE = "petowner/pet/form/message";
	public static final String FORWARD_PETOWNER_PET_QUERY_FORM = "petowner/pet/query/form";
	public static final String FORWARD_PETOWNER_PET_QUERY_RESULT = "petowner/pet/query/result";
	public static final String FORWARD_PETOWNER_CLINIC_QUERY_FORM = "petowner/clinic/query/form";
	public static final String FORWARD_PETOWNER_CLINIC_QUERY_RESULT = "petowner/clinic/query/result";
	public static final String FORWARD_PETOWNER_CLINIC_QUERY_DETAIL = "petowner/clinic/query/detail";
	public static final String FORWARD_PETOWNER_VETERINARIAN_QUERY_FORM = "petowner/veterinarian/query/form";
	public static final String FORWARD_PETOWNER_VETERINARIAN_QUERY_RESULT = "petowner/veterinarian/query/result";
	public static final String FORWARD_PETOWNER_VETERINARIAN_QUERY_DETAIL = "petowner/veterinarian/query/detail";
	public static final String FORWARD_PETOWNER_INTERROGATION_FORM = "petowner/interrogation/form";
	public static final String FORWARD_PETOWNER_INTERROGATION_FORM_ERROR = "petowner/interrogation/form/error";
	public static final String FORWARD_PETOWNER_INTERROGATION_FORM_MESSAGE = "petowner/interrogation/form/message";
	public static final String FORWARD_PETOWNER_INTERROGATION_QUERY_FORM = "petowner/interrogation/query/form";
	public static final String FORWARD_PETOWNER_INTERROGATION_QUERY_RESULT = "petowner/interrogation/query/result";
	public static final String FORWARD_PETOWNER_INTERROGATION_QUERY_DETAIL = "petowner/interrogation/query/detail";
	public static final String FORWARD_PETOWNER_DAILYOUTPATIENT_QUERY_FORM = "petowner/dailyoutpatient/query/form";
	public static final String FORWARD_PETOWNER_DAILYOUTPATIENT_QUERY_RESULT = "petowner/dailyoutpatient/query/result";
	public static final String FORWARD_PETOWNER_DAILYOUTPATIENT_APPOINTMENT_MESSAGE = "petowner/dailyoutpatient/appointment/message";
	public static final String FORWARD_PETOWNER_APPOINTMENT_QUERY_FORM = "petowner/appointment/query/form";
	public static final String FORWARD_PETOWNER_APPOINTMENT_QUERY_RESULT = "petowner/appointment/query/result";
	
	/* admin views */
	public static final String FORWARD_ADMIN_LOGIN = "admin/login";
	public static final String REDIRECT_ADMIN_LOGIN = "redirect:/adminLogin";
	public static final String FORWARD_ADMIN_REQUEST_TEMPPASSWORD_FORM = "admin/requestTempPassword/form";
	public static final String FORWARD_ADMIN_REQUEST_TEMPPASSWORD_FORM_MESSAGE = "admin/requestTempPassword/form/message";
	public static final String REDIRECT_ADMIN_HOME = "redirect:/admin/home";
	public static final String FORWARD_ADMIN_PASSWORD_FORM = "admin/password/form";
	public static final String FORWARD_ADMIN_PASSWORD_FORM_MESSAGE = "admin/password/form/message";
	public static final String FORWARD_ADMIN_CLINIC_FORM_STEP1 = "admin/clinic/form/step1";
	public static final String FORWARD_ADMIN_CLINIC_FORM_STEP2 = "admin/clinic/form/step2";
	public static final String FORWARD_ADMIN_CLINIC_FORM_MESSAGE = "admin/clinic/form/message";
	public static final String FORWARD_ADMIN_CLINIC_QUERY_FORM = "admin/clinic/query/form";
	public static final String FORWARD_ADMIN_CLINIC_QUERY_RESULT = "admin/clinic/query/result";
	public static final String FORWARD_ADMIN_VETERINARIAN_FORM_STEP1 = "admin/veterinarian/form/step1";
	public static final String FORWARD_ADMIN_VETERINARIAN_FORM_STEP2 = "admin/veterinarian/form/step2";
	public static final String FORWARD_ADMIN_VETERINARIAN_FORM_MESSAGE = "admin/veterinarian/form/message";
	public static final String FORWARD_ADMIN_VETERINARIAN_QUERY_FORM = "admin/veterinarian/query/form";
	public static final String FORWARD_ADMIN_VETERINARIAN_QUERY_RESULT = "admin/veterinarian/query/result";
	
}
