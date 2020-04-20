package com.apirest.rxjava.repository;

import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

import com.apirest.rxjava.documents.Family;

@Repository
public interface FamilyRepository extends RxJava2CrudRepository<Family,String>{

}