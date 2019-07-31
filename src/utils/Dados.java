package utils;

import java.util.ArrayList;

public class Dados {

    private double[][] input;
    private int[] output;
    private final int sizedata = 8;

    private ArrayList<Integer> outputArray;
    private ArrayList<Float> inputArray;

    public Dados(){
        this.outputArray = new ArrayList<Integer>();
        this.inputArray = new ArrayList<Float>();
    }

    public ArrayList<Integer> getOutputArray() {
        return outputArray;
    }

    public void setOutputArray(ArrayList<Integer> outputArray) {
        this.outputArray = outputArray;
    }

    public ArrayList<Float> getInputArray() {
        return inputArray;
    }

    public void setInputArray(ArrayList<Float> inputArray) {
        this.inputArray = inputArray;
    }

    public double[][] getInput() {
        return input;
    }

    public void setInput(double[][] input) {
        this.input = input;
    }

    public int[] getOutput() {
        return output;
    }

    public void setOutput(int[] output) {
        this.output = output;
    }

    public void translateData() {
        this.output = new int[outputArray.size()];
        this.input = new  double[outputArray.size()][sizedata];

        for(int i=0; i<this.outputArray.size(); i++){
            output[i] = outputArray.get(i);
        }

        int j=0;
        for(int i=0, k=0; i<this.inputArray.size(); i++, k++){

            if(k==8) {
                k=0;
                j++;
            }
//            System.out.println("i :" + i + " j: " + j);
            input[j][k] = inputArray.get(i);
//            if(i == (9*(j+1)) - 1) j++;
        }
    }
}
