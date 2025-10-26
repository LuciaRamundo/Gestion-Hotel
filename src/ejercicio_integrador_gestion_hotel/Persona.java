package ejercicio_integrador_gestion_hotel;

import java.util.ArrayList;


public abstract class Persona {
    
    //Atributos privados
    private String nombre;
    private String dni;
    private ArrayList<String> notificaciones;
    
    //Constructores
    public Persona() {
        
        this.notificaciones = new ArrayList<> ();
    }
    
    public Persona(String nombre, String dni) {
        
        //Invoca al constructor que no tiene parámetro
        this(); // Le damos valor a la lista
        
        this.nombre = nombre;
        this.dni = dni;
    }
    
    //Método abstracto
    public abstract void notificar(String notificacion);

    //Métodos
    public String getNombre() {
        return this.nombre;
    }

    public String getDni() {
        return this.dni;
    }
    
    /*
    public ArrayList<String> getNotificaciones() {
        return this.notificaciones; // Devolvemos la direccion de memoria de este array
    */

    public ArrayList<String> getNotificaciones() {
        // Hacemos una copia del array y devolvemos la copia. Nueva direccion de memoria con los mismos datos
        return new ArrayList <String> (this.notificaciones); // Forma recomendable de devolver la lista
    }
    
    protected void agregarNotificacion(String mensaje) {
        
        this.notificaciones.add(mensaje);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona: ");
        sb.append("nombre: ").append(nombre);
        sb.append(", dni: ").append(dni);
        // Recorre las notoficaciones
        for (String item : notificaciones) {
            
            sb.append("Notificacion ").append(item);
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {  // Comparo YO con YO
            
            return true;
        } else if  (obj == null || this.getClass() != obj.getClass()) { // Comparo si son la misma clase
            
            return false;
        }
        
        Persona otra_persona = (Persona) obj;
        
        return this.dni == otra_persona.dni && this.nombre == otra_persona.nombre;
    }
    

}
