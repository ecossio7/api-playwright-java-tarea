package models;

public record RReaccion(int likes, int dislikes) {
    public static RReaccion generateRReaccion() {
        final var faker = new net.datafaker.Faker();
        final var likes = faker.number().numberBetween(0, 1000);
        final var dislikes = faker.number().numberBetween(0, 1000);
        return new RReaccion(likes, dislikes);
    }
}
