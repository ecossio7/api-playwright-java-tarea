package models;

public record Reaccion(int likes, int dislikes) {
    public static Reaccion generateRReaccion() {
        final var faker = new net.datafaker.Faker();
        final var likes = faker.number().numberBetween(0, 1000);
        final var dislikes = faker.number().numberBetween(0, 1000);
        return new Reaccion(likes, dislikes);
    }
}
