import perceptron.Perceptron;

public class AppSystem {

    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron();

        double[][] inputs = {{0,0},{0,1},{1,0},{1,1}};
        int[] output = {0,0,0,1};

        perceptron.Training(inputs,output,0.2, 0.1, 200);
        System.out.println(perceptron.Output(new double[]{0,0}));
        System.out.println(perceptron.Output(new double[]{1,0}));
        System.out.println(perceptron.Output(new double[]{0,1}));
        System.out.println(perceptron.Output(new double[]{1,1}));

    }
}
