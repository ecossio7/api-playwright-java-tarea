package models;

public record VideoJuego(int id,
                         String nombre,
                         int epoca,
                         Double precio,
                         int duracion,
                         String genero,
                         Empresa empresa) {
    public static VideoJuego generateVideoJuego() {
        final var faker = new net.datafaker.Faker();
        final var id = -1;
        final var nombre = faker.name().fullName();
        final var epoca = faker.number().numberBetween(1, 10);
        final var precio = faker.number().randomDouble(2, 10, 100);
        final var duracion = faker.number().numberBetween(1, 100);
        final var genero = faker.options().option("Acción", "Aventura", "RPG", "Deportes", "Estrategia");
        final var empresa = Empresa.generateREmpresa();
        return new VideoJuego(id, nombre, epoca, precio, duracion, genero, empresa);
    }
}
