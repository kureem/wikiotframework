package framework.renderer;

import framework.JSContainer;
import framework.Renderable;

public interface Renderer<T extends Renderable> {
	
	public void doRender(JSContainer c);

}
