package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Produto> list = new ArrayList<>();

		System.out.print("Informe o numero de produtos: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do produto #" + i + ":");
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char ch = sc.next().charAt(0);

			if (ch == 'i') {
				System.out.print("Nome: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.print("Preco: ");
				double preco = sc.nextDouble();
				System.out.print("Taxa alfandegaria: ");
				double taxaAlfandegaria = sc.nextDouble();
				list.add(new ProdutoImportado(nome, preco, taxaAlfandegaria));
			}

			else if (ch == 'c') {
				System.out.print("Nome: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.print("Preco: ");
				double preco = sc.nextDouble();
				list.add(new Produto(nome, preco));
			}

			else {
				System.out.print("Nome: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.print("Preco: ");
				double preco = sc.nextDouble();
				System.out.print("Data de fabricacao: ");
				Date data = sdf.parse(sc.next());
				list.add(new ProdutoUsado(nome, preco, data));
			}
		}

		System.out.println();
		for (Produto p : list) {
			System.out.println(p.etiqueta());
		}

		sc.close();
	}
}
