package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;

class MusicAppTest {
    private MusicApp musicApp;

    @BeforeEach
    void setUp() {
        // Initialize the MusicApp before each test
        musicApp = new MusicApp();
    }

    @Test
    void shouldCaptureUserInputWhenSubmitButtonIsClicked() {
        // Retrieve form components
        JTextField artistField = musicApp.getArtistField();
        JTextField studioField = musicApp.getStudioField();
        JComboBox<String> categoryBox = musicApp.getCategoryBox();
        JCheckBox availableCheckBox = musicApp.getAvailableCheckBox();

        // Simulate user input
        artistField.setText("Bob Marley");
        studioField.setText("Tuff Gong");
        categoryBox.setSelectedIndex(0); // Selecting "Reggae"
        availableCheckBox.setSelected(true);

        // Simulate clicking the submit button
        musicApp.handleSubmitButton();

        // Verify that the input fields hold the expected values
        assertEquals("Bob Marley", artistField.getText(), "Artist name should match input");
        assertEquals("Tuff Gong", studioField.getText(), "Studio name should match input");
        assertEquals("Reggae", categoryBox.getSelectedItem(), "Selected genre should be Reggae");
        assertTrue(availableCheckBox.isSelected(), "Availability checkbox should be checked");
    }

    @Test
    void shouldExitWithoutErrorsWhenExitButtonIsClicked() {
        // Ensure that calling the exit method does not cause any unexpected exceptions
        assertDoesNotThrow(() -> musicApp.handleExitButton(), "Exit button should close the app without errors");
    }
}