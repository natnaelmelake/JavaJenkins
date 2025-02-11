package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;

class MusicAppTest {
    private MusicApp musicApp;

    @BeforeEach
    void setUp() {

        musicApp = new MusicApp();
    }

    @Test
    void shouldCaptureUserInputWhenSubmitButtonIsClicked() {

        JTextField artistField = musicApp.getArtistField();
        JTextField studioField = musicApp.getStudioField();
        JComboBox<String> categoryBox = musicApp.getCategoryBox();
        JCheckBox availableCheckBox = musicApp.getAvailableCheckBox();


        artistField.setText("Bob marley");
        studioField.setText("Tuff gong");
        categoryBox.setSelectedIndex(0);
        availableCheckBox.setSelected(true);


        musicApp.handleSubmitButton();



        assertEquals("Bob marley", artistField.getText(), "Artist name should match input");
        assertEquals("Tuff gong", studioField.getText(), "Studio name should match input");
        assertEquals("Reggae", categoryBox.getSelectedItem(), "Selected genre should be Reggae");
        assertTrue(availableCheckBox.isSelected(), "Availability checkbox should be checked");
    }


    @Test
    void shouldExitWithoutErrorsWhenExitButtonIsClicked() {

        assertDoesNotThrow(() -> musicApp.handleExitButton(), "Exit button should close the app without errors");
    }
}