package br.ufpb.dcx.cintia;


import javax.swing.*;


public class TestaLivro {
   public static void main(String[] args) throws Exception {
       SistemaLivro livro = new SistemaLivro();
       int quant = Integer.parseInt(JOptionPane.showInputDialog("Quantos Livros livros voce deseja colocar na lista?"));
       for (int i = 0; i < quant; i++) {
           String autor = JOptionPane.showInputDialog("Nome do Autor: ");
           String titulo = JOptionPane.showInputDialog("Titulo do livro: ");
           String genero = JOptionPane.showInputDialog("Genero: ");
           int quantPaginas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de páginas: "));


           Livro livro1 = new Livro(autor,titulo,genero,quantPaginas);
           livro.AdicionarLivro(livro1);


       }
       for (Livro l : livro.getLivros()) {
           System.out.println(l.toString());




       }
      


   }


}
