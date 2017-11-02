
package dimensiones_de_pieza;





public class Pieza {
    
    
    private String filas;
    private String columnas;

    public Pieza(){};

    public Pieza(String filas, String columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public String getFilas() {
        return filas;
    }

    public void setFilas(String filas) {
        this.filas = filas;
    }

    public String getColumnas() {
        return columnas;
    }

    public void setColumnas(String columnas) {
        this.columnas = columnas;
    }
    
    public int transformarFilasDeStringANumero(){
        int ancho=Integer.parseInt(filas);
        return ancho;
    }
    
    public int transformarColumnasDeStringANumero(){
        int alto=Integer.parseInt(columnas);
        return alto;
    }
    
    


    
    

    
    
}
