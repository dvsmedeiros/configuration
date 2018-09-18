package com.dvsmedeiros.configuration.core.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.dao.impl.GenericDAO;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.configuration.core.IConfigurationDAO;
import com.dvsmedeiros.configuration.domain.Configuration;
import com.google.common.base.Strings;

@Component
public class ConfigurationDAO extends GenericDAO<Configuration> implements IConfigurationDAO {

	@Override
	public Configuration filter(Filter<Configuration> filter) {

		boolean hasFilter = filter != null && filter.getEntity() != null;

		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT c FROM ");
		jpql.append(Configuration.class.getName());
		jpql.append(" c ");
		jpql.append(" WHERE 1=1 ");

		if (hasFilter && !Strings.isNullOrEmpty(filter.getEntity().getCode())) {
			jpql.append("AND c.code = :code ");
		}

		if (hasFilter && !Strings.isNullOrEmpty(filter.getEntity().getGroup().getCode())) {
			jpql.append("AND c.group.code = :group ");
		}

		Query query = em.createQuery(jpql.toString());

		if (hasFilter && !Strings.isNullOrEmpty(filter.getEntity().getCode())) {
			jpql.append("AND c.code = :code ");
			query.setParameter("code", filter.getEntity().getCode());
		}

		if (hasFilter && !Strings.isNullOrEmpty(filter.getEntity().getGroup().getCode())) {
			query.setParameter("group", filter.getEntity().getGroup().getCode());
		}

		List<Configuration> resultList = query.getResultList();
		return resultList != null && !resultList.isEmpty() ? resultList.get(0) : null;
	}
}
