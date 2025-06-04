package models;

public record Direccion(String direccion,
                        String ciudad,
                        String estado,
                        String pais,
                        String continente,
                        String codigoPostal,
                        Coordenadas coordenadas) {
    public static Direccion generateRDireccion() {
        final var faker = new net.datafaker.Faker();
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
