package ejercicio.de.ia;

import java.util.Random;

public class EjercicioDeIa {

    public static void main(String[] args) {

        String valor = "ingenieria informatica, inteligencia artificial";
        int cantidadIndeviduos;
        int pressure = 4; //Cuantos fenotipos se seleccionan para reproduccion. Necesariamente mayor que 2
        double valor_mutacion = 0.2; // valor de la mutacion
        double valor_cruce = 0.8; // valor de la cruce
        int iteracion = 5;// iteraciones del usuario desea 
        char v[] = fraseCortada(valor);
        double valorFitnnes[] = new double[2];
        double sumatoriafitnnes = 0;
        int auxBinario;
        char auxFenotipo;
        int cont = 0;
        int contalr = 46;
        int individuo1[] = new int[47];
        int individuo2[] = new int[47];
        boolean salida = false;

        //agregar valores aletorios en 4 vectores de char 
        char fenotipo1[] = caracterAletorio(32);
        char fenotipo2[] = caracterAletorio(32);

        System.out.println("primera version ");
        System.out.println("");
        System.out.println("1");
        for (int i = 0; i < fenotipo1.length; i++) {

            System.out.print("{" + fenotipo1[i] + "]");

        }

        System.out.println("");
        System.out.println("2");
        for (int i = 0; i < fenotipo2.length; i++) {

            System.out.print("{" + fenotipo2[i] + "]");

        }
        System.out.println(" ");
        System.out.println(" //////////// ");

        //agregar 2 valores binario en los vectores de fenotipo siendo 1 si aparece y 0 no aparece 
        individuo1 = vectorBinario(fenotipo1, v);
        individuo2 = vectorBinario(fenotipo2, v);

        //mete los valores de la funcion fitness para saber que vectores escogemos,(escogemos los dos mayores)      
        valorFitnnes[0] = funcfitness(individuo1);
        valorFitnnes[1] = funcfitness(individuo2);

        // luego se hace la suma de sus valores y se saca el porcentaje de cada uno           
        sumatoriafitnnes = proposion(valorFitnnes);

        for (int i = 0; i < valorFitnnes.length; i++) {
            valorFitnnes[i] = valorFitnnes[i] / sumatoriafitnnes;
        }

        for (int k = 0; k < iteracion; k++) {

            for (int i = 24; i < 47; i++) {

                if (individuo1[i] == 0) {
                    // se hace el cruce    de binario   
                    auxBinario = individuo1[i];
                    individuo1[i] = individuo2[i];
                    individuo2[i] = auxBinario;
                    // se hace el cruce de fenotipos         
                    auxFenotipo = fenotipo1[i];
                    fenotipo1[i] = fenotipo2[i];
                    fenotipo2[i] = auxFenotipo;
                } else {

                }

            }
            System.out.println(" ");
            System.out.println("cruce  ");
            System.out.println("");
            System.out.println("1");
            for (int i = 0; i < fenotipo1.length; i++) {

                System.out.print("{" + fenotipo1[i] + "]");

            }

            System.out.println("");
            System.out.println("2");
            for (int i = 0; i < fenotipo2.length; i++) {

                System.out.print("{" + fenotipo2[i] + "]");

            }

            System.out.println(" ");
            System.out.println(" //////////// ");

            // se hace la mutacion por el medio de insercion 
            salida = false;
            contalr = 46;
            cont = 0;
            while (salida == false) {
                if (individuo1[cont] == 0) {
                    salida = true;
                    fenotipo1[cont] = letraAletorio();
                } else {

                    cont += 1;
                }

            }

            System.out.println("mutacion ");
            System.out.println("");
            System.out.println("1");
            for (int i = 0; i < fenotipo1.length; i++) {

                System.out.print("{" + fenotipo1[i] + "]");

            }

            System.out.println("");
            System.out.println("2");
            for (int i = 0; i < fenotipo2.length; i++) {

                System.out.print("{" + fenotipo2[i] + "]");

            }
            System.out.println(" //////////// ");

            //agregar 2 valores binario en los vectores de fenotipo siendo 1 si aparece y 0 no aparece         
            individuo1 = vectorBinario(fenotipo1, v);
            individuo2 = vectorBinario(fenotipo2, v);

            //mete los valores de la funcion fitness para saber que vectores escogemos,(escogemos los dos mayores)      
            valorFitnnes[0] = funcfitness(individuo1);
            valorFitnnes[1] = funcfitness(individuo2);

            // luego se hace la suma de sus valores y se saca el porcentaje de cada uno           
            sumatoriafitnnes = proposion(valorFitnnes);

            for (int i = 0; i < valorFitnnes.length; i++) {
                valorFitnnes[i] = valorFitnnes[i] / sumatoriafitnnes;
            }

        }

        System.out.println("final ");
        System.out.println("");
        System.out.println("1");
        for (int i = 0; i < fenotipo1.length; i++) {

            System.out.print("{" + fenotipo1[i] + "]");

        }

        System.out.println("");
        System.out.println("2");
        for (int i = 0; i < fenotipo2.length; i++) {

            System.out.print("{" + fenotipo2[i] + "]");

        }
        System.out.println(" //////////// ");

    }

    // poner un vector con letras aletorias 
    public static char[] caracterAletorio(int n) {

        Random random = new Random();
        char[] aletorio = new char[47];

        for (int i = 0; i < 47; i++) {
            char randomizedCharacter = (char) (random.nextInt(n) + 'a');

            aletorio[i] = randomizedCharacter;

        }
        return aletorio;
    }

    public static char letraAletorio() {

        Random random = new Random();

        char randomizedCharacter = (char) (random.nextInt(28) + 'a');

        return randomizedCharacter;
    }

    // recorta la frase para poder hacer comparaciones 
    public static char[] fraseCortada(String frase) {

        char[] v = frase.toCharArray();

        for (int i = 0; i < v.length; i++) {
            System.out.print(" " + v[i] + " ");

        }
        return v;
    }

    // vector que llena entre 0 y 1 
    public static int[] vectorBinario(char v[], char n[]) {
        int vector[] = new int[47];
        for (int i = 0; i < v.length; i++) {

            if (v[i] == n[i]) {
                vector[i] = 1;
            } else {
                vector[i] = 0;
            }
        }
        return vector;
    }

    //funcion de la fitness 
    public static double funcfitness(int individuo[]) {
        double fitness = 0;

        for (int i = 0; i < individuo.length; i++) {

            if (individuo[i] == 1) {
                double fx = Math.pow(2, i);
                fitness += fx;
            }

        }

        return fitness;

    }

    //funcion sumatoria  de la sumatoria  fitness 
    public static double proposion(double porcentajefittnes[]) {
        double sumatoria = 0;

        for (int i = 0; i < porcentajefittnes.length; i++) {

            sumatoria += porcentajefittnes[i];
        }

        return sumatoria;

    }

}
