package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.sun.jndi.cosnaming.CNCtx;

public class PersonaDao
{
    private String host =     "jdbc:mysql://localhost:3306/";
    private String usr =      "root";
    private String pass =     "root";
    private String dbName =   "bdpersonas";
    
    public PersonaDao()
    {
        
    }
    
    public int crearPersona( Persona _persona )
    {
        String statementToExecute = "INSERT INTO `bdpersonas`.`personas`(`Dni`,`Nombre`,`Apellido`)"
                + "VALUES(" + _persona.getDni() + ", '" + _persona.getNombre() + "', '" + _persona.getApellido() + "');";
        
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(host + dbName, usr, pass);
            Statement statement = conn.createStatement();
            return statement.executeUpdate(statementToExecute);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
}
