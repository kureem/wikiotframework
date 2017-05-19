package framework.mobile;


public class ONSInput extends ONSModifiable{

	private String placeholder;
	
	private boolean flt;
	
	private String type;

	public ONSInput(String name) {
		super(name, "ons-input");
	}

	
	
	public void setFloat(boolean b){
		if(b)
			setAttribute("float", "true");
		else
			setAttribute("float", "false");
		this.flt = b;
	}
	
	public boolean isFloat(){
		return flt;
	}



	public String getPlaceholder() {
		return placeholder;
	}



	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
		setAttribute("placeholder", placeholder);
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
		setAttribute("type", type);
	}
	
	
	
	
	

}
