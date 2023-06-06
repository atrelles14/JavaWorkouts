/*
Este programa permite calcular el área y perimetro de muchas figuras geometricas, así como el radio del círculo y la 
hipotenusa del Triangulo Rectangulo.
*/

package pruebaparcial2;

import java.util.Scanner;

public class PruebaParcial2 {
   
       
    public enum TipoFigura {
        CUADRADO,
        CIRCULO,
        RECTANGULO,
        TRIANGULO,
        ROMBO,
        TRAPECIO
    }

    public static void main(String[] args) {
        System.out.println("Ingrese el tipo de figura");
        System.out.println("1. Cuadrado");
        System.out.println("2. Círculo");
        System.out.println("3. Rectángulo");
        System.out.println("4. Triángulo");
        System.out.println("5. Rombo");
        System.out.println("6. Trapecio");
        System.out.println("7. Salir");

        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        FiguraGeometrica figura = null;

        switch (opcion) {
            case 1:
                System.out.println("Ingrese la longitud de un lado del cuadrado(cm):");
                double ladoCuadrado = scanner.nextDouble();
                figura = new Cuadrado(ladoCuadrado);
                break;
            case 2:
                System.out.println("Ingrese el radio del círculo(cm²):");
                double radio = scanner.nextDouble();
                figura = new Circulo(radio);
                break;
            case 3:
                System.out.println("Ingrese la base del rectángulo(cm):");
                double baseRectangulo = scanner.nextDouble();
                System.out.println("Ingrese la altura del rectángulo(cm):");
                double alturaRectangulo = scanner.nextDouble();
                figura = new Rectangulo(baseRectangulo, alturaRectangulo);
                break;
            case 4:
                     System.out.println("Ingrese la base del triángulo(cm):");
        double baseTriangulo = scanner.nextDouble();
        System.out.println("Ingrese la altura del triángulo(cm):");
        double alturaTriangulo = scanner.nextDouble();

        System.out.println("¿Desea clasificar el triángulo por sus lados o por sus ángulos?");
        System.out.println("1. Clasificar por lados");
        System.out.println("2. Clasificar por ángulos");
        int clasificacion = scanner.nextInt();

        if (clasificacion == 1) {
            System.out.println("Ingrese el valor del lado 1:");
            double lado1Triangulo = scanner.nextDouble();
            System.out.println("Ingrese el valor del lado 2:");
            double lado2Triangulo = scanner.nextDouble();
            System.out.println("Ingrese el valor del lado 3:");
            double lado3Triangulo = scanner.nextDouble();
            figura = new Triangulo(baseTriangulo, alturaTriangulo, lado1Triangulo, lado2Triangulo, lado3Triangulo, 0, 0, 0);
        } else if (clasificacion == 2) {
            System.out.println("Ingrese el valor del primer ángulo:");
            double angulo1Triangulo = scanner.nextDouble();

            System.out.println("Ingrese el valor del segundo ángulo:");
            double angulo2Triangulo = scanner.nextDouble();

            // El tercer ángulo se calcula como la diferencia entre 180 grados y la suma de los dos ángulos anteriores
            double angulo3Triangulo = 180 - angulo1Triangulo - angulo2Triangulo;

            System.out.println("Ingrese el valor del lado 1:");
            double lado1Triangulo = scanner.nextDouble();
            System.out.println("Ingrese el valor del lado 2:");
            double lado2Triangulo = scanner.nextDouble();
            System.out.println("Ingrese el valor del lado 3:");
            double lado3Triangulo = scanner.nextDouble();

            figura = new Triangulo(baseTriangulo, alturaTriangulo, lado1Triangulo, lado2Triangulo, lado3Triangulo, angulo1Triangulo, angulo2Triangulo, angulo3Triangulo);
        } else {
            System.out.println("Opción no válida.");
            scanner.close();
            return;
                }
                break;
            case 5:
                System.out.println("Ingrese la longitud de la diagonal mayor del rombo(cm):");
                double diagonalMayor = scanner.nextDouble();
                System.out.println("Ingrese la longitud de la diagonal menor del rombo(cm):");
                double diagonalMenor = scanner.nextDouble();
                figura = new Rombo(diagonalMayor, diagonalMenor);
                break;
            case 6:
                System.out.println("Ingrese la longitud de la base mayor del trapecio(cm):");
                double baseMayor = scanner.nextDouble();
                System.out.println("Ingrese la longitud de la base menor del trapecio(cm):");
                double baseMenor = scanner.nextDouble();
                System.out.println("Ingrese la altura del trapecio(cm):");
                double alturaTrapecio = scanner.nextDouble();
                figura = new Trapecio(baseMayor, baseMenor, alturaTrapecio);
                break;
            case 7:
                System.out.println("Saliendo...");
                scanner.close();
                return;
            default:
                System.out.println("Opción no válida.");
                scanner.close();
                return;
        }

        ImpresoraFigura.imprimirFigura(figura);

        scanner.close();
    }
}

