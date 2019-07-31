package perceptron;

import utils.Dados;

import java.io.*;

public class Reader{

    private final int count = 9;
    private int numeroLinha;
    public Dados dados;

    public Reader(){
        this.dados = new Dados();
        numeroLinha = 0;
    }


    public int getNumeroLinha() {
        return numeroLinha;
    }

    public void carregaDados(String arquivo) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;
        while (br.ready()) {
            linha = br.readLine();
            numeroLinha++;
            processaLinha(linha);
        }
        this.dados.translateData();
        br.close();
    }

    public void processaLinha(String linha) throws Exception {
        String[] dados = linha.split(",");

        for(int i = 0, j=0; i<this.count ; i++){
            if(i == count-1){
                this.dados.getOutputArray().add(Integer.parseInt(dados[i]));
            }
            else{
                this.dados.getInputArray().add(Float.parseFloat(dados[i]));
            }

        }
    }

}
