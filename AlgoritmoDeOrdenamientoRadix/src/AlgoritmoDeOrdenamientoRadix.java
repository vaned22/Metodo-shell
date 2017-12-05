/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

/**
 *
     * @author vanessa albarran
     */
    public class AlgoritmoDeOrdenamientoRadix {
    int i, j, temporal, pasadas;

    public AlgoritmoDeOrdenamientoRadix() {
        this.i = 0;
        this.j = 0;
        this.temporal = 0;
    }

    public void burbuja1(int[] arreglo) {
        pasadas = 0;
        for (i = 0; i < arreglo.length; i++) {
            for (j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    temporal = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temporal;
                }
                pasadas++;
            }
        }
        System.out.println("Termino en " + pasadas + " pasadas");
    }

    public void burbuja2(int[] arreglo) {
        pasadas = 0;
        for (i = 1; i < arreglo.length; i++) {
            for (j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    temporal = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temporal;
                }
                pasadas++;
            }
        }
        System.out.println("Termino en " + pasadas + " pasadas");
    }

    //Método quick
    public void quick(int[] arreglo, int primero, int último) {
        int i, j, pivote, auxiliar;
        i = primero;
        j = último;
        pivote = arreglo[(primero + último) / 2];
        do {
            while (arreglo[i] < pivote) {
                i++;
            }
            while (arreglo[j] > pivote) {
                j--;
            }
            //intercambio
            if (i <= j) {
                auxiliar = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = auxiliar;
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            quick(arreglo, primero, j);
        }
        if (i < último) {
            quick(arreglo, i, último);
        }
        mostrarArreglo(arreglo);

    }

    public void mostrarArreglo(int[] arreglo) {
        int k = 0;
        for (k = 0; k < arreglo.length; k++) {
            System.out.print("[" + arreglo[k] + "]");
        }
        System.out.println();
    }

    public void radix(int[] arreglo) {
        int x, i, j;
        for (x = Integer.SIZE - 1; x >= 0; x--) {
            int auxiliar[] = new int[arreglo.length];
            j = 0;
            for (i = 0; i < arreglo.length; i++) {
                boolean mover = arreglo[i] << x >= 0;
                if (x == 0 ? !mover : mover) {
                    auxiliar[j] = arreglo[i];
                    j++;
                } else {
                    arreglo[i - j] = arreglo[i];
                }
            }
            for (i = j; i < auxiliar.length; i++) {
                auxiliar[i] = arreglo[i - j];
            }
            arreglo = auxiliar;
        }
        System.out.println("El Arreglo Ordenado con Radix es: ");
        mostrarArreglo(arreglo);

    }

    //Metodo para insercion
    public void insercion(int[] arreglo, int n) {
        int i, j, auxiliar;
        for (i = 1; i < n; i++) {
            auxiliar = arreglo[i];
            j = i - 1;
            while (j >= 0 && arreglo[j] > auxiliar) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = auxiliar;

        }
        System.out.println("Arreglo Ordenado por Insercion");
        mostrarArreglo(arreglo);
    }

    //Metodo Shell
    public void shell(int[] arreglo) {
        int salto, i, j, k, auxiliar;
        salto = arreglo.length / 2;
        while (salto > 0) {
            for (i = salto; i < arreglo.length; i++) {
                j = i - salto;
                while (j >= 0) {
                    k = j + salto;
                    if (arreglo[j] <= arreglo[k]) {
                        j = -1;
                    } else {
                        auxiliar = arreglo[j];
                        arreglo[j] = arreglo[k];
                        arreglo[k] = auxiliar;
                        j -= salto;//j=j-saltó
                    }

                }
            }
            salto = salto / 2;
        }
        System.out.println("Arreglo Ordenado con shell");
        mostrarArreglo(arreglo);
    }
}
    /*Metodo Intercalacion
    public void intercalacion(int[] arregloA, int[] arregloB) {
        int i, j, k;
        int arregloC[] = new int[arregloA.length + arregloB.length];
        //Repetir mientras los arreglos A Y B tengan los elementos que comparar
        for (i = j = k = 0; i < arregloA.length && j < arregloB.length; k++) {
            if (arregloA[i] < arregloB[j]) {
                arregloC[k] = arregloA[i];
                i++;

            } else {
                arregloC[k] = arregloB[j];
                j++;

            }
        }
        //Para añadir los elementos del arregloA sobrantes en caso de haberlo
        for (; i < arregloA.length; i++, k++) {
            arregloC[k] = arregloA[i];
        }
        //Para añadir los elementos del arregloA sobrantes en caso de haberlo
        for (; j < arregloB.length; j++, k++) {
            arregloC[k] = arregloA[j];
        }
        System.out.println("Arreglos ordenados por Itercalacion");
        mostrarArreglo(arregloC);

    }
*/