package app;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.JsonSyntaxException;

import model.Endereco;
import service.ViaCepService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CEP: " + "ex .. 06105020");
        String cep = scanner.nextLine();

        ViaCepService vcs = new ViaCepService();

       
        try {
            Endereco endereco = vcs.getEndereco(cep);
            System.out.println(endereco.toString());
        } catch (IOException e) {
            System.err.println("Erro ao obter informações do CEP: " + e.getMessage());
            e.printStackTrace();
        } catch (JsonSyntaxException jse) {
            System.err.println("Erro de sintaxe JSON: " + jse.getMessage());
            jse.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
