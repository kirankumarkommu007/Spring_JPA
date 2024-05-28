package com.example.demo.enitities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Employee_oto")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;

}
