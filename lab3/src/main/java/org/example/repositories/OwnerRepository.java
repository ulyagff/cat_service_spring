package org.example.repositories;

import entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    public List<Owner> getAllByName(String name);
    public List<Owner> getAllByBirthday(LocalDate date);
    //public Owner save(Owner owner);

}
