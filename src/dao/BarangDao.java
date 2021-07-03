package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Barang;
import util.DbUtil;

public class BarangDao {

    private Connection connection;

    public BarangDao() {
        connection = DbUtil.getConnection();
    }

    public void addBarang(Barang barang) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into barang(nama_barang,harga) values (?, ?)"
            );
            // Parameters start with 1
            preparedStatement.setString(1, barang.getNamaBarang());
            preparedStatement.setString(2, barang.getHarga());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBarang(int barangId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from barang where id_barang=?"
            );
            // Parameters start with 1
            preparedStatement.setInt(1, barangId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBarang(Barang barang) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update barang set nama_barang=?, harga=? where id_barang=?"
            );
            // Parameters start with 1
            preparedStatement.setString(1, barang.getNamaBarang());
            preparedStatement.setString(2, barang.getHarga());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Barang> getAllBarangs() {
        List<Barang> barang = new ArrayList<Barang>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from barang");
            while (rs.next()) {
                Barang barang = new barang();
                barang.setBarangid(rs.getInt("id_barang"));
                barang.setNamaBarang(rs.getString("nama_barang"));
                barang.setHarga(rs.getString("harga"));
                barang.add(barang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return barang;
    }

    public Barang getBarangById(int barangId) {
        Barang barang = new Barang();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from barang where id_barang=?"
            );
            preparedStatement.setBarangid(1, barangId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                barang.setBarangid(rs.getInt("id_barang"));
                barang.setNamaBarang(rs.getString("nama_barang"));
                barang.setHarga(rs.getString("harga"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return barang;
    }
}
