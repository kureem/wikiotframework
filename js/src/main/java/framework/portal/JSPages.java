package framework.portal;

import static jsweet.lang.Globals.eval;

import framework.Renderable;
import framework.services.Node;
import framework.services.Page;

public class JSPages extends JSCards<JSPage> {


	private WireFrame owner_;
	
	public JSPages(String name, WireFrame owner) {
		super(name);
		this.owner_ = owner;
		addClass("content-wrapper");
	}


	public JSPage getPage(String name) {
		for (Renderable child : getChildren()) {
			if (child instanceof JSPage) {
				JSPage page = (JSPage) child;
				if (page.getName().equals(name)) {
					return page;
				}
			}
		}
		return null;
	}
	
	
	public boolean openNode(Node node){
		Page page = node.getPage();
		if(page != null){
			try{
				if(!show(page.getName())){
					JSPage iPage =  (JSPage)eval("new " +  page.getImplementation().getName());
					iPage.setName(page.getName());
					iPage.setOwner(owner_);
					addChild(iPage);
					iPage.buildPage();
					
					return show(page.getName());
				}
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	public boolean showNode(Node node){
		Page page = node.getPage();
		return show(page.getName());
	}
	

}
