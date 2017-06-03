package rborgesds.chatcliente.cliente;

import rborgesds.chatcliente.ui.Chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by rborgesds on 27/05/17.
 */
public class Cliente {

    private Socket cliente;
    private String host;
    private int porta;

    public Cliente(String host, int porta) {
        this.host = host;
        this.porta = porta;
    }

    public void executa(Chat chat) throws IOException {
        cliente = new Socket(this.host, this.porta);
        System.out.println("Você se conectou ao servidor. " + cliente.getInetAddress().getHostAddress());

        new Thread(new ReceborDeMensagem(cliente.getInputStream(), chat)).start();
    }

    public void envia(Mensagem mensagem) throws IOException {
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        saida.println(mensagem.getMensagemFormata());
        saida.flush();
    }
}
