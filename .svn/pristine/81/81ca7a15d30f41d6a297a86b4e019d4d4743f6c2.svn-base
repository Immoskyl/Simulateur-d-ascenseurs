package ascenseur.affichage;

import ascenseur.traitement.*;
import ascenseur.traitement.strategie.ChoixAleatoire;
import ascenseur.traitement.strategie.ChoixArbitraire;
import ascenseur.traitement.strategie.ChoixOptimal;
import ascenseur.utils.Constantes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {

    public static int promptInt(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int result = min - 1;
        while (result < min || result > max) {
            try {
                result = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.err.println("Veuillez entrer un entier entre " + min + " et " + max);
                scanner.nextLine();
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

        // -- INITIALISATION DE LA VUE --

        Scanner sin = new Scanner(System.in);
        sin.useDelimiter("\\n");
        int nbEtages;
        int nbAscenseur;
        ControleurAbstrait controleur = Controleur.getInstance();

        System.out.println("Choisir nombre d'étages (exemple : 10)");
        nbEtages = promptInt(Constantes.NB_ETAGES_MIN, Constantes.NB_ETAGES_MAX);

        System.out.println("Choisir le nombre d'ascenseurs (exemple : 3)");
        nbAscenseur = promptInt(1, Constantes.NB_ASCENSEURS_MAX);

        System.out.println("Choisir le comportement des ascenseurs:");
        System.out.println("1: ALEATOIRE  : Ascenseur choisi aléatoirement");
        System.out.println("2: ARBITRAIRE : L'ascenseur ayant le moins de requêtes prend en charge la requête");
        System.out.println("3: OPTIMAL    : L'ascenseur susceptible d'arriver le plus vite à l'étage de la requête");
        int strategie = promptInt(1, 3);

        switch (strategie) {
            case 1:
                controleur.setStrategieDeSelection(new ChoixAleatoire());
                break;
            case 2:
                controleur.setStrategieDeSelection(new ChoixArbitraire());
                break;
            case 3:
                controleur.setStrategieDeSelection(new ChoixOptimal());
                break;
            default:
                controleur.setStrategieDeSelection(new ChoixArbitraire());
                System.out.println("Boutton non géré, l'ascenseur ayant le moins de requêtes prendra donc en charge la première requête venant d'un étage");
        }

        String option ;

        for (int i = 0; i < nbAscenseur; ++i) {
            System.out.println("Choisissez les options pour l'ascenseur numero " + i);
            System.out.println("Options : Musique, Rapide, une par ligne, vide pour aucune option");
            FabriqueAscenseur fabrique = new FabriqueAscenseur();
            AscenseurAbstrait ascenseur = fabrique.creerAscenseur();

            while (true){
                option = sin.nextLine();
                if (option.equals("")) break;
                ascenseur = fabrique.ajouterOptions(option, ascenseur) ;
            }
            controleur.ajouterAscenseur(ascenseur);
        }

        controleur.attacherObservateur(new VueCoupeImmeuble(controleur, nbEtages));
        controleur.attacherObservateur(new VueRequetes(controleur.getListeRequetesExternes(), controleur.getListeRequetesInternes()));
        controleur.attacherObservateur(new VueInteractive(nbEtages, nbAscenseur));
        controleur.informerObservateurs();
    }
}
