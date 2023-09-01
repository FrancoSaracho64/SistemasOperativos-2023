package ar.edu.unlu.so;

public class Proceso {
    private Integer process_id;
    private Integer tiempo_requerido;

    public Proceso() {
    }

    public Proceso(Integer process_id, Integer tiempo_requerido) {
        this.process_id = process_id;
        this.tiempo_requerido = tiempo_requerido;
    }

    public Integer getProcess_id() {
        return process_id;
    }

    public void setProcess_id(Integer process_id) {
        this.process_id = process_id;
    }

    public Integer getTiempo_requerido() {
        return tiempo_requerido;
    }

    public void setTiempo_requerido(Integer tiempo_requerido) {
        this.tiempo_requerido = tiempo_requerido;
    }
}
