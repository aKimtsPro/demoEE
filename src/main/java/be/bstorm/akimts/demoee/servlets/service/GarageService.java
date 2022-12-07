package be.bstorm.akimts.demoee.servlets.service;

import be.bstorm.akimts.demoee.servlets.model.Voiture;

import java.util.List;
import java.util.Optional;

public interface GarageService {

    void ajouter(Voiture toAdd);

    List<Voiture> getAll();

    Voiture getOne(int index);

}
