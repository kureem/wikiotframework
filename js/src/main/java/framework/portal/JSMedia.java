package framework.portal;

import framework.JSContainer;

public class JSMedia extends JSContainer{

	private JSLink mediaLeft = (JSLink)new JSLink("media-left").addClass("media-left");
	
	private JSImage leftImage = (JSImage)new JSImage("left-image").addClass("img-circle").addClass("img-sm");
	
	private JSContainer mediaBody = new JSContainer("div").addClass("media-body");
	
	private JSContainer mediaHeading = new JSContainer("span").addClass("media-heading text-semibold");
	
	private JSContainer mediaText = new JSContainer("div").addClass("text-size-mini text-muted");
	
	private JSContainer mediaRight = new JSContainer("div").addClass("media-right").addClass("media-middle");
	
	private JSContainer iconsList = new JSContainer("ul").addClass("icons-list");
	
	public JSMedia(String name) {
		super(name, "div");
		addClass("media");
		
		addChild(mediaLeft);
		mediaLeft.addChild(leftImage);
		
		addChild(mediaBody);
		
		mediaBody.addChild(mediaHeading);
		
		mediaBody.addChild(mediaText);
		
		addChild(mediaRight);
		
		mediaRight.addChild(iconsList);
	}
	
	
	
	public JSMedia setImage(String src){
		leftImage.setSource(src);
		return this;
	}
	
	public JSMedia setHeading(String heading){
		mediaHeading.setHtml(heading);
		return this;
	}
	
	public JSMedia setText(String txt){
		mediaText.setHtml(txt);
		return this;
	}
	
	public JSMedia addButton(JSButton button){
		JSContainer li = new JSContainer("li");
		iconsList.addChild(li);
		
		li.addChild(button);
		return this;
	}

}
