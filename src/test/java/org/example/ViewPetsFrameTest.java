package org.example;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

class ViewPetsFrameTest {
    private ViewPetsFrame viewPetsFrame;

    @BeforeEach
    void setUp() {
        viewPetsFrame = new ViewPetsFrame();
    }
    @Test
    void testActionPerformed() {
        ActionEvent event = new ActionEvent(viewPetsFrame.butonExit, ActionEvent.ACTION_PERFORMED, "");
        viewPetsFrame.actionPerformed(event);
        assertFalse(viewPetsFrame.viewPets.isVisible());
    }
}
