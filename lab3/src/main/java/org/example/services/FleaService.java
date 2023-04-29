package org.example.services;

import entity.Cat;
import entity.Flea;
import entity.Owner;

import java.time.LocalDate;
import java.util.List;

public interface FleaService {
    public Flea addFlea(String name, int catId);
    public void deleteFlea(int id);
    public Flea getFleaById(int id);
    public List<Flea> getAllByCatId(int id);
    public void deleteAll();
    public List<Flea> getAll();
}
