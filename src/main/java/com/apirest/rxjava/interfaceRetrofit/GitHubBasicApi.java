package com.apirest.rxjava.interfaceRetrofit;

import java.util.List;

import com.apirest.rxjava.documents.Student;

import io.reactivex.Flowable;

import retrofit2.http.GET;

public interface GitHubBasicApi {
	
	@GET("api-student")
    Flowable<List<Student>> listAllStudent();
    
}
