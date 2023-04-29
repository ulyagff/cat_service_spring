package org.example.repositories;

import entity.Cat;
import entity.Flea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FleaRepository extends JpaRepository<Flea, Integer> {
    public List<Flea> getAllByCatId(int id);
}
