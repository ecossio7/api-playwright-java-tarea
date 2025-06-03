package models;

public record RParticipant(int id,
                           String nombre,
                           String apellido,
                           String correo,
                           String usuario,
                           String clave,
                           RReaccion reaccion,
                           String plataforma) {
}
