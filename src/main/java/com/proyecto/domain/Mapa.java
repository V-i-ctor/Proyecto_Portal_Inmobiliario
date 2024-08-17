
package com.proyecto.domain;

import lombok.Data;
import java.io.Serializable;
import jakarta.persistence.*;
    @Data
public class Mapa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mapa")
    private Long id;

    private double latitude;
    private double longitude;
    private int zoomLevel;
    private String mapType;

    public Mapa() {
    }

    public Mapa(double latitude, double longitude, int zoomLevel, String mapType) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.zoomLevel = zoomLevel;
        this.mapType = mapType;
    }

    // Método para actualizar la configuración del mapa
    public void updateMap(double latitude, double longitude, int zoomLevel, String mapType) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.zoomLevel = zoomLevel;
        this.mapType = mapType;
    }

    // Método para obtener la posición central del mapa
    public String getCenter() {
        return String.format("Lat: %f, Lng: %f", latitude, longitude);
    }

    // Método para obtener la configuración completa del mapa
    public String getMapDetails() {
        return String.format("Center: %s, Zoom Level: %d, Map Type: %s",
                getCenter(), zoomLevel, mapType);
    }
}
