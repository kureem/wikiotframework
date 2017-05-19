package framework.portal;

import framework.JSContainer;
import framework.Renderable;

public class JSCards<T extends Renderable> extends JSContainer {

	private int currentIndex = -1;

	public JSCards(String name) {
		super(name, "div");
	}

	public void showByIndex(int index) {
		for (Renderable c : getChildren()) {
			c.setVisible(false);
		}

		getChildren().get(index).setVisible(true);
		currentIndex = index;
	}

	public Renderable getCurrent() {
		if (currentIndex >= 0) {
			return  getChildren().get(currentIndex);
		}
		return null;
	}

	public boolean show(String name) {

		int count = 0;
		for(Renderable c : getChildren()){
			if(c.getName().equals(name)){
				showByIndex(count);
				return true;
			}
			count++;
		}
		return false;

	}

}
