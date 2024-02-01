package fr.uga.miage.m1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import fr.uga.miage.m1.dto.CovoiturageLieuDto;
import fr.uga.miage.m1.entities.CovoiturageLieu;
import fr.uga.miage.m1.mapper.CovoiturageLieuMapper;
import fr.uga.miage.m1.mapper.LieuCovoiturageMapper;
import fr.uga.miage.m1.mapper.OffreCovoiturageMapper;
import fr.uga.miage.m1.repos.CovoiturageLieuRepo;
import fr.uga.miage.m1.services.CovoiturageLieuService;
import fr.uga.miage.m1.services.LieuCovoiturageService;
import fr.uga.miage.m1.services.OffreCovoiturageService;

@ExtendWith(MockitoExtension.class)
class CovoiturageLieuServiceTest {

    @InjectMocks
    CovoiturageLieuService service;

    @Mock
    CovoiturageLieuRepo repo;

    @Mock
    CovoiturageLieuMapper mapper;

    @Mock
    OffreCovoiturageMapper offreCovoiturageMapper;

    @Mock
    OffreCovoiturageService offreCovoiturageService;

    @Mock
    LieuCovoiturageMapper lieuCovoiturageMapper;

    @Mock
    LieuCovoiturageService lieuCovoiturageService;

   

    @Test
    void testSave() {
        CovoiturageLieu entity = new CovoiturageLieu();
        CovoiturageLieuDto dto = new CovoiturageLieuDto();
        when(mapper.toDto(any(CovoiturageLieu.class))).thenReturn(dto);
        when(repo.save(any(CovoiturageLieu.class))).thenReturn(entity);

        CovoiturageLieuDto result = service.save(entity);

        assertEquals(dto, result);
        verify(mapper).toDto(entity);
        verify(repo).save(entity);
    }

    @Test
    void testGetAll() {
        CovoiturageLieu entity = new CovoiturageLieu();
        CovoiturageLieuDto dto = new CovoiturageLieuDto();
        when(repo.findAll()).thenReturn(Arrays.asList(entity));
        when(mapper.toDto(entity)).thenReturn(dto);

        List<CovoiturageLieuDto> result = service.getAll();

        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
        verify(repo).findAll();
        verify(mapper).toDto(entity);
    }

    @Test
    void testGetById() {
        Long id = 1L;
        CovoiturageLieu entity = new CovoiturageLieu();
        CovoiturageLieuDto dto = new CovoiturageLieuDto();
        when(repo.findById(id)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);

        CovoiturageLieuDto result = service.getById(id);

        assertEquals(dto, result);
        verify(repo).findById(id);
        verify(mapper).toDto(entity);
    }


    @Test
    public void testGetAllWithPageable() {
        // Create mock objects
        CovoiturageLieu covoiturageLieu = mock(CovoiturageLieu.class);
        CovoiturageLieuDto covoiturageLieuDto = mock(CovoiturageLieuDto.class);
        Pageable pageable = mock(Pageable.class);

        // Define behavior of mock objects
        when(repo.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(Collections.singletonList(covoiturageLieu)));
        when(mapper.toDto(any(CovoiturageLieu.class))).thenReturn(covoiturageLieuDto);

        // Call the method to test
        Page<CovoiturageLieuDto> result = service.getAll(pageable);

        // Verify the result
        assertEquals(1, result.getContent().size());
        assertEquals(covoiturageLieuDto, result.getContent().get(0));
    }

    @Test
    public void testGetByIdFestival() {
        // Create mock objects
        CovoiturageLieu covoiturageLieu = mock(CovoiturageLieu.class);
        CovoiturageLieuDto covoiturageLieuDto = mock(CovoiturageLieuDto.class);
        Pageable pageable = mock(Pageable.class);

        // Define behavior of mock objects
        when(repo.findByOffreCovoiturageFestivalNomManifestation(any(Pageable.class), anyString())).thenReturn(new PageImpl<>(Collections.singletonList(covoiturageLieu)));
        when(mapper.toDto(any(CovoiturageLieu.class))).thenReturn(covoiturageLieuDto);

        // Call the method to test
        Page<CovoiturageLieuDto> result = service.getByIdFestival(pageable, "Test Festival");

        // Verify the result
        assertEquals(1, result.getContent().size());
        assertEquals(covoiturageLieuDto, result.getContent().get(0));
    }
}