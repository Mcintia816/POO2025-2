package ufpb.dcx.amigosecreto;

public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSecretio;

    public Amigo(String nome, String email, String emailAmigoSecreto) {
        this.nome = nome;
        this.email = email;
        this.emailAmigoSecretio = emailAmigoSecreto;


    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAmigoSecreto() {
        return this.emailAmigoSecretio;
    }

    public void setEmailAmigoSecreto(String emailAmigoSecreti) {
        this.emailAmigoSecretio= emailAmigoSecreti;
    }



}
