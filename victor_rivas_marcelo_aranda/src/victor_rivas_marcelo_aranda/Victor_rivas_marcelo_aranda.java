package victor_rivas_marcelo_aranda;

import dimensiones_de_pieza.Pieza;
import elementos_de_pieza.Gato;
import elementos_de_pieza.Raton;
import datos_de_mueble.Primera_coordenada_de_mueble;
import datos_de_mueble.Segunda_coordenada_de_mueble;

import java.util.Scanner;

public class Victor_rivas_marcelo_aranda {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("----------------------------------");
        System.out.println("Bienvenido al creador de planos");
        System.out.println("----------------------------------");
        System.out.println("Regla: todo lo que sea coordenada");
        System.out.println("se debe ingresar separado por una");
        System.out.println("coma. EJ: 1,4 ");
        System.out.println("----------------------------------");

        int MAXIMO = 20;// variable "MAXIMO" para regular el alto y ancho de la pieza


        int ancho_de_matriz;
        int alto_de_matriz;

        while (true) {
            try {
                System.out.print("Ingrese ancho y alto de la pieza: ");
                String dimension = input.nextLine();

                String[] valores = dimension.split(",");
                String filas = valores[0];
                String columnas = valores[1];

                Pieza p = new Pieza(filas, columnas);
                ancho_de_matriz = (p.transformarFilasDeStringANumero()) + 1;
                alto_de_matriz = (p.transformarColumnasDeStringANumero()) + 1;

                if (((ancho_de_matriz - 1) <= MAXIMO) && ((alto_de_matriz - 1) <= MAXIMO) && ((ancho_de_matriz - 1) > 0) && ((alto_de_matriz - 1) > 0)) {
                    break;

                } else if (((ancho_de_matriz - 1) > MAXIMO) || ((alto_de_matriz - 1) > MAXIMO)) {
                    System.out.println("Ni el el alto, ni el ancho pueden ser mayores a 20");

                } else if (((ancho_de_matriz - 1) < 0) || ((alto_de_matriz - 1) < 0)) {
                    System.out.println("No puede ingresar numeros negativos");
                }

            } catch (Exception e) {
                System.out.println("\033[31m{ERROR} Ingrese 2 numeros separados por una coma");

            }

        }

        String[][] pieza = new String[ancho_de_matriz][alto_de_matriz];
        /*
        Linea 62 crea una matriz aumentada en 1 (la fila y la columna extra se 
        usan para colocarle el numero del indice correspondiente a cada fila y columna)
         */

        //ciclo para rellenar con " - "
        for (int i = 0; i < +ancho_de_matriz; i++) {
            for (int j = 0; j < alto_de_matriz; j++) {
                pieza[i][j] = " - ";

            }

        }

        //lineas 52 a 70 son para poner los numeros al lado
        for (int i = 0; i < alto_de_matriz; i++) {
            if (i <= 10) {
                pieza[0][i] = " 0" + (i - 1);
            } else if (i >= 11) {
                pieza[0][i] = " " + (i - 1);
            }
        }

        for (int i = 0; i < ancho_de_matriz; i++) {
            if (i <= 10) {
                pieza[i][0] = " 0" + (i - 1);

            } else if (i >= 11) {
                pieza[i][0] = " " + (i - 1);
            }
        }

        pieza[0][0] = " fc";

        //ciclo para mostrar tabla actual (97 a 114)
        for (int i = 0; i < alto_de_matriz; i++) {
            System.out.printf("---");

        }
        System.out.println("");
        for (int j = 0; j < ancho_de_matriz; j++) {
            for (int k = 0; k < alto_de_matriz; k++) {
                System.out.print(pieza[j][k]);
            }
            System.out.println();

        }
        for (int i = 0; i < alto_de_matriz; i++) {
            System.out.printf("---");

        }

        System.out.println();

        int area = (alto_de_matriz - 1) * (ancho_de_matriz - 1);//linea para calcular el area
        int PORCENTAJE_GATOS = 10;//
        int PORCENTAJE_RATONES = 25;

        int maximo_de_gatos = (area * PORCENTAJE_GATOS) / 100;//maximo de gatos redondeado hacia abajo
        int maximo_de_ratones = (area * PORCENTAJE_RATONES) / 100;//maximo de ratones redondeado hacia abajo

        System.out.println("Solo puede ingresar [" + maximo_de_gatos + "] gatos como maximo");

        Scanner tomarCantGatos = new Scanner(System.in);

        int cantGatos;

        while (true) {
            try {

                System.out.print("Cantidad de gatos: ");
                cantGatos = Integer.parseInt(input.nextLine());

                if (cantGatos >= 0 && cantGatos <= maximo_de_gatos) {
                    break;
                } else if (cantGatos < 0) {
                    System.out.println("No puede ingresar una cantidad negativa");
                } else if (cantGatos > maximo_de_gatos) {
                    System.out.println("La cantidad de gatos no puede superar la cantidad maxima de gatos (" + maximo_de_gatos + ")");
                }

            } catch (Exception e) {
                System.out.println("{ERROR} Ingrese un numero entero");

            }
        }

