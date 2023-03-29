package modelo;

import java.sql.Date;

public class Asignacion {
	private Integer id_asignacion;
	private Date fecha_partida;
	private String hora_salida;
	private Integer nro_butacas;
	private Integer nro_colectivo;
	private Integer disponibilidad_pasajes;

	public Asignacion(Integer id_asignacion, Date fecha_partida, String hora_salida, Integer nro_colectivo, Integer nro_butacas,
			Integer disponibilidad_pasajes) {
		super();
		this.id_asignacion = id_asignacion;
		this.fecha_partida = fecha_partida;
		this.hora_salida = hora_salida;
		this.nro_colectivo = nro_colectivo;
		this.nro_butacas = nro_butacas;
		this.disponibilidad_pasajes = disponibilidad_pasajes;
	}

	public Integer getId_asignacion() {
		return id_asignacion;
	}

	public void setId_asignacion(Integer id_asignacion) {
		this.id_asignacion = id_asignacion;
	}

	public Date getFecha_partida() {
		return fecha_partida;
	}

	public void setFecha_partida(Date fecha_partida) {
		this.fecha_partida = fecha_partida;
	}

	public Integer getNro_butacas() {
		return nro_butacas;
	}

	public void setNro_butacas(Integer nro_butacas) {
		this.nro_butacas = nro_butacas;
	}

	public Integer getDisponibilidad_pasajes() {
		return disponibilidad_pasajes;
	}

	public void setDisponibilidad_pasajes(Integer disponibilidad_pasajes) {
		this.disponibilidad_pasajes = disponibilidad_pasajes;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	public Integer getNro_colectivo() {
		return nro_colectivo;
	}

	public void setNro_colectivo(Integer nro_colectivo) {
		this.nro_colectivo = nro_colectivo;
	}

	@Override
	public String toString() {
		return id_asignacion+ "-" + " Partida: " + fecha_partida +" " + hora_salida + " Butacas: " + nro_butacas + " Colectivo: " + nro_colectivo;
	}
	
	
	
}
