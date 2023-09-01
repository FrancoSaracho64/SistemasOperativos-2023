import ar.edu.unlu.so.Proceso;
import ar.edu.unlu.so.ProcesoTerminado;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Inicializamos/creamos lo necesario
        ArrayList<ProcesoTerminado> procesosFinalizados = new ArrayList<ProcesoTerminado>();
        ArrayList<Proceso> procesos = new ArrayList<Proceso>();
        ArrayList<Proceso> copia = new ArrayList<Proceso>();

        int q = 10;
        double ti = 1;  // --->
        double reloj = 0.0;

        Proceso P1 = new Proceso(1,8); // 6-4-2-fin termina tercero
        Proceso P2 = new Proceso(2,9); // 7-5-3fin termina cuarto
        Proceso P3 = new Proceso(3,5); // 3-fin termina segundo
        Proceso P4 = new Proceso(4,2); // fin termina primero
        Proceso P5 = new Proceso(5,16); // fin termina primero
        Proceso P6 = new Proceso(6,15); // fin termina primero
        Proceso P7 = new Proceso(7,10); // fin termina primero
        Proceso P8 = new Proceso(8,8); // fin termina primero
        procesos.add(P1);
        procesos.add(P2);
        procesos.add(P3);
        procesos.add(P4);
        procesos.add(P5);
        procesos.add(P6);
        procesos.add(P7);
        procesos.add(P8);


        Proceso P1_ = new Proceso(1,8); // 6-4-2-fin termina tercero
        Proceso P2_ = new Proceso(2,9); // 7-5-3fin termina cuarto
        Proceso P3_ = new Proceso(3,5); // 3-fin termina segundo
        Proceso P4_ = new Proceso(4,2); // fin termina primero
        Proceso P5_ = new Proceso(5,16); // fin termina primero
        Proceso P6_ = new Proceso(6,15); // fin termina primero
        Proceso P7_ = new Proceso(7,10); // fin termina primero
        Proceso P8_ = new Proceso(8,8); // fin termina primero
        copia.add(P1_);
        copia.add(P2_);
        copia.add(P3_);
        copia.add(P4_);
        copia.add(P5_);
        copia.add(P6_);
        copia.add(P7_);
        copia.add(P8_);

        Proceso procAnt = null;

        int contadorPasadas = 1;

        while (calcularSumatoria(procesos) > 0){
            System.out.println("Pasada n°: " + contadorPasadas);

            for (int i = 0; i <= procesos.size()-1; i++) {
                if (procesos.get(i).getTiempo_requerido() > 0) {
                    System.out.println();
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
                        if (procesos.get(i) != procAnt) {
                            //Scheduler
                            reloj += (ti / 2);
                        }

                        ejecutarProceso(procesos.get(i), q);
                        reloj = reloj + q;
                    } else {
                        if (procesos.get(i) != procAnt) {
                            //Scheduler
                            reloj += (ti / 2);
                        }
                        ejecutarProceso(procesos.get(i), q);
                        reloj = reloj + q;

                        reloj += procesos.get(i).getTiempo_requerido();
                        procesos.get(i).setTiempo_requerido(0);

                        ProcesoTerminado finalizado = new ProcesoTerminado(procesos.get(i).getProcess_id(), copia.get(i).getTiempo_requerido(), reloj);

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
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("Ya finalizaron todos los procesos.");
        System.out.println();
        System.out.println();

        for (int i = 0; i <= procesosFinalizados.size() - 1; i++){
            Integer processId = procesosFinalizados.get(i).getProcess_id();
            //double estadoReloj = procesosFinalizados.get(i).getEstado_Reloj();
            double tiempo_Espera = procesosFinalizados.get(i).getEstado_Reloj() - procesosFinalizados.get(i).getTiempo_requerido();
            double tiempo_Retorno = procesosFinalizados.get(i).getEstado_Reloj();

            System.out.println("ID: " + processId);
            //System.out.println("Reloj: " + estadoReloj + " Quantums");
            System.out.println("Tiempo de espera: " + tiempo_Espera + " Quantums");
            System.out.println("Tiempo de retorno: " + tiempo_Retorno + " Quantums");

            System.out.println();
            System.out.println("************************************************************");
        }
        System.out.println();

    }
    public static int calcularSumatoria(ArrayList<Proceso> procesos){
        int sumatoria = 0;
        for (int i = 0; i < procesos.size(); i++){
            sumatoria += procesos.get(i).getTiempo_requerido();
        }
        return sumatoria;
    }

    public static void ejecutarProceso(Proceso proceso, int quantum){
        proceso.setTiempo_requerido(proceso.getTiempo_requerido() - quantum);
    }
}