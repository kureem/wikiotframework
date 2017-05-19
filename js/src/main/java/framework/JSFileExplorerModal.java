package framework;

import framework.portal.JSModal;

public class JSFileExplorerModal extends JSModal {

	public JSFileExplorerModal(String name)throws Exception {
		super(name);
		setTitle("File explorer");
		getBody().addChild(new JSFileExplorer(name));
		showHeader(true);
		showFooter(true);
		pack(true);
	}
	
	

}
