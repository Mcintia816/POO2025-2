package br.ufpb.dcx.cintia;

import java.util.*;

public class SistemaLivro {
    private List<Livro> livros;

    public SistemaLivro() {
        this.livros = new ArrayList<>();
    }


    public void AdicionarLivro(Livro livro) throws Exception {

         for(Livro l: livros){
             if (l.getTitulo().equalsIgnoreCase(livro.getTitulo())){
                 throw new Exception(" Este titulo já existe na lista");
             }

        }
        livros.add(livro);
        IO.println("Livro  Adicionado: " + livro.getTitulo());
    }
    public List<Livro>getLivros(){
        return this.livros;
    }

    public boolean RemoverL(String autor) {
        for (Livro l : livros)
            if (l.getNomeAutor().equals(autor)) {
                livros.remove(l);
                System.out.println("Titulo removido com sucesso!");
                return true;
            }
        return false;

    }

    public Livro Buscar(String titulo){
        for (Livro l: livros){
            if(l.getTitulo().equalsIgnoreCase(titulo)){
                return l;
            }

        }
        return null;

    }


}
