package framework.io;

import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;
import jsweet.dom.XMLDocument;
import jsweet.dom.XMLSerializer;
import jsweet.util.function.TriFunction;
public class Remote {
	
	
	
	public static void get(String url, Object params, String dataType,final ResponseHandler<Object> handler){
		TriFunction<Object, String, JQueryXHR, XMLDocument> onSuccess = new TriFunction<Object, String, JQueryXHR, XMLDocument>() {

			@Override
			public XMLDocument apply(Object t, String u, JQueryXHR v) {
				String s = new XMLSerializer().serializeToString((XMLDocument)t);
				handler.handleResponse(s);
				return null;
			}
		};
		
		$.get(url).then(onSuccess);
		
	}
	
	public static void getXHTML(String url, Object params, final ResponseHandler<Object> handler){
		get(url,params,"application/xhtml+xml",handler);
	}
	
	public static  void getJSON(String url, Object params, final ResponseHandler<Object> handler){
		get(url,params,"application/json",handler);
	}
	
	
	public interface ResponseHandler<R>{
		public void handleResponse(R response);
	}

}
