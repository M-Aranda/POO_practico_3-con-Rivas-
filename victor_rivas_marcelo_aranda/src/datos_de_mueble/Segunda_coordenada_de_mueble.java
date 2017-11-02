
package datos_de_mueble;


public class Segunda_coordenada_de_mueble {
    
    private String s_coor;
    
    public Segunda_coordenada_de_mueble(){};

    public Segunda_coordenada_de_mueble(String s_coor) {
        this.s_coor = s_coor;
    }

    public String getS_coor() {
        return s_coor;
    }

    public void setS_coor(String s_coor) {
        this.s_coor = s_coor;
    }
    
    public int ObtenerSegundaFila(){
        String[]filaYcolumna=getS_coor().split(",");
        String fila=filaYcolumna[0];
        String columna=filaYcolumna[1];
        
        int segundaFila=Integer.parseInt(fila);
        return segundaFila;
    }
    
    public int ObtenerSegundaColumna(){
        String[]filaYcolumna=getS_coor().split(",");
        String fila=filaYcolumna[0];
        String columna=filaYcolumna[1]; 
        
        int segundaColumna=Integer.parseInt(columna);
        return segundaColumna;
    }
    
}
