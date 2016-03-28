package ascenseur.traitement.strategie;

import ascenseur.traitement.AscenseurAbstrait;
import ascenseur.traitement.RequeteExterne;

import java.util.ArrayList;

/**
 * Created by r14006780 on 15/01/16.
 */
public class ChoixAleatoire implements SelectionAscenceur {

    public void choisirAscenseur(RequeteExterne requete, ArrayList<AscenseurAbstrait> listeAscenseurs) {
        //the random way
        int i = (int) (Math.random() * listeAscenseurs.size());
        listeAscenseurs.get(i).ajouterRequete(requete);
    }
}
