package com.kubrafelek.restapi.repository;

import com.kubrafelek.restapi.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
