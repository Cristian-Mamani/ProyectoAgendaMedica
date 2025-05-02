package pe.SaludAgenda.Agenda.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pago")
public class Pago {
    public enum EstadoPago{PAGADO, PENDIENTE}
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cita_id")
    private Cita cita;

    private Double monto;
    private String metodoPago;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    private LocalDateTime fechaPago;


}
