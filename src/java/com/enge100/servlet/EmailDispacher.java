package com.enge100.servlet;

import com.enge100.ejb.EmailEnvioBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenge
 */
@WebServlet(name = "EmailDispacher", urlPatterns = {"/EmailDispacher"})

public class EmailDispacher extends HttpServlet {
    
    @EJB
        private EmailEnvioBean emailEnvio;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
     
                              
            String email = request.getParameter("email");
            String assunto = request.getParameter("assunto");
            String mensagem = request.getParameter("mensagem");
            
            String paraEmail = "lzenge@gmail.com";
            String usuario = "lzenge@gmail.com";
            String senha = "l30303030";
            
        try (PrintWriter out = response.getWriter()) {
            
            emailEnvio.envioEmail(paraEmail, usuario, senha, email, assunto, mensagem);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Status de Email</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Status de Email!!!</h1>");
            out.println("<b>Email enviado com Sucesso</b><br>");
            out.println("Click <a href='emailCliente.jsp'>here</a>voltar aqui");
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
