package AgendaContatos;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class AgendaGerenciador implements Agenda {
    private HashMap<String,Contato> contatos;
    private GravadorDeDados gravador;

    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        //if(this.contatos)
        return false;
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        return null;
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        return false;
    }

    @Override
    public void salvarDados() throws IOException {

    }

    @Override
    public void recuperarDados() throws IOException {

    }
}
