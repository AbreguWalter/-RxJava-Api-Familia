package com.apirest.rxjava.restcontroller;

import com.apirest.rxjava.documents.Family;
import com.apirest.rxjava.documents.Student;
import com.apirest.rxjava.service.FamilyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;


@RestController
@RequestMapping("/api-family")
public class FamilyRestController{
    @Autowired
    private FamilyService familyService;

    @GetMapping
    public Flowable<Family> listAllFamily(){
        return familyService.listFamily();
    }
    
    @GetMapping("/student")
    public Flowable<Student> listAllStudent(){
        return familyService.list();
    }

    @PostMapping
    public Single<Family> saveStudent(@RequestBody Family family ){
        return familyService.saveFamily(family);
    }
    
    
    @PutMapping("/{id}")
	public Single<Family> update(@RequestBody Family family,@PathVariable String id){
		return familyService.updateFamily(family, id);
    	
	}
	
	@DeleteMapping("/{id}")
	public Completable delete(@PathVariable String id) {
		return familyService.deleteFamily(id);
	}

}