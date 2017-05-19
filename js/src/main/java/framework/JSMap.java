package framework;
import jsweet.lang.JSON;
import jsweet.lang.Object;

public class JSMap extends Object{

	
	public String getJavascript(){
		return JSON.stringify(this);
	}
}
