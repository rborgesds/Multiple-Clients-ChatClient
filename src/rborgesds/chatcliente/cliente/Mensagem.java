package rborgesds.chatcliente.cliente;

import java.io.Serializable;

/**
 * Created by rborgesds on 27/05/17.
 */
public class Mensagem implements Serializable {
    static final long serialVersionUID = 1L;

    private String mensagem;
    private Usuario usuario;

    public Mensagem(String mensagem, Usuario usuario) {
        this.mensagem = mensagem;
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getMensagemFormata() {
        return "<" + usuario.getNome() + ">: " + getMensagem();
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "[DEBUG] {" + this.usuario.getNome() + "} ~> " + this.mensagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return false;
    }

    @Override
    public int hashCode() {
        int result = getMensagem() != null ? getMensagem().hashCode() : 0;
        result = 31 * result + (getUsuario() != null ? getUsuario().hashCode() : 0);
        return result;
    }
}
