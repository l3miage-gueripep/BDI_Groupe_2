package fr.uga.miage.m1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import fr.uga.miage.m1.dto.OffreCovoiturageDto;
import fr.uga.miage.m1.entities.OffreCovoiturage;
import fr.uga.miage.m1.mapper.OffreCovoiturageMapper;
import fr.uga.miage.m1.repos.OffreCovoiturageRepo;
import fr.uga.miage.m1.services.OffreCovoiturageService;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class OffreCovoiturageServiceTest {

    @Mock
    private OffreCovoiturageRepo repo;

    @Mock
    private OffreCovoiturageMapper mapper;

    @InjectMocks
    private OffreCovoiturageService service;

    @Test
    void testCreate() {
        OffreCovoiturageDto offreCovoiturageDto = new OffreCovoiturageDto();
        OffreCovoiturage offreCovoiturage = new OffreCovoiturage();
        when(mapper.toEntity(offreCovoiturageDto)).thenReturn(offreCovoiturage);
        when(repo.save(offreCovoiturage)).thenReturn(offreCovoiturage);
        when(mapper.toDto(offreCovoiturage)).thenReturn(offreCovoiturageDto);

        OffreCovoiturageDto result = service.create(offreCovoiturageDto);

        assertEquals(offreCovoiturageDto, result);
    }

    @Test
    void testGetAll() {
        Pageable pageable = mock(Pageable.class);
        OffreCovoiturage offreCovoiturage1 = new OffreCovoiturage();
        OffreCovoiturage offreCovoiturage2 = new OffreCovoiturage();
        OffreCovoiturageDto offreCovoiturageDto1 = new OffreCovoiturageDto();
        OffreCovoiturageDto offreCovoiturageDto2 = new OffreCovoiturageDto();
        Page<OffreCovoiturage> page = new PageImpl<>(Arrays.asList(offreCovoiturage1, offreCovoiturage2));
        when(repo.findAll(pageable)).thenReturn(page);
        when(mapper.toDto(offreCovoiturage1)).thenReturn(offreCovoiturageDto1);
        when(mapper.toDto(offreCovoiturage2)).thenReturn(offreCovoiturageDto2);

        List<OffreCovoiturageDto> result = service.getAll(pageable);

        assertEquals(2, result.size());
        assertEquals(offreCovoiturageDto1, result.get(0));
        assertEquals(offreCovoiturageDto2, result.get(1));
    }

    @Test
    void testGetAllByFestival() {
        Pageable pageable = mock(Pageable.class);
        OffreCovoiturage offreCovoiturage1 = new OffreCovoiturage();
        OffreCovoiturage offreCovoiturage2 = new OffreCovoiturage();
        OffreCovoiturageDto offreCovoiturageDto1 = new OffreCovoiturageDto();
        OffreCovoiturageDto offreCovoiturageDto2 = new OffreCovoiturageDto();
        Page<OffreCovoiturage> page = new PageImpl<>(Arrays.asList(offreCovoiturage1, offreCovoiturage2));
        when(repo.findAllByFestivalNomManifestation("Festival1", pageable)).thenReturn(page);
        when(mapper.toDto(offreCovoiturage1)).thenReturn(offreCovoiturageDto1);
        when(mapper.toDto(offreCovoiturage2)).thenReturn(offreCovoiturageDto2);

        List<OffreCovoiturageDto> result = service.getAllByFestival(pageable, "Festival1");

        assertEquals(2, result.size());
        assertEquals(offreCovoiturageDto1, result.get(0));
        assertEquals(offreCovoiturageDto2, result.get(1));
    }

    @Test
    void testGetById() {
        OffreCovoiturage offreCovoiturage = new OffreCovoiturage();
        OffreCovoiturageDto offreCovoiturageDto = new OffreCovoiturageDto();
        when(repo.findById(1L)).thenReturn(Optional.of(offreCovoiturage));
        when(mapper.toDto(offreCovoiturage)).thenReturn(offreCovoiturageDto);

        OffreCovoiturageDto result = service.getById(1L);

        assertEquals(offreCovoiturageDto, result);
    }

    @Test
    void testGetByIdNotFound() {
        when(repo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> service.getById(1L));
    }

    @Test
    void testPrendrePlaces() {
        OffreCovoiturage offreCovoiturage = new OffreCovoiturage();
        offreCovoiturage.setNbPlaces(5);
        OffreCovoiturageDto offreCovoiturageDto = new OffreCovoiturageDto();
        when(repo.findById(1L)).thenReturn(Optional.of(offreCovoiturage));
        when(mapper.toDto(offreCovoiturage)).thenReturn(offreCovoiturageDto);
    
        OffreCovoiturageDto result = service.prendrePlaces(1L, 2);
    
        assertEquals(offreCovoiturageDto, result);
        assertEquals(3, offreCovoiturage.getNbPlaces());
        verify(repo, times(1)).save(offreCovoiturage);
    }
    
    @Test
    void testPrendrePlacesNotFound() {
        when(repo.findById(1L)).thenReturn(Optional.empty());
    
        assertThrows(NoSuchElementException.class, () -> service.prendrePlaces(1L, 2));
    }
    
}