package tn.esprit.spring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;  // Import de l'énumération Role
import tn.esprit.spring.repository.EmployeRepository;

import java.util.Arrays;
import java.util.List;

public class EmployeServiceImplTest {

    @Mock
    private EmployeRepository employeRepository;

    @InjectMocks
    private EmployeServiceImpl employeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialisation des mocks
    }

    @Test
    public void testCalculateActiveEmployeesPercentage_WithMixedEmployees() {
        // Arrange : Créez une liste d'employés avec des états actifs et inactifs
        List<Employe> employes = Arrays.asList(
                new Employe("Alice", "Smith", "alice.smith@example.com", "password", true, Role.INGENIEUR),
                new Employe("Bob", "Brown", "bob.brown@example.com", "password", false, Role.ADMINISTRATEUR),
                new Employe("Charlie", "Johnson", "charlie.johnson@example.com", "password", true, Role.TECHNICIEN)
        );

        // Simulez le comportement du repository
        when(employeRepository.findAll()).thenReturn(employes);

        // Act : Calculez le pourcentage d'employés actifs
        double percentage = employeService.calculateActiveEmployeesPercentage();

        // Assert : Vérifiez que le pourcentage est correct (66.67%)
        assertEquals(66.67, percentage, 0.01);
    }
}
