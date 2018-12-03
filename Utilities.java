package prog.objet.projet.utilities;

import java.util.Scanner;

public class Utilities {

	public static Scanner input = new Scanner(System.in);

	public static String Input() {
		return input.nextLine();
	}

	public static String Input(String p_message) {
		System.out.print(p_message);
		return Input();
	}

	public static void Print(Object p_message) {
		System.out.println(p_message.toString());
	}

	public static int SaisirChoixMenu() {
		int choixMenu = Integer.MIN_VALUE;
		do {
			try {
				choixMenu = Integer.parseInt(Utilities.Input("Faite un choix : "));
			} catch (Exception e) {
				System.err.println(e.getCause() + " " + e.getMessage());
				choixMenu = Integer.MIN_VALUE;
			}
		} while (choixMenu == Integer.MIN_VALUE);
		return choixMenu;
	}

	// Le le min et max sont inclue
	public static int SaisirChoixMenu(int p_min, int p_max) {
		int choixMenu = Integer.MIN_VALUE;
		while (choixMenu < p_min || choixMenu > p_max) {
			try {
				choixMenu = Integer.parseInt(Utilities.Input("Faite un choix : "));
			} catch (Exception e) {
				System.err.println(e.getCause() + " " + e.getMessage());
				choixMenu = Integer.MIN_VALUE;
			}
			if (choixMenu < p_min || choixMenu > p_max) {
				Utilities.Print("Veuillez faire un choix valide");
			}
		}
		return choixMenu;
	}

	// Le le min et max sont inclue
	public static int SaisirChoixMenu(int p_min, int p_max, String p_message) {
		int choixMenu = Integer.MIN_VALUE;
		while (choixMenu < p_min || choixMenu > p_max) {
			try {
				choixMenu = Integer.parseInt(Utilities.Input(p_message));
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
				choixMenu = Integer.MIN_VALUE;
			}
			if (choixMenu < p_min || choixMenu > p_max) {
				Utilities.Print("Veuillez faire un choix valide");
			}
		}
		return choixMenu;
	}
}
