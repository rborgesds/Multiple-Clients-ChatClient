package rborgesds.chatcliente.cliente;

import rborgesds.chatcliente.ui.Chat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by rborgesds on 28/05/17.
 */
public class ReceborDeMensagem implements Runnable {

    private final Chat chat;
    private InputStream servidor;

    ReceborDeMensagem(InputStream servidor, Chat chat) throws IOException {
        this.servidor = servidor;
        this.chat = chat;
    }

    @Override
    public void run() {
        Scanner entrada = new Scanner(servidor);

        while (entrada.hasNextLine()) {
            chat.recebeMensagem(entrada.nextLine());
        }
    }
}
