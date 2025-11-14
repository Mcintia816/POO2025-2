package br.ufpb.dcx.cintia;

 public class TestaLivro {
    public static void main(String[] args){
        SistemaLivro livro = new SistemaLivro();


        livro.Buscar("");

        try {
            Livro l = new Livro("");
            livro.AdicionarLivro(l);
            } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    }

