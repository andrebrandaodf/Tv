package tv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppTv {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("======================== TV Nlogonia ========================");
		char ligar = 'S';

		Integer volume           = null;
		Integer quantidadeTrocas = null;
		boolean linhaValida      = true;

		if (ligar == 'S') {
		
			System.out.println();
			//do {
				System.out.println("Digite o volume e quantidade de trocas (Ex. 50 4):");
				String linha1 = sc.nextLine();

				String[] numeros = linha1.split(" ");
				if (numeros == null || numeros.length < 2) {
					linhaValida = true;
				} else {
					linhaValida = false;
					volume = Integer.valueOf(numeros[0]);
					quantidadeTrocas = Integer.valueOf(numeros[1]);
				}

			//} while (linhaValida);

			System.out.println("Volume: " + volume);
			System.out.println("Quantidade de trocas de volume: " + quantidadeTrocas);
			System.out.println("Digite as modificações do volume: ");

			String linha2 = sc.nextLine();
			String[] volumesString = linha2.split(" ");
			List<Integer> volumes = new ArrayList<Integer>();

			try {
				for (String s : volumesString) {
					volumes.add(Integer.parseInt(s));
				}
			} catch (NumberFormatException e) {
				System.out.println("É necessario informar um numero");
			}

			Integer volumeFinal = volume;

			for (int i = 0; i < quantidadeTrocas; i++) {

				volumeFinal += volumes.get(i);
				if (volumeFinal > 100) {
					volumeFinal = 100;
				} else if (volumeFinal < -100) {
					volumeFinal = -100;
				}
			}

			System.out.println("Volume atual da TV: " + volumeFinal);

			sc.close();
		}
	}
}
