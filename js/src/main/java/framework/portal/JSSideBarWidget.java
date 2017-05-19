package framework.portal;

import def.jquery.JQueryEventObject;
import framework.Event;
import framework.EventListener;
import framework.JSContainer;
import framework.Renderable;

public class JSSideBarWidget extends JSContainer{

	private JSContainer title = new JSContainer("span");
	
	private JSContainer iconsList = new JSContainer("ul").addClass("icons-list");
	
	private JSButton toggle = new JSButton("toggle").setIcon("fa fa-chevron-down");
	
	private JSContainer categoryTitle = 
			new JSContainer("div").addClass("category-title")
				.addChild(title)
				.addChild(iconsList);
	
	
	private JSContainer categoryContent = new JSContainer("div").addClass("category-content");
	
	
	private boolean hidden = false;
	
	
	public JSSideBarWidget(String name) {
		super(name,"div");
		addClass("sidebar-category");
		//categoryTitle.addChild(title);
		addChild(categoryTitle);
		addChild(categoryContent);
		addButton(toggle);
		toggle.addOnClick(new EventListener() {
			
			@Override
			public void performAction(JSContainer source, Event<JQueryEventObject> evt) {
				toggle();
			}
		});
		toggle.setAttribute("class", "inner-button");
		//close();
		
	}
	
	
	public void close(){
		if(!hidden){
			categoryContent.setStyle("display", "none");
			hidden = true;
		}
	}
	
	public void open(){
		if(hidden){
			categoryContent.setStyle("display", "block");
			hidden = false;
		}
	}
	
	public void toggle(){
		if(hidden){
			categoryContent.setStyle("display", "block");
			
		}else{
			categoryContent.setStyle("display", "none");
		}
		
		hidden = !hidden;
	}
	
	public JSSideBarWidget pack(boolean b){
		if(b){
			categoryContent.addClass("no-padding");
		}else{
			categoryContent.removeClass("no-padding");
		}
		return this;
	}
	
	
	public Renderable getTitleContainer(){
		return categoryTitle;
	}
	
	public JSSideBarWidget setTitle(String txt){
		title.setHtml(txt);
		return this;
	}
	
	public Renderable getContent(){
		return categoryContent;
	}

	
	public JSSideBarWidget addButton(JSButton button){
		JSContainer li = new JSContainer("li");
		li.addChild(button);
		iconsList.addChild(li);
		return this;
	}
	
	public JSSideBarWidget showTitle(boolean b){
		categoryTitle.setVisible(b);
		return this;
	}
}
