package ar.edu.unlu.so;

public class ProcesoTerminado{
    private int process_id;
    private int tiempo_inicial;
    private double estado_Reloj;

    public ProcesoTerminado(int id, int tiempo_inicial, double estado_Reloj) {
        this.process_id = id;
        this.tiempo_inicial = tiempo_inicial;
        this.estado_Reloj = estado_Reloj;
    }

    public int getProcess_id() {
        return process_id;
    }

    public void setProcess_id(int process_id) {
        this.process_id = process_id;
    }

    public int getTiempo_inicial() {
        return tiempo_inicial;
    }

    public void setTiempo_inicial(int tiempo_inicial) {
        this.tiempo_inicial = tiempo_inicial;
    }

    public double getEstado_Reloj() {
        return estado_Reloj;
    }

    public void setEstado_Reloj(double estado_Reloj) {
        this.estado_Reloj = estado_Reloj;
    }
}
