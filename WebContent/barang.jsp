<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css" href="css/style.css" rel="stylesheet" />
        <link type="text/css" href="css/jquery-ui/jquery-ui.min.css" rel="stylesheet" />
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
        <script type="text/javascript" src="js/jquery-ui.min.js"></script>
        <title>Add New Barang</title>
    </head>
    <body>
        <div class="container">
            <h2><%= request.getAttribute("title")%> Barang</h2>
            <form method="POST" action='BarangController' name="frmAddBarang">
                <input type="hidden" name="token" value="<%= session.getAttribute("token")%>" />
                <input type="hidden" readonly="readonly" name="barangid" value="<c:out value="${barang.id_barang}" />" />
                <div class="form-group">
                    <label>Nama Barang</label>
                    <input type="text" name="namaBarang" value="<c:out value="${barang.nama_barang}" />" />
                </div>
                <div class="form-group">
                    <label>Harga Barang</label>
                    <input type="text" name="hargaBarang" value="<c:out value="${barang.harga}" />" />
                </div>
                <input type="button" onclick="location.href='index.jsp'" class="btn btn-outline-secondary" value="Back">
                <input type="submit" value="Submit" class="btn btn-success" />
            </form>
        </div>
    </body>
</html>