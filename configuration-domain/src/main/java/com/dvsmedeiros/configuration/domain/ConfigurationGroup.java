package com.dvsmedeiros.configuration.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.DomainSpecificEntity;

@Entity
@Table(name="CONFIGURATION_GROUP")
public class ConfigurationGroup extends DomainSpecificEntity {

}
