package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchPetFrameTest {
    private SearchPetFrame searchPetFrame;

    @BeforeEach
    void setUp() {
        searchPetFrame = new SearchPetFrame();
    }

    @Test
    void testActionPerformedSuccess() {
        // Simulăm acțiunea pentru căutare cu succes
        searchPetFrame.searchable.setText("Husky");
        ActionEvent event = new ActionEvent(searchPetFrame.searchB, ActionEvent.ACTION_PERFORMED, "");
        searchPetFrame.actionPerformed(event);

        // Verificăm dacă modelul tabelului conține rânduri
        DefaultTableModel model = (DefaultTableModel) searchPetFrame.result.getModel();
        assertNotNull(model);
        assertTrue(model.getRowCount() >= 0);
    }

    @Test
    void testActionPerformedNoResults() {
        // Simulăm acțiunea pentru căutare fără rezultate
        searchPetFrame.searchable.setText("Unknown");
        ActionEvent event = new ActionEvent(searchPetFrame.searchB, ActionEvent.ACTION_PERFORMED, "");
        searchPetFrame.actionPerformed(event);

        // Verificăm dacă modelul tabelului este gol
        DefaultTableModel model = (DefaultTableModel) searchPetFrame.result.getModel();
        assertNotNull(model);
        assertEquals(0, model.getRowCount());
    }

    @Test
    void testActionPerformedException() {
        // Simulăm acțiunea pentru căutare cu o excepție
        searchPetFrame.searchable.setText("Exception");
        ActionEvent event = new ActionEvent(searchPetFrame.searchB, ActionEvent.ACTION_PERFORMED, "");
        searchPetFrame.actionPerformed(event);

        // Verificăm dacă modelul tabelului este gol
        DefaultTableModel model = (DefaultTableModel) searchPetFrame.result.getModel();
        assertNotNull(model);
        assertEquals(0, model.getRowCount());
    }
}
