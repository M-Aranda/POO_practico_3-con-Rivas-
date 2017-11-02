
package elementos_de_pieza;

//clase Gato


public class Gato {
    
    private String coordenadas_del_gato;
    
    public Gato(){};

    public Gato(String coordenadas_del_gato) {
        this.coordenadas_del_gato = coordenadas_del_gato;
    }

    public String getCoordenadas_del_gato() {
        return coordenadas_del_gato;
    }

    public void setCoordenadas_del_gato(String coordenadas_del_gato) {
        this.coordenadas_del_gato = coordenadas_del_gato;
    }
    
    public int obtenerFilaCoordenadas_del_gato(){
        String[]filaYcolumna=getCoordenadas_del_gato().split(",");
        String fila=filaYcolumna[0];
        String columna=filaYcolumna[1];
        
        int filaGato=Integer.parseInt(fila)+1;
        
        return filaGato;
        
   
        
        
    }
    
    public int obtenerColumnaCoordenadas_del_gato(){
        String[]filaYcolumna=getCoordenadas_del_gato().split(",");
        String fila=filaYcolumna[0];
        String columna=filaYcolumna[1];
        
        int columnaGato=Integer.parseInt(columna)+1;
        
        return columnaGato;
    }
    
    


    


    
    
}
