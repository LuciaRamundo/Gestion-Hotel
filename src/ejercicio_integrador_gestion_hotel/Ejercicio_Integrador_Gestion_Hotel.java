package ejercicio_integrador_gestion_hotel;

import java.time.LocalDate;
import java.time.Month;

public class Ejercicio_Integrador_Gestion_Hotel {

    public static void main(String[] args) {
      
      Hotel h1 = new Hotel("Bella Vista", "Bolivia 77");
      Habitacion hab1 = new Habitacion(200, TipoHabitacion.SIMPLE, 100);
      Habitacion hab2 = new Habitacion(500, TipoHabitacion.DOBLE, 100);
      h1.agregarHabitacion(hab1);
      h1.agregarHabitacion(hab2);
      Recepcionista r1 = new Recepcionista("Agustin", "12345678", "154");
      Recepcionista r2 = new Recepcionista("Roberto", "14785233", "155");
      h1.agregarRecepcionista(r1);
      h1.agregarRecepcionista(r2);
      Cliente c1 = new Cliente("Luis", "88888888", "aaa@gmail.com");
      Cliente c2 = new Cliente("Lopez", "77777777", "bbb@gmail.com");
      Cliente c3 = new Cliente("Perez", "99999999", "ccc@gmail.com");
      // Cliente c4 = new Cliente("Diaz", "55555555", "ddd@gmail.com");
      
      
       System.out.println("------- ESCENARIO 1 -------");
       
      LocalDate fecha_inicio = LocalDate.of(2025, 10, 8);
      LocalDate fecha_final = LocalDate.of(2025, 10, 10);
      c1.realizarReserva(h1, hab1, fecha_inicio, fecha_final);
      r1.confirmarReserva(h1.buscarReservarPorCliente(c1));
      
      System.out.println("------- ESCENARIO 2 -------");
      
      LocalDate fecha_inicio_2 = LocalDate.of(2025, 10, 19);
      LocalDate fecha_final_2 = LocalDate.of(2025, 10, 25);
      c2.realizarReserva(h1, hab1, fecha_inicio_2, fecha_final_2);
      r2.confirmarReserva(h1.buscarReservarPorCliente(c2));
      
      System.out.println("------- ESCENARIO 3 -------");
      
      LocalDate fecha_inicio_3 = LocalDate.of(2025, Month.OCTOBER, 24);
      LocalDate fecha_final_3 = LocalDate.of(2025, Month.OCTOBER, 26);
      c3.realizarReserva(h1, hab1, fecha_inicio_3, fecha_final_3);
      r1.confirmarReserva(h1.buscarReservarPorCliente(c3));
      
        System.out.println("------- NOTIFICACIONES CLIENTE -------");
        
        for (String item : c1.getNotificaciones()) {
            
            System.out.println(item);
        }
        
        System.out.println("------- NOTIFICACIONES RECEPCIONISTA -------");
        
        for (Recepcionista item : h1.getRecepcionistas()) {
            for (String notificacion : item.getNotificaciones()) {
                
                System.out.println(notificacion);
            }
        }
        
         System.out.println("------- RESERVAS CONFIRMADAS -------");
         
         for (Reserva item : h1.getReservasConfirmadas()) {
            
             System.out.println(item);
        }
    }

}
