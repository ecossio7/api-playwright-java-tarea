package models;

public record RCoordenadas(double latitud, double longitud) {

    public static RCoordenadas randomCoordenadas() {
        final var faker = new net.datafaker.Faker();
        final var latitud = faker.number().randomDouble(6, -90, 90);
        final var longitud = faker.number().randomDouble(6, -180, 180);
        return new RCoordenadas(latitud, longitud);
    }
}
