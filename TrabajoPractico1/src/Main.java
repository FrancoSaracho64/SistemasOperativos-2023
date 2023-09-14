import ar.edu.unlu.so.Proceso;
import ar.edu.unlu.so.ProcesoTerminado;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Inicializamos/creamos lo necesario
        ArrayList<Proceso> procesos = new ArrayList<>();
        ArrayList<ProcesoTerminado> procesosFinalizados = new ArrayList<>();

        int q = 5;
        double ti = 1;  // --->
        double reloj = 0.0;

        Proceso P1 = new Proceso(6);
        Proceso P2 = new Proceso(6);
        Proceso P3 = new Proceso(5);
        Proceso P4 = new Proceso(2);
        Proceso P5 = new Proceso(16);
        Proceso P6 = new Proceso(15);
        Proceso P7 = new Proceso(10);
        Proceso P8 = new Proceso(8);
        procesos.add(P1);
        procesos.add(P2);
        /*procesos.add(P3);
        procesos.add(P4);
        procesos.add(P5);
        procesos.add(P6);
        procesos.add(P7);
        procesos.add(P8);*/

        Proceso procAnt = null;

        int contadorPasadas = 1;

        while (calcularSumatoria(procesos) > 0){
            System.out.println("Pasada n°: " + contadorPasadas);

            for (int i = 0; i <= procesos.size()-1; i++) {
                if (procesos.get(i).getTiempo_requerido() > 0) {
                    System.out.println("************************************************************");
                    System.out.println("Estado del reloj antes de la ejecucion: " + reloj);
                    System.out.println("ID_Process: " + procesos.get(i).getProcess_id());
                    System.out.println("Tiempo de servicio requerido (antes de ejecutarse): " + procesos.get(i).getTiempo_requerido());

                    if (procAnt == null) {
                        //Scheduler
                        reloj += (ti / 2);
                    }

                    if (procesos.get(i) != procAnt && procAnt != null) {
                        //Scheduler
                        reloj += (ti / 2);
                    }

                    if (procesos.get(i).getTiempo_requerido() > q) {
                        ejecutarProceso(procesos.get(i), q);
                        reloj = reloj + q;
                    } else {

                        ejecutarProceso(procesos.get(i), q);
                        reloj = reloj + q;
                        reloj += procesos.get(i).getTiempo_requerido();
                        procesos.get(i).setTiempo_requerido(0);

                        ProcesoTerminado finalizado = new ProcesoTerminado(procesos.get(i).getProcess_id(), procesos.get(i).getTiempo_inicial(), reloj);

                        procesosFinalizados.add(finalizado);
                    }
                    System.out.println("Tiempo de servicio requerido (despues de ejecutarse): " + procesos.get(i).getTiempo_requerido());
                    System.out.println("Estado del reloj actual: " + (reloj));
                    System.out.println("************************************************************");

                } else {
                    System.out.println();
                    System.out.println("************************************************************");
                    System.out.println("ID_Process: " + procesos.get(i).getProcess_id() + " ya ha finalizado su ejecucion");
                    System.out.println("************************************************************");
                }
                procAnt = procesos.get(i);
            }
            contadorPasadas++;
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println("Ya finalizaron todos los procesos.");
        System.out.println();

        for (ProcesoTerminado procesosFinalizado : procesosFinalizados) {
            int processId = procesosFinalizado.getProcess_id();
            double tiempo_Espera = procesosFinalizado.getEstado_Reloj() - procesosFinalizado.getTiempo_inicial();
            double tiempo_Retorno = procesosFinalizado.getEstado_Reloj();

            System.out.println("ID: " + processId);
            System.out.println("Tiempo de espera: " + tiempo_Espera + " Quantums");
            System.out.println("Tiempo de retorno: " + tiempo_Retorno + " Quantums");

            System.out.println();
            System.out.println("************************************************************");
        }
        System.out.println();
        System.out.println();
        System.out.println("---- Promedios ----");
        double prom_espera = 0.0;
        double prom_retorno = 0.0;

        for (ProcesoTerminado procesosFinalizado : procesosFinalizados) {
            prom_espera += procesosFinalizado.getEstado_Reloj() - procesosFinalizado.getTiempo_inicial();
            prom_retorno += procesosFinalizado.getEstado_Reloj();
        }
        prom_espera = prom_espera/procesosFinalizados.size();
        prom_retorno = prom_retorno/procesosFinalizados.size();

        System.out.println("Tiempo de espera promedio: " + prom_espera + " Quantums");
        System.out.println("Tiempo de retorno promedio: " + prom_retorno + " Quantums");
        System.out.println();
    }
    public static int calcularSumatoria(ArrayList<Proceso> procesos){
        int sumatoria = 0;
        for (Proceso proceso : procesos) {
            sumatoria += proceso.getTiempo_requerido();
        }
        return sumatoria;
    }

    public static void ejecutarProceso(Proceso proceso, int quantum){
        proceso.setTiempo_requerido(proceso.getTiempo_requerido() - quantum);
    }
}