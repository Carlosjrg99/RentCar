package modelo;


public class Automovil {
    String marca, patente, modelo, color, rutPropietario;
    double valorDiaArriendo;
    
    public Automovil(){
        marca = null;
        patente = null;
        modelo = null;
        color = null;
        valorDiaArriendo = 0;
        rutPropietario = null;
    }

    public Automovil(String marca, String patente, String modelo, String color, double valorDiaArriendo, String rutPropietario) {
        this.marca = marca;
        this.patente = patente;
        this.modelo = modelo;
        this.color = color;
        this.valorDiaArriendo = valorDiaArriendo;
        this.rutPropietario = rutPropietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getValorDiaArriendo() {
        return valorDiaArriendo;
    }

    public void setValorDiaArriendo(double valorDiaArriendo) {
        this.valorDiaArriendo = valorDiaArriendo;
    }

    public String getRutPropietario() {
        return rutPropietario;
    }

    public void setRutCliente(String rutPropietario) {
        this.rutPropietario = rutPropietario;
    }

    @Override
    public String toString() {
        if(rutPropietario == null)
            return "Marca: "+marca+"\nPatente: "+patente+"\nModelo: "+modelo
                    +"\nColor: "+color+"\nValor por día de Arriendo: "
                    +Double.toString(valorDiaArriendo)+"\n\nAuto Disponible";
        else
            return "Marca: "+marca+"\nPatente: "+patente+"\nModelo: "+modelo
                    +"\nColor: "+color+"\nValor por día de Arriendo: "
                    +Double.toString(valorDiaArriendo)+"\nRut del propietario: "
                    +rutPropietario;
    }
}
