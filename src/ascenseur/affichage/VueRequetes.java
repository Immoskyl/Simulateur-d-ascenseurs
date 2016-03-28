package ascenseur.affichage ;

import ascenseur.traitement.*;

import java.util.ArrayList;
import java.util.List;

public class VueRequetes implements  Observateur{
	
	List<RequeteExterne> listeRequetesExternes = new ArrayList<>();
	ArrayList<RequeteInterne> listeRequetesInternes = new ArrayList<>();

	public VueRequetes(ArrayList<RequeteExterne> listeRequetesExternes, ArrayList<RequeteInterne> listeRequetesInternes) {
		this.listeRequetesExternes = listeRequetesExternes;
		this.listeRequetesInternes = listeRequetesInternes;
	}

	public void afficher () {
		if (listeRequetesInternes.isEmpty() && listeRequetesExternes.isEmpty()) {
			System.out.println("Aucune Requete.");
		}
		else {
			System.out.println("Requetes internes en attente :");
			int numRequete = 0 ;
			for (Requete rq : listeRequetesInternes) {
				System.out.println("N°" + numRequete + " vers etage " + rq.getEtage());
                numRequete++;
			}

            System.out.println("Requetes externes en attente :");
            numRequete = 0;
            for (RequeteExterne rq : listeRequetesExternes) {
                System.out.println("N°" + numRequete + " à l'etage " + rq.getEtage() + " vers le " + (rq.getDirection() ? "haut" : "bas"));
                numRequete++;
            }
		}
	}

	@Override
	public void actualiser(ControleurAbstrait controleurAbstrait) {
		this.listeRequetesExternes = controleurAbstrait.getListeRequetesExternes();
		this.listeRequetesInternes = controleurAbstrait.getListeRequetesInternes();
        afficher();
	}
}
