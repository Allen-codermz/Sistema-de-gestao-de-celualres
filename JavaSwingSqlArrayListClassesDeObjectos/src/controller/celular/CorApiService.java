package controller.celular;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CorApiService {

	public static String buscarDescricao(String hex) {

		String hexSimples = hex.replace("#", "");

		if (hexSimples.isEmpty()) {
			return "Cor não disponivel";
		}

		try {
			String urlCor = "https://www.thecolorapi.com/id?hex=" + hexSimples;
			URL url = new URL(urlCor);

			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			conexao.setRequestMethod("GET");
			conexao.setConnectTimeout(5000);
			conexao.setReadTimeout(5000);
			conexao.setRequestProperty("Accept", "application/json");

			int codRes = conexao.getResponseCode();
			if (codRes != 200) {
				return "Cor não disponivel";
			}
			BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			StringBuilder res = new StringBuilder();
			String linha;
			while ((linha = leitor.readLine()) != null) {
				res.append(linha);
			}
			leitor.close();
			conexao.disconnect();

			String json = res.toString();
			String descricao = extrairNomeRes(json);

			return descricao;

		} catch (Exception e) {
			System.err.println("Erro a carregar a cor " + e.getMessage());
			return "Cor não disponivel";
		}
	}

	public static String extrairNomeRes(String json) {
		try {
			int indexName = json.indexOf("\"name\":");
			if (indexName == -1)
				return "Cor não disponivel";

			String subJson = json.substring(indexName);
			int indexValue = subJson.indexOf("\"value\":");
			if (indexValue == -1)
				return "Cor não disponivel";

			int inicio = indexValue + 9;
			int fim = subJson.indexOf("\"", inicio);
			if (fim == -1)
				return "Cor não disponivel";

			return subJson.substring(inicio, fim);
		} catch (Exception e) {
			return "Cor não disponivel";
		}
	}

}
