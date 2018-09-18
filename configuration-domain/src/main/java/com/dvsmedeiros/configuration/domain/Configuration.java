package com.dvsmedeiros.configuration.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.DomainSpecificEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name = "CONFIGURATION")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Configuration extends DomainSpecificEntity {

	private String value;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH })
	private ConfigurationGroup group;
	
	public Configuration() {
	}
	
	public Configuration(String value) {
		this.value = value;
	}
	
	@JsonIgnore
	public int getIntValue() {
		return Integer.parseInt(value);
	}

	@JsonIgnore
	public double getDoubleValue() {
		return Double.parseDouble(value);
	}

	@JsonIgnore
	public long getLongValue() {
		return Long.parseLong(value);
	}

	@JsonIgnore
	public String getStringValue() {
		return value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ConfigurationGroup getGroup() {
		return group;
	}

	public void setGroup(ConfigurationGroup group) {
		this.group = group;
	}

}
