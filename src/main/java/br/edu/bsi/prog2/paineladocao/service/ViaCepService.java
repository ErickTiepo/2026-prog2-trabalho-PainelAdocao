/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.bsi.prog2.paineladocao.service;

/**
 *
 * @author Erick
 */
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCepService {

    // Método que recebe uma String com o CEP e devolve um array de Strings com [Rua, Bairro, Cidade]
    public static String[] buscarEnderecoPorCep(String cep) {
        // Limpa o CEP tirando os tracinhos se o utilizador digitar
        cep = cep.replace("-", "").replace(".", "");

        try {
            // Cria o link da API do ViaCEP
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            // Se a resposta for 200 (OK), a internet funcionou
            if (conexao.getResponseCode() == 200) {
                // Aqui o Gson entra em ação para ler a resposta
                InputStreamReader leitor = new InputStreamReader(conexao.getInputStream(), "UTF-8");
                JsonObject json = JsonParser.parseReader(leitor).getAsJsonObject();

                // Verifica se o CEP não existe
                if (json.has("erro")) {
                    return null;
                }

                // Pega nos pedaços do endereço que a API devolveu
                String rua = json.get("logradouro").getAsString();
                String bairro = json.get("bairro").getAsString();
                String cidade = json.get("localidade").getAsString();
                String estado = json.get("uf").getAsString();

                // Devolve empacotado para a nossa tela usar mais tarde
                return new String[]{rua, bairro, cidade + " - " + estado};
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar o CEP: " + e.getMessage());
        }

        // Se der erro ou não encontrar, retorna vazio
        return null;
    }
}
