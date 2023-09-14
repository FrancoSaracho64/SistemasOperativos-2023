package ar.edu.unlu.so;

public class Proceso {
    private static int count = 0;
    private int process_id;
    private int tiempo_requerido;
    private final int tiempo_inicial;
    private double estado_Reloj;

    public Proceso(Integer tiempo_requerido) {
        this.process_id = ++count;
        this.tiempo_requerido = tiempo_requerido;
        this.tiempo_inicial = tiempo_requerido;
        estado_Reloj = 0.0;
    }

    public Integer getProcess_id() {
        return process_id;
    }

    public Integer getTiempo_requerido() {
        return tiempo_requerido;
    }

    public void setTiempo_requerido(Integer tiempo_requerido) {
        this.tiempo_requerido = tiempo_requerido;
    }

    public int getTiempo_inicial() {
        return tiempo_inicial;
    }

    public double getEstado_Reloj() {
        return estado_Reloj;
    }

    public void setEstado_Reloj(double estado_Reloj) {
        this.estado_Reloj = estado_Reloj;
    }
}
