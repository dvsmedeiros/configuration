package com.dvsmedeiros.configuration.core;

import java.util.stream.Stream;

import com.dvsmedeiros.bce.core.dao.IDAO;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.configuration.domain.Configuration;

public interface IConfigurationDAO extends IDAO<Configuration> {

	public Stream<Configuration> filter(Filter<Configuration> filter);
}
