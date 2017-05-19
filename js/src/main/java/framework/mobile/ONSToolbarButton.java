package framework.mobile;


public class ONSToolbarButton extends ONSModifiable{

	public ONSToolbarButton(String name) {
		super(name, "ons-toolbar-button");
	}
	
	
	public void setDisabled(boolean b){
		if(b){
			setAttribute("disabled", "true");
		}else{
			setAttribute("disabled", (String)null);
		}
	}
	
	public boolean isDisabled(){
		return "true".equals(getAttribute("disabled"));
	}

}
