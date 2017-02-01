package org.wikiot.server;

import java.util.List;

import org.wikiot.DeviceDefinition;

public interface DeviceRegistry {


	public Device getDevice(String deviceId);

	public Device associate(String deviceId, DeviceDefinition definition);
	
	public List<Device> getDevices();

}
