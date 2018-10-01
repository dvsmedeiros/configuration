package com.dvsmedeiros.configuration.core;

import java.util.Map;
import java.util.Optional;

import com.dvsmedeiros.bce.core.controller.IFacade;
import com.dvsmedeiros.configuration.domain.Configuration;

public interface IConfigurationFacade extends IFacade<Configuration>{

	public Optional<Configuration> find(String group, String code, String defaultValue);

	public Map<String, Configuration> find(String group);
}
