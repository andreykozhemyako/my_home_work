package com.simbirsoft.javacourse.repository;

import com.simbirsoft.javacourse.entity.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonalData,Long> {

    List<PersonalData> findAll();

    List<PersonalData> findByEmail(String email);

    List<PersonalData> findById(Long id);


}
