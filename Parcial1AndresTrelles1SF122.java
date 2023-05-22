package parcial1andrestrelles.pkg1sf122;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Parcial1AndresTrelles1SF122 {
    
    static int numContratistas = 5;  //Es necesario incluir manualmente los valores de los honorarios 3=40 Y 2=30
    static int numEmpleados = 10;   //En caso de querer agrandar el programa, se aumenta el número asignado 
    static double[] salariosNetosContratistas;
    static double[] salariosNetosAsalariados;
public static void main(String[] args) {  

        System.out.println("Bienvenido al sistema de Gestión de Innova&Crea");

        salarioAsalariado();
        salarioContratista();
        salarioGerente();
        double salarioNetoGerente = 0.0;
        double ingresoTotalNeto = calcularSalarioNetos(salariosNetosContratistas, salariosNetosAsalariados, salarioNetoGerente);
         System.out.printf("El ingreso de la empresa es de: $%.2f\n", ingresoTotalNeto);
        double ingresoFinal = deudaFiscal(salariosNetosContratistas, salariosNetosAsalariados, salarioNetoGerente);
         System.out.printf("El ingreso final de la empresa luego de las deducciones de deuda fiscal y costo de servicios es de: $%.2f\n", ingresoFinal);
         double ingresoDeseado = 0.45 * ingresoFinal / 100.0;
        double ingresoTotalDeseado = ingresoDeseado / 0.55;
        System.out.printf("El ingreso total necesario para obtener 0.45 centavos por dólar al final del mes es de: $%.2f\n", ingresoTotalDeseado);
         
        System.out.println("El programa ha finalizado.");
    }

public static double salarioAsalariado() {
    
     System.out.println("Ingrese la información de los asalariados ");
 Scanner sc = new Scanner(System.in);


double[] sueldos = new double[numEmpleados];
String[] asalariados = new String[numEmpleados];
String[] cedulas = new String[numEmpleados];
salariosNetosAsalariados = new double[numEmpleados];
double totalSalariosNetosA = 0.0;

for (int i = 0; i < numEmpleados; i++) {
    String nombre = JOptionPane.showInputDialog("Introduce el nombre completo del empleado #" + (i+1));
    String cedula = JOptionPane.showInputDialog("Introduce la cédula del empleado #" + (i+1));
    double salario = 0;
    boolean salarioValido = false;
    while (!salarioValido) {
        String salarioStr = JOptionPane.showInputDialog("Introduce el salario bruto mensual de " + nombre);
        try {                   //Manejo de excepciones
            salario = Double.parseDouble(salarioStr);
            if (salario < 800 || salario > 1600) {
                JOptionPane.showMessageDialog(null, "El salario debe estar entre $800 y $1600.");   //El null es utilizado para mantener centreado el mensaje de diálogo
            } else {
                salarioValido = true;
            }
        } catch (NumberFormatException e) {         //Fin del manejo de excepciones
            JOptionPane.showMessageDialog(null, "Introduce un número válido.");
        }
    }
    sueldos[i] = salario;                   //Arreglos de los asalariados y sus componentes a escanear(salario bruto, nombre completo, cédula
    asalariados[i] = nombre;
    cedulas[i] = cedula;
}

System.out.println("Salario bruto de los asalariados:");
System.out.println("Cédula\t\tNombre\t\t\tSalario Bruto\tImpuesto Renta\tImpuesto Seguro Social\tImpuesto Seguro Educativo\tSalario Neto");
for (int i = 0; i < numEmpleados; i++) {            //Ciclo for, incremento hasta que i sea mayor al numero de empleados(ahí se finaliza)
    double salarioBruto = sueldos[i];
    double impuestoRenta = calcularImpuestoRenta(salarioBruto * 13);                
    double impuestoSeguroSocial = salarioBruto * 0.0975;                            
    double impuestoSeguroEducativo = salarioBruto * 0.0125;
     salariosNetosAsalariados[i] = salarioBruto - impuestoSeguroSocial - impuestoSeguroEducativo - impuestoRenta;
        totalSalariosNetosA +=  salariosNetosAsalariados[i]; // sumar salario neto al total
        System.out.printf("%s\t%s\t$%.2f\t\t$%.2f\t\t$%.2f\t\t\t$%.2f\t\t\t$%.2f\n", cedulas[i], asalariados[i], salarioBruto, impuestoRenta, impuestoSeguroSocial, impuestoSeguroEducativo, salariosNetosAsalariados[i]);
     }
     return totalSalariosNetosA; // devolver la sumatoria de los salarios netos  $%.4f\n
}


public static double salarioContratista() {
    
     System.out.println("Ingrese la información de los contratistas ");
     Scanner sc = new Scanner(System.in);

    double[] honorarios = new double[numContratistas];
    double[] horasTrabajadas = new double[numContratistas];
    String[] nombres = new String[numContratistas];
    String[] cedulas = new String[numContratistas];     
    salariosNetosContratistas = new double[numContratistas];
    double totalSalariosNetosC = 0.0;

    
    for (int i = 0; i < numContratistas; i++) {
        nombres[i] = JOptionPane.showInputDialog(null, "Ingrese el nombre completo del contratista #" + (i+1));     
        cedulas[i] = JOptionPane.showInputDialog(null, "Ingrese la cédula del contratista #" + (i+1));
        honorarios[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el honorario por hora del contratista #" + (i+1)));
        horasTrabajadas[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese las horas trabajadas del contratista #" + (i+1)));
        salariosNetosContratistas[i] = honorarios[i] * horasTrabajadas[i] * 0.93; // guardar el salario neto en el nuevo arreglo
    }

    System.out.println("Salario mensual de los contratistas:");
    System.out.println("Cédula\t\tNombre\t\t\tSalario Bruto\tImpuesto Servicio Profesional\tSalario Neto");
    for (int i = 0; i < numContratistas; i++) {
        double salarioBruto = honorarios[i] * horasTrabajadas[i];
        double impuestoServicioProfesional = salarioBruto * 0.07;
        double salarioNeto = salariosNetosContratistas[i]; // obtener el salario neto del nuevo arreglo
        System.out.printf("%s\t%s\t$%.2f\t\t$%.2f\t\t\t\t$%.2f\n", cedulas[i], nombres[i], salarioBruto, impuestoServicioProfesional, salarioNeto);
        totalSalariosNetosC += salarioNeto; // sumar el salario neto al total
    }
    System.out.printf("Total de salarios netos de los contratistas : $%.2f\n", totalSalariosNetosC); // imprimir el total de salarios netos
    return totalSalariosNetosC;
}


public static double salarioGerente() {
    double sueldoMensual = 4300.00;
    System.out.println("Salario bruto mensual del gerente: $" + sueldoMensual);
    System.out.println("Salario bruto anual del gerente: $" + sueldoMensual*12.0);
    double impuestoRenta = calcularImpuestoRenta(55900);
    System.out.printf("Impuesto Renta: $%.4f\n", impuestoRenta);
    double impuestoSeguroSocial = 4300.00 * 0.0975;
    System.out.println("Impuesto Seguro Social: $" + impuestoSeguroSocial);
    double impuestoSeguroEducativo = 4300.00 * 0.0125;
    System.out.println("Impuesto Seguro Educativo: $" + impuestoSeguroEducativo);
    double salarioNetoGerente = 4300.00 - impuestoRenta - impuestoSeguroSocial - impuestoSeguroEducativo;
    System.out.printf("Salario Neto mensual: $%.2f\n", salarioNetoGerente );
    System.out.printf("Salario Neto anual: $%.2f\n", salarioNetoGerente * 12.0);
    System.out.printf("Salario neto del Gerente: $%.2f\n", salarioNetoGerente);
    return salarioNetoGerente;
}




public static double calcularImpuestoRenta(double salarioAnual) {       //Función del impuesto de renta
        double impuesto = 0.0;
        if (salarioAnual <= 10000) {
            impuesto = 0.0;
        } else if (salarioAnual <= 25000) {
            impuesto = (salarioAnual - 10000) * 0.1;
        } else if (salarioAnual <= 50000) {
            impuesto = 1500 + (salarioAnual - 25000) * 0.2;
        } else if (salarioAnual <= 100000) {
            impuesto = 9000 + (salarioAnual - 50000) * 0.3;
        } else {
            impuesto = 21000 + (salarioAnual - 100000) * 0.4;
        }
        return impuesto / 13.0;
    }

public static double calcularImpuestoSeguroSocial(double salario) { //Función para Calcular el impuesto del seguro Social
    if (salario <= 0) { //Aquí evitamos que el usuario inserte numeros negativos o 0
        return 0;
    } else if (salario <= 1000) {
        return salario * 0.06;
    } else if (salario <= 2000) {
        return salario * 0.075;
    } else {
        return salario * 0.09;
    }
}

public static double calcularImpuestoSeguroEducativo(double salario) {  //Función para Calcular el impuesto del seguro Educativo
    if (salario <= 0) {     //Aquí evitamos que el usuario inserte numeros negativos o 0
        return 0;
    } else if (salario <= 1000) {
        return salario * 0.01;
    } else if (salario <= 2000) {
        return salario * 0.015;
    } else {
        return salario * 0.02;
    }
    
}
public static double calcularSalarioNetos(double[] salariosNetosContratistas, double[] salariosNetosAsalariados, double salarioNetoGerente) {
    // Sumar salarios netos de los asalariados
    double sumaSalariosAsalariados = 0.0;
    for (double salarioNeto : salariosNetosAsalariados) {
        sumaSalariosAsalariados += salarioNeto;
    }
    System.out.printf("Suma de los salarios netos de los asalariados: $%.2f\n", sumaSalariosAsalariados);
    
    // Sumar salarios netos de los contratistas
    double sumaSalariosContratistas = 0.0;
    for (double salarioNeto : salariosNetosContratistas) {
        sumaSalariosContratistas += salarioNeto;
    }
    System.out.printf("Suma de los salarios netos de los contratistas: $%.2f\n", sumaSalariosContratistas);
    double ingresosTotales = sumaSalariosAsalariados + sumaSalariosContratistas + salarioNetoGerente;

    return ingresosTotales;
}



public static double deudaFiscal(double[] salariosNetosContratistas, double[] salariosNetosAsalariados, double salarioNetoGerente) {
double sumaSalariosContratistas = 0.0;
for (double salarioNeto : salariosNetosContratistas) {
sumaSalariosContratistas += salarioNeto;
}
double sumaSalariosAsalariados = 0.0;
for (double salarioNeto : salariosNetosAsalariados) {
sumaSalariosAsalariados += salarioNeto;
}
double ingresoTotalNeto = sumaSalariosContratistas + sumaSalariosAsalariados + salarioNetoGerente;
double deudaFiscal = ingresoTotalNeto;
double costoOperativo = deudaFiscal * 0.5;
double costoServicio = deudaFiscal * 0.3;
double ingresoFinal = deudaFiscal + costoOperativo + costoServicio;
double ingresoTotal = (0.8/0.55) * ingresoFinal;
return ingresoTotal;
}

}