        for (int i = 0; i < cantGatos; i++) {

            for (int j = 0; j < alto_de_matriz; j++) {
                System.out.printf("---");

            }
            System.out.println("");
            for (int j = 0; j < ancho_de_matriz; j++) {
                for (int k = 0; k < alto_de_matriz; k++) {
                    System.out.print(pieza[j][k]);
                }
                System.out.println();

            }
            for (int k = 0; k < alto_de_matriz; k++) {
                System.out.printf("---");

            }

            while (true) {
                try {
                    System.out.println();
                    System.out.println("-------");
                    System.out.println("GATO Nº " + (i + 1) + ":");
                    System.out.println("-------");
                    System.out.print("Ingrese fila y columna: ");

                    Scanner leerG = new Scanner(System.in);
                    String coorG = leerG.nextLine();
                    Gato g = new Gato(coorG);
                    int fg = g.obtenerFilaCoordenadas_del_gato();
                    int cg = g.obtenerColumnaCoordenadas_del_gato();


                    if ((pieza[fg][cg] = " - ") == (pieza[fg][cg] = " - ")) {
                        pieza[g.obtenerFilaCoordenadas_del_gato()][g.obtenerColumnaCoordenadas_del_gato()] = " G ";

                        break;

                    } else if ((pieza[fg][cg] = " G ") == (pieza[fg][cg] = " G ")) {
                        System.out.println("Ya hay algo en esa posicion (" + (fg - 1) + "," + (cg - 1) + " G )");
                        pieza[fg][cg] = " - ";
                    } else if ((pieza[fg][cg] = " G ") == (pieza[fg][cg] = " R ")) {
                        System.out.println("Ya hay algo en esa posicion (" + (fg - 1) + "," + (cg - 1) + " R )");
                        pieza[fg][cg] = " - ";
                    } else if ((pieza[fg][cg] = " G ") == (pieza[fg][cg] = " M ")) {
                        System.out.println("Ya hay algo en esa posicion (" + (fg - 1) + "," + (cg - 1) + " M )");
                        pieza[fg][cg] = " - ";
                    }

                } catch (Exception e) {
                    System.out.println("\033[31m{ERROR} Debe ingresar una pocision valida");
                }

            }

        }

        for (int i = 0; i < alto_de_matriz;
                i++) {
            System.out.printf("---");

        }

        System.out.println(
                "");
        for (int j = 0;
                j < ancho_de_matriz;
                j++) {
            for (int k = 0; k < alto_de_matriz; k++) {
                System.out.print(pieza[j][k]);
            }
            System.out.println();

        }
        for (int i = 0;
                i < alto_de_matriz;
                i++) {
            System.out.printf("---");

        }

        System.out.println();

        System.out.println(
                "Solo puede ingresar [" + maximo_de_ratones + "] ratones como maximo");

        {
            Scanner tomarCantRatones = new Scanner(System.in);

            int cantRatones;

            while (true) {
                try {
                    System.out.print("Cantidad de Ratones: ");
                    cantRatones = Integer.parseInt(tomarCantRatones.nextLine());

                    if (cantRatones >= 0 && cantRatones <= maximo_de_ratones) {
                        break;
                    } else if (cantRatones < 0) {
                        System.out.println("No puede ingresar una cantidad negativa");
                    } else if (cantRatones > maximo_de_ratones) {
                        System.out.println("La cantidad de ratones no puede superar la cantidad maxima de ratones (" + maximo_de_ratones + ")");
                    }

                } catch (Exception e) {
                    System.out.println("\033[31m{ERROR} Ingrese un numero entero");
                }
            }

            for (int i = 0; i < cantRatones; i++) {

                for (int j = 0; j < alto_de_matriz; j++) {
                    System.out.printf("---");
                }
                System.out.println("");
                for (int j = 0; j < ancho_de_matriz; j++) {
                    for (int k = 0; k < alto_de_matriz; k++) {
                        System.out.print(pieza[j][k]);
                    }
                    System.out.println();
                }
                for (int j = 0; j < alto_de_matriz; j++) {
                    System.out.printf("---");//

                }
                while (true) {
                    try {

                        System.out.println();
                        System.out.println("-------");
                        System.out.println("Raton Nº " + (i + 1) + ":");
                        System.out.println("-------");
                        System.out.print("Ingrese fila y columna: ");

                        Scanner leerR = new Scanner(System.in);
                        String coorR = leerR.nextLine();
                        Raton r = new Raton(coorR);
                        pieza[r.obtenerFilaCoordenadas_del_Raton()][r.obtenerColumnaCoordenadas_del_Raton()] = " R ";
                        int fr = r.obtenerFilaCoordenadas_del_Raton();
                        int cr = r.obtenerColumnaCoordenadas_del_Raton();

                        if ((pieza[fr][cr] = " - ") == (pieza[fr][cr] = " - ")) {
                            pieza[r.obtenerFilaCoordenadas_del_Raton()][r.obtenerColumnaCoordenadas_del_Raton()] = " R ";

                            break;

                        } else if ((pieza[fr][cr] = " R ") == (pieza[fr][cr] = " G ")) {
                            System.out.println("Ya hay algo en esa posicion (" + (fr - 1) + "," + (cr - 1) + " G )");
                            pieza[fr][cr] = " - ";
                        } else if ((pieza[fr][cr] = " R ") == (pieza[fr][cr] = " R ")) {
                            System.out.println("Ya hay algo en esa posicion (" + (fr - 1) + "," + (cr - 1) + " R )");
                            pieza[fr][cr] = " - ";
                        } else if ((pieza[fr][cr] = " R ") == (pieza[fr][cr] = " M ")) {
                            System.out.println("Ya hay algo en esa posicion (" + (fr - 1) + "," + (cr - 1) + " M )");
                            pieza[fr][cr] = " - ";
                        }

                    } catch (Exception e) {
                        System.out.println("\033[31m{ERROR} Debe ingresar una pocision valida");

                    }
                }

            }

            //estas lineas de abajo son para mostrar la matriz actual con su art attack correspondiente
            for (int i = 0; i < alto_de_matriz; i++) {
                System.out.printf("---");

            }
            System.out.println("");
            for (int j = 0; j < ancho_de_matriz; j++) {
                for (int k = 0; k < alto_de_matriz; k++) {
                    System.out.print(pieza[j][k]);

                }
                System.out.println();

            }
            for (int i = 0; i < alto_de_matriz; i++) {
                System.out.printf("---");
            }
            System.out.println();
        }

