package org.example.services;

import entity.Cat;
import entity.Owner;

import java.time.LocalDate;
import java.util.List;

public interface CatService {
    public Cat addCat(String name, LocalDate birthday, String breed, String color, int ownerId, int tailLength);
    public void deleteCat(int id);
    public Cat getCatById(int id);
    public List<Cat> getAllByName(String name);
    public List<Cat> getAllByBirthday(LocalDate birthday);
    public List<Cat> getAllByBreed(String breed);
    public List<Cat> getAllByColor(String color);
    public List<Cat> getAllByOwnerId(int id);
    public void deleteAll();
    public List<Cat> getAll();
}
