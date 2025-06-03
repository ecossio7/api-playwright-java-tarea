package models;

public record REmpresa(String nombre,
                       String paginaWeb,
                       String mision,
                       RDireccion direccion) {
    public static REmpresa generateREmpresa() {
        final var faker = new net.datafaker.Faker();
        final var nombre = faker.company().name();
        final var paginaWeb = faker.internet().domainName();
        final var mision = faker.lorem().sentence();
        final var direccion = RDireccion.generateRDireccion();
        return new REmpresa(nombre, paginaWeb, mision, direccion);
    }
}
