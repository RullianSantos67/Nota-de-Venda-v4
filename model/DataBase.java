package model;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
	private static Map<String, String[]> products = new HashMap<>();
	private static Map<String, PaymentMethod> payments = new HashMap<>();
	private static Stock stock = new Stock(); // Estoque reutilizável

	static {
		// Adicionando produtos ao mapa de produtos
		products.put("at", new String[] {"Arroz Tatiana", "30"});
		products.put("ff", new String[] {"Feijão Fejó", "20"});
		products.put("msa", new String[] {"Macarrão Santa Amália", "15"});

		// Adicionando produtos ao estoque
		stock.addItem(new Product("Arroz Tatiana"), 10);
		stock.addItem(new Product("Feijão Fejó"), 5);
		stock.addItem(new Product("Macarrão Santa Amália"), 8);

		// Adicionando formas de pagamento
		CreditCard creditCard = new CreditCard(5.0);
		DebitCard debitCard = new DebitCard(0.0);
		Cash cash = new Cash(5.0);
		payments.put("cc", creditCard);
		payments.put("dc", debitCard);
		payments.put("c", cash);
	}

	// Seleciona o método de pagamento
	public static PaymentMethod selectPayment(String payment) {
		if (!payments.containsKey(payment)) {
			System.out.println("Método de pagamento inválido!");
			return null;
		}
		return payments.get(payment);
	}

	// Seleciona o produto com base no código
	public static String[] selectProduct(String code) {
		if (!products.containsKey(code)) {
			System.out.println("Produto não encontrado!");
			return null;
		}
		return products.get(code);
	}

	// Retorna o estoque
	public static Stock getStock() {
		return stock;
	}
}
