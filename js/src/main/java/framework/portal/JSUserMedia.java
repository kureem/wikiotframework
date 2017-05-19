package framework.portal;

import framework.services.User;

public class JSUserMedia extends JSMedia {

	private User user = null;

	public JSUserMedia(String name) {
		super(name);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		setImage(user.getProfilePic());
		setHeading(user.getFullName());
		setText("<i class=\"icon-pin text-size-small\"></i> &nbsp;" + user.getShortAddress());
		this.user = user;
	}

}
