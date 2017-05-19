package framework.portal;

import def.jquery.JQueryEventObject;
import framework.Event;
import framework.EventListener;
import framework.JSContainer;
import framework.portal.widgets.JSNavigation;
import framework.services.Node;
import framework.services.User;

public class JSPrimarySideBar extends JSSideBar {

	private JSSideBarWidget userWidget = new JSSideBarWidget("userWidget");
	private JSUserMedia userMedia = new JSUserMedia("user");

	private JSSideBarWidget navigationWidget = new JSSideBarWidget("menu");

	private JSNavigation navigation = new JSNavigation("nav");

	public JSPrimarySideBar(String name) {
		super(name);
		addClass("sidebar-main");
		userWidget.showTitle(false);
		userWidget.setAttribute("class", "sidebar-user");
		userWidget.getContent().addChild(userMedia);

		navigationWidget.showTitle(false);
		navigationWidget.getContent().addChild(navigation);
		navigationWidget.pack(true);
		
		addWidget(userWidget);
		addWidget(navigationWidget);

	}
	
	public JSPrimarySideBar setUser(User u){
		
		userMedia.setUser(u);
		return this;
	}

	public JSSideBar addItem(Node node) {

		JSButton button = new JSButton(node.getName());
		button.setText(node.getLabel());
		button.setIcon(node.getIcon());
		button.setData(node);
		if (node.getChildren().size() > 0) {
			JSDropdownMenu menu = new JSDropdownMenu(node.getName() + "_menu");
			menu.setAttribute("class", "hidden-ul");
			button.addClass("has-ul");
			for (Node n : node.getChildren()) {
				JSButton item = new JSButton(n.getName());
				item.setText(n.getLabel());
				item.setIcon(n.getIcon());
				item.setData(n);
				menu.addButton(item);

			}
			JSDropdown dropdown = new JSDropdown(button, menu);
			navigation.addDropdown(dropdown);
			//

		} else {
			navigation.addButton(button);

			button.addOnClick(new EventListener() {

				@Override
				public void performAction(JSContainer source, Event<JQueryEventObject> evt) {
					Node n = (Node) source.getData();
					JSPages pages = source.getAncestorOfType(JSPortal.class).getPages();
					pages.openNode(n);
				}
			});
		}
		return this;
	}

	public void setNode(Node node) {

		navigation.getChildren().clear();
		JSIcon elipse = new JSIcon("elipse").setIcon("fa fa-ellipsis-h");

		navigation.addHeader(node.getLabel(), elipse);

		for (Node n : node.getChildren()) {
			addItem(n);
		}
	}

}
