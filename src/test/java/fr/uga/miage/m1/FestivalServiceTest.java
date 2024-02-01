package fr.uga.miage.m1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import fr.uga.miage.m1.entities.Festival;
import fr.uga.miage.m1.mapper.FestivalMapper;
import fr.uga.miage.m1.repos.FestivalRepo;
import fr.uga.miage.m1.requests.FestivalFilterRequest;
import fr.uga.miage.m1.services.FestivalService;
import fr.uga.miage.m1.dto.FestivalDto;
import fr.uga.miage.m1.dto.SousDomaineDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class FestivalServiceTest {

    @Mock
    private FestivalRepo repo;

    @Mock
    private FestivalMapper mapper;

    @InjectMocks
    private FestivalService service;

    @Test
    void testCreate() {
        Festival festival = new Festival();
        when(repo.save(any(Festival.class))).thenReturn(festival);

        Festival result = service.create(festival);

        assertEquals(festival, result);
        verify(repo, times(1)).save(festival);
    }

    @Test
    void testGetAll() {
        Festival festival = new Festival();
        FestivalDto festivalDto = new FestivalDto();
        Page<Festival> pageFestival = new PageImpl<>(Collections.singletonList(festival));
        when(repo.findAll(any(Pageable.class))).thenReturn(pageFestival);
        when(mapper.toDto(festival)).thenReturn(festivalDto);

        Page<FestivalDto> result = service.getAll(Pageable.unpaged());

        assertEquals(1, result.getContent().size());
        assertEquals(festivalDto, result.getContent().get(0));
    }

    @Test
    void testGetById() {
        Festival festival = new Festival();
        FestivalDto festivalDto = new FestivalDto();
        when(repo.findById(anyString())).thenReturn(Optional.of(festival));
        when(mapper.toDto(festival)).thenReturn(festivalDto);

        FestivalDto result = service.getById("test");

        assertEquals(festivalDto, result);
    }

    @Test
    void testGetAllLieuPrincipal() {
        Festival festival1 = new Festival();
        Festival festival2 = new Festival();
        FestivalDto festivalDto1 = new FestivalDto();
        festivalDto1.setLieuPrincipal("Lieu 1");
        FestivalDto festivalDto2 = new FestivalDto();
        festivalDto2.setLieuPrincipal("Lieu 2");
        when(repo.findAll()).thenReturn(Arrays.asList(festival1, festival2));
        when(mapper.toDto(festival1)).thenReturn(festivalDto1);
        when(mapper.toDto(festival2)).thenReturn(festivalDto2);

        List<String> result = service.getAllLieuPrincipal();

        assertEquals(2, result.size());
        assertEquals("Lieu 1", result.get(0));
        assertEquals("Lieu 2", result.get(1));
    }

    @Test
    void testGetAllDomaine() {
        Festival festival1 = new Festival();
        Festival festival2 = new Festival();
        FestivalDto festivalDto1 = new FestivalDto();
        SousDomaineDto sousDomaineDto1 = new SousDomaineDto();
        sousDomaineDto1.setNomDomaine("Domaine 1");
        festivalDto1.setSousDomaine(sousDomaineDto1);
        FestivalDto festivalDto2 = new FestivalDto();
        SousDomaineDto sousDomaineDto2 = new SousDomaineDto();
        sousDomaineDto2.setNomDomaine("Domaine 2");
        festivalDto2.setSousDomaine(sousDomaineDto2);
        when(repo.findAll()).thenReturn(Arrays.asList(festival1, festival2));
        when(mapper.toDto(festival1)).thenReturn(festivalDto1);
        when(mapper.toDto(festival2)).thenReturn(festivalDto2);

        List<String> result = service.getAllDomaine();

        assertEquals(2, result.size());
        assertEquals("Domaine 1", result.get(0));
        assertEquals("Domaine 2", result.get(1));
    }


    @Test
    public void testGetByFilter() {
        // Create mock objects
        Festival festival = mock(Festival.class);
        FestivalDto festivalDto = mock(FestivalDto.class);
        FestivalFilterRequest filter = FestivalFilterRequest.builder().build();
        Pageable pageable = mock(Pageable.class);

        // Define behavior of mock objects
        when(repo.findAll(any(Specification.class), any(Pageable.class))).thenReturn(new PageImpl<>(Collections.singletonList(festival)));
        when(mapper.toDto(any(Festival.class))).thenReturn(festivalDto);

        // Call the method to test
        Page<FestivalDto> result = service.getByFilter(filter, pageable);

        // Verify the result
        assertNotNull(result);
    }
    


}
        