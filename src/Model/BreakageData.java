package Model;

public class BreakageData {

    private String dateBreakage;
    private String reason;
    private String fio;
    private int idEquipment;
    private int idArea;
    private String nameEquipment;
    private String typeEquipment;
    private String nameArea;

    public BreakageData(String dateBreakage, String reason, String fio, int idEquipment, int idArea) {
        this.dateBreakage = dateBreakage;
        this.reason = reason;
        this.fio = fio;
        this.idEquipment = idEquipment;
        this.idArea = idArea;
    }

    public BreakageData(String reason, String dateBreakage, String nameEquipment, String typeEquipment, String nameArea) {
        this.reason = reason;
        this.dateBreakage = dateBreakage;
        this.nameEquipment = nameEquipment;
        this.typeEquipment = typeEquipment;
        this.nameArea = nameArea;

    }

    public void setTypeEquipment(String typeEquipment) {
        this.typeEquipment = typeEquipment;
    }

    public String getTypeEquipment() {
        return typeEquipment;
    }

    public void setNameEquipment(String nameEquipment) {
        this.nameEquipment = nameEquipment;
    }

    public String getNameEquipment() {
        return nameEquipment;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }

    public String getNameArea() {
        return nameArea;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public void setIdEquipment(int idEquipment) {
        this.idEquipment = idEquipment;
    }

    public int getIdEquipment() {
        return idEquipment;
    }

    public void setDateBreakage(String dateBreakage) {
        this.dateBreakage = dateBreakage;
    }

    public String getDateBreakage() {
        return dateBreakage;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
