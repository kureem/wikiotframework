package framework.builder.create;

import def.jquery.JQueryEventObject;
import framework.Event;
import framework.EventListener;
import framework.JSContainer;
import framework.builder.JSBuilder;
import framework.builder.create.JSProductType.SelectProjectTypeHandler;
import framework.portal.ColorType;
import framework.portal.JSButton;
import framework.portal.JSCards;
import framework.portal.JSModal;

public class JSNewWizard extends JSModal implements SelectProjectTypeHandler, EventListener {

	private ProjectType selectedType_;

	private JSBuilder ownser_;

	private JSProjectTypes projectTypes = new JSProjectTypes("projectTypes", this);

	private JSNewProjectInfo projectInfo = new JSNewProjectInfo("projectInfo");

	private JSCards<JSContainer> screens = new JSCards<>("screen");

	private JSButton next = new JSButton("next").setText("Next");

	private JSButton back = new JSButton("back").setText("Back");

	private JSButton cancel = new JSButton("cancel").setText("Cancel");

	private JSButton finish = new JSButton("finish").setText("Finish");

	public JSNewWizard(String name, JSBuilder page) {
		super(name);
		this.ownser_ = page;
		getBody().addChild(screens);
		screens.addChild(projectTypes);
		screens.addChild(projectInfo);
		getFooter().addChild(cancel.addOnClick(this)).addChild(back.addOnClick(this)).addChild(next.addOnClick(this))
				.addChild(finish.addOnClick(this));
		back.setVisible(false);
		finish.setVisible(false);
		next.setDisabled(true);
		next.setColorType(ColorType.PRIMARY);
		setTitle("Create new wizard");
		screens.show("projectTypes");

	}

	@Override
	public JSModal show() {
		screens.show("projectTypes");
		back.setVisible(false);
		finish.setVisible(false);
		next.setDisabled(true);
		return super.show();
	}

	@Override
	public void doSelect(ProjectType type) {
		this.selectedType_ = type;
		next.setDisabled(false);

	}

	@Override
	public void performAction(JSContainer source, Event<JQueryEventObject> evt) {
		if (source.getName().equals("next")) {
			screens.show("projectInfo");
			back.setVisible(true);
			cancel.setVisible(false);
			next.setVisible(false);
			finish.setVisible(true);
		} else if (source.getName().equals("back")) {
			screens.show("projectTypes");
			back.setVisible(false);
			cancel.setVisible(true);
			next.setVisible(true);
			finish.setVisible(false);
		} else if (source.getName().equals("cancel")) {
			this.hide();
		} else if (source.getName().equals("finish")) {
			this.hide();
			ProjectInfo info = projectInfo.getProjectInfo(selectedType_);
			this.ownser_.createNew(info);

		}
	}


}
