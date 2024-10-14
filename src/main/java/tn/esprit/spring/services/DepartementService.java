package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartementService implements IDepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public Map<String, Long> getTotalEmployeesByEntreprise() {
        return departementRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        departement -> departement.getEntreprise().getName(),
                        Collectors.summingLong(departement -> departement.getEmployes().size())
                ));
    }
}
