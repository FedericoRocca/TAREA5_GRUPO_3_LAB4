package negociolmpl;

import java.util.List;

import dao.PersonaDao;
import daolmpl.PersonaDaolmpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegociolmpl implements PersonaNegocio {
	
	PersonaDao pdao = new PersonaDaolmpl();
	
	@Override
	public boolean insert(Persona persona) {
		boolean estado=false;
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0 && persona.getDni().trim().length()>0)
		{
			estado=pdao.insert(persona);
		}
		return estado;
	}
	
	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
	}

	@Override
	public boolean update(Persona persona) {
		return pdao.update(persona);
	}
	
	@Override
	public boolean delete(String dni) {
		return pdao.delete(dni);
	}
}
