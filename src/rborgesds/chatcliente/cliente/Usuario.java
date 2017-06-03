package rborgesds.chatcliente.cliente;

import java.io.Serializable;

/**
 * Created by rborgesds on 27/05/17.
 */
public class Usuario {

    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
