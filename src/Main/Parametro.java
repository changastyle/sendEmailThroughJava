package Main;

public class Parametro
{
    public String nombre;
    public String valor;

    public Parametro()
    {
    }
    
    public Parametro(String nombre, String valor)
    {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getValor()
    {
        return valor;
    }

    public void setValor(String valor)
    {
        this.valor = valor;
    }

    @Override
    public String toString()
    {
        return "Parametro{" + "nombre=" + nombre + ", valor=" + valor + '}';
    }
}
