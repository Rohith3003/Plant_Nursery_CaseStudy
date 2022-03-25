package com.onlineplantnursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlineplantnursery.bean.Seed;

@Repository
public interface ISeedRepository extends JpaRepository<Seed, Integer> {
	
	//Get Seed by name
	@Query(value="select p from Seed p where p.name=:name")
	public Seed getByName(@Param("name") String name);
}
