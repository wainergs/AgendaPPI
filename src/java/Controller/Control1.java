/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.contatos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Junior
 */
@WebServlet(name = "Control1", urlPatterns = {"/Control1"})
public class Control1 extends HttpServlet {
 
    public int le() throws FileNotFoundException, IOException
    {
            int cont=0;
            String caminhoDir = getServletContext().getRealPath("/WEB-INF");    
            File arquivo = new File(caminhoDir,"contatos.txt");
	    if(arquivo.exists()==false)
                arquivo.createNewFile();
            String cli = getServletContext().getRealPath("/WEB-INF/contatos.txt");    
            BufferedReader b = new BufferedReader(
                                   new InputStreamReader(
                                       new FileInputStream(cli), Charset.forName("UTF-8").newDecoder()));
            while(b.readLine() != null)
                    cont++;
            b.close();
            return cont;
    }
    
    public void grava(contatos c) throws IOException
    {
            String caminhoDir = getServletContext().getRealPath("/WEB-INF");    
            File arquivo = new File(caminhoDir,"contatos.txt");
	    if(arquivo.exists()==false)
                arquivo.createNewFile();
            String cli = getServletContext().getRealPath("/WEB-INF/contatos.txt");    
            OutputStreamWriter g = new OutputStreamWriter(
                                       new FileOutputStream(cli,true),Charset.forName("UTF-8").newEncoder());
            BufferedWriter b = new BufferedWriter(g);
            b.write(c.getId()+";");
            b.write(c.getNome()+";");
            b.write(c.getTelefone());
            b.newLine();
            b.flush();
            b.close();   
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
            
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            int cont = le();
            contatos c = new contatos();
            c.setId(++cont);
            c.setNome(request.getParameter("nome"));
            c.setTelefone(request.getParameter("telefone"));
            grava(c);
            response.sendRedirect( "cadastro.jsp" );             
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
