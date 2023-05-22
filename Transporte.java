/* 
Andrés Trelles
1SF122 
Práctica 
*/
package practicatransporte;


import javax.swing.JOptionPane;


public class PracticaTransporte {

    private String marca;
    private int velocidad;
    private int pasajeros;
    private String color; 
    private String modelo; 
   

    public PracticaTransporte(String marca, int velocidad, int pasajeros, String color, String modelo){
    this.marca = marca; 
    this.velocidad = velocidad; 
    this.pasajeros = pasajeros;
    this.color = color;
    this.modelo = modelo; 
        
    }
    
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public int getVelocidad(){
        return velocidad;
    }
    
    public void setVelocidad(int velocidad){
        this.velocidad = velocidad; 
    }
      public int getPasajeros(){
        return pasajeros;
    }
    public void setPasajeros(int pasajeros){
        this.pasajeros = pasajeros;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;    
    }
    
        public String getModelo(){
        return modelo;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo; 
        
    }
        public static void main(String[] args) {
        System.out.println("Ingrese la información del carro:");
        String marcaCarro = JOptionPane.showInputDialog("Marca del carro:");
        int velocidadCarro = Integer.parseInt(JOptionPane.showInputDialog("Velocidad del carro(mp/h):"));
        int pasajerosCarro = Integer.parseInt(JOptionPane.showInputDialog("Número de pasajeros del carro:"));
        String colorCarro = JOptionPane.showInputDialog("Color del carro:");
        String modeloCarro = JOptionPane.showInputDialog("Modelo del carro:");
        int puertasCarro = Integer.parseInt(JOptionPane.showInputDialog("Número de puertas del carro:"));
        String transmisionCarro = JOptionPane.showInputDialog("Tipo de transmisión del carro:");
        double potenciaMotorCarro = Double.parseDouble(JOptionPane.showInputDialog("Potencia del motor del carro(caballos de fuerza):"));
        String combustibleCarro = JOptionPane.showInputDialog("Tipo de combustible del carro:");
        int kilometrajeCarro = Integer.parseInt(JOptionPane.showInputDialog("Kilometraje del carro:"));

        Carro carro = new Carro(marcaCarro, velocidadCarro, pasajerosCarro, colorCarro, modeloCarro, puertasCarro,
                transmisionCarro, potenciaMotorCarro, combustibleCarro, kilometrajeCarro);
        
         System.out.println("Información del carro:");
        System.out.println("Marca: " + carro.getMarca());
        System.out.println("Velocidad: " + carro.getVelocidad() + " mph");
        System.out.println("Número de pasajeros: " + carro.getPasajeros());
        System.out.println("Color: " + carro.getColor());
        System.out.println("Modelo: " + carro.getModelo());
        System.out.println("Puertas: " + carro.getPuertas());
        System.out.println("Transmisión: " + carro.getTransmision());
        System.out.println("Potencia del motor: " + carro.getPotenciaMotor() +" caballos de fuerza");
        System.out.println("Combustible utilizado: " + carro.getCombustible());
        System.out.println("Kilometraje del auto: " + carro.getKilometraje() + "kilometros");

                int velocidadCarroObtenida = carro.getVelocidad();
        System.out.println("Velocidad del carro: " + velocidadCarroObtenida + " mph");
        if (velocidadCarroObtenida < 60) {
            System.out.println("Boleta por ir lento");
        } else if (velocidadCarroObtenida >= 110) {
            System.out.println("Boleta por ir muy rápido");
        } else {
            System.out.println("Va a buena velocidad");
        }
                
        
          System.out.println("\nIngrese la información del barco:");
        String marcaBarco = JOptionPane.showInputDialog("Marca del barco:");
        int velocidadBarco = Integer.parseInt(JOptionPane.showInputDialog("Velocidad del barco:"));
        int pasajerosBarco = Integer.parseInt(JOptionPane.showInputDialog("Número de pasajeros del barco:"));
        String colorBarco = JOptionPane.showInputDialog("Color del barco:");
        String modeloBarco = JOptionPane.showInputDialog("Modelo del barco:");
        int caladoBarco = Integer.parseInt(JOptionPane.showInputDialog("Calado del barco(metros):"));
        String nombreBarco = JOptionPane.showInputDialog("Nombre del barco:");
        double tonelajeBarco = Double.parseDouble(JOptionPane.showInputDialog("Tonelaje del barco(toneladas permitidas):"));
        String tipoBarco = JOptionPane.showInputDialog("Tipo de barco:");
        int autonomiaBarco = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la autonomía del barco(en horas):"));

        Barco barco = new Barco(marcaBarco, velocidadBarco, pasajerosBarco, colorBarco, modeloBarco, caladoBarco,
                            nombreBarco, tonelajeBarco, tipoBarco, autonomiaBarco);
        
                  
        System.out.println("Información del barco:");
        System.out.println("Marca: " + barco.getMarca());
        System.out.println("Viaja a " + barco.getVelocidad() + " km/h");
        System.out.println("Su número de pasajeros es: " + barco.getPasajeros());
        System.out.println("Color: " + barco.getColor());
        System.out.println("Modelo: " + barco.getModelo());
        System.out.println("El Calado es de "+ barco.getCalado() + " metros");
        System.out.println("Nombre: " +nombreBarco);
        System.out.println("El tonelaje es de: " + tonelajeBarco + " toneladas" );
        System.out.println("Tipo: " +tipoBarco);
        System.out.println("La autonomía del barco es de:" + autonomiaBarco + " horas");
        
        
        int pasajerosBarcoObtenidos = barco.getPasajeros();
        if (pasajerosBarcoObtenidos < 200) {
            System.out.println("El barco no puede zarpar debido a que tiene menos de 200 pasajeros.");
        } else if (pasajerosBarcoObtenidos <= 1000) {
            System.out.println("El barco puede zarpar a cualquier destino.");
        } else {
            System.out.println("El barco puede zarpar, pero solo a destinos cercanos.");
        }
    }
}
     class Carro extends PracticaTransporte{
        private int puertas; 
        private String transmision; 
        private double potenciamotor; 
        private String combustible;
        private int kilometraje; 
        
        public Carro(String marca, int velocidad, int pasajeros, String color, String modelo, int puertas, String transmision, double potenciamotor, String combustible, int kilometraje){
            super(marca, velocidad, pasajeros, color, modelo);
            this.puertas = puertas;
            this.transmision = transmision; 
            this.potenciamotor = potenciamotor; 
            this.combustible = combustible; 
            this.kilometraje = kilometraje;
        
        }
        public int getPuertas() {
        return puertas;
}

        public String getTransmision() {
        return transmision;
}        
        public double getPotenciaMotor() {
        return potenciamotor;
}       
        public String getCombustible() {
            
        return combustible;
}        
        public int getKilometraje() {
        return kilometraje;
}        
           
      
    }
    
       class Barco extends PracticaTransporte{
        private int calado; 
        private String nombre; 
        private double tonelaje; 
        private String tipo;
        private int autonomia; 
        
        public int getCalado() {
        return calado;
}

        public String getNombre() {
        return nombre;
}        
        public double getTonelaje() {
        return tonelaje;
}       
        public String getTipo() {
        return tipo;
}        
        public int getAutonomia() {
        return autonomia;
}        
        
        public Barco(String marca, int velocidad, int pasajeros, String color, String modelo, int calado, String nombre, double tonelaje, String tipo, int autonomia){
            super(marca, velocidad, pasajeros, color, modelo);
            this.calado = calado;
            this.nombre = nombre;
            this.tonelaje = tonelaje;
            this.tipo = tipo; 
            this.autonomia = autonomia;
  
        
            
        }
        
        
    }
       
