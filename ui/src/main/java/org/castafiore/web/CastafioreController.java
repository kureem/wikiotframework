package org.castafiore.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.castafiore.ComponentNotFoundException;
import org.castafiore.ui.Application;
import org.castafiore.ui.ApplicationRegistry;
import org.castafiore.ui.CastafioreApplicationContextHolder;
import org.castafiore.ui.CastafioreJSONEngine;
import org.castafiore.ui.Data;
import org.castafiore.ui.interceptors.InterceptorRegistry;
import org.castafiore.utils.ComponentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CastafioreController {

	@Autowired
	private InterceptorRegistry interceptorRegistry;

	@Autowired
	private ApplicationRegistry applicationRegistry;

	public void doMethod(HttpServletRequest request, HttpServletResponse response) {

	}

	@SuppressWarnings("rawtypes")
	private Map<String, String> getParameterMap(Map parameters) {

		Map<String, String> result = new HashMap<String, String>(parameters.size());
		Iterator iter = parameters.keySet().iterator();

		while (iter.hasNext()) {
			String key = iter.next().toString();

			String value = ((String[]) parameters.get(key))[0].toString();

			result.put(key, value);
		}

		return result;
	}


	private CastafioreJSONEngine getEngine(HttpServletRequest req) {
		CastafioreJSONEngine engine = (CastafioreJSONEngine) req.getSession().getAttribute("CastafioreEngine");
		if (engine == null) {
			engine = new CastafioreJSONEngine(interceptorRegistry);
			req.getSession().setAttribute("CastafioreEngine", engine);
			return (CastafioreJSONEngine) req.getSession().getAttribute("CastafioreEngine");
		} else {
			return engine;
		}
	}

	@RequestMapping("/castafiore/ui/*")
	public Object doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ComponentUtil.loadApplication((HttpServletRequest) request, (HttpServletResponse) response,
				applicationRegistry);

		request.setCharacterEncoding("UTF-8");

		Map<String, String> params = this.getParameterMap(request.getParameterMap());

		String componentId = request.getParameter("casta_componentid");
		String eventId = request.getParameter("casta_eventid");
		String applicationId = request.getParameter("casta_applicationid");

		Assert.notNull(applicationId,
				"cannot execute a castafiore request when the applicationid is null. Please verify that the parameter casta_applicationid has been set correctly in tag, jsp or whatever");

		// gets the already loaded application
		Application applicationInstance = CastafioreApplicationContextHolder.getCurrentApplication();
		List<Data> res = new LinkedList<Data>();
		if ((componentId == null && eventId == null && applicationInstance != null)) {
			applicationInstance.setRendered(false);
			getEngine(request).getJQuery(applicationInstance, "root_" + applicationId, applicationInstance, res);

		} else if ((componentId != null && eventId != null) && applicationInstance != null) {
			try {
				getEngine(request).executeServerAction(componentId, applicationInstance, "root_" + applicationId,
						params, res);
			} catch (ComponentNotFoundException cnfe) {
			}
		} else if ((componentId != null && eventId != null) && applicationInstance == null) {
		}

		applicationInstance.flush(12031980);
		
		return res;

	}

	public void doExecute(HttpServletRequest request, HttpServletResponse response) {

	}

}
