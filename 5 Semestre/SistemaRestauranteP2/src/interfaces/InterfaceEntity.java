package interfaces;

public abstract class InterfaceEntity {
    private Integer id;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = (id==null || id.isEmpty() || !id.matches("[0-9.]+")) ? 0 : Integer.parseInt(id);
    }
}
