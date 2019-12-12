package Controller;

import Main.*;
import Model.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    private Connection conn = Main.returnCon();
    private List<Data> list = new ArrayList<>();

    public List<Data> getAreas() throws SQLException {
        list.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("SELECT * FROM production_area");
             ResultSet rs = preparedStatementInner.executeQuery();
            while (rs.next()) {
                list.add(new Data(rs.getInt(1), rs.getString(2)));
            }

        for (Data data: list) {
            System.out.println(data.getIdArea() + " " + data.getNameArea());
        }
        return list;
    }

    public void deleteArea(int idArea) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM production_area WHERE idArea = ?");
        preparedStatement.setInt(1, idArea);
        preparedStatement.executeUpdate();
    }

    public void changeArea(int idArea, String nameArea) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE production_area SET nameArea = ? WHERE idArea = ?");
        preparedStatement.setInt(2, idArea);
        preparedStatement.setString(1, nameArea);
        preparedStatement.executeUpdate();
    }

    public void addArea(int idArea, String nameArea) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO production_area(idArea, nameArea) VALUES (?,?)");
        preparedStatement.setInt(1, idArea);
        preparedStatement.setString(2, nameArea);
        preparedStatement.executeUpdate();
    }


}
