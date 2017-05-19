package framework.portal;

public class JSLabel extends AbstractColorType {

	public JSLabel(String name) {
		super(name, "span", "label");
	}

	public JSLabel setText(String txt) {
		setHtml(txt);
		return this;
	}

}
