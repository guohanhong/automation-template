package com.asking.template;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.htmlcleaner.XPatherException;
import org.xml.sax.SAXException;

import com.asking.extract.IExtract;
import com.asking.extract.constant.Constant;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import net.sf.json.JSONObject;

public abstract class Template {

	public abstract String extract(String html);
	
	private String name ;
	
	public void name(String name){
		this.name = name;
	}
	public String name(){
		return name;
	}
	
	private String domain;
	
	public void domain(String domain){
		this.domain = domain;
	}
	public String domain(){
		return this.domain;
	}

	protected String extract2(String html , String template){
		JSONObject templatedf = JSONObject.fromObject(template);
		
		JSONObject extract = new JSONObject();
		extract.put(com.asking.template.Constant.GENERATETIME, System.currentTimeMillis());
		
		for(Object key : templatedf.keySet()){
			StringBuffer extractBuffer = new StringBuffer();
			List<String> xpaths = (List<String>) templatedf.get(key.toString());
			try {
				for(String xpath : xpaths){
					List<String> values = IExtract.extract(html, Constant.EXTRACT_MODE_XPATH, xpath);
					extractBuffer.append(values.toString());
					extractBuffer.append("\n");
				}
				extract.put(key.toString(), extractBuffer.toString());
			} catch (XPathExpressionException | IOException | SAXException | ParserConfigurationException
					| XPatherException | XpathSyntaxErrorException e) {
				e.printStackTrace();
			}
		}
		
		return extract.toString();
	};
}
