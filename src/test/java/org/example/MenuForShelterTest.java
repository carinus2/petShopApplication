package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.ActionEvent;

class MenuForShelterTest {
    private MenuForShelter menuForShelter;

    @BeforeEach
    void setUp() {
        menuForShelter = new MenuForShelter();
    }

    @Test
    void testActionPerformedOption1() {
        // Simulăm acțiunea pentru option1 (Adăugare pet)
        ActionEvent event = new ActionEvent(menuForShelter.option1, ActionEvent.ACTION_PERFORMED, "");
        menuForShelter.actionPerformed(event);

        // Verificăm dacă fereastra de adăugare pet este afișată
        assertTrue(menuForShelter.addPet.isVisible());
    }

    @Test
    void testActionPerformedOption2() {
        // Simulăm acțiunea pentru option2 (Ștergere pet)
        ActionEvent event = new ActionEvent(menuForShelter.option2, ActionEvent.ACTION_PERFORMED, "");
        menuForShelter.actionPerformed(event);

        // Verificăm dacă fereastra de ștergere pet este afișată
        assertTrue(menuForShelter.deletePet.isVisible());
    }

    @Test
    void testActionPerformedOption3() {
        // Simulăm acțiunea pentru option3 (Editare pet)
        ActionEvent event = new ActionEvent(menuForShelter.option3, ActionEvent.ACTION_PERFORMED, "");
        menuForShelter.actionPerformed(event);
        // Verificăm dacă fereastra de editare pet este afișată
        assertTrue(menuForShelter.editPet.isVisible());
    }

    @Test
    void testActionPerformedOption5() {
        // Simulăm acțiunea pentru option5 (Ieșire)
        ActionEvent event = new ActionEvent(menuForShelter.option5, ActionEvent.ACTION_PERFORMED, "");
        menuForShelter.actionPerformed(event);

        // Verificăm dacă fereastra principală este închisă
        assertFalse(menuForShelter.isVisible());
    }
}
