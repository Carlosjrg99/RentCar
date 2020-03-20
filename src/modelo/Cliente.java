package modelo;


public class Cliente{
    String rut, nombre, correo, direccion;
    int telefono, dias;
    boolean sexo;
    
    public Cliente() {
        rut = null;
        nombre = null;
        telefono = 0;
        correo = null;
        direccion = null;
        sexo = false;
        dias = 0;
    }

    public Cliente(String rut, String nombre, int telefono, String correo, String direccion, boolean sexo, int dias) {
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.sexo = sexo;
        this.dias = dias;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
    String auxSexo;
            if(sexo)
                auxSexo = "masculino";
            else if(!sexo && rut != null)
                auxSexo = "femenino";
            else auxSexo = "No especificado";
            return "Rut: "+rut+"\nNombre: "+nombre+"\nTeléfono:"+telefono+
                "\nCorreo: "+correo+"\nDirección: "+direccion+
                "\nSexo: "+auxSexo+"\nNúmero de días de arriendo: "+dias;        
    }
}
