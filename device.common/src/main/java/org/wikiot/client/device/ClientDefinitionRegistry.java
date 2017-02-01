/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wikiot.client.device;

import java.util.Collection;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.wikiot.DefinitionRegistry;
import org.wikiot.DeviceDefinition;

@Component
public class ClientDefinitionRegistry implements DefinitionRegistry, InitializingBean {

	@Value("${wikiot.host:http://localhost:8081}")
	private String endpoint;

	@Autowired
	private RestTemplate restTemplate;

	public ClientDefinitionRegistry(String endpoint) {
		super();
		this.endpoint = endpoint;
	}

	@Override
	public DeviceDefinition getDefinition(String definitionId) {

		String surl = endpoint + "/definitions/" + definitionId;
		return restTemplate.getForObject(surl, DeviceDefinition.class);
	}

	@Override
	public DeviceDefinition publishDefinition(DeviceDefinition definition) {
		return restTemplate.postForObject(endpoint + "/definitions", definition, DeviceDefinition.class);
	}

	@Override
	public Collection<DeviceDefinition> getDefinitions() {
		throw new RuntimeException("not implemented in client");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(restTemplate, "Rest template cannot be null");
		Assert.notNull(endpoint, "endpoint cannot be null. Please specify the endpoint of the iot server");
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
