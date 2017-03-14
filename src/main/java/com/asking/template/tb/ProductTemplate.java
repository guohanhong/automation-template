package com.asking.template.tb;

import java.util.Map;

import com.asking.common.util.TemplateUtil;
import com.asking.template.Template;

public class ProductTemplate extends Template {

	private final String _suffix = "template";

	private Map<String, String> templates = null;

	private String template = null;

	public ProductTemplate() {
		templates = TemplateUtil.template(String.format("%s." + _suffix, domain()));
		template = templates.get(name());
	}

	@Override
	public String extract(String html) {
		String extract = extract2(html, template);
		return extract;
	}

	@Override
	public String name() {
		return "com.asking.template.tb.ProductTemplate";
	}

	@Override
	public String domain() {
		return "tb";
	}

}
