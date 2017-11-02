
package elementos_de_pieza;

//clase Raton
public class Raton {
    
    private String  Coordenadas_del_raton;
    
    public Raton(){};

    public Raton(String Coordenadas_del_raton) {
        this.Coordenadas_del_raton = Coordenadas_del_raton;
    }

    public String getCoordenadas_del_raton() {
        return Coordenadas_del_raton;
    }

    public void setCoordenadas_del_raton(String Coordenadas_del_raton) {
        this.Coordenadas_del_raton = Coordenadas_del_raton;
    }

    public int obtenerFilaCoordenadas_del_Raton(){
        String[]filaYcolumna = getCoordenadas_del_raton().split(",");//Mr. Rivas, favor recordar que un metodo que tenga aunque sea un caracter cambiado (inclusive mayuscula o minuscula), no es igual a otro que se llame igual pero esta escrito distinto. Atte. el unico uruguayo del instituto.
        String fila=filaYcolumna[0];
        String columna=filaYcolumna[1];
        
        int filaRaton=Integer.parseInt(fila)+1;
        
        return filaRaton;
        
    }
    
    public int obtenerColumnaCoordenadas_del_Raton(){
        String[]filaYcolumna = getCoordenadas_del_raton().split(",");
        String fila=filaYcolumna[0];
        String columna=filaYcolumna[1];
        
        int columnaRaton=Integer.parseInt(columna)+1;
        
        return columnaRaton;
    
    
    
    
}
}   



