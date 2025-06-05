package models;

import net.datafaker.Faker;

public record Direccion(String direccion,
                        String ciudad,
                        String estado,
                        String pais,
                        String continente,
                        String codigoPostal,
                        Coordenadas coordenadas) {
    private static final Faker faker = new net.datafaker.Faker();

    public static Direccion generateRDireccion() {
        final var direccion = faker.address().streetAddress();
        final var ciudad = faker.address().city();
        final var estado = faker.address().state();
        final var pais = faker.address().country();
        final var continente = faker.address().state();
        final var codigoPostal = faker.address().zipCode();
        final var coordenadas = Coordenadas.randomCoordenadas();
        return new Direccion(direccion, ciudad, estado, pais, continente, codigoPostal, coordenadas);
    }
}
