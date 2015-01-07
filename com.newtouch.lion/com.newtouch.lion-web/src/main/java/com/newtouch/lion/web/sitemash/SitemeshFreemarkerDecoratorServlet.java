/*
 * Copyright (c)  2014, Newtouch
 * All rights reserved. 
 *
 * $id: SitemeshFreemarkerDecoratorServlet.java 9552 2014年12月31日 下午3:32:16 WangLijun$
 */
package com.newtouch.lion.web.sitemash;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newtouch.lion.common.SpringContextUtil;
import com.newtouch.lion.web.freemarker.WebFreeMarkerConfigurer;
import com.opensymphony.module.sitemesh.HTMLPage;
import com.opensymphony.module.sitemesh.RequestConstants;
import com.opensymphony.module.sitemesh.freemarker.FreemarkerDecoratorServlet;

import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateModel;

/**
 * <p>
 * Title:重写SiteMash Freemarker的装饰
 * </p>
 * <p>
 * Description: 重写SiteMash Freemarker的装饰
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * <p>
 * Company: Newtouch
 * </p>
 * 
 * @author WangLijun
 * @version 1.0
 */
public class SitemeshFreemarkerDecoratorServlet extends
		FreemarkerDecoratorServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -932927776246721655L;

	@Override
	protected boolean preTemplateProcess(HttpServletRequest request,
			HttpServletResponse response, Template template,
			TemplateModel templateModel) throws ServletException, IOException {
		boolean result = super.preTemplateProcess(request, response, template,
				templateModel);

		Configuration config =this.getFreemarkerConfig();
		SimpleHash hash = (SimpleHash) templateModel;

		HTMLPage htmlPage = (HTMLPage) request.getAttribute(RequestConstants.PAGE);

		String title, body, head;

		if (htmlPage == null) {
			title = "No Title";
			body = "No Body";
			head = "<!-- No head -->";
		} else {
			title = htmlPage.getTitle();

			StringWriter buffer = new StringWriter();
			htmlPage.writeBody(buffer);
			body = buffer.toString();

			buffer = new StringWriter();
			htmlPage.writeHead(buffer);
			head = buffer.toString();

			hash.put("page", htmlPage);
		}

		hash.put("title", title); 
		hash.put("body", body);
		hash.put("head", head);
		
		if (!config.getSharedVariableNames().isEmpty()) {
			Object[] names = config.getSharedVariableNames().toArray();
			for (Object name : names) {
				hash.put(name.toString(),
						config.getSharedVariable(name.toString()));
			}
		}
		
		return result;
	}
	
	/**加载Spring Freemarker配置，可使用自定义标签
	 * 
	 * */
	protected Configuration getFreemarkerConfig(){
		WebFreeMarkerConfigurer  freeMarkerConfigurer=(WebFreeMarkerConfigurer) SpringContextUtil.getBean("freeMarkerConfigurer");
		return freeMarkerConfigurer.getConfiguration();
	}

}
