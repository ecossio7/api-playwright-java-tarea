package models;

public record Coordenadas(double latitud, double longitud) {

    public static Coordenadas randomCoordenadas() {
        final var faker = new net.datafaker.Faker();
        final var latitud = faker.number().randomDouble(6, -90, 90);
        final var longitud = faker.number().randomDouble(6, -180, 180);
        return new Coordenadas(latitud, longitud);
    }
}