        Scanner tomarCantMuebles = new Scanner(System.in);

        System.out.print("Cantidad de muebles: ");
        int cantMuebles = Integer.parseInt(tomarCantMuebles.nextLine());

        //pp=primera punta sp=segunda punta
        for (int i = 0; i < cantMuebles; i++) {

            Scanner leerMueble_pp = new Scanner(System.in);
            System.out.println("Mueble Nº " + (i + 1) + ": ");

            System.out.print("Ingrese fila y columna separada por un espacio: ");
            String coorM_pp = leerMueble_pp.nextLine();
            Primera_coordenada_de_mueble pc = new Primera_coordenada_de_mueble(coorM_pp);

            int primeraFila = (pc.obtenerPrimeraFila()) + 1;
            int primeraColumna = (pc.obtenerPrimeraColumna() + 1);

            pieza[primeraFila][primeraColumna] = " x ";

            for (int j = 0; j < alto_de_matriz; j++) {
                System.out.printf("---");

            }
            System.out.println("");
            for (int k = 0; k < ancho_de_matriz; k++) {
                for (int l = 0; l < alto_de_matriz; l++) {
                    System.out.print(pieza[k][l]);

                }
                System.out.println();

            }

            for (int j = 0; j < alto_de_matriz; j++) {
                System.out.printf("---");
            }
            System.out.println();

            Scanner leerMueble_sp = new Scanner(System.in);

            System.out.print("Ingrese fila y columna separada por un espacio: ");
            String coorM_sp = leerMueble_sp.nextLine();
            Segunda_coordenada_de_mueble sc = new Segunda_coordenada_de_mueble(coorM_sp);

            int segundaFila = (sc.ObtenerSegundaFila()) + 1;
            int segundaColumna = (sc.ObtenerSegundaColumna()) + 1;

            pieza[segundaFila][segundaColumna] = " x ";

            for (int j = 0; j < alto_de_matriz; j++) {
                System.out.printf("---");

            }
            System.out.println("");
            for (int k = 0; k < ancho_de_matriz; k++) {
                for (int l = 0; l < alto_de_matriz; l++) {
                    System.out.print(pieza[k][l]);

                }
                System.out.println();

            }

            for (int j = 0; j < alto_de_matriz; j++) {
                System.out.printf("---");
            }
            System.out.println();

            Scanner leerEleccion = new Scanner(System.in);

            System.out.println("Proceder?: ");
            System.out.println("1.Si");
            System.out.println("2.No");

            int eleccion = leerEleccion.nextInt();

            if (eleccion == 1) {

                /*                     
Lineas 422 a la 425 sirven para rellenar las coordenada ingresadas con M. 
Se necesita aumentar la segundaColumna y la segundaFila e 1, para que calze 
con el limite de la matriz. Se comienza en la primera fila y la primera columna,
y sus limites son la segunda columna y la segunda fila respectivamente.
                    
                 */
                for (int j = primeraFila; j < segundaColumna + 1; j++) {
                    for (int k = primeraColumna; k < segundaFila + 1; k++) {
                        pieza[j][k] = " M ";
                    }

                }

                for (int j = 0; j < alto_de_matriz; j++) {
                    System.out.printf("---");

                }
                System.out.println("");
                for (int k = 0; k < ancho_de_matriz; k++) {
                    for (int l = 0; l < alto_de_matriz; l++) {
                        System.out.print(pieza[k][l]);

                    }
                    System.out.println();

                }
                for (int j = 0; j < alto_de_matriz; j++) {
                    System.out.printf("---");
                }

                System.out.println();
            }
        }

    }

}
