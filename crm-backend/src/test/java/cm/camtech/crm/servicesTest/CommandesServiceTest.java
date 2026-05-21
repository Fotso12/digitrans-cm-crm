package cm.camtech.crm.servicesTest;

import cm.camtech.crm.dtos.CommandesDto;
import cm.camtech.crm.entities.Commandes;
import cm.camtech.crm.mappers.CommandesMapper;
import cm.camtech.crm.repositories.CommandesRepo;
import cm.camtech.crm.services.implementations.CommandesService;

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
public class CommandesServiceTest {

    @Mock
    private CommandesRepo commandesRepo;

    @Mock
    private CommandesMapper commandesMapper;

    @InjectMocks
    private CommandesService commandesService;

    private Commandes commandes;
    private CommandesDto commandesDto;

    @BeforeEach
    void setUp() {
        commandes = new Commandes();
        commandes.setId(1L);

        commandesDto = new CommandesDto();
        commandesDto.setId(1L);
    }

    @Test
    void testGetAllCommandes() {
        List<Commandes> liste = new ArrayList<>();
        liste.add(commandes);

        when(commandesRepo.findAll()).thenReturn(liste);
        when(commandesMapper.toDto(any(Commandes.class))).thenReturn(commandesDto);

        List<CommandesDto> resultat = commandesService.findAll();

        assertNotNull(resultat);
        assertEquals(1, resultat.size());

        verify(commandesRepo, times(1)).findAll();
    }

    @Test
    void testGetCommandeById() {
        when(commandesRepo.findById(1L)).thenReturn(Optional.of(commandes));
        when(commandesMapper.toDto(commandes)).thenReturn(commandesDto);

        CommandesDto resultat = commandesService.findById(1L);

        assertNotNull(resultat);

        verify(commandesRepo, times(1)).findById(1L);
    }

    @Test
    void testSaveCommande() {
        when(commandesMapper.toEntity(commandesDto)).thenReturn(commandes);
        when(commandesRepo.save(commandes)).thenReturn(commandes);
        when(commandesMapper.toDto(commandes)).thenReturn(commandesDto);

        CommandesDto resultat = commandesService.save(commandesDto);

        assertNotNull(resultat);

        verify(commandesRepo, times(1)).save(commandes);
    }

    @Test
    void testUpdateCommande() {
        when(commandesRepo.existsById(1L)).thenReturn(true);
        when(commandesMapper.toEntity(commandesDto)).thenReturn(commandes);
        when(commandesRepo.save(commandes)).thenReturn(commandes);
        when(commandesMapper.toDto(commandes)).thenReturn(commandesDto);

        CommandesDto resultat = commandesService.update(1L, commandesDto);

        assertNotNull(resultat);

        verify(commandesRepo, times(1)).save(commandes);
    }

    @Test
    void testDeleteCommande() {
        when(commandesRepo.existsById(1L)).thenReturn(true);
        doNothing().when(commandesRepo).deleteById(1L);

        commandesService.delete(1L);

        verify(commandesRepo, times(1)).deleteById(1L);
    }
}
