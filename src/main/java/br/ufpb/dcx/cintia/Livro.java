package br.ufpb.dcx.cintia;

import java.util.Objects;

public class Livro {
    private String nomeAutor;
    private String titulo;
    private String genero;
    private int quantPaginas;

    public Livro(String nomeAutor){
        this.nomeAutor = nomeAutor;
        this.titulo = titulo;
        this.genero = genero;
        this.quantPaginas = quantPaginas;

    }

    public Livro(){
        this.nomeAutor = "";
        this.titulo = "";
        this.genero = "";
        this.quantPaginas = 0;



    }

    public String getNomeAutor(){
        return this.nomeAutor;

    }

    public void setNomeAutor( String nomeAutor){
        this.nomeAutor =nomeAutor;

    }

    public String getTitulo() {
        return this.titulo;

    }

    public String setTitulo(String titulo){
        return this.titulo;
    }
    public String getGenero(){
        return this.genero;

    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(nomeAutor, livro.nomeAutor) && Objects.equals(titulo, livro.titulo) && Objects.equals(genero, livro.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeAutor, titulo, genero);
    }

    public int getQuantPaginas(){
        return this.quantPaginas;
    }

    public void setQuantPaginas(int quantPaginas) {
        this.quantPaginas = quantPaginas;
    }

    public String toString(){
        return "Nome do Autor: " + getNomeAutor() + "Titulo do livro: " + getTitulo() + "Genero: " + getQuantPaginas() + "Quantidade de páginas:";


    }



}
