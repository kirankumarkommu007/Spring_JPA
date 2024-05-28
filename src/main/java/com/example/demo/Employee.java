package com.example.demo;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name="entity_mapping_annotations")
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="first_name")
	private String name;

	
	@Transient
	private String department;
	
	
}
