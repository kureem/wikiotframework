package framework;

import framework.portal.JSCol;
import framework.portal.JSNavBar;
import framework.portal.JSRow;
import framework.portal.Size;
import framework.services.FileService;
import framework.services.FileService.FileDefinition;

public class JSFileExplorer extends JSRow{ 

	private JSNavBar navBar = new JSNavBar("top").setSize(Size.EXTRA_SMALL);
	
	private JSCol topCol = new JSCol("top").setWidthMedium(12).setWidthSmall(12).setWidthLarge(12);
	
	private JSCol leftCol = new JSCol("left").setWidthMedium(3).setWidthSmall(12).setWidthLarge(2);
	
	private JSCol rightCol = new JSCol("right").setWidthMedium(9).setWidthSmall(12).setWidthLarge(10);
	
	private JSTable fileList = new JSTable("fileList");
	
	private FileService fileService = FileService.getInstance();
	
	public JSFileExplorer(String name)throws Exception {
		super();
		setStyle("height", "250px");
		addChild(topCol);
		topCol.addChild(navBar);
		addChild(leftCol);
		addChild(rightCol);
		setAttribute("class", "container-fluid");

		
		fileList.addHeaderCell(new JSContainer("th").setHtml("Name"));
		fileList.addHeaderCell(new JSContainer("th").setHtml("Size"));
		
		for(FileDefinition def : fileService.getFiles()){
			String file = def.getName();
			String size = def.getSize();
			fileList.addRow().addChild(new JSContainer("td").setHtml(file)).addChild(new JSContainer("td").setHtml(size));
		}
		fileList.setCondensed(true);
		fileList.setBordered(true);
		
		rightCol.addChild(fileList);
		
	}
	

}
