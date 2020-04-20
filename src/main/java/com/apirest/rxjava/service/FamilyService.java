package com.apirest.rxjava.service;

import com.apirest.rxjava.documents.Family;
import com.apirest.rxjava.documents.Student;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface FamilyService{
	
    Flowable<Family> listFamily();
    
    Single<Family> saveFamily(Family family);
    
    Single<Family> updateFamily(Family family,String id);
    
    Completable deleteFamily(String id);
    
    Maybe<Family> findById(String id);
    
    Flowable<Student> list();
}