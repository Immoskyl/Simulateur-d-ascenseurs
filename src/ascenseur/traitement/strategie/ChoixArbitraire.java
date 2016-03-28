package ascenseur.traitement.strategie;

import ascenseur.traitement.AscenseurAbstrait;
import ascenseur.traitement.RequeteExterne;
import ascenseur.utils.Calcul;

import java.util.ArrayList;

/**
 * Created by r14006780 on 15/01/16.
 */
public class ChoixArbitraire implements SelectionAscenceur {

    public void choisirAscenseur(RequeteExterne requete, ArrayList<AscenseurAbstrait> listeAscenseurs) {
        ArrayList<Integer> velocite = new ArrayList<>();
        for (AscenseurAbstrait ascenseur: listeAscenseurs) {
            if (!ascenseur.estBloque())
                 velocite.add(ascenseur.getNombreRequetes());
            else
                velocite.add(-1);
        }
        //Determination de l'ascenseur ayant la meilleure velocite
        if (velocite.size() != 0) {
            listeAscenseurs.get(velocite.indexOf(Calcul.getMinPositiveOuNulleValeurDe(velocite))).ajouterRequete(requete);
        }
    }
}
