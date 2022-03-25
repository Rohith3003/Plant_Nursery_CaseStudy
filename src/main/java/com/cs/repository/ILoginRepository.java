package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cs.bean.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, String> {

}