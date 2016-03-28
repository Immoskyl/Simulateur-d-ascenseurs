package ascenseur.traitement.strategie;

import ascenseur.traitement.AscenseurAbstrait;
import ascenseur.traitement.RequeteExterne;
import ascenseur.utils.Calcul;
import ascenseur.utils.Constantes;

import java.util.ArrayList;

/**
 * Created by r14006780 on 15/01/16.
 */
public class ChoixOptimal implements SelectionAscenceur {

    private void ajouterRequeteAscenseur (ArrayList<Integer> velocite, RequeteExterne requete, ArrayList<AscenseurAbstrait> listeAscenseurs) {
        listeAscenseurs.get(velocite.indexOf(Calcul.getMinPositiveOuNulleValeurDe(velocite))).ajouterRequete(requete);
    }

    public void choisirAscenseur(RequeteExterne requete, ArrayList<AscenseurAbstrait> listeAscenseurs) {
        ArrayList<Integer> velocite = new ArrayList<>();

        //Calcul de la velocite des ascenseurs dans le bon sens
        for (AscenseurAbstrait ascenseur: listeAscenseurs) {
            if (!ascenseur.estBloque()) {
                if (((ascenseur.getEtage() > requete.getEtage()
                        && ascenseur.getEtat().getValeur() == Constantes.ValeursEtat.MOUVEMENT_BAS))
                        || (ascenseur.getEtage() < requete.getEtage()
                        && ascenseur.getEtat().getValeur() == Constantes.ValeursEtat.MOUVEMENT_HAUT))
                    velocite.add(ascenseur.getEtage() - requete.getEtage());
                else
                    velocite.add(-1);
            }
            else
                velocite.add(-1);
        }
        //Determination de l'ascenseur ayant la meilleure velocite
        if (velocite.size() != 0) {
            ajouterRequeteAscenseur (velocite, requete, listeAscenseurs);
        }
        //Calcul de la velocite des ascenseurs arretes
        for (AscenseurAbstrait ascenseur: listeAscenseurs) {
            if (! ascenseur.estBloque()) {
                if (ascenseur.getEtat().getValeur() == Constantes.ValeursEtat.IMMOBILE_FERME)
                    velocite.add(ascenseur.getEtage() - requete.getEtage());
                else if (ascenseur.getEtat().getValeur() == Constantes.ValeursEtat.IMMOBILE_OUVERT)
                    velocite.add(ascenseur.getEtage() - requete.getEtage());
                else
                    velocite.add(-1);
            }
            else
                velocite.add(-1);
        }
        //Determination de l'ascenseur ayant la meilleure velocite
        if (velocite.size() != 0) {
            ajouterRequeteAscenseur (velocite, requete, listeAscenseurs);
        }
        //Calcul du nombre de requete des ascenceurs dans le mauvais sens
        for (AscenseurAbstrait ascenseur: listeAscenseurs) {
            if (!ascenseur.estBloque()) {
                if ((ascenseur.getEtage() < requete.getEtage()
                        && ascenseur.getEtat().getValeur() == Constantes.ValeursEtat.MOUVEMENT_BAS)
                        || (ascenseur.getEtage() > requete.getEtage()
                        && ascenseur.getEtat().getValeur() == Constantes.ValeursEtat.MOUVEMENT_HAUT))
                    velocite.add(ascenseur.getNombreRequetes());
                else
                    velocite.add(-1);
            }
            else
                velocite.add(-1);
        }
        //Determination de l'ascenseur ayant la meilleure velocite
        if (velocite.size() != 0) {
            ajouterRequeteAscenseur (velocite, requete, listeAscenseurs);
        }
    }

}
