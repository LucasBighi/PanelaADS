/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Basic.Agenda;
import Basic.Aluno;

/**
 *
 * @author Alexander
 */
public class Inserir {
    public Agenda InserirAgenda(String contato, String telefone){
        Agenda agenda = new Agenda(contato,telefone);
        return agenda;
    }
    
    public Aluno InserirAluno(String nome, String apelido, String idade){
        Aluno aluno = new Aluno(nome, apelido, idade);
        return aluno;
    }
}
