package Paquete;
/*
*Función Promedio de respuesta por consulta de clientes
* FuncionPromedioRespuestaConsulta
* Andrés Trelles
* 8-971-969
*/

import java.io.IOException;
import Paquete.Excel;
import Paquete.Interfaces.Operacion;

public class PromedioRespuestaConsulta implements Operacion {
    static final String HOJA = "fc";
    static final int FILA = 11;

    public double calcular() {
        int numeroConsultas = 0;
        double tiempoRespuestaTotal = 0;

        try {
            // Leer las entradas desde el archivo Excel
            numeroConsultas = (int) Excel.leerCelda(HOJA, FILA, 1);
            tiempoRespuestaTotal = Excel.leerCelda(HOJA, FILA, 2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calcular el promedio de respuesta por consulta
        double promedioRespuesta = calcularPromedioRespuesta(numeroConsultas, tiempoRespuestaTotal);
        return promedioRespuesta;
    }

    public void guardarValor(double valor) {
        try {
            // Escribir la salida (promedio de respuesta) en la columna 4 del archivo Excel
            Excel.escribirCelda(HOJA, FILA, 4, valor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

          public void explicarIndice() {
    // Explica tu indice
    System.out.println("Se encarga de calcular el promedio de respuesta por consulta y guardar este valor en una hoja de cálculo de Excel."
            + "Utiliza dos entradas, las cuales son el número total de consultas por clientes y el tiempo promedio de respuesta en minutos. "
            + "Con esto se obtiene el promedio de respuesta por consulta de clientes");
  }
          
    // Método para calcular el promedio de respuesta por consulta
    public static double calcularPromedioRespuesta(int numeroConsultas, double tiempoRespuestaTotal) {
        // Calcular el promedio de respuesta
        return tiempoRespuestaTotal / numeroConsultas;
    }
}

