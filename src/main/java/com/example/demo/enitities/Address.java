package com.example.demo.enitities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Address_oto")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String city;
	private Long pincode;



}