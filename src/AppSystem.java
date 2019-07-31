import perceptron.Perceptron;
import perceptron.Reader;

import javax.print.DocFlavor;

public class AppSystem {



    public static void main(String[] args) throws Exception {
        AppSystem.run();
    }

    public static void run() throws Exception {

        int acertosTotais = 0;
        for(int m=0; m<100 ; m++){
            String arquivo = "C:\\Users\\Derecky\\IdeaProjects\\NeuralNetworks\\src\\docs\\inputTest";

            Reader reader = new Reader();
            Perceptron perceptron = new Perceptron();

            reader.carregaDados(arquivo);

            double[][] inputs = reader.dados.getInput();
//        System.out.println("Erro aqui: " + inputs[0].length);
            int[] output = reader.dados.getOutput();

            perceptron.Training(inputs,output,0.2, 0.1, 200);
//            System.out.println("A Rede foi treinada com " + reader.getNumeroLinha() + " dados.");

            String saida = "C:\\Users\\Derecky\\IdeaProjects\\NeuralNetworks\\src\\docs\\outputTest";
            Reader reader1 = new Reader();
            reader1.carregaDados(saida);


            int acertos = 0, total = reader1.dados.getOutput().length;
            for (int i=0; i<total ; i++){
                if(reader1.dados.getOutput()[i] == perceptron.Output(reader.dados.getInput()[i])) acertos++;
            }
            acertosTotais += acertos;
            System.out.println("A rede obteve um acerto de " + acertos + " num total de " + total + " entradas");
        }

        System.out.println("Taxa de acerto: " + (float) acertosTotais/1500 + "%");

    }


}
