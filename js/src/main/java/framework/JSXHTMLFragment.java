package framework;

import static def.jquery.Globals.$;

public class JSXHTMLFragment extends JSContainer{

	
	private String templateId; 
	
	public JSXHTMLFragment(String name, String templateId) {
		super(name, "div");
		this.templateId = templateId;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	@Override
	public String getHtml() {
		return $("#" + templateId).html();
	}

	
	
	

}
