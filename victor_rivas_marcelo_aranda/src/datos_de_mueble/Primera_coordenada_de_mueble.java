
package datos_de_mueble;


public class Primera_coordenada_de_mueble {
    
    
    private String p_coor;
    
    public Primera_coordenada_de_mueble(){};

    public Primera_coordenada_de_mueble(String p_coor) {
        this.p_coor = p_coor;
    }

    public String getP_coor() {
        return p_coor;
    }

    public void setP_coor(String p_coor) {
        this.p_coor = p_coor;
    }
    
    public int obtenerPrimeraFila(){
        String[]filaYcolumna=getP_coor().split(",");
        String fila=filaYcolumna[0];
        String columna=filaYcolumna[1];
        
        int primeraFila=Integer.parseInt(fila);
        return primeraFila;
        
        
    }
    
        public int obtenerPrimeraColumna(){
        String[]filaYcolumna=getP_coor().split(",");
        String fila=filaYcolumna[0];
        String columna=filaYcolumna[1];
        
        int primeraColumna=Integer.parseInt(columna);
        return primeraColumna;
        
        
    }
    
}
