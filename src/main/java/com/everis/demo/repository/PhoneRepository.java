package com.everis.demo.repository;


import com.everis.demo.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, String> {
    
    @Query(value = "select p from Phone p where p.userUuid = :id ")
    public List<Phone> findPhoneUserID(@Param("id") String id);
}
