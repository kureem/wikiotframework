package org.wikiot.server;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.wikiot.DefinitionRegistry;
import org.wikiot.DeviceDefinition;

@Component
public class MemoryDefinitionRegistry implements DefinitionRegistry {

	private Map<String, DeviceDefinition> definitions = new LinkedHashMap<String, DeviceDefinition>();

	public MemoryDefinitionRegistry() {
	}

	@Override
	public DeviceDefinition getDefinition(String definitionId) {
		return definitions.get(getKey(definitionId));
	}

	protected String getKey(String id) {
		return id;
	}

	@Override
	public DeviceDefinition publishDefinition(DeviceDefinition definition) {

		definitions.put(getKey(definition.getId()), definition);
		return definition;

	}

	public void setDefinitions(Map<String, DeviceDefinition> definitions) {
		this.definitions = definitions;
	}

	@Override
	public Collection<DeviceDefinition> getDefinitions() {
		return definitions.values();
	}

}
