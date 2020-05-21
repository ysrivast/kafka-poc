package com.kafka.poc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data(staticConstructor = "of")
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Setter(value = AccessLevel.NONE)
	private Long id;

	private String name;

}
