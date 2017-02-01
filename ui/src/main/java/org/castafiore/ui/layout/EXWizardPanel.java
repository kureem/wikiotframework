package org.castafiore.ui.layout;

import java.util.Map;

import org.castafiore.ui.Container;
import org.castafiore.ui.Event;
import org.castafiore.ui.JQuery;
import org.castafiore.ui.UIException;

public class EXWizardPanel<T> extends EXCardLayout implements Event {
	private static final long serialVersionUID = 1L;

	private T dataModel;

	private WizardController controller = null;

	private String current;

	public EXWizardPanel(String name, T dataModel) {
		super(name, "div");
		this.dataModel = dataModel;

	}

	@SuppressWarnings("rawtypes")
	public EXWizardPanel addPanel(String label, WizardItem<T> panel) {
		addChild(panel);
		show(0);
		current = getChildByIndex(0).getName();

		return this;
	}

	@SuppressWarnings("unchecked")
	public WizardItem<T> next() {
		String next = controller.getNext(current);
		WizardItem<T> uicurrent = getChild(this.current).getAncestorOfType(WizardItem.class);

		if (uicurrent.validate()) {
			uicurrent.collect(dataModel);
		}

		if (next != null) {
			WizardItem<T> item = getChild(next).getAncestorOfType(WizardItem.class);
			this.current = next;
			show(this.current);
			return item;
		}
		return null;
	}

	@Override
	public void ClientAction(JQuery container) {
		container.mask().server(this);

	}

	@Override
	public boolean ServerAction(Container container, Map<String, String> request) throws UIException {

		next();
		return true;
	}

	@Override
	public void Success(JQuery container, Map<String, String> request) throws UIException {

	}

}
