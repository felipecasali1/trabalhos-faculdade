package models;

public class StatusPedido {
    private int id;
    private Status status;

    public StatusPedido() {
    }

    public StatusPedido(int id, Status status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
