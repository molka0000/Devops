package tn.esprit.spring.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Departement;

import java.util.List;
@Service
public interface IDepartementService {
    Departement addDepartement(Departement departement);

    Departement updateDepartement(Departement departement);

    void deleteDepartement(Long id);

    List<Departement> getAllDepartements();

    Departement getDepartementById(Long id);
}
