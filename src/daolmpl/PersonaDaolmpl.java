package daolmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaolmpl implements PersonaDao
{
	private static final String insert = "INSERT INTO personas(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String readall = "SELECT * FROM personas";
	private static final String update = "UPDATE personas SET dni=?,nombre=?,apellido=? WHERE dni=?"; 
		
	public boolean insert(Persona persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getDni() );
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return isInsertExitoso;
	}
	
	public static ResultSet getTabla(String Consulta) {

	Connection conexion = Conexion.getConexion().getSQLConexion();
	Statement st;
	ResultSet datos=null;
	try {

		st=conexion.createStatement();
		datos=st.executeQuery(Consulta);

	}catch(Exception e){System.out.print(e.toString());}

	return datos;
	}
	
	public List<Persona> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				
				personas.add(getPersona(resultSet));
			
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	return personas;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		String dni = resultSet.getString("DNI");
		return new Persona(dni, nombre, apellido);
	}
	
	public boolean update(Persona persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			statement.setString(4, persona.getDni());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isUpdateExitoso = true;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}		
		return isUpdateExitoso;
	}
	
}
