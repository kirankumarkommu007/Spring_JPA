package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.enitities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
