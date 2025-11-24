package ufpb.dcx.amigosecreto;

 void main(String[] args) throws AmigoInexistenteException {

    SistemaAmigo sistema = new SistemaAmigo();

    try {
        sistema.cadastraAmigo("José", "@joseM15");
        sistema.cadastraAmigo("Maria", "@maria19");

        sistema.configuraAmigoSecretoDe("@joseM15", "@maria19");
        sistema.configuraAmigoSecretoDe("@maria19", "@joseM15");

    } catch (AmigoJaExisteException | AmigoInexistenteException e) {
        System.out.println("Erro ao cadastrar ou configurar amigo secreto: " + e.getMessage());
    }

    System.out.println("\nMensagens anônimas:");
    for (Mensagem msg : sistema.pesquisaMensagensAnonimas()) {
        System.out.println(msg.getTextoCompletoAExibir());

    String am = sistema.pesquisaAmigoSecretoDe("@joseM15");
        if (am.getEmailAmigoSecreto().equalsIgnoreCase("@maria19")) {
            System.out.println("\nOk");
        } else {
            System.out.println("\nFalhou: José não tirou Maria.");
        }
    }
}