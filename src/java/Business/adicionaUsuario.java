/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Basic.Usuario;
import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucasbighi
 */
@WebServlet(name = "adicionaUsuario", urlPatterns = {"/adicionaUsuario"})
public class adicionaUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nomeCompleto = request.getParameter("nomeCompleto");
            String cpfcnpj = request.getParameter("cpfcnpj");
            String dataEmTexto = request.getParameter("dataNascimento");
            Calendar data = null;
            String endereco = request.getParameter("endereco");
            String nmr = request.getParameter("nmr");
            String cidade = request.getParameter("cidade");
            String uf = request.getParameter("uf");
            String cep = request.getParameter("cep");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
          try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            data = Calendar.getInstance();
            data.setTime(date);
          } catch (ParseException e) {
            out.println("Erro de conversão da data");
            return; //para a execução do método
          }
            
            Usuario usuario = new Usuario();
            usuario.setNomeCompleto(nomeCompleto);
            usuario.setCpfcnpj(cpfcnpj);
            usuario.setDataNascimento(data);
            usuario.setEndereco(endereco);
            usuario.setNrm(nmr);
            usuario.setCidade(cidade);
            usuario.setUf(uf);
            usuario.setCep(cep);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            
            UsuarioDao dao = new UsuarioDao();
            dao.adiciona(usuario);
            
            out.println("<html>");
            out.println("<body>");
            out.println("Contato "+usuario.getNomeCompleto()+" Adicionado");
            out.println("</body>");
            out.println("</html>");
            
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
