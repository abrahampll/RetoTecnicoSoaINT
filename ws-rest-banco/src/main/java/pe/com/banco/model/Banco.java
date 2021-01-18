package pe.com.banco.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "banco")
public class Banco  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBanco;

	@Column(name = "nombre",  length = 100)
	private String nombre;
	
	@Column(name = "direccion", length = 100)
	private String direccion;
	
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	

	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name ="idbanco", referencedColumnName = "idBanco" )
	List<Sucursales> sucursales = new ArrayList<Sucursales>();

	
	
	
	
	
	public Banco(Integer idBanco, String nombre, String direccion, Date fechaRegistro) {
		this.idBanco = idBanco;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaRegistro = fechaRegistro;
	}
	public Banco() {
	}
	public int getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
	
	
	
}
