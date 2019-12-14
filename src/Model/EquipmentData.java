package Model;

public class EquipmentData {

    private int idEquipment;
    private String nameEquipment;
    private String typeEquipment;

    public EquipmentData(int idEquipment, String nameEquipment, String typeEquipment) {
        this.idEquipment = idEquipment;
        this.nameEquipment = nameEquipment;
        this.typeEquipment = typeEquipment;
    }

    public void setIdEquipment(int idEquipment) {
        this.idEquipment = idEquipment;
    }

    public int getIdEquipment() {
        return idEquipment;
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
}
