package rborgesds.chatcliente.ui;

import rborgesds.chatcliente.cliente.Cliente;
import rborgesds.chatcliente.cliente.Mensagem;
import rborgesds.chatcliente.cliente.Usuario;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Created by rborgesds on 28/05/17.
 */
public class Chat {
    private JFrame quadro;
    private JPanel painel;
    private JTextField mensagemTextField;
    private JButton enviaButton;
    private JTextArea mensagensTextArea;

    public Chat(String enderecoIP, int porta, Usuario usuario) throws IOException {
        Cliente cliente = new Cliente(enderecoIP, porta);
        cliente.executa(this);

        mensagemTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    enviaButton.doClick();
                }
            }
        });

        enviaButton.addActionListener(actionEvent -> {
            if (mensagemTextField.getText().length() < 1) return;

            Mensagem mensagem = new Mensagem(mensagemTextField.getText(), usuario);

            try {
                cliente.envia(mensagem);
                mensagemTextField.setText("");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(painel, "Não foi possível enviar sua mensagem.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void exibe(Usuario usuario) {
        quadro = new JFrame("APS Chat - " + usuario.getNome());
        mensagensTextArea.setLineWrap(true);
        quadro.setSize(600, 350);
        quadro.setContentPane(painel);
        quadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quadro.setLocationRelativeTo(null);
        quadro.setVisible(true);
    }

    public void recebeMensagem(String mensagem) {
        mensagensTextArea.append(mensagem + "\n");
    }
}
