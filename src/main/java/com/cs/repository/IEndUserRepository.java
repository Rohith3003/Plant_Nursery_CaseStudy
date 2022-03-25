package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cs.bean.EndUser;


@Repository
public interface IEndUserRepository extends JpaRepository<EndUser, Integer> {

}
