package framework.builder.create;

import framework.JSInput;
import framework.portal.JSCheckBox;
import framework.portal.JSForm;

public class JSNewProjectInfo extends JSForm{

	private JSInput projectName = new JSInput("projectName");
	
	private JSCheckBox sample = new JSCheckBox("sample", "Create sample screens");
	
	
	private JSCheckBox multiScreen = new JSCheckBox("multiscreen", "Multi screen or single screen");
	
	

	public JSNewProjectInfo(String name) {
		super(name);
		
		addInput(projectName).setTitleColor("#4e4e4e");
		addCheckBox(sample).addCheckBox(multiScreen);
		sample.setTitleColor("#4e4e4e");
		multiScreen.setTitleColor("#4e4e4e");
		
	}
	
	
	public ProjectInfo getProjectInfo(ProjectType type){
		ProjectInfo info = new ProjectInfo();
		info.setMulti(multiScreen.isChecked());
		info.setSamples(sample.isChecked());
		info.setName(projectName.getValue());
		info.setType(type);
		return info;
	}
	
	
	

}
