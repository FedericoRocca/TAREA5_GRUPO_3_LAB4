package negocio;

import java.util.List;

//import java.util.List;

import entidad.Persona;


public interface PersonaNegocio {
	
	public boolean insert(Persona persona);
	public boolean update(Persona persona);
	public List<Persona> readAll();
	
}