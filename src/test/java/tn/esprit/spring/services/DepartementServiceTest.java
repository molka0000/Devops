package tn.esprit.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;

import tn.esprit.spring.repository.DepartementRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DepartementServiceTest {

    @InjectMocks
    private DepartementService departementService;

    @Mock
    private DepartementRepository departementRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTotalEmployeesByEntreprise() {
        // Création des données de test
        Entreprise entreprise1 = new Entreprise();
        entreprise1.setName("Entreprise A");

        Entreprise entreprise2 = new Entreprise();
        entreprise2.setName("Entreprise B");

        Departement departement1 = new Departement();
        departement1.setEntreprise(entreprise1);
        departement1.setEmployes(Arrays.asList(new Employe(), new Employe())); // 2 employés

        Departement departement2 = new Departement();
        departement2.setEntreprise(entreprise1);
        departement2.setEmployes(Arrays.asList(new Employe())); // 1 employé

        Departement departement3 = new Departement();
        departement3.setEntreprise(entreprise2);
        departement3.setEmployes(Arrays.asList(new Employe(), new Employe(), new Employe())); // 3 employés

        List<Departement> departements = Arrays.asList(departement1, departement2, departement3);

        // Mocking du repository
        when(departementRepository.findAll()).thenReturn(departements);

        // Appel de la méthode à tester
        Map<String, Long> result = departementService.getTotalEmployeesByEntreprise();

        // Vérification des résultats
        Map<String, Long> expected = new HashMap<>();
        expected.put("Entreprise A", 3L); // 2 + 1
        expected.put("Entreprise B", 3L);

        assertEquals(expected, result);
    }
}
