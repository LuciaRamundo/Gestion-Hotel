package ejercicio_integrador_gestion_hotel;

import java.time.LocalDate;
import java.util.ArrayList;


public class Hotel {

    //Atributos privados
    private String nombre;
    private String direccion;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Recepcionista> recepcionistas;
    private ArrayList<Reserva> reservasTotales;
    
    //Constructores
    public Hotel() {
        
        this.habitaciones = new ArrayList <> ();
        this.recepcionistas = new ArrayList <> ();
        this.reservasTotales = new ArrayList <> ();
    }
    
    public Hotel(String nombre, String direccion) {
        
        this();
        this.nombre = nombre;
        this.direccion = direccion;
    }

    //Métodos públicos
    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return new ArrayList (this.habitaciones);
    }

    public ArrayList<Recepcionista> getRecepcionistas() {
        return new ArrayList (this.recepcionistas);
    }

    public ArrayList<Reserva> getReservasTotales() {
        return new ArrayList (this.reservasTotales);
    }
    
    public void agregarHabitacion(Habitacion habitacion) {
        
        this.habitaciones.add(habitacion);
    }
    
    public void agregarRecepcionista(Recepcionista recepcionista) {
        
        this.recepcionistas.add(recepcionista);
    }
    
    public void agregarReserva(Reserva reserva) {
        
        this.reservasTotales.add(reserva);
    }
    
    public ArrayList <Habitacion> buscarHabitacionesDisponibles(LocalDate inicio, LocalDate fin, TipoHabitacion tipo) {
        
        // Creo un lista de habitaciones disponibles
        ArrayList <Habitacion> habitacionesDisponibles = new ArrayList <> ();
        
        // Recorre las habitaciones que tenemos y, deacuerdo a si están disponibles, las carga en el array o no
        for (Habitacion item : this.habitaciones) {
            
            // Checkea si la habitación está disponible
            if (this.estaHabitacionDisponible(item, inicio, fin)) {
                
                // Cargamos la habitacion en el nuevo array
                habitacionesDisponibles.add(item);
                
            }
        }
        
        return habitacionesDisponibles;
    }
    
    public boolean estaHabitacionDisponible(Habitacion habitacion, LocalDate inicio, LocalDate fin) {
        
        boolean disponibilidad = true;
        
        //Linea para probar el cambio en GitHub
        boolean a = true;
        
        // Recorro si la habitación está en la base de datos
        for (Reserva item : reservasTotales) {
            
            // Checkea si la habitación está en las reservas
            // Traigo la habitación (getHabitacion) y la comparo (equals)
            if (item.getHabitacion().equals(habitacion)) {
                LocalDate inicioReserva = item.getFechaInicio(); // 08/10
                LocalDate inicioSolicitud = inicio; // 19/10
                LocalDate finReserva = item.getFechaFin(); //10/10
                LocalDate finSolicitud = fin; // 25/10
                
               // isBefore -> Verifica si la fecha está antes que la fecha que le paso como parámetro
               // En este caso, verifica que la solicitud no venga despues que la reserva
               boolean solapados =! (finSolicitud.isBefore(inicioReserva) || inicioSolicitud.isAfter(finReserva));
                
               // Verifica que las fechas no choquen
                if (solapados) {
                    
                    disponibilidad = false;
                }
            }
        }
        return disponibilidad;
    }
    
    public Reserva buscarReservarPorCliente(Cliente cliente) {
        
        for (Reserva item : reservasTotales) {
            
            if (item.getCliente().equals(cliente)) { //Si son los mismos clientes
                
                return item;
            }
        }
        
        return null;
    }
    
    public ArrayList<Reserva> getReservasConfirmadas() {
        
        ArrayList<Reserva> reservas_confirmadas = new ArrayList <> ();
        
        for (Reserva item : this.getReservasTotales()) {
            
            if (item.isConfirmada()) {
                
                reservas_confirmadas.add(item);
            }
        }
        
        return reservas_confirmadas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hotel: ");
        sb.append("nombre: ").append(nombre);
        sb.append(", direccion: ").append(direccion);
        sb.append(", habitaciones: ").append(habitaciones);
        sb.append(", recepcionistas: ").append(recepcionistas);
        sb.append(", reservasTotales: ").append(reservasTotales);
        sb.append('}');
        return sb.toString();
    }
}
