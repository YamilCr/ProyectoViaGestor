package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasedeDatos {
	
	   private static BasedeDatos bd = null;
		private Connection conexion;
	   private String url= "jdbc:postgresql://localhost:5432/";
	   private String nombreBD = "VG";
	   private String usuario="postgres";
	   private String clave="poo2021";
	   
	   private BasedeDatos() {
			try {
				DriverManager.registerDriver(new org.postgresql.Driver());
				this.setConexion(DriverManager.getConnection(url + nombreBD, usuario, clave));
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		public static BasedeDatos getInstance() {
			return (bd == null) ? new BasedeDatos() : bd;
		}

		public ResultSet getAll(String consulta) {
			ResultSet rs = null;

			try {
				Statement s = getConexion().createStatement();
				rs = s.executeQuery(consulta);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
		}

		public Integer add(String tabla, String columnas, String valores, String id) {
			try {
				PreparedStatement ps = getConexion().prepareStatement(
						"INSERT INTO public." + tabla + " (" + columnas + " ) VALUES (" + valores + ") returning "+ id +";");

				if (ps.execute()) {
					ResultSet rs = ps.getResultSet();
					rs.next();
					return rs.getInt(1);
				} else {
					Integer entero = ps.getUpdateCount();
					System.out.println("Devuelve por getUpdateCount " + entero + ".");
				}
				return -1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;

		}

		public Boolean update(String tabla, Integer id, String valores, String nombre_id) {
			
			try {
				PreparedStatement ps = getConexion()
						
						.prepareStatement("UPDATE public." + tabla + " SET " + valores + " WHERE "+nombre_id +"='" + id + "';");
				ps.execute();
				Integer entero = ps.getUpdateCount();
				return entero > 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

		public Boolean remove(String tabla, Integer id, String nombre_id) {
			try {
				Statement st = getConexion().createStatement();
				Integer entero = st.executeUpdate("DELETE FROM public." + tabla + " WHERE "+ nombre_id+ "= " + id);
				return entero > 0;
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return false;
		}

		public Connection getConexion() {
			return conexion;
		}

		private void setConexion(Connection conexion) {
			this.conexion = conexion;
		}
}
