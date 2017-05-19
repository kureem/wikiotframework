package org.castafiore.mobile;

public class EXInput extends EXModifiable{

	private String placeholder;
	
	private boolean flt;
	
	private String type;

	public EXInput(String name) {
		super(name, "ons-input");
	}

	
	
	public void setFloat(boolean b){
		setBoolean("float", b);
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
