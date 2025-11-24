package ufpb.dcx.amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {

    private Map<String, Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigoMap() {
        this.amigos = new HashMap<>();
        this.mensagens = new ArrayList<>();
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        Amigo a = amigos.get(emailAmigo);
        if (a == null) {
            throw new AmigoInexistenteException("Amigo com email " + emailAmigo + " não encontrado.");
        }
        return a;
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        if (amigos.containsKey(emailAmigo))
            throw new AmigoJaExisteException("Esse amigo já está cadastrado: " + emailAmigo);
        amigos.put(emailAmigo, new Amigo(nomeAmigo, emailAmigo));

    }
    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado)
            throws AmigoInexistenteException {
        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
        pessoa.setEmailAmigoSecreto(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailPessoa) throws AmigoInexistenteException {
        return pesquisaAmigo(emailPessoa).getEmailAmigoSecreto();
    }


    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                anonimas.add(m);
            }
        }
        return anonimas;
    }

    public void enviarMensagensparaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem m = new Mensagem(texto, emailRemetente, ehAnonima) {
            @Override
            public String getTextoCompletoAExibir() {
                if (ehAnonima()) {
                    return "Mensagem anônima para TODOS: " + getTexto();
                } else {
                    return "De " + getEmailRemetente() + " para TODOS: " + getTexto();
                }
            }
        };
        mensagens.add(m);
    }

    public void enviarMensagensParaAlguém(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        Mensagem m = new Mensagem(texto, emailRemetente, ehAnonima) {
            @Override
            public String getTextoCompletoAExibir() {
                if (ehAnonima()) {
                    return "Mensagem anônima para " + emailDestinatario + ": " + getTexto();
                } else {
                    return "De " + getEmailRemetente() + " para " + emailDestinatario + ": " + getTexto();
                }
            }
        };
        mensagens.add(m);
    }

    public void sortearAmigo() throws AmigoNaoSorteadoException {
        List<Amigo> listaAmigos = new ArrayList<>(amigos.values());
        List<Amigo> aindaNaoSorteados = new ArrayList<>(listaAmigos);

        for (Amigo at : listaAmigos) {
            if (aindaNaoSorteados.isEmpty()) break;

            int posicaoDaListaSorteada = (int) (Math.random() * aindaNaoSorteados.size());
            Amigo sorteado = aindaNaoSorteados.get(posicaoDaListaSorteada);

            if (sorteado.getEmail().equalsIgnoreCase(at.getEmail())) {
                if (aindaNaoSorteados.size() == 1) {
                    sortearAmigo();
                    return;
                }
                posicaoDaListaSorteada = (int) (Math.random() * aindaNaoSorteados.size());
                sorteado = aindaNaoSorteados.get(posicaoDaListaSorteada);
            }

            at.setEmailAmigoSecreto(sorteado.getEmail());
            aindaNaoSorteados.remove(sorteado);
        }
    }
}
