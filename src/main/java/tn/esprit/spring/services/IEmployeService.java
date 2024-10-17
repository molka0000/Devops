package tn.esprit.spring.services;

import tn.esprit.spring.entities.Employe;

import java.util.List;

public interface IEmployeService {
    double calculateActiveEmployeesPercentage();
    List<Employe> getEmployesByRole(String role);
    int countEmployesByActiveStatus(boolean isActive);
    // Ajoutez d'autres méthodes avancées si nécessaire
}
