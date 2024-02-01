package fr.uga.miage.m1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.uga.miage.m1.entities.PanierOffre;
import fr.uga.miage.m1.repos.PanierOffreRepo;
import fr.uga.miage.m1.services.PanierOffreService;

@ExtendWith(MockitoExtension.class)
class PanierOffreServiceTest {

    @Mock
    private PanierOffreRepo repo;

    @InjectMocks
    private PanierOffreService service;

    @Test
    void testSave() {
        PanierOffre panierOffre = new PanierOffre();
        when(repo.save(any(PanierOffre.class))).thenReturn(panierOffre);

        PanierOffre result = service.save(panierOffre);

        assertEquals(panierOffre, result);
        verify(repo, times(1)).save(panierOffre);
    }

    @Test
    void testDeleteAll() {
        service.deleteAll();

        verify(repo, times(1)).deleteAll();
    }

    @Test
    void testDeleteById() {
        Long idPanierOffre = 1L;
        doNothing().when(repo).deleteByIdPanierOffre(idPanierOffre);

        service.deleteById(idPanierOffre);

        verify(repo, times(1)).deleteByIdPanierOffre(idPanierOffre);
    }
}