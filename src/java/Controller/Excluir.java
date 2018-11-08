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
 * @author eduardo
 */
@WebServlet(name = "Excluir", urlPatterns = {"/Excluir"})
public class Excluir extends HttpServlet {
    
      public List<contatos> le() throws FileNotFoundException, IOException
    {
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
         request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            
            List<contatos> result = le();
            if(!result.isEmpty())
            {
               request.setAttribute("resp", result);
               request.getRequestDispatcher("excluir.jsp").forward(request, response);        
            }
            else
                 request.getRequestDispatcher("index.html").forward(request, response);                    
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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


   

