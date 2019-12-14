package Model;

public class ProdAreaData {
    private int idArea;
    private String nameArea;
    private int idEquipment;
    private String nameEquipment;
    private String typeEquipment;
    private String date;
    private String result;
    private String reason;
    private int idEmployee;
    private String fio;
    private String position;


    //предприятия
    public ProdAreaData(int idArea, String nameArea, String typeEquipment) {
        this.idArea = idArea;
        this.nameArea = nameArea;
        this.typeEquipment = typeEquipment;
    }

    //поломка

//    public ProdAreaData(String date, String reason, String fio,
//                        String nameArea, int idEquipment, String nameEquipment){
//        this.date = date;
//        this.reason = reason;
//        this.fio = fio;
//        this.nameArea = nameArea;
//        this.idEquipment = idEquipment;
//        this.nameEquipment = nameEquipment;
//    }

    public void setTypeEquipment(String typeEquipment) {
        this.typeEquipment = typeEquipment;
    }

    public String getTypeEquipment () {
        return typeEquipment;
    }

    public void setDate() {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setReason() {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setFio() {
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

    public void setNameEquipment() {
        this.nameEquipment = nameEquipment;
    }

    public String getNameEquipment() {
        return nameEquipment;
    }

    public void setIdArea(int idArea){
        this.idArea = idArea;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }

    public String getNameArea() {
        return nameArea;
    }
}
