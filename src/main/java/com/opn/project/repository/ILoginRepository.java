package com.opn.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opn.project.bean.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, String>{

}
