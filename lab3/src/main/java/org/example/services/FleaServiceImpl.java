package org.example.services;

import entity.Cat;
import entity.Flea;
import org.example.repositories.CatRepository;
import org.example.repositories.FleaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FleaServiceImpl implements FleaService{

    @Autowired
    FleaRepository fleaRepository;

    @Autowired
    CatRepository catRepository;
    @Override
    public Flea addFlea(String name, int catId) {
        Cat cat = catRepository.getReferenceById(catId);
        Flea flea = new Flea(name, cat);
        cat.addFlea(flea);
        return fleaRepository.save(flea);
    }

    @Override
    public void deleteFlea(int id) {
        fleaRepository.deleteById(id);
    }

    @Override
    public Flea getFleaById(int id) {
        return fleaRepository.getReferenceById(id);
    }

    @Override
    public List<Flea> getAllByCatId(int id) {
        return fleaRepository.getAllByCatId(id);
    }

    @Override
    public void deleteAll() {
        fleaRepository.deleteAll();
    }

    @Override
    public List<Flea> getAll() {
        return fleaRepository.findAll();
    }
}
