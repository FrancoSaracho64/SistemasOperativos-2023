package ar.edu.unlu.so;

public class ProcesoTerminado {
    private Integer process_id;
    private Integer tiempo_requerido;
    private double estado_Reloj;

    public ProcesoTerminado() {
    }

    public ProcesoTerminado(Integer process_id, Integer tiempo_requerido, double estado_Reloj) {
        this.process_id = process_id;
        this.tiempo_requerido = tiempo_requerido;
        this.estado_Reloj = estado_Reloj;
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

    public double getEstado_Reloj() {
        return estado_Reloj;
    }

    public void setEstado_Reloj(double estado_Reloj) {
        this.estado_Reloj = estado_Reloj;
    }
}
