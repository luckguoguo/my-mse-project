package cn.edu.sjtu.common.spring.tiles2.ext;

import org.springframework.web.servlet.view.tiles2.TilesView;
import org.springframework.web.servlet.view.AbstractTemplateView;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import java.util.Map;

public class ExtTilesView extends TilesView {

	private boolean exposeSpringMacroModel = false;

	public void setExposeSpringMacroModel(boolean exposeSpringMacroModel) {
		this.exposeSpringMacroModel = exposeSpringMacroModel;
	}

	@SuppressWarnings("unchecked")
	protected final void renderMergedOutputModel(Map model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if (exposeSpringMacroModel) {
			if (model.containsKey(AbstractTemplateView.SPRING_MACRO_REQUEST_CONTEXT_ATTRIBUTE)) {
				throw new ServletException("Cannot expose bind macro helper '" +
						AbstractTemplateView.SPRING_MACRO_REQUEST_CONTEXT_ATTRIBUTE +
						"' because of an existing model object of the same name");
			}
			model.put(AbstractTemplateView.SPRING_MACRO_REQUEST_CONTEXT_ATTRIBUTE, new RequestContext(request, response, getServletContext(), model));
		}

		super.renderMergedOutputModel(model, request, response);
	}

}