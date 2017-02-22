package br.com.fiap.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class CarrinhoBean implements CarrinhoBeanRemote {

	private List<Item> itens = new ArrayList<>();
	private HashMap<Integer, Object> newsletter = new HashMap<>();

	public CarrinhoBean() {
	}

	public void cadastrarItem(Item item) {
		itens.add(item);
		System.out.println("Item cadastrado com sucesso: " + item.getNome());
	}

	public List<Item> obterItens() {

		return this.itens;
	}

	public int obterQuantidadeItens() {
		return this.itens.size();
	}

	public void adicionarEmail(int matricula, String email) {
		
		if (newsletter.containsKey(new Integer(matricula))) {
			newsletter.remove(new Integer(matricula));
		}

		newsletter.put(new Integer(matricula), email);

		System.out.println("\n\n");
		System.out.println("======= EMAILS CADASTRADOS =======");
		newsletter.values().forEach(System.out::println);
		System.out.println("======= TOTAL: " + newsletter.size() + " =======");
	}
}
