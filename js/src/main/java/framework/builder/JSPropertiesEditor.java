package framework.builder;

import java.util.List;

import framework.JSContainer;
import framework.JSInput;
import framework.JSTable;
import framework.Renderable;
import framework.services.i18nService;

public class JSPropertiesEditor extends JSContainer {

	private List<FieldDefinition> definitions_;

	private JSTable table = new JSTable("properties");

	private i18nService i18n = new i18nService();

	public JSPropertiesEditor(String name, List<FieldDefinition> definitions) {
		super(name, "div");
		this.definitions_ = definitions;
		addClass("properties");
		for (FieldDefinition df : definitions) {
			Renderable row = table.addRow();
			String label = i18n.getValue("common." + df.getName());
			//String type = df.getType();

			JSContainer cLabel = new JSContainer("th");
			JSContainer cInput = new JSContainer("td");
			cLabel.addClass("cell-label");
			cLabel.addChild(new JSContainer("span").setHtml(label));
			row.addChild(cLabel);

			cInput.addClass("cell-input");
			cInput.addChild(new JSInput("value"));
			row.addChild(cInput);
		}
		addChild(table);
		table.removeClass("table");
	}

}
