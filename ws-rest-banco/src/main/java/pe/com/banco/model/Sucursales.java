package pe.com.banco.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sucursales")
public class Sucursales implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSucursal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idBanco", nullable = false,referencedColumnName = "idBanco")
	private Banco banco;
	
	@Column(name = "nombre", precision = 40)
	private String nombre;
	
	@Column(name = "direccion", precision = 40)
	private String direccion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaRegistro", precision = 10)
	private Date fechaReg;

	@OneToMany( cascade = { CascadeType.ALL }, mappedBy = "idOrdenPago")
	private Set<OrdenesPago> ordenesPago = new HashSet<OrdenesPago>();

	public Sucursales() {
	}

	public Integer getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
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

	
	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

}
