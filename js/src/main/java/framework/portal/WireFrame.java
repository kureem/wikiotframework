package framework.portal;

import framework.JSContainer;

public class WireFrame extends JSContainer {

	private JSNavBar navbar = new JSNavBar("nav");

	private JSPrimarySideBar primarySideBar = new JSPrimarySideBar("sideBar");

	private JSNavbarGroup leftGroup = new JSNavbarGroup("left");

	private JSNavbarGroup rightGroup = new JSNavbarGroup("right");
	//

	private JSPageContainer pageContainer = new JSPageContainer("page-container");

	private JSPages pages = new JSPages("pages", this);

	public WireFrame(String name) {
		super(name, "div");
		addChild(navbar);
		addChild(pageContainer);
		navbar.setInverted(true);
		pageContainer.getContent().addChild(primarySideBar);
		pageContainer.getContent().addChild(pages);
	}

	public void init() {
		initTopNav();
	}

	public void initTopNav() {
		setLogo("http://demo.interface.club/limitless/layout_1/LTR/default/assets/images/logo_light.png");
		addNavBarGroup(leftGroup);
		rightGroup.setPosition(HorizontalDirection.RIGHT);
		addNavBarGroup(rightGroup);

		JSButton toggle = new JSButton("toggle");
		toggle.setIcon("fa fa-bars");
		toggle.addClass("sidebar-control sidebar-main-toggle hidden-xs").setStyle("font-size", "18px");
		leftGroup.addButtonItem(toggle);

	}

	public void setLogo(String url) {
		JSLogo logo = new JSLogo("logo");
		logo.setSrc(url);
		getNavbar().setHeader(logo);
	}

	public void addNavBarGroup(JSNavbarGroup grp) {
		navbar.addGroupItem(grp);
	}

	public JSNavBar getNavbar() {
		return navbar;
	}

	public JSPrimarySideBar getPrimarySideBar() {
		return primarySideBar;
	}

	public JSPageContainer getPageContainer() {
		return pageContainer;
	}

	public JSPages getPages() {
		return pages;
	}

	public JSNavbarGroup getLeftNavBarGroup() {
		return leftGroup;
	}

	public JSNavbarGroup getRightNavBarGroup() {
		return rightGroup;
	}

}
