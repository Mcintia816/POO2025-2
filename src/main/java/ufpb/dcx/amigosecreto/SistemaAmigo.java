package ufpb.dcx.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException{
        for (Amigo a : amigos) {
            if (a.getEmail().equalsIgnoreCase(emailAmigo)) {
                return a;
            }
        }
        throw new AmigoInexistenteException(" O amigos que voce está procurando não foi encontrado");

    }


    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        for (Amigo a : amigos) {
            if (!a.getNome().contains(nomeAmigo) && a.getEmailAmigoSecreto().contains(emailAmigo)) {
                amigos.add(a);
            }

        }
        throw new AmigoJaExisteException("Esse amigo já está cadastrado");
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return this.mensagens;

        //public void configuraAmigoSecretoDe(String emailDapessoa, String emailAmigoSecreto) throws Exception{
        //   Amigo pessoa= ;
        //  Amigo amigoSorteado = pesquisaAmigo(emailAmigoSecreto);
        //  for(Amigo amigo; amigos){
        //    if(amigo.getEmail().equalsIgnoreCase(emailDapessoa)){

        //}

    }

    public String pesquisaAmigoSecretoDe(String emailPessoa) throws AmigoInexistenteException {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equalsIgnoreCase(emailPessoa)) {
                return amigo.getEmailAmigoSecreto();

            }
        }
        throw new AmigoInexistenteException(" Pessoa do email: " + emailPessoa + " Não encontrada");
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonima = new ArrayList<>();
        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                anonima.add(m);

            }
        }
        return anonima;
    }

  //  public void enviarMensagensparaTodos(String texto, String emailRemetente, boolean ehAnonima) {
    //    Mensagem m = new Mensagem(texto, "Todos", ehAnonima) {
      //      @Override
       //     public String getTextoCompletoAExibir() {
         //       return "";
       //     }

       // }
  //  }

   // public void enviarMensagensParaAlguém(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
      //  mensagens.add(new Mensagem(texto, emailRemetente, ehAnonima) {
        //    @Override
           // public String getTextoCompletoAExibir() {
              //  return "";
          //  }
       // });
    //}


    public void sortearAmigo()throws AmigoNaoSorteadoException{
        List<Amigo> aindaNaoSorteados = new ArrayList<>(amigos);
        for(Amigo at: amigos){
            int posicaoDaListaSorteada = (int) (Math.random())*aindaNaoSorteados.size();
            Amigo sorteado = aindaNaoSorteados.get(posicaoDaListaSorteada);
            if (sorteado.getEmail().equalsIgnoreCase(at.getEmail())){
                if (aindaNaoSorteados.size()==1){
                    sortearAmigo();
                    return;
                }
                posicaoDaListaSorteada= (int) (Math.random()*aindaNaoSorteados.size());
                sorteado = aindaNaoSorteados.get(posicaoDaListaSorteada);

            }
            at.setEmailAmigoSecreto(sorteado.getEmail());

        }
    }
}
