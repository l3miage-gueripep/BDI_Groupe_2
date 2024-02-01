package fr.uga.miage.m1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.uga.miage.m1.entities.LieuCovoiturage;
import fr.uga.miage.m1.mapper.LieuCovoiturageMapper;
import fr.uga.miage.m1.repos.LieuCovoiturageRepo;
import fr.uga.miage.m1.services.LieuCovoiturageService;
import fr.uga.miage.m1.dto.LieuCovoiturageDto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class LieuCovoiturageServiceTest {

    @Mock
    private LieuCovoiturageRepo repo;

    @Mock
    private LieuCovoiturageMapper mapper;

    @InjectMocks
    private LieuCovoiturageService service;

    @Test
    void testCreate() {
        LieuCovoiturage lieuCovoiturage = new LieuCovoiturage();
        when(repo.save(any(LieuCovoiturage.class))).thenReturn(lieuCovoiturage);

        LieuCovoiturage result = service.create(lieuCovoiturage);

        assertEquals(lieuCovoiturage, result);
        verify(repo, times(1)).save(lieuCovoiturage);
    }

    @Test
    void testGetAll() {
        LieuCovoiturage lieuCovoiturage1 = new LieuCovoiturage();
        LieuCovoiturage lieuCovoiturage2 = new LieuCovoiturage();
        LieuCovoiturageDto lieuCovoiturageDto1 = new LieuCovoiturageDto();
        LieuCovoiturageDto lieuCovoiturageDto2 = new LieuCovoiturageDto();
        when(repo.findAll()).thenReturn(Arrays.asList(lieuCovoiturage1, lieuCovoiturage2));
        when(mapper.toDto(lieuCovoiturage1)).thenReturn(lieuCovoiturageDto1);
        when(mapper.toDto(lieuCovoiturage2)).thenReturn(lieuCovoiturageDto2);

        List<LieuCovoiturageDto> result = service.getAll();

        assertEquals(2, result.size());
        assertEquals(lieuCovoiturageDto1, result.get(0));
        assertEquals(lieuCovoiturageDto2, result.get(1));
    }

    @Test
    void testGetById() {
        LieuCovoiturage lieuCovoiturage = new LieuCovoiturage();
        LieuCovoiturageDto lieuCovoiturageDto = new LieuCovoiturageDto();
        when(repo.findById("1")).thenReturn(Optional.of(lieuCovoiturage));
        when(mapper.toDto(lieuCovoiturage)).thenReturn(lieuCovoiturageDto);

        LieuCovoiturageDto result = service.getById("1");

        assertEquals(lieuCovoiturageDto, result);
    }

    @Test
    void testGetByIdNotFound() {
        when(repo.findById("1")).thenReturn(Optional.empty());

        LieuCovoiturageDto result = service.getById("1");

        assertNull(result);
    }
}