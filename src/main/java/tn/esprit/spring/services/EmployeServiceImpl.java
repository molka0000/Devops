package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeServiceImpl implements IEmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public double calculateActiveEmployeesPercentage() {
        List<Employe> allEmployes = employeRepository.findAll();
        long totalEmployes = allEmployes.size();
        long activeEmployesCount = allEmployes.stream().filter(Employe::isActif).count();
        return totalEmployes == 0 ? 0 : (double) activeEmployesCount / totalEmployes * 100;
    }

    @Override
    public List<Employe> getEmployesByRole(String role) {
        return employeRepository.findAll()
                .stream()
                .filter(employe -> employe.getRole().toString().equals(role))
                .collect(Collectors.toList()); // Utilisation de collect() au lieu de toList()
    }

    @Override
    public int countEmployesByActiveStatus(boolean isActive) {
        return (int) employeRepository.findAll()
                .stream()
                .filter(employe -> employe.isActif() == isActive)
                .count();
    }

    // Vous pouvez ajouter d'autres méthodes avancées ici
}
