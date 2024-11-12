package utils;

import javax.swing.*;

public class InputUtils {
    public static String getStringInput(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    public static Integer getIntegerInput(String message) {
        String input = JOptionPane.showInputDialog(null, message);
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Float getFloatInput(String message) {
        String input = JOptionPane.showInputDialog(null, message);
        try {
            return Float.valueOf(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Object getSelectionInput(String message, Object[] options) {
        return JOptionPane.showInputDialog(null, message, "Seleção", JOptionPane.QUESTION_MESSAGE, null, options, null);
    }
}
