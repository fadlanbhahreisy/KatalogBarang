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
        <title>Show Barang</title>
    </head>
    <body>
        <div class="container">
            <h2>List Barang</h2>
            <p><a href="BarangController?action=insert" class="btn btn-success" role="button">Add barang</a></p>
            <c:choose>
                <c:when test = "${barangs.size() == 0}">
                    <div class="alert alert-info">No data recorded.</div>
                </c:when>    
                <c:otherwise>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Id Barang</th>
                                <th>Nama Barang</th>
                                <th>Harga</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${barangs}" var="barang">
                                <tr>
                                    <td><c:out value="${barang.id_barang}" /></td>
                                    <td><c:out value="${barang.nama_barang}" /></td>
                                    <td><c:out value="${barang.harga}" /></td>
                                    <td><a href="BarangController?action=edit&barangId=<c:out value="${barang.id_barang}"/>" class="btn btn-primary">Update</a></td>
                                    <td><a href="BarangController?action=delete&barangId=<c:out value="${barang.id_barang}"/>" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this item?')">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>