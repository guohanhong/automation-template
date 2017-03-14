import java.util.List;

import com.google.common.collect.Lists;

import net.sf.json.JSONObject;

public class GenerateTemplateMain {
	
	public static void main(String[] args) {
		JSONObject template = new JSONObject();
		
		List<String> productName = Lists.<String>newArrayList("//div[@class='sku-name']/allText()");
		template.put("productName", productName);
		
		List<String> category = Lists.<String>newArrayList("//div[@class='crumb-wrap']/allText()");
		template.put("category", category);
		
		List<String> description = Lists.<String>newArrayList("//div[@class='p-parameter']/allText()");
		template.put("description", description);
		

		
		System.out.println(template.toString());
	}
}
