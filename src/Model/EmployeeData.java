package Model;

public class EmployeeData {

    private int idEmployee;
    private String position;
    private String fio;

    public EmployeeData(int idEmployee, String fio, String position){
        this.idEmployee = idEmployee;
        this.fio = fio;
        this.position = position;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }
}
