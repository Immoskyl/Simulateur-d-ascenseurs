package ascenseur.affichage ;

import ascenseur.traitement.AscenseurAbstrait;
import ascenseur.traitement.Controleur;
import ascenseur.traitement.ControleurAbstrait;
import ascenseur.utils.Constantes ;

import java.util.ArrayList;

public class VueCoupeImmeuble implements  Observateur{

	private ControleurAbstrait controleurAbstrait ;
	private ArrayList<AscenseurAbstrait> listeAscenseurs;
	private int nbEtages ;
	
	public VueCoupeImmeuble(ControleurAbstrait controleurAbstrait, int nbEtages) {
		this.controleurAbstrait = controleurAbstrait ;
		this.listeAscenseurs = controleurAbstrait.getListeAscenseurs();
		this.nbEtages = nbEtages ;
	}
	
	private void afficheLegende() {
		System.out.println("U = mouvement haut, D = mouvement bas,  O = immobile ouvert, C = immobile ferme");
	}

	private void afficheToit() {
		System.out.println(" Otiste");
		afficheLegende();
		System.out.print(Constantes.ICONE_TOIT);
		for (int i = 0 ; i < listeAscenseurs.size() * Constantes.VALEUR_LARGEUR_IMMEUBLE ; ++i ) {
			System.out.print(Constantes.ICONE_TOIT);
		}
		System.out.println(Constantes.CASE_VIDE);
	}
	
	private void afficheUnEtage(int numEtage) {
		System.out.print(Constantes.ICONE_BORD_IMMEUBLE);
		System.out.print(Constantes.CASE_VIDE);
		for (AscenseurAbstrait a : listeAscenseurs) {
			if (a.getEtage() == numEtage) {
				if (a.getEtat().getValeur() == Constantes.ValeursEtat.IMMOBILE_FERME) {
					System.out.print(Constantes.ICONE_PORTES_FERMES);
				}
				else if (a.getEtat().getValeur() == Constantes.ValeursEtat.IMMOBILE_OUVERT) {
					System.out.print(Constantes.ICONE_PORTES_OUVERTES);
				}
				else if (a.getEtat().getValeur() == Constantes.ValeursEtat.MOUVEMENT_HAUT) {
					System.out.print(Constantes.ICONE_MOUVEMENT_MONTER);
				}
				else if (a.getEtat().getValeur() == Constantes.ValeursEtat.MOUVEMENT_BAS) {
					System.out.print(Constantes.ICONE_MOUVEMENT_DESCENDRE);
				}
				else {
					System.out.print(Constantes.ICONE_ERREUR); // Si un ascenceur a X c'est une erreur pas bien
				}
			}
			else {
				System.out.print(Constantes.ICONE_RAIL_ASCENSEUR);
			}
			System.out.print(Constantes.CASE_VIDE);
			System.out.print(Constantes.ICONE_BORD_IMMEUBLE);
			System.out.print(Constantes.CASE_VIDE);
		}
	}
	
	private void afficheCorp() {
		for (int i = nbEtages ; i >= 0 ; --i ) {
			afficheUnEtage(i) ;
			System.out.print(Constantes.CASE_VIDE);
			System.out.print(i); // Affiche l'etage
			System.out.println(Constantes.CASE_VIDE);
		}
	}

	private void afficheCasesVides(int nombre) {
		for (int i = 0 ; i < nombre ; ++i) {
			System.out.print(Constantes.CASE_VIDE);
		}
	}

	private void afficheNumeros() {
		afficheCasesVides(2);
		for (int i = 0 ; i < listeAscenseurs.size() ; i++ ) {
			if (i >= 10) {
				System.out.print(i);
				afficheCasesVides(2);
			}
			else {
				System.out.print(i);
				afficheCasesVides(3);
			}

		}
	}

	private void afficheOptions() {
		controleurAbstrait.afficheOptions() ;
	}
	
	public void afficher () {
		afficheToit();
		afficheCorp();
		afficheNumeros() ;
		afficheOptions() ;
	}

	@Override
	public void actualiser(ControleurAbstrait controleurAbstrait) {
		this.listeAscenseurs = controleurAbstrait.getListeAscenseurs();
		afficher();
	}
}
