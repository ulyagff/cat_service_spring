package org.example.services;

import entity.Cat;
import entity.Owner;
import org.example.repositories.CatRepository;
import org.example.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CatServiceImpl implements CatService{
    @Autowired
    CatRepository catRepository;

    @Autowired
    OwnerRepository ownerRepository;
    @Override
    public Cat addCat(String name, LocalDate birthday, String breed, String color, int ownerId, int tailLength) {
        Owner owner = ownerRepository.getReferenceById(ownerId);
        Cat cat = new Cat(name, birthday, breed, Cat.ColorType.valueOf(color), owner, tailLength);
        owner.addCat(cat);
        return catRepository.save(cat);
    }

    @Override
    public void deleteCat(int id) {
        catRepository.deleteById(id);
    }

    @Override
    public Cat getCatById(int id) {
        return catRepository.getReferenceById(id);
    }

    @Override
    public List<Cat> getAllByName(String name) {
        return catRepository.getAllByName(name);
    }

    @Override
    public List<Cat> getAllByBirthday(LocalDate birthday) {
        return catRepository.getAllByBirthday(birthday);
    }

    @Override
    public List<Cat> getAllByBreed(String breed) {
        return catRepository.getAllByBreed(breed);
    }

    @Override
    public List<Cat> getAllByColor(String color) {
        return catRepository.getAllByColor(Cat.ColorType.valueOf(color));
    }

    @Override
    public List<Cat> getAllByOwnerId(int id) {
        return catRepository.getAllByOwnerId(id);
    }

    @Override
    public void deleteAll() {
        catRepository.deleteAll();
    }

    @Override
    public List<Cat> getAll() {
        return catRepository.findAll();
    }
}
