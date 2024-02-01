package fr.uga.miage.m1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.uga.miage.m1.dto.PanierDto;
import fr.uga.miage.m1.entities.Adherent;
import fr.uga.miage.m1.entities.CovoiturageLieu;
import fr.uga.miage.m1.entities.Panier;
import fr.uga.miage.m1.entities.PanierOffre;
import fr.uga.miage.m1.mapper.PanierMapper;
import fr.uga.miage.m1.repos.AdherentRepo;
import fr.uga.miage.m1.repos.PanierRepo;
import fr.uga.miage.m1.requests.CreatePanierRequest;
import fr.uga.miage.m1.services.CovoiturageLieuService;
import fr.uga.miage.m1.services.PanierOffreService;
import fr.uga.miage.m1.services.PanierService;

@ExtendWith(MockitoExtension.class)
class PanierServiceTest {

    @Mock
    private PanierRepo repo;

    @Mock
    private PanierMapper mapper;

    @Mock
    private AdherentRepo adherentRepo;

    @Mock
    private CovoiturageLieuService covoiturageLieuService;

    @Mock
    private PanierOffreService panierOffreService;

    @InjectMocks
    private PanierService service;

    @Test
    public void testCreate() {
        // Arrange
        CreatePanierRequest request = CreatePanierRequest.builder().build();
        request.setEtat(Etat.ENCOURS);
        request.setDatePanier(new Date());
        request.setUserMail("test@mail.com");
        PanierDto dto = new PanierDto();
        dto.setEtat(Etat.ENCOURS);
        dto.setDatePanier(new Date());
        when(mapper.toEntity(any(PanierDto.class))).thenReturn(new Panier());
        when(adherentRepo.findByMail(any(String.class))).thenReturn(new Adherent());
        when(repo.save(any(Panier.class))).thenReturn(new Panier());
        when(mapper.toDto(any(Panier.class))).thenReturn(dto);

        // Act
        PanierDto result = service.create(request);

        // Assert
        assertEquals(Etat.ENCOURS, result.getEtat());
        assertEquals(request.getDatePanier(), result.getDatePanier());
    }

     @Test
    void testGetCurrentPanierByUserMail() {
        String userMail = "test@mail.com";

        Adherent adherent = new Adherent();
        adherent.setMail(userMail);

        Panier panier = new Panier();
        panier.setAdherent(adherent);
        panier.setEtat(Etat.ENCOURS);
        panier.setDatePanier(new Date());

        PanierDto dto = new PanierDto();

        when(service.getCurrentPanierEntityByUserMail(userMail)).thenReturn(Optional.of(panier));
        when(mapper.toDto(panier)).thenReturn(dto);

        Optional<PanierDto> result = service.getCurrentPanierByUserMail(userMail);

        assertTrue(result.isPresent());
        assertEquals(dto, result.get());
    }

    @Test
    void testGetCurrentPanierEntityByUserMail() {
        String userMail = "test@mail.com";

        Adherent adherent = new Adherent();
        adherent.setMail(userMail);

        Panier panier = new Panier();
        panier.setAdherent(adherent);
        panier.setEtat(Etat.ENCOURS);
        panier.setDatePanier(new Date());

        when(repo.findByAdherentMailAndEtat(userMail, Etat.valueOf("ENCOURS"))).thenReturn(Optional.of(panier));

        Optional<Panier> result = service.getCurrentPanierEntityByUserMail(userMail);

        assertTrue(result.isPresent());
        assertEquals(panier, result.get());
    }

    @Test
    public void testGetAll() {
        // Arrange
        Panier panier = new Panier();
        panier.setEtat(Etat.ENCOURS);
        when(repo.findAll()).thenReturn(Arrays.asList(panier));
        PanierDto dto = new PanierDto();
        dto.setEtat(Etat.ENCOURS);
        when(mapper.toDto(any(Panier.class))).thenReturn(dto);

        // Act
        List<PanierDto> result = service.getAll();

        // Assert
        assertEquals(1, result.size());
        assertEquals(Etat.ENCOURS, result.get(0).getEtat());
    }

    @Test
    public void testSetEtatToPaye() throws Exception {
        // Create mock object
        Panier panier = mock(Panier.class);

        // Define behavior of mock objects
        when(repo.findById(anyLong())).thenReturn(Optional.of(panier));

        // Call the method to test
        service.setEtatToPaye(1L);

        // Verify that setEtat was called with Etat.PAYE
        verify(panier, times(1)).setEtat(Etat.PAYE);
    }

    
}
