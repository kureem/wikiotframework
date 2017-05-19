package app;

import static def.jquery.Globals.$;
import static jsweet.dom.Globals.document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import framework.Renderable;
import framework.portal.JSPortal;
import framework.portal.WireFrame;

public class Boot { 
	
public static void main(String[] args) {
		

		Renderable root = new JSPortal(); //new Chimebler();//new EXPage("root");
		$(document).ready(() -> {
			root.render();
			return null;
		});
		
	}
}
