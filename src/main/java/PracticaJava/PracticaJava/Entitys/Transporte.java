package PracticaJava.PracticaJava.Entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
    @Data
    @Entity
    public class Transporte {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private String tipo;

        @OneToMany(mappedBy = "transporte")
        private List<Flete> fletes = new ArrayList<>();

        public Transporte() {
        }

        public Transporte(String nombre, String tipo) {
            this.nombre = nombre;
            this.tipo = tipo;
        }


    }


