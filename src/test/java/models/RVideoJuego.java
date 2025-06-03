package models;

public record RVideoJuego(int id,
                          String nombre,
                          int epoca,
                          Double precio,
                          int duracion,
                          String genero,
                          REmpresa empresa) {
    public static RVideoJuego generateVideoJuego() {
        final var faker = new net.datafaker.Faker();
        final var id = -1;
        final var nombre = faker.name().fullName();
        final var epoca = faker.number().numberBetween(1, 10);
        final var precio = faker.number().randomDouble(2, 10, 100);
        final var duracion = faker.number().numberBetween(1, 100);
        final var genero = faker.options().option("Acción", "Aventura", "RPG", "Deportes", "Estrategia");
        final var empresa = REmpresa.generateREmpresa();
        return new RVideoJuego(id, nombre, epoca, precio, duracion, genero, empresa);
    }
}
