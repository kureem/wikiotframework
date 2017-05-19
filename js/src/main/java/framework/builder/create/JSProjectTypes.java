package framework.builder.create;

import java.util.LinkedList;
import java.util.List;

import framework.JSContainer;
import framework.Renderable;
import framework.builder.create.JSProductType.SelectProjectTypeHandler;
import framework.portal.JSCol;
import framework.portal.JSRow;
import framework.portal.JSThumbnail;

public class JSProjectTypes extends JSContainer {

	private JSContainer grid = new JSContainer("div").addClass("container-fluid");

	private List<ProjectType> projectTypes = new LinkedList<>();

	private SelectProjectTypeHandler handler = null;

	private JSCol col = new JSCol("cell").setWidthMedium(2).setWidthLarge(2);
	
	public JSProjectTypes(String name, SelectProjectTypeHandler hand) {
		super(name, "div");
		addChild(grid);
		this.handler = hand;
		init();

	}

	public void init() {
		if (projectTypes.size() == 0) {
			projectTypes.add(new ProjectType("admin", "Admin App", "admin.png"));
			JSRow main = new JSRow();
			for (ProjectType type : projectTypes) {
				
				main.addChild(col);
				JSProductType projectType = new JSProductType(type);
				projectType.addHandler(handler);
				col.addChild(projectType);
			}

			grid.addChild(main);
		}
	}
	
	public List<JSProductType> getProjectTypes(){
		List l = col.getChildren();
		return l;
	}
	
	public void selectItem(JSProductType type){
		for(Renderable c : col.getChildren()){
			c.removeClass("active");
		}
		
		type.addClass("active");
	}
	

	public void userSelectItem(JSThumbnail thumb) {
		
	}

}
