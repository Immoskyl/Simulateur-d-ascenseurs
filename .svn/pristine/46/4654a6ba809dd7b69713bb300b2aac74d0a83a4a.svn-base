package ascenseur.affichage;

import ascenseur.traitement.*;
import ascenseur.utils.Constantes;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.util.ArrayList;
import java.util.Scanner;

public class VueInteractive implements Observateur {

	private int nbEtagesImmeuble;
	private int nbAscenseurs;
    private Scanner scanner;

	public VueInteractive(int nbEtagesImmeuble, int nbAscenseurs) {
		this.nbEtagesImmeuble = nbEtagesImmeuble;
		this.nbAscenseurs = nbAscenseurs;
        scanner = new Scanner(System.in);
	}

    private void afficherAide() {
        System.out.println("    Syntaxe : type param1 [param2]");
        System.out.println("Requete externe: E etage direction(U ou D)");
        System.out.println("Requete interne: I etage numeroAscenseur");
        System.out.println("Bloquer un ascenseur: B numAscenseur");
        System.out.println();
    }

	@Override
	public void actualiser(ControleurAbstrait controleurAbstrait) {

        while (true) {
			System.out.print("Entrer une requete (help pour la syntaxe):");

            String ligne = scanner.nextLine();
			if (ligne.isEmpty()) break;

			String[] tokens = ligne.split(Constantes.TOKEN_CONTINUE);
            if (tokens[0].equals(Constantes.TOKEN_HELP)) {
                afficherAide();
                continue;
            }

			char type = Character.toUpperCase(tokens[0].charAt(0));

			try {
				int param1 = Integer.parseInt(tokens[1]);

				if (type == Constantes.TOKEN_REQUETE_EXTERNE) {

					char tokenDirection = Character.toUpperCase(tokens[2].charAt(0));
					boolean direction = (tokenDirection == 'U' || tokenDirection == 'H');
					System.out.println("Requete externe : etage=" + param1 + ", direction=" + (direction ? "haut" : "bas"));

					controleurAbstrait.creerRequeteExterne(param1, direction);
				} else if (type == Constantes.TOKEN_REQUETE_INTERNE) {

					int numAscenseur = Integer.parseInt(tokens[2]);
					System.out.println("Requete interne : etage=" + param1 + ", num=" + numAscenseur);

					controleurAbstrait.getListeAscenseurs().get(numAscenseur).creerRequeteInterne(param1);
				} else if (type == Constantes.TOKEN_REQUETE_BLOQUER) {

					AscenseurAbstrait ascenseur = controleurAbstrait.getListeAscenseurs().get(param1);
					if (! ascenseur.estBloque()) {
                        System.out.println("Blocage ascenseur n°" + param1);
                        ascenseur.bloquer();
                    } else {
                        System.out.println("Déblocage ascenseur n°" + param1);
                        ascenseur.debloquer();
                    }
				} else {
					System.err.println("Erreur de syntaxe : type de requete (choisir E, I ou B)");
				}
			} catch (NumberFormatException ex) {
				System.err.println("Erreur de syntaxe : conversion en entier");
			} catch (IndexOutOfBoundsException ex) {
				System.err.println("Numero d'ascenseur trop grand");
			}
		}

        controleurAbstrait.affecterRequetes();
        controleurAbstrait.actionAscenseurs();
		controleurAbstrait.informerObservateurs();
	}

	public static void main(String[] args) {
		Controleur controleur = Controleur.getInstance();
		controleur.ajouterAscenseur(new Ascenseur(Constantes.ValeursEtat.IMMOBILE_FERME, 2));
		VueInteractive vue = new VueInteractive(3, 2);
		vue.actualiser(controleur);
	}
}
