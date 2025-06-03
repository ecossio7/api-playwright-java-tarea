package models;

public record RDireccion(String direccion,
                         String ciudad,
                         String pais,
                         String continente,
                         String codigoPostal,
                         RCoordenadas coordenadas) {
}
