package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BarangDao;
import model.Barang;

public class BarangController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/barang.jsp";
    private static String LIST_BARANG = "/listBarang.jsp";
    private BarangDao dao;

    public BarangController() {
        super();
        dao = new BarangDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        HttpSession session = request.getSession();
        session.setAttribute("token", "wax654");

        if (action.equalsIgnoreCase("delete")) {
            int barangId = Integer.parseInt(request.getParameter("barangId"));
            dao.deleteBarang(barangId);
            forward = LIST_BARANG;
            request.setAttribute("barangs", dao.getAllBarangs());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int barangId = Integer.parseInt(request.getParameter("barangId"));
            barang barang = dao.getBarangById(barangId);
            request.setAttribute("barang", barang);
            request.setAttribute("title", "Edit");
        } else if (action.equalsIgnoreCase("listBarang")) {
            forward = LIST_BARANG;
            request.setAttribute("barangs", dao.getAllBarangs());
        } else {
            forward = INSERT_OR_EDIT;
            request.setAttribute("title", "Add");
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Barang barang = new Barang();
        barang.setNamaBarang(request.getParameter("namaBarang"));
        barang.setHarga(request.getParameter("hargaBarang"));

        HttpSession session = request.getSession();
        String tokenFromSession = (String) session.getAttribute("token");
        String tokenFromRequest = (String) request.getParameter("token");

        if (tokenFromRequest.equals(tokenFromSession)) {
            if (barangId == null || barangId.isEmpty()) {
                dao.addBarang(barang);
            } else {
                barang.setBarangid(Integer.parseInt(barangId));
                dao.updateBarang(barang);
            }
            session.setAttribute("token", null);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_BARANG);
        request.setAttribute("barangs", dao.getAllBarangs());
        view.forward(request, response);
    }
}
