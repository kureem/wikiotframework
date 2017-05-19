package framework.services;

import java.util.HashMap;
import java.util.Map;

public class i18nService {

	private static Map<String, String> values = new HashMap<>();
	
	static{
		values.put("common.width", "Width");
		values.put("common.height", "Height");
		values.put("common.min-height", "Min Height");
		values.put("common.max-height", "Max Height");
		values.put("common.min-width", "Min Width");
		values.put("common.max-width", "Max Width");
		values.put("common.float", "Float");
		values.put("common.position", "Position");
		values.put("common.top", "Top");
		values.put("common.right", "Right");
		values.put("common.bottom", "Bottom");
		values.put("common.left", "Left");
		
		values.put("common.margin-top", "Top");
		values.put("common.margin-right", "Right");
		values.put("common.margin-bottom", "Bottom");
		values.put("common.margin-left", "Left");
		
		values.put("common.padding-top", "Top");
		values.put("common.padding-right", "Right");
		values.put("common.padding-bottom", "Bottom");
		values.put("common.padding-left", "Left");
		
		values.put("common.border-top", "Top");
		values.put("common.border-right", "Right");
		values.put("common.border-bottom", "Bottom");
		values.put("common.border-left", "Left");
		values.put("form.projectInfo.projectName", "Name");
	}
	
	public String getValue(String key){
		return values.get(key);
	}
	
}
