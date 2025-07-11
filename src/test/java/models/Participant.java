package models;

public record Participant(int id,
                          String nombre,
                          String apellido,
                          String correo,
                          String usuario,
                          String clave,
                          Reaccion reaccion,
                          String plataforma) {
    public static Participant generateRParticipant() {
        final var faker = new net.datafaker.Faker();
        final var id = -1;
        final var nombre = faker.name().firstName();
        final var apellido = faker.name().lastName();
        final var correo = faker.internet().emailAddress();
        final var usuario = faker.name().firstName();
        final var clave = faker.internet().password();
        final var reaccion = Reaccion.generateRReaccion();
        final var plataforma = faker.options().option("PC", "PlayStation", "Xbox", "Nintendo Switch");

        return new Participant(id, nombre, apellido, correo, usuario, clave, reaccion, plataforma);
    }
}