class ImpresoraFigura {
    public static void imprimirFigura(FiguraGeometrica figura) {
        if (figura instanceof Cuadrado) {
            Cuadrado cuadrado = (Cuadrado) figura;
            System.out.println("Cuadrado");
            System.out.println("Lado: " + cuadrado.getLado());
            System.out.println("Área: " + cuadrado.calcularArea());
            System.out.println("Perímetro: " + cuadrado.calcularPerimetro());
        } else if (figura instanceof Circulo) {
            Circulo circulo = (Circulo) figura;
            System.out.println("Círculo");
            System.out.println("Radio en cm: " + circulo.getRadio());
            System.out.println("Área: " + circulo.calcularArea() + " cm");
            System.out.println("Perímetro: " + circulo.calcularPerimetro() + " cm");
        } else if (figura instanceof Rectangulo) {
            Rectangulo rectangulo = (Rectangulo) figura;
            System.out.println("Rectángulo");
            System.out.println("Base: " + rectangulo.getBase());
            System.out.println("Altura: " + rectangulo.getAltura());
            System.out.println("Área: " + rectangulo.calcularArea());
            System.out.println("Perímetro: " + rectangulo.calcularPerimetro());
       } else if (figura instanceof Triangulo) {
        Triangulo triangulo = (Triangulo) figura;
        System.out.println("Triángulo");
        System.out.println("Base: " + triangulo.getBase());
        System.out.println("Altura: " + triangulo.getAltura());
        System.out.println("Área: " + triangulo.calcularArea());
        System.out.println("Perímetro: " + triangulo.calcularPerimetro());

                if (triangulo.esRectangulo()) {
                    System.out.println("Hipotenusa: " + triangulo.calcularHipotenusa());
                }
        System.out.println("Tipo de triángulo por lados: " + triangulo.determinarTipoTriangulo());
        System.out.println("Tipo de triángulo por ángulos: " + triangulo.determinarTipoTrianguloPorAngulos());
        
        } else if (figura instanceof Rombo) {
            Rombo rombo = (Rombo) figura;
            System.out.println("Rombo");
            System.out.println("Diagonal Mayor: " + rombo.getDiagonalMayor());
            System.out.println("Diagonal Menor: " + rombo.getDiagonalMenor());
            System.out.println("Área: " + rombo.calcularArea());
            System.out.println("Perímetro: " + rombo.calcularPerimetro());
        } else if (figura instanceof Trapecio) {
            Trapecio trapecio = (Trapecio) figura;
            System.out.println("Trapecio");
            System.out.println("Base Mayor: " + trapecio.getBaseMayor());
            System.out.println("Base Menor: " + trapecio.getBaseMenor());
            System.out.println("Altura: " + trapecio.getAltura());
            System.out.println("Área: " + trapecio.calcularArea());
            System.out.println("Perímetro: " + trapecio.calcularPerimetro());
        }
    }
}

abstract class FiguraGeometrica {
    abstract double calcularArea();
    abstract double calcularPerimetro();
}

class Cuadrado extends FiguraGeometrica {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
}

class Circulo extends FiguraGeometrica {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

    class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}

class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    private double lado3;
    private double angulo1;
    private double angulo2;
    private double angulo3;

    public Triangulo(double base, double altura, double lado1, double lado2, double lado3, double angulo1, double angulo2, double angulo3) {
        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.angulo1 = angulo1;
        this.angulo2 = angulo2;
        this.angulo3 = angulo3;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public String determinarTipoTriangulo() {
        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }
    
        public String determinarTipoTrianguloPorAngulos() {
            if (angulo1 < 90 && angulo2 < 90 && angulo3 < 90) {
                return "Acutángulo";
            } else if (angulo1 == 90 || angulo2 == 90 || angulo3 == 90) {
                return "Rectángulo";
            } else {
                return "Obtusángulo";
            }
        }

    
    public boolean esRectangulo(){
        return (angulo1 == 90 || angulo2 == 90 || angulo3 == 90);
    }

    public double calcularArea() {
        return (base * altura) / 2;
    }

    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }
    
    public double calcularHipotenusa() {
        if (angulo1 == 90) {
            return Math.sqrt(lado2 * lado2 + lado3 * lado3);
        } else if (angulo2 == 90) {
            return Math.sqrt(lado1 * lado1 + lado3 * lado3);
        } else if (angulo3 == 90) {
            return Math.sqrt(lado1 * lado1 + lado2 * lado2);
        } else {
            return 0; // Si el triángulo no es rectángulo, se devuelve 0
        }
    }
}


class Rombo extends FiguraGeometrica {
    private double diagonalMayor;
    private double diagonalMenor;

    public Rombo(double diagonalMayor, double diagonalMenor) {
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }

    public double getDiagonalMayor() {
        return diagonalMayor;
    }

    public double getDiagonalMenor() {
        return diagonalMenor;
    }

    @Override
    public double calcularArea() {
        return (diagonalMayor * diagonalMenor) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * Math.sqrt((diagonalMayor * diagonalMayor + diagonalMenor * diagonalMenor) / 4);
    }
}

class Trapecio extends FiguraGeometrica {
    private double baseMayor;
    private double baseMenor;
    private double altura;

    public Trapecio(double baseMayor, double baseMenor, double altura) {
        this.baseMayor = baseMayor;
        this.baseMenor = baseMenor;
        this.altura = altura;
    }

    public double getBaseMayor() {
        return baseMayor;
    }

    public double getBaseMenor() {
        return baseMenor;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double calcularArea() {
        return ((baseMayor + baseMenor) * altura) / 2;
    }

    @Override
    public double calcularPerimetro() {
        double ladoA = Math.abs((baseMayor - baseMenor) / 2);
        double ladoB = Math.sqrt(ladoA * ladoA + altura * altura);
        return 2 * (baseMayor + baseMenor) + ladoA + ladoB;
    }

}

   
    

