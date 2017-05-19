package framework.portal;

import framework.services.NavigationService;
import framework.services.Node;
import framework.services.User;
import framework.services.UserService;

public class JSPortal extends WireFrame {

	private UserService userService = new UserService();

	private NavigationService navigationService = new NavigationService();

	public JSPortal() {
		super("portal");
		init();
	}

	public void init() {

		super.init();
		User u = userService.getCurrentUser();

		setCurrentUser(u);

		Node nav = navigationService.getRootNode(u);

		setNavigation(nav);
	}

	public void setNavigation(Node nav) {
		getPrimarySideBar().setNode(nav);
	}

	public void setCurrentUser(User u) {
		getPrimarySideBar().setUser(u);
	}

}
