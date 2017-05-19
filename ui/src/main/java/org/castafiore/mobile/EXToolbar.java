package org.castafiore.mobile;

public class EXToolbar extends EXModifiable {

	public EXToolbar(String name ) {
		super(name, "ons-toolbar");
	}
	
	
	public void setInline(boolean b){
		if(b)
			setAttribute("inline", "true");
		else
			setAttribute("inline", (String)null);
	}
	
	
	
	
	
	

}
