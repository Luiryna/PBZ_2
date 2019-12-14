package Controller;

import Main.*;
import Model.EmployeeData;
import Model.EquipmentData;
import Model.ProdAreaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    private Connection conn = Main.returnCon();
    private List<ProdAreaData> list = new ArrayList<>();
    private List<EquipmentData> equipmentList = new ArrayList<>();
    private List<EmployeeData> employeeList = new ArrayList<>();

    public List<ProdAreaData> getBreakages() throws SQLException {
        list.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("SELECT * FROM breakage");
             ResultSet rs = preparedStatementInner.executeQuery();
            while (rs.next()) {
                list.add(new ProdAreaData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6)));
            }

        for (ProdAreaData data: list) {
            System.out.println(data.getDate() + " " + data.getReason() + " " + data.getFio() + " " + data.getNameArea()
            + " " + data.getIdEquipment() + " " + data.getNameEquipment());
        }
        return list;
    }



    public List<ProdAreaData> getAreas() throws SQLException {
        list.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("SELECT * FROM production_area");
        ResultSet rs = preparedStatementInner.executeQuery();
        while (rs.next()) {
            list.add(new ProdAreaData(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        for (ProdAreaData data: list) {
            System.out.println(data.getIdArea() + " " + data.getNameArea() + " " + data.getTypeEquipment());
        }

        return list;
    }

    public List<EmployeeData> getEmployees() throws SQLException {
        employeeList.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("SELECT * FROM employee");
        ResultSet rs = preparedStatementInner.executeQuery();
        while (rs.next()) {
            employeeList.add(new EmployeeData(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        for (EmployeeData data: employeeList) {
            System.out.println(data.getIdEmployee() + " " + data.getFio() + " " + data.getPosition());
        }

        return employeeList;
    }

    public void deleteEmployee(int idEmployee) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM employee WHERE idEmployee = ?");
        preparedStatement.setInt(1, idEmployee);
        preparedStatement.executeUpdate();
    }

    public void changeEmployee(int idEmployee, String fio, String position) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE employee SET FIO = ?, position = ? WHERE idEmployee = ?");
        preparedStatement.setString(1, fio);
        preparedStatement.setString(2, position);
        preparedStatement.setInt(3, idEmployee);
        preparedStatement.executeUpdate();
    }

    public void addEmployee(int idEmployee, String fio, String position) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO employee(idEmployee, FIO, position) VALUES (?,?,?)");
        preparedStatement.setInt(1, idEmployee);
        preparedStatement.setString(2, fio);
        preparedStatement.setString(3, position);
        preparedStatement.executeUpdate();
    }

    public List<EquipmentData> getEquipment() throws SQLException {
        equipmentList.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("SELECT * FROM equipment");
        ResultSet rs = preparedStatementInner.executeQuery();
        while (rs.next()) {
            equipmentList.add(new EquipmentData(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        for (EquipmentData data: equipmentList) {
            System.out.println(data.getIdEquipment() + " " + data.getNameEquipment() + " " + data.getTypeEquipment());
        }

        return equipmentList;
    }

    public void deleteEquipment(int idEquipment) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM equipment WHERE idEquipment = ?");
        preparedStatement.setInt(1, idEquipment);
        preparedStatement.executeUpdate();
    }

    public void changeEquipment(int idEquipment, String nameEquipment, String typeEquipment) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE equipment SET nameEquipment = ?, typeEquipment = ? WHERE idEquipment = ?");
        preparedStatement.setString(1, nameEquipment);
        preparedStatement.setString(2, typeEquipment);
        preparedStatement.setInt(3, idEquipment);
        preparedStatement.executeUpdate();
    }

    public void addEquipment(int idEquipment, String nameEquipment, String typeEquipment) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO equipment(idEquipment, nameEquipment, typeEquipment) VALUES (?,?,?)");
        preparedStatement.setInt(1, idEquipment);
        preparedStatement.setString(2, nameEquipment);
        preparedStatement.setString(3, typeEquipment);
        preparedStatement.executeUpdate();
    }

    public void deleteArea(int idArea) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM production_area WHERE idArea = ?");
        preparedStatement.setInt(1, idArea);
        preparedStatement.executeUpdate();
    }

    public void changeArea(int idArea, String nameArea, String typeEquipment) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE production_area SET nameArea = ?, typeEquipment = ? WHERE idArea = ?");
        preparedStatement.setString(1, nameArea);
        preparedStatement.setString(2, typeEquipment);
        preparedStatement.setInt(3, idArea);
        preparedStatement.executeUpdate();
    }

    public void addArea(int idArea, String nameArea, String typeEquipment) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO production_area(idArea, nameArea, typeEquipment) VALUES (?,?,?)");
        preparedStatement.setInt(1, idArea);
        preparedStatement.setString(2, nameArea);
        preparedStatement.setString(3, typeEquipment);
        preparedStatement.executeUpdate();
    }


}
