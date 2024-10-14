package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartementService implements IDepartementService{

    @Override
    public Departement addDepartement(Departement departement) {
        return null;
    }

    @Override
    public Departement updateDepartement(Departement departement) {
        return null;
    }

    @Override
    public void deleteDepartement(Long id) {

    }

    @Override
    public List<Departement> getAllDepartements() {
        return null;
    }

    @Override
    public Departement getDepartementById(Long id) {
        return null;
    }




    @Autowired
    private DepartementRepository departementRepository;
    // Méthode avancée pour regrouper les départements par entreprise et calculer le nombre total d'employés
    // Méthode avancée pour regrouper les départements par entreprise et calculer le nombre total d'employés
    public Map<String, Long> getTotalEmployeesByEntreprise() {
        return departementRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        departement -> departement.getEntreprise().getName(),
                        Collectors.summingLong(departement -> departement.getEmployes().size())
                ));
    }


}
