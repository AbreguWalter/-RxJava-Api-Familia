package com.apirest.rxjava.impl;

import com.apirest.rxjava.documents.Family;
import com.apirest.rxjava.documents.Student;
import com.apirest.rxjava.interfaceRetrofit.GitHubBasicApi;
import com.apirest.rxjava.repository.FamilyRepository;
import com.apirest.rxjava.service.FamilyService;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class FamilyImplement implements FamilyService{

    @Autowired
    private FamilyRepository familyRepo;
    

    @Override
    public Flowable<Family> listFamily(){
        return familyRepo.findAll();
    }

    @Override
    public Single<Family> saveFamily(Family family){
       return familyRepo.save(family);
    }

	@Override
	public Single<Family> updateFamily(Family family,String id) {
		return familyRepo.findById(id).map(s->{
			s.setFullname(family.getFullname());
			s.setNickname(family.getNickname());
			return s;
		})
		.toSingle()
		.flatMap(ss->{
			return familyRepo.save(ss);
		});
	}

	@Override
	public Completable deleteFamily(String id) {
		return familyRepo.deleteById(id);
	}

	@Override
	public Maybe<Family> findById(String id) {
		return familyRepo.findById(id);
	}
	
	@Override
	public Flowable<Student> list() {	
		Retrofit retrofit = new Retrofit.Builder()
  			  .baseUrl("http://localhost:8081/")
  			  .addConverterFactory(GsonConverterFactory.create())
  			  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
  			  .build();
		
	  	 GitHubBasicApi gitHubApi = retrofit.create(GitHubBasicApi.class);
	  	Flowable<Student> st = gitHubApi.listAllStudent().flatMap(s->Flowable.fromIterable(s));
	  	return st;
	}
}