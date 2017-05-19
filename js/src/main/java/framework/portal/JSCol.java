package framework.portal;

import framework.JSContainer;

public class JSCol extends JSContainer{

	private int small = 0;
	private int medium = 0;
	private int large = 0;
	private int extraSmall =0;
	
	
	public JSCol(String name) {
		super(name,"div");
	}

	public JSCol setWidthSmall(int w){
		this.small = w;
		refresh();
		return this;
	}
	
	public JSCol setWidthMedium(int w){
		this.medium = w;
		refresh();
		return this;
	}
	
	public JSCol setWidthExtraSmall(int w){
		this.extraSmall = w;
		refresh();
		return this;
	}
	
	public JSCol setWidthLarge(int w){
		this.large = w;
		refresh();
		return this;
	}
	
	private void refresh(){
		String style = "";
		if(extraSmall > 0){
			style = style + " " + "col-xs-" + extraSmall;
		}
		
		if(small > 0){
			style = style + " " + "col-sm-" + small;
		}
		
		if(medium > 0){
			style = style + " " + "col-md-" + medium;
		}
		
		if(large > 0){
			style = style + " " + "col-lg-" + large;
		}
		setAttribute("class", style);
	}
}
