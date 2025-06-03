package models;

public record VideoJuego(int id,
                         String nombre,
                         int epoca,
                         Double precio,
                         int duracion,
                         String genero,
                         REmpresa empresa) {
}
