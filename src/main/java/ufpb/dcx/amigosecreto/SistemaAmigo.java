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

   // public Amigo pesquisaAmigo(String emailAmigo)}
    //TODO
//}


    public void CadastrarAmigo(String nomeAmigo, String emailAmigo){
        for (Amigo a: amigos ){
            if (!a.getNome().contains(nomeAmigo) && a.getEmailAmigoSecreto().contains(emailAmigo)){
                amigos.add(a);
            }
        }
    }
}
