package com.mohamedsctraore.spatial.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author Mohamed Traore
 */
@Entity
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Marker> markers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Marker> getMarkers() {
        return markers;
    }

    public void setMarkers(List<Marker> markers) {
        this.markers = markers;
    }

    public void addMarker(Marker marker) {
        this.markers.add(marker);
    }

    public void removeMarker(Marker marker) {
        this.markers.remove(marker);
    }
}
