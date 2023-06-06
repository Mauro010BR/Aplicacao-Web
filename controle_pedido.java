import dao.dao;
import model.pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cadastro_pedido"})
public class controle_pedido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nome = request.getParameter("nome");
            String processador = request.getParameter("processador");
            String pvideo = request.getParameter("pvideo");
            String pmae = request.getParameter("pmae");
            String ram = request.getParameter("ram");
            String cooler = request.getParameter("cooler");
            String hd = request.getParameter("hd");
            String ssd = request.getParameter("ssd");
            String gabinete = request.getParameter("gabinete");
            String estado = request.getParameter("estado");

            String submit = request.getParameter("submit");
            dao d = new dao();

            if (submit.equals("Enviar Pedido")) {
                pedido p = new pedido(nome, processador, pvideo, pmae, ram, cooler, hd, ssd, gabinete, estado);
                d.cadastrar(p);
                response.sendRedirect("http://localhost:8080/CrudWeb/cadastro_pedido?submit=ConsultarTodos");
                System.out.println("Cadastrado!");
            } else if (submit.equals("ConsultarTodos")) {
                try {
                    List<pedido> lprod = d.consultarTodos();
                    request.setAttribute("lprod", lprod);
                    request.getRequestDispatcher("consulta.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro:" + ex.getMessage());
                }
            } else if (submit.equals("Deletar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                pedido p = new pedido(id);
                try {
                    d.deletar(p);
                    response.sendRedirect("http://localhost:8080/CrudWeb/cadastro_pedido?submit=ConsultarTodos");
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro:" + ex.getMessage());
                }
            } else if (submit.equals("BuscarId")) {
                int id = Integer.parseInt(request.getParameter("id"));
                pedido p = new pedido(id);
                try {
                    p = d.consultarById(p);
                    request.setAttribute("pe", p);
                    request.getRequestDispatcher("ConsultarId.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro:" + ex.getMessage());
                }
            } else if (submit.equals("Editar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                pedido p = new pedido(id);
                try {
                    p = d.consultarById(p);
                    request.setAttribute("pe", p);
                    request.getRequestDispatcher("alterar.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro:" + ex.getMessage());
                }
            } else if (submit.equals("Salvar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                pedido p = new pedido(id, nome, processador, pvideo, pmae, ram, cooler, hd, ssd, gabinete, estado);
                d.editar(p);
                response.sendRedirect("http://localhost:8080/CrudWeb/cadastro_pedido?submit=ConsultarTodos");
                System.out.println("Cadastrado!");
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(controle_pedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controle_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(controle_pedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controle_pedido.class.getName()).log(Level.SEVERE, null, ex);
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
