package rborgesds.chatcliente.ui;

import rborgesds.chatcliente.cliente.Usuario;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by rborgesds on 28/05/17.
 */
public class Principal {
    private JFrame quadro;
    private JPanel painel;
    private JButton entrar;
    private JTextField nomeTextField;
    private JTextField servidorTextField;
    private JLabel nomeLabel;
    private JLabel servidorLabel;
    private JTextField portaTextField;
    private JLabel portaLabel;

    public Principal() {
        quadro = new JFrame("APS - Chat");
        portaTextField.setText("12345");

        entrar.addActionListener(actionEvent -> {
            try {
                validaDados();
                Usuario usuario = new Usuario(nomeTextField.getText());

                SwingUtilities.invokeLater(() -> {
                    try {
                        Chat chat = new Chat(
                                servidorTextField.getText(),
                                Integer.parseInt(portaTextField.getText()),
                                usuario
                        );
                        chat.exibe(usuario);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível conectar ao servidor.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    esconde();
                });
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        });
    }

    private void validaDados() throws IllegalArgumentException {
        if (nomeTextField.getText().isEmpty() || servidorTextField.getText().isEmpty() || portaTextField.getText().isEmpty()) {
            throw new IllegalArgumentException("Você precisa preencher todos os campos.");
        }
    }

    public void exibe() {
        quadro.setSize(300, 220);
        quadro.setContentPane(painel);
        quadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quadro.setLocationRelativeTo(null);
        quadro.setVisible(true);
    }

    public void esconde() {
        quadro.setVisible(false);
    }


}
