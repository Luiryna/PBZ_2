package Controller;

import Main.*;
import Model.*;

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
    private List<BreakageData> breakages = new ArrayList<>();
    private List<InspectionData> inspections = new ArrayList<>();
    private List<BreakageData> search1 = new ArrayList<>();
    private List<InspectionData> search2 = new ArrayList<>();
    private List<InspectionData> search3 = new ArrayList<>();


    public List<InspectionData> getInspections() throws SQLException {
        inspections.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("SELECT * FROM inspection");
        ResultSet rs = preparedStatementInner.executeQuery();
        while (rs.next()) {
            inspections.add(new InspectionData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
        }

        for (InspectionData data: inspections) {
            System.out.println(data.getDateInspection() + " " + data.getReason() + " " + data.getResult() + " " +
                    data.getIdEmployee() + " " + data.getIdEquipment());
        }

        return inspections;
    }

    public List<BreakageData> getBreakages() throws SQLException {
        breakages.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("SELECT * FROM breakage");
        ResultSet rs = preparedStatementInner.executeQuery();
        while (rs.next()) {
            breakages.add(new BreakageData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
        }

        for (BreakageData data: breakages) {
            System.out.println(data.getDateBreakage() + " " + data.getReason() + " " + data.getFio() + " " +
                    data.getIdEquipment() + " " + data.getIdArea());
        }

        return breakages;
    }

    public void addBreakage(String date, String reason, String fio, int idEquipment, int idArea) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO breakage(dateBreakage, reason, FIO, idEquipment, idArea) VALUES (?,?,?,?,?)");
        preparedStatement.setString(1, date);
        preparedStatement.setString(2, reason);
        preparedStatement.setString(3, fio);
        preparedStatement.setInt(4, idEquipment);
        preparedStatement.setInt(5, idArea);
        preparedStatement.executeUpdate();
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

    public void deleteInspections(String result) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM inspection WHERE result = ?");
        preparedStatement.setString(1, result);
        preparedStatement.executeUpdate();
    }

    public void changeInspection(String result, String reason) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE inspection SET reason = ? WHERE result = ?");
        preparedStatement.setString(1, reason);
        preparedStatement.setString(2, result);
        preparedStatement.executeUpdate();
    }

    public void addInspection(String date, String result, String reason, int idEmployee, int idEquipment) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO inspection(dateInspection, result, reason, idEmployee, idEquipment) VALUES (?,?,?,?,?)");
        preparedStatement.setString(1, date);
        preparedStatement.setString(2, result);
        preparedStatement.setString(3, reason);
        preparedStatement.setInt(4, idEmployee);
        preparedStatement.setInt(5, idEquipment);
        preparedStatement.executeUpdate();
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

    public List<BreakageData> search1 (String date) throws SQLException {
        search1.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("select breakage.reason, breakage.dateBreakage, e.nameEquipment, e.typeEquipment, pa.nameArea\n" +
                "from breakage\n" +
                "inner join equipment e on breakage.idEquipment = e.idEquipment\n" +
                "inner join production_area pa on breakage.idArea = pa.idArea\n" +
                "where dateBreakage = ?;");
        preparedStatementInner.setString(1, date);
        ResultSet rs = preparedStatementInner.executeQuery();
        while (rs.next()) {
            search1.add(new BreakageData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }

        for (BreakageData data: search1) {
            System.out.println(data.getReason() + " " + data.getDateBreakage() + " " + data.getNameEquipment() + " " +
                    data.getTypeEquipment() + " " + data.getNameArea());
        }
        return search1;
    }

    public List<InspectionData> search2 (int idEquipment) throws SQLException {
        search2.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("select inspection.dateInspection, inspection.idEquipment,\n" +
                "       e.nameEquipment, e.typeEquipment,\n" +
                "       inspection.result from inspection\n" +
                "inner join equipment e on inspection.idEquipment = e.idEquipment\n" +
                "where inspection.idEquipment = ?;");
        preparedStatementInner.setInt(1, idEquipment);
        ResultSet rs = preparedStatementInner.executeQuery();
        while (rs.next()) {
            search2.add(new InspectionData(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }

        return search2;
    }

    public List<InspectionData> search3 (String dateInspection) throws SQLException {
        search3.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("select distinct e.FIO, e.position, inspection.dateInspection\n" +
                "from inspection\n" +
                "inner join employee e on inspection.idEmployee = e.idemployee\n" +
                "where dateInspection = ?;");
        preparedStatementInner.setString(1, dateInspection);
        ResultSet rs = preparedStatementInner.executeQuery();
        while (rs.next()) {
            search3.add(new InspectionData(rs.getString(1), rs.getString(2), rs.getString(3)));
        }

        return search3;
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
