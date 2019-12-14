package Model;

public class InspectionData {
    private String dateInspection;
    private String result;
    private String reason;
    private int idEmployee;
    private int idEquipment;
    private String nameEquipment;
    private String typeEquipment;
    private String FIO;
    private String position;


    public InspectionData(String dateInspection, String result, String reason, int idEmployee, int idEquipment) {
        this.dateInspection = dateInspection;
        this.result = result;
        this.reason = reason;
        this.idEmployee = idEmployee;
        this.idEquipment = idEquipment;
    }

    public InspectionData(String dateInspection, int idEquipment, String nameEquipment, String typeEquipment, String result) {
        this.dateInspection = dateInspection;
        this.idEquipment = idEquipment;
        this.nameEquipment = nameEquipment;
        this.typeEquipment = typeEquipment;
        this.result = result;
    }

    public InspectionData(String FIO, String position, String dateInspection){
        this.FIO = FIO;
        this.position = position;
        this.dateInspection = dateInspection;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getFIO() {
        return FIO;
    }

    public void setNameEquipment(String nameEquipment) {
        this.nameEquipment = nameEquipment;
    }

    public String getNameEquipment() {
        return nameEquipment;
    }

    public void setTypeEquipment(String typeEquipment) {
        this.typeEquipment = typeEquipment;
    }

    public String getTypeEquipment() {
        return typeEquipment;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setIdEquipment(int idEquipment) {
        this.idEquipment = idEquipment;
    }

    public int getIdEquipment() {
        return idEquipment;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setDateInspection(String dateInspection) {
        this.dateInspection = dateInspection;
    }

    public String getDateInspection() {
        return dateInspection;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
