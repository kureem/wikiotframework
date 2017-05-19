package framework;

public class JSTable extends JSContainer{

	private JSContainer tbody = new JSContainer("tbody");
	private JSContainer thead = new JSContainer("thead");
	private JSContainer tfoot = new JSContainer("tfoot");

	
	public JSTable(String name) {
		super(name,"table");
		addClass("table");
		addChild(thead).addChild(tbody).addChild(tfoot);
		
	}
	
	
	private JSTable toggleCls(boolean b, String cls){
		if(b){
			addClass(cls);
		}else{
			removeClass(cls);
		}
		return this;
	}
	public JSTable setStriped(boolean b){
		return toggleCls(b, "table-striped");
	}
	
	public JSTable setBordered(boolean b){
		return toggleCls(b, "table-bordered");
	}
	
	public JSTable setCondensed(boolean b){
		return toggleCls(b, "table-condensed");
	}
	
	
	public JSTable setHoverRows(boolean b){
		String cls = "table-hover";
		if(b){
			tbody.addClass(cls);
		}else{
			tbody.removeClass(cls);
		}
		return this;
	}
	
	
	public JSTable addHeaderCell(JSContainer th){
		if(thead.getChildren().size() == 0){
			thead.addChild(new JSContainer("tr"));
		}
		thead.getChildren().get(0).addChild(th);
		return this;
	}
	
	
	public JSTable addFooterCell(JSContainer td){
		if(tfoot.getChildren().size() == 0){
			tfoot.addChild(new JSContainer("tr"));
		}
		tfoot.getChildren().get(0).addChild(td);
		return this;
	}
	
	public Renderable addRow(){
		
		JSContainer row = new JSContainer("tr");
		tbody.addChild(row);
		return row;
	}
	
	public Renderable addRowAt(int index){
		JSContainer row = new JSContainer("tr");
		tbody.addChildAt(index, row);
		return row;
	}
	
	
	
	

}
