
package JavaClasses;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


@WebServlet(name = "FileUploader", urlPatterns = {"/FileUploader"})
@MultipartConfig
public class FileUploader extends HttpServlet {

    private String fileFolder = null;
    
    @Override
    public void init() throws ServletException{
        super.init();
        getServletContext().getInitParameter("fileFolder");
        this.fileFolder = "ArquivoLeitura";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FileUploader</title>");            
            out.println("<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js?ver=1.4.2'></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FileUploader at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Part selectedFile  = request.getPart("selectedFile");
        if(selectedFile.getContentType().equals("text/plain")){
            //pegando pasta arquivo
            String pastaArquivos = getServletContext().getRealPath("");

            //definindo caminho do armazenamento do arquivo
            //String finalPath = pastaArquivos + File.separator + fileFolder;
            String finalPath = pastaArquivos + fileFolder;

            //verifica se o caminho existe, se nao, cria o caminho
            File folder = new File(finalPath);
            if(!folder.exists()){
                folder.mkdir();
            }
            String filename = "processoSeletivoEquals";
            selectedFile.write(finalPath + File.separator + filename + ".txt");
            out.println("Arquivo enviado com sucesso!");
            
            request.setAttribute("equalsAplication.caminho", finalPath + File.separator + filename + ".txt");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            out.println("Arquino nao suportado, envie somente arquivos txt.");
        }
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
