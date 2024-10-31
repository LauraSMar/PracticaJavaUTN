package PracticaJava.PracticaJava.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direccion;
    private String localidad;

    // Relación bidireccional opcional
    @OneToMany(mappedBy = "destino")
    private List<Flete> fletes = new ArrayList<>();

    public Destino() {
    }

    public Destino(String direccion, String ciudad) {
        this.direccion = direccion;
        this.localidad = localidad;
    }


}

