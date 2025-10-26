package ejercicio_integrador_gestion_hotel;


public class Habitacion {

    //Atributos privados
    private int numero;
    private TipoHabitacion tipo;
    private double precioPorNoche;
    
    //Constructor
    public Habitacion(int numero, TipoHabitacion tipo, double precioPorNoche) {
        
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
    }

    //Métodos públicos
    public int getNumero() {
        return this.numero;
    }

    public TipoHabitacion getTipo() {
        return this.tipo;
    }

    public double getPrecioPorNoche() {
        return this.precioPorNoche;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) { // Comparo YO con YO (compara misma direccion de memoria). Apuntan al mismo lugar
            
            return true;
        } else if  (obj == null || this.getClass() != obj.getClass()) { // Comparo si son la misma clase (tienen el mismo nombre)
            
            return false;
        }
        
        Habitacion habitacion = (Habitacion) obj; // Casteo para ver tipo y numero de obj
        
        return this.tipo == habitacion.tipo && this.numero == habitacion.numero;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Habitacion: ");
        sb.append("numero: ").append(numero);
        sb.append(", tipo: ").append(tipo);
        sb.append(", precioPorNoche: ").append(precioPorNoche);
        sb.append('}');
        return sb.toString();
    }
}
