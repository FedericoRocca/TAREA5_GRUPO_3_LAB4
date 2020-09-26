package dominio;

public class Persona
{
    private String nombre;
    private String apellido;
    private int dni;
    public Persona()
    {
        super();
    }
    public Persona(String nombre, String apellido, int dni)
    {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
    }
    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    /**
     * @return the apellido
     */
    public String getApellido()
    {
        return apellido;
    }
    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
    /**
     * @return the dni
     */
    public int getDni()
    {
        return dni;
    }
    /**
     * @param dni the dni to set
     */
    public void setDni(int dni)
    {
        this.dni = dni;
    }
}
