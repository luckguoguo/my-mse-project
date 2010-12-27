package cn.edu.sjtu.common.web;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseRenderUtiles {
	
	private static final String ENCODING_PREFIX = "encoding";
	private static final String NOCACHE_PREFIX = "no-cache";
	private static final String ENCODING_DEFAULT = "UTF-8";
	private static final boolean NOCACHE_DEFAULT = true;

	private static final String TEXT_TYPE = "text/plain";
	private static final String JSON_TYPE = "application/json";
	private static final String XML_TYPE = "text/xml";
	private static final String HTML_TYPE = "text/html";
	private static final String JS_TYPE = "text/javascript";

	private static Logger logger = LoggerFactory.getLogger(ResponseRenderUtiles.class);

	/**
	 * Render.
	 * 
	 * eg.
	 * render(response, "text/plain", "hello", "encoding:GBK");
	 * render(response, "text/plain", "hello", "no-cache:false");
	 * render(response, "text/plain", "hello", "encoding:GBK", "no-cache:false");
	 */
	public static void render(HttpServletResponse response, final String contentType, final String content, final String... headers) {
		try {
			String encoding = ENCODING_DEFAULT;
			boolean noCache = NOCACHE_DEFAULT;
			for (String header : headers) {
				String headerName = StringUtils.substringBefore(header, ":");
				String headerValue = StringUtils.substringAfter(header, ":");

				if (StringUtils.equalsIgnoreCase(headerName, ENCODING_PREFIX)) {
					encoding = headerValue;
				} else if (StringUtils.equalsIgnoreCase(headerName, NOCACHE_PREFIX)) {
					noCache = Boolean.parseBoolean(headerValue);
				} else
					throw new IllegalArgumentException(headerName + " is not a valid header");
			}

			String fullContentType = contentType + ";charset=" + encoding;
			response.setContentType(fullContentType);
			if (noCache) {
				WebUtils.setNoCacheHeader(response);
			}

			response.getWriter().write(content);
			response.getWriter().flush();

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public static void renderText(HttpServletResponse response, final String text, final String... headers) {
		render(response, TEXT_TYPE, text, headers);
	}

	public static void renderHtml(HttpServletResponse response, final String html, final String... headers) {
		render(response, HTML_TYPE, html, headers);
	}

	public static void renderXml(HttpServletResponse response, final String xml, final String... headers) {
		render(response, XML_TYPE, xml, headers);
	}

	public static void renderJson(HttpServletResponse response, final String jsonString, final String... headers) {
		render(response, JSON_TYPE, jsonString, headers);
	}

	@SuppressWarnings("unchecked")
	public static void renderJson(HttpServletResponse response, final Map map, final String... headers) {
		String jsonString = JSONObject.fromObject(map).toString();
		render(response, JSON_TYPE, jsonString, headers);
	}

	public static void renderJson(HttpServletResponse response, final Object object, final String... headers) {
		String jsonString = JSONObject.fromObject(object).toString();
		render(response, JSON_TYPE, jsonString, headers);
	}

	public static void renderJson(HttpServletResponse response, final Collection<?> collection, final String... headers) {
		String jsonString = JSONArray.fromObject(collection).toString();
		render(response, JSON_TYPE, jsonString, headers);
	}

	public static void renderJson(HttpServletResponse response, final Object[] array, final String... headers) {
		String jsonString = JSONArray.fromObject(array).toString();
		render(response, JSON_TYPE, jsonString, headers);
	}

	@SuppressWarnings("unchecked")
	public static void renderJsonp(HttpServletResponse response, final String callbackName, final Map contentMap, final String... headers) {
		String jsonParam = JSONObject.fromObject(contentMap).toString();

		StringBuilder result = new StringBuilder().append(callbackName).append("(").append(jsonParam).append(");");

		render(response, JS_TYPE, result.toString(), headers);
	}
	
}
