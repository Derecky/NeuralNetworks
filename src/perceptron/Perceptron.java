package perceptron;

import java.util.Random;

public class Perceptron {

    double[] weights;                            // Array que guarda os pesos sinápticos
    double limits;

    /* Método para treinar a matriz 0.2, 0.1, 200*/
    public void Training( double[][] inputs,    // Entrada uma matriz, exemplo as duas primeiras colunas da tabela verdade de um operador comum
                          int[] outputs,        // Saída da tabela verdade correspondente
                          double limits,
                          double leftRate,
                          int period){

        this.limits = limits;
        int sizeLine = inputs[0].length;
        int outputSize = outputs.length;
        weights = new double[sizeLine];
        Random rand = new Random();

        /* Inicializa os pesos*/
        for(int i=0; i<sizeLine; i++){

            weights[i] = rand.nextDouble();  // Inicializa os pesos com valores aleatórios
        }


        for(int i=0; i<period; i++){

            int error = 0;                  // inicializa o erro total
            for(int j=0; j<outputSize; j++){

                int output = Output(inputs[j]);
                int localError = outputs[j] - output;
                error += localError;

                for (int k=0 ; k<sizeLine ; k++){
                    weights[k] += (leftRate * inputs[j][k] * localError);
                }
            }

            if(error == 0) break;
        }
    }

    /* Função somatório */
    private int Output(double[] input) {
        double sum = 0.0;
        for (int i=0; i<input.length; i++){
            sum += weights[i]*input[i];
        }

        if(sum>limits) return 1;
        else return 0;
    }
}
