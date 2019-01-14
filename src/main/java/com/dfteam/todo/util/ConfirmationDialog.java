package com.dfteam.todo.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

/**
 * Class for asking user "Are you sure?" before important actions
 */
public class ConfirmationDialog {
    /**
     * @return true if OK is pressed
     */
    public static boolean showConfirmation(String title, String text) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK) return true;
        else return false;
    }
}