package co.edu.unisabana.examplek8s;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioORM {

  @Id
  @Column
  private String cedula;
  @Column
  private String nombre;

  @Column
  private String direccion;
}
