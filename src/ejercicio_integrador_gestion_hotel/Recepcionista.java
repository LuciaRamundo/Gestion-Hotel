package ejercicio_integrador_gestion_hotel;

import java.util.ArrayList;


public class Recepcionista extends Persona{
    
    //Atributo privado
    private String legajo;
    
    //Constructor
    public Recepcionista(String nombre, String dni, String legajo) {
        super(nombre, dni);
        this.legajo = legajo;
    }

    //Métodos públicos
    public String getLegajo() {
        return this.legajo;
    }
    
    public void confirmarReserva(Reserva reserva) {
        
        if (reserva == null) {
            
            System.out.println("La reserva es nula");
            return;
        }
        
        if (reserva.isConfirmada()) {
            
            System.out.println("Reserva confirmada");
            return;
        } else {
            
            reserva.confirmar();
            Cliente cliente = reserva.getCliente();
            int numero_habitacion = reserva.getHabitacion().getNumero();
            String notificacion = "Reseva confirmada por el cliente: " + cliente.getNombre() + " " + "para la habitacion" 
                    + numero_habitacion + " " + "con un precio total de: " + reserva.calcularTotal();
            cliente.notificar(notificacion);
        }
        
    }
    
    @Override
    public void notificar(String notificacion) {
        
        String mensaje = "Legajo Nro: " + this.legajo + " " + " Sr " + super.getNombre() + " : " + notificacion;
        super.agregarNotificacion(mensaje);
    }

}
