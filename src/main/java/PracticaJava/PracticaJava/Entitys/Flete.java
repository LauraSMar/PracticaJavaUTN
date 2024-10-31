package PracticaJava.PracticaJava.Entitys;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
public class Flete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String estado;
    private LocalDateTime init;
    private LocalDateTime end;
    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Destino destino;

    @ManyToOne
    @JoinColumn(name = "transporte_id")
    private Transporte transporte;

    public Flete(String descripcion, LocalDateTime init, LocalDateTime end, Destino destino, Transporte transporte, String estado) {
        this.descripcion=descripcion;
        this.init=init;
        this.end=end;
        this.destino=destino;
        this.transporte= transporte;
        this.estado = estado;

    }
}
