package com.apirest.rxjava.documents;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student{
    private String id;
    private String fullname;
    private String nickname;
}