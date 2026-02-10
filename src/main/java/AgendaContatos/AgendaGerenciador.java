package AgendaContatos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class AgendaGerenciador implements Agenda {
    private HashMap<String,Contato> contatos;
    private GravadorDeDados gravador;

    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        if (this.contatos.containsKey(nome)) {
            return false;
        } else {
            Contato c = new Contato(nome, dia, mes);
            this.contatos.put(nome, c);
            return true;
        }
    }
        @Override
        public Collection<Contato> pesquisaAniversariantes(int dia, int mes){
            Collection<Contato> contatosA = new ArrayList<>();
            for (Contato c : this.contatos.values()) {
                if (c.getDiaAniversario() == dia && c.getMesAniversario() == mes) {
                    contatosA.add(c);
                }
            }
            return contatosA;
        }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        if(this.contatos.containsKey(nome)){
            this.contatos.remove(nome);
            return true;
        }else{
            throw new ContatoInexistenteException("Não existe contato com esse nome: " + nome);
        }
    }

    @Override
    public void salvarDados() throws IOException {
        this.gravador.salvarContatos(this.contatos);

    }

    @Override
    public void recuperarDados() throws IOException {
        this.contatos = this.gravador.recuperarContatos();

    }
}
