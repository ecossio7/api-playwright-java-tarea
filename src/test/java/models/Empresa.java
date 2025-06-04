package models;

public record Empresa(String nombre,
                      String paginaWeb,
                      String mision,
                      Direccion direccion) {
    public static Empresa generateREmpresa() {
        final var faker = new net.datafaker.Faker();
        final var nombre = faker.company().name();
        final var paginaWeb = faker.internet().domainName();
        final var mision = faker.lorem().sentence();
        final var direccion = Direccion.generateRDireccion();
        return new Empresa(nombre, paginaWeb, mision, direccion);
    }
}
