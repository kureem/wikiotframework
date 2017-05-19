package framework.portal;

import framework.JSContainer;
import framework.Renderable;

public class JSThumbnail extends JSContainer{

	private JSImage image = new JSImage("image");
	
	private JSContainer captions = new JSContainer("caption","div" ).addClass("caption");
	
	private JSContainer title = null;
	public JSThumbnail(String name) {
		super(name, "div");
		addChild(image.addClass("thumbnail"));
		addChild(captions);
		
	}
	
	public JSThumbnail addCaption(JSContainer caption){
		captions.addChild(caption);
		return this;
	}
	
	public JSImage getImage(){
		return image;
	}
	
	public Renderable getCaptions(){
		return captions;
	}
	
	
	public JSThumbnail setTitle(String stitle){
		if(title == null){
			captions.addChildAt(0, title);
		}
		
		title = new JSContainer("h3").setHtml(stitle);
		title.setRendered(false);
		
		return this;
	}
	
	

}
