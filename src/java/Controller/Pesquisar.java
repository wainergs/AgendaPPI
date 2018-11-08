/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.contatos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "Pesquisar", urlPatterns = {"/Pesquisar"})
public class Pesquisar extends HttpServlet {
    String pesquisar = "";
     public List<contatos> le() throws FileNotFoundException, IOException{
            List<contatos> result = new ArrayList<>();
            String caminhoDir = getServletContext().getRealPath("/WEB-INF");    
            File arquivo = new File(caminhoDir,"contatos.txt");
	    if(arquivo.exists())
            {
               String linha;
               String cli = getServletContext().getRealPath("/WEB-INF/contatos.txt");    
               BufferedReader b = new BufferedReader(
                                      new InputStreamReader(
                                          new FileInputStream(cli), Charset.forName("UTF-8").newDecoder()));
               while(( linha = b.readLine()) != null)
                  if ((linha != null) && (!linha.isEmpty()))
                  {
                    contatos c = new contatos();
                    String[] vetContatos = linha.split(";");
                    c.setId(Integer.parseInt(vetContatos[0]));
                    c.setNome(vetContatos[1]);
                    c.setTelefone(vetContatos[2]);

                    result.add(c);
                  }
               b.close();
            }
            return result;
            
    }
    

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
         pesquisar = request.getParameter("pesquisar").toUpperCase();
        
           List<contatos> result = le();
             request.setAttribute("resp", result);
             request.setAttribute("pesquisar", pesquisar);
               request.getRequestDispatcher("pesquisar.jsp").forward(request, response);        
           

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
