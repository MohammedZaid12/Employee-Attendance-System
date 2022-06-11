package com.company.employeeattendance.services;

import java.util.List;

public interface  BaseService<Type, Dto> {

     List<Type> findAll();

     List<Type> findAllActive();


    Type findById(Integer id);

    Dto findByIdDto(Integer id);

     Type save(Type type);

     Dto saveByDto(Dto dto);

}
