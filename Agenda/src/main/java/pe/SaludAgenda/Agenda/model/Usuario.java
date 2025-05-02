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
@Table(name = "usuario")
public class Usuario {
    public enum Rol { PACIENTE, PROFECIONAL}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String contraseña;
    private String telefono;

    @Enumerated(EnumType.STRING)
    private Rol rol; // PACIENTE, PROFESIONAL

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;


}