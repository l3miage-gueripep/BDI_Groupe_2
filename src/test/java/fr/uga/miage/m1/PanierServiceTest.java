package fr.uga.miage.m1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.uga.miage.m1.dto.PanierDto;
import fr.uga.miage.m1.entities.Adherent;
import fr.uga.miage.m1.entities.Panier;
import fr.uga.miage.m1.mapper.PanierMapper;
import fr.uga.miage.m1.repos.AdherentRepo;
import fr.uga.miage.m1.repos.PanierRepo;
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
}
