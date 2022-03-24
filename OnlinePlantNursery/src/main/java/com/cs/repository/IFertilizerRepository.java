package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs.bean.Fertilizer;


@Repository
public interface IFertilizerRepository extends JpaRepository<Fertilizer, Integer> {
	
	public Fertilizer findByName(String name);
	
	@Query(value="delete from fertilizer where name=:name returning *", nativeQuery=true)
	public Fertilizer deleteByName(@Param("name") String name);
	
//	@Query(value="update fertilizer set price=:price where fertilizer_id=:id returning *", nativeQuery=true)
//	public Fertilizer updatePriceById(@Param("id") int id, @Param("price") double price);
//	
//	@Query(value="update fertilizer set price=:price where name=:name returning *", nativeQuery=true)
//	public Fertilizer updatePriceByName(@Param("name") String name, @Param("price") double price);

}
