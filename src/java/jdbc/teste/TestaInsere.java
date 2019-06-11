/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.teste;

import Basic.Usuario;
import dao.UsuarioDao;
import java.util.Calendar;

/**
 *
 * @author lucasbighi
 */
public class TestaInsere {
    public static void main(String[] args) {
        
        Usuario usuario = new Usuario();
        usuario.setNomeCompleto("Lucas Marques");
        usuario.setCpfcnpj("437.197.258-63");
        usuario.setDataNascimento(Calendar.getInstance());
        usuario.setEndereco("Rua Marmelopolis");
        usuario.setNrm("93");
        usuario.setCidade("Sao Paulo");
        usuario.setUf("SP");
        usuario.setCep("03942-020");
        usuario.setEmail("lucasmbighi@ecommerce.com");
        usuario.setSenha("******");
        
        UsuarioDao dao = new UsuarioDao();
        dao.adiciona(usuario);
        System.out.println("Gravado");
    }
}
