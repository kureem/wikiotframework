package framework.mobile;


public class ONSToolbar extends ONSModifiable {

	public ONSToolbar(String name ) {
		super(name, "ons-toolbar");
	}
	
	
	public void setInline(boolean b){
		if(b)
			setAttribute("inline", "true");
		else
			setAttribute("inline", (String)null);
	}
	
	
	
	
	
	

}
