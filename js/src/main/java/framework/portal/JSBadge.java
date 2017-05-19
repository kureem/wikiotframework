package framework.portal;

public class JSBadge extends AbstractColorType{

	public JSBadge(String name) {
		super(name,"span", "badge");
	}
	
	public JSBadge setValue(Integer val){
		setHtml(val.intValue() + "");
		return this;
	}

}
