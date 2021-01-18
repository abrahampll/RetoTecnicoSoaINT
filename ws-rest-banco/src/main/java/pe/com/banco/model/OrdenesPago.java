package pe.com.banco.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ordenespago")
public class OrdenesPago  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonIgnore
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idOrdenPago;
	
	private int monto;
	
	private String moneda;
	private String estado;
	
	
	@Temporal(TemporalType.DATE)
	private Date fechaPago;
	
	
	@ManyToOne
	@JoinColumn(name="IdSucursal" ,referencedColumnName = "idSucursal")
	private Sucursales sucursale;

	
	

	public OrdenesPago(int idOrdenPago, int monto, String moneda, String estado, Date fechaPago, Sucursales sucursale) {
		this.idOrdenPago = idOrdenPago;
		this.monto = monto;
		this.moneda = moneda;
		this.estado = estado;
		this.fechaPago = fechaPago;
		this.sucursale = sucursale;
	}


	public OrdenesPago() {
	}


	
	


	public int getIdOrdenPago() {
		return idOrdenPago;
	}


	public void setIdOrdenPago(int idOrdenPago) {
		this.idOrdenPago = idOrdenPago;
	}


	public int getMonto() {
		return monto;
	}


	public void setMonto(int monto) {
		this.monto = monto;
	}


	public String getMoneda() {
		return moneda;
	}


	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaReg() {
		return fechaPago;
	}


	public void setFechaReg(Date fechaReg) {
		this.fechaPago = fechaReg;
	}


	public Sucursales getSucursale() {
		return sucursale;
	}


	public void setSucursale(Sucursales sucursale) {
		this.sucursale = sucursale;
	}


	
	
	
	

}
