package br.ufpb.dcx.cintia;


import javax.swing.*;


public class TestaLivro {
   public static void main(String[] args){
       SistemaLivro livro = new SistemaLivro();
       int quant = Integer.parseInt(JOptionPane.showInputDialog("Quantos Livros voce deseja colocar na lista?"));
       for (int i = 0; i < quant; i++) {
           String autor = JOptionPane.showInputDialog("Nome do Autor: ");
           String titulo = JOptionPane.showInputDialog("Titulo do livro: ");
           String genero = JOptionPane.showInputDialog("Genero: ");
           int quantPaginas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de páginas: "));

           Livro livro1 = new Livro(autor,titulo,genero,quantPaginas);

           try{
               livro.AdicionarLivro(livro1);

               }catch(TituloExistente e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
           }

       }

       for (Livro l: livro.getLivros()) {
           System.out.println(l.toString());
       }





       }




   }






