package cm.camtech.crm.servicesTest;

import cm.camtech.crm.dtos.LignesCommandesDto;
import cm.camtech.crm.entities.LignesCommandes;
import cm.camtech.crm.mappers.LignesCommandesMapper;
import cm.camtech.crm.repositories.LignesCommandesRepo;
import cm.camtech.crm.services.implementations.LignesCommandesService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LignesCommandesServiceTest {

    @Mock
    private LignesCommandesRepo lignesCommandesRepo;

    @Mock
    private LignesCommandesMapper lignesCommandesMapper;

    @InjectMocks
    private LignesCommandesService lignesCommandesService;

    private LignesCommandes lignesCommandes;
    private LignesCommandesDto lignesCommandesDto;

    @BeforeEach
    void setUp() {
        lignesCommandes = new LignesCommandes();
        lignesCommandes.setId(1L);

        lignesCommandesDto = new LignesCommandesDto();
        lignesCommandesDto.setId(1L);
    }

    @Test
    void testGetAllLignesCommandes() {
        List<LignesCommandes> liste = new ArrayList<>();
        liste.add(lignesCommandes);

        when(lignesCommandesRepo.findAll()).thenReturn(liste);
        when(lignesCommandesMapper.toDto(any(LignesCommandes.class))).thenReturn(lignesCommandesDto);

        List<LignesCommandesDto> resultat = lignesCommandesService.findAll();

        assertNotNull(resultat);
        assertEquals(1, resultat.size());

        verify(lignesCommandesRepo, times(1)).findAll();
    }

    @Test
    void testGetLigneCommandeById() {
        when(lignesCommandesRepo.findById(1L)).thenReturn(Optional.of(lignesCommandes));
        when(lignesCommandesMapper.toDto(lignesCommandes)).thenReturn(lignesCommandesDto);

        LignesCommandesDto resultat = lignesCommandesService.findById(1L);

        assertNotNull(resultat);

        verify(lignesCommandesRepo, times(1)).findById(1L);
    }

    @Test
    void testSaveLigneCommande() {
        when(lignesCommandesMapper.toEntity(lignesCommandesDto)).thenReturn(lignesCommandes);
        when(lignesCommandesRepo.save(lignesCommandes)).thenReturn(lignesCommandes);
        when(lignesCommandesMapper.toDto(lignesCommandes)).thenReturn(lignesCommandesDto);

        LignesCommandesDto resultat = lignesCommandesService.save(lignesCommandesDto);

        assertNotNull(resultat);

        verify(lignesCommandesRepo, times(1)).save(lignesCommandes);
    }

    @Test
    void testUpdateLigneCommande() {
        when(lignesCommandesRepo.existsById(1L)).thenReturn(true);
        when(lignesCommandesMapper.toEntity(lignesCommandesDto)).thenReturn(lignesCommandes);
        when(lignesCommandesRepo.save(lignesCommandes)).thenReturn(lignesCommandes);
        when(lignesCommandesMapper.toDto(lignesCommandes)).thenReturn(lignesCommandesDto);

        LignesCommandesDto resultat = lignesCommandesService.update(1L, lignesCommandesDto);

        assertNotNull(resultat);

        verify(lignesCommandesRepo, times(1)).save(lignesCommandes);
    }

    @Test
    void testDeleteLigneCommande() {
        when(lignesCommandesRepo.existsById(1L)).thenReturn(true);
        doNothing().when(lignesCommandesRepo).deleteById(1L);

        lignesCommandesService.delete(1L);

        verify(lignesCommandesRepo, times(1)).deleteById(1L);
    }
}
