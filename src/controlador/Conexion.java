package controlador;
import java.sql.*;
import java.util.ArrayList;
import modelo.Automovil;
import modelo.Cliente;

public class Conexion {
    private Connection connect;
    private Statement state;
    
public void conectar(){
    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/x_wing","root",null);
        state = connect.createStatement();
    }catch(Exception ex){
        ex.printStackTrace();
    }
}

public boolean insertarCliente(Cliente cliente){
    boolean insertar = false;
    try{
        conectar();
        state.executeUpdate("INSERT INTO cliente VALUES('"+cliente.getRut()+
                "','"+cliente.getNombre()+"',"+cliente.getTelefono()+",'"
                +cliente.getCorreo()+"','"+cliente.getDireccion()+
                "',"+cliente.getSexo()+","+cliente.getDias()+");");
        connect.close();
        insertar = true;
    }catch(Exception ex){
        ex.printStackTrace();
    }
return insertar;
}

public boolean insertarAutomovil(Automovil auto){
    boolean insertar = false;
    try{
        conectar();
        state.executeUpdate("INSERT INTO automovil VALUES('"+auto.getMarca()+
                "','"+auto.getPatente()+"','"+auto.getModelo()+"','"+auto.getColor()+"',"
                +auto.getValorDiaArriendo()+",'"+auto.getRutPropietario()+"');");
        connect.close();
        insertar = true;
    }catch(Exception ex){
        ex.printStackTrace();
    }
return insertar;
}

public int eliminar(String rut){
    int entero = 0;
    try{
        conectar();
        entero = state.executeUpdate("DELETE FROM cliente WHERE rut='"+rut+"';");
    }catch(Exception ex){
        ex.printStackTrace();
    }
    return entero;
}

public ArrayList<Automovil> getArreglo(ResultSet result) throws SQLException{
    Automovil auto = new Automovil();;
    ArrayList<Automovil> arreglo = new ArrayList();
                while(result.next()){
                    auto.setMarca((String)result.getObject(1));
                    auto.setPatente((String)result.getObject(2));
                    auto.setModelo((String)result.getObject(3));
                    auto.setColor((String)result.getObject(4));
                    auto.setValorDiaArriendo((Double)result.getObject(5));
                    auto.setRutCliente((String)result.getObject(6));
                    arreglo.add(auto);
                }
                return arreglo;

}

public ArrayList<Automovil> buscarAuto(String marca, String modelo, String color,String valorDiaArriendo){
    ArrayList<Automovil> arreglo = new ArrayList();
    int op = 0;
    if(marca != null){
        op=1;
    }
    if(modelo != null){
        op+=2;
    }
    if(color != null){
        op+=4;
    }
    if(valorDiaArriendo != null){
        op+=8;
    }
    switch(op){
        case 1:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE marca='"+marca+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 2:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE modelo='"+modelo+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 3:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE marca='"+marca+"' AND modelo='"+modelo+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 4:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE color='"+color+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 5:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE marca='"+marca+"' AND color='"+color+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 6:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE modelo='"+modelo+"' AND color='"+color+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 7:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE marca='"+marca+"' AND color='"+color+"' AND modelo='"+modelo+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 8:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE valorDiaArriendo='"+valorDiaArriendo+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 9:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE marca='"+marca+"' AND valorDiaArriendo='"+valorDiaArriendo+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 10:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE modelo='"+modelo+"' AND valorDiaArriendo='"+valorDiaArriendo+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 11:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE marca='"+marca+"' AND valorDiaArriendo='"+valorDiaArriendo+"' AND modelo='"+modelo+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 12:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE valorDiaArriendo='"+valorDiaArriendo+"' AND color='"+color+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 13:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE marca='"+marca+"' AND color='"+color+"' AND valorDiaArriendo='"+valorDiaArriendo+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 14:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE valorDiaArriendo='"+valorDiaArriendo+"' AND color='"+color+"' AND modelo='"+modelo+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
        case 15:
            try{
                conectar();    
                ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE marca='"+marca+"' AND color='"+color+"' AND modelo='"+modelo+"' AND valorDiaArriendo='"+valorDiaArriendo+"';");
                arreglo = getArreglo(result);
                return arreglo;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return arreglo;
    }
    return arreglo;
}

public Automovil buscarPatente(String patente){
    Automovil auto = new Automovil();
    try{
        conectar();    
        ResultSet result = state.executeQuery("SELECT * FROM automovil WHERE patente='"+patente+"';");
        while(result.next()){
            auto.setMarca((String)result.getObject(1));
            auto.setPatente((String)result.getObject(2));
            auto.setModelo((String)result.getObject(3));
            auto.setColor((String)result.getObject(4));
            auto.setValorDiaArriendo((Double)result.getObject(5));
            auto.setRutCliente((String)result.getObject(6));
        }
        return auto;
    }catch(Exception ex){
        ex.printStackTrace();
    }
    return auto;
}

public ArrayList buscarMarca(){
    ArrayList<String> marcas = new ArrayList();
    try{
        ResultSet result = state.executeQuery("SELECT marca FROM automovil;");
        while (result.next()){
            marcas.add((String)result.getObject(1));
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
    return marcas;
}

public int modificarCliente(Cliente cliente){
    int entero = 0;
    try{
        conectar();
        entero = state.executeUpdate("UPDATE cliente SET nombre='"
                +cliente.getNombre()+"', telefono="+cliente.getTelefono()+", correo='"
                +cliente.getCorreo()+"', direccion='"+cliente.getDireccion()+
                "', sexo="+cliente.getSexo()+", dias="+cliente.getDias()+
                "where rut='"+cliente.getRut()+"');");
        connect.close();
    }catch(Exception ex){
        ex.printStackTrace();
    }
    return entero;
}

public ArrayList<Automovil> listarAutos() throws SQLException{ 
        conectar();
        byte i = 0;
        ArrayList<Automovil> automovil = new ArrayList();
        ResultSet result = state.executeQuery("select * from automovil where rutCliente='"+null+"';");
        while(result.next()){
            Automovil auto = new Automovil();
            auto.setMarca((String)result.getObject(1));
            auto.setPatente((String)result.getObject(2));
            auto.setModelo((String)result.getObject(3));
            auto.setColor((String)result.getObject(4));
            auto.setValorDiaArriendo((Double)result.getObject(5));
            auto.setRutCliente((String)result.getObject(6));
            automovil.add(i, auto);
            i++;
        }
        return automovil;
}
}

/*



*/