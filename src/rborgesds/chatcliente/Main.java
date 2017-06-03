package rborgesds.chatcliente;

import rborgesds.chatcliente.ui.Principal;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Principal principal = new Principal();
            principal.exibe();
        });
    }
}
