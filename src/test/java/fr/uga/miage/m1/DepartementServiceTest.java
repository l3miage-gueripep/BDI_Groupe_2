package fr.uga.miage.m1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.uga.miage.m1.entities.Departement;
import fr.uga.miage.m1.repos.DepartementRepo;
import fr.uga.miage.m1.services.DepartementService;

@ExtendWith(MockitoExtension.class)
class DepartementServiceTest {

    @Mock
    private DepartementRepo repo;

    @InjectMocks
    private DepartementService service;

    @Test
    void testCreate() {
        Departement departement = new Departement();
        when(repo.save(any(Departement.class))).thenReturn(departement);

        Departement result = service.create(departement);

        assertEquals(departement, result);
        verify(repo, times(1)).save(departement);
    }
}
