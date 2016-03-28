package ascenseur.traitement;

import ascenseur.affichage.VueCoupeImmeuble;
import ascenseur.traitement.Ascenseur;
import ascenseur.traitement.AscenseurAbstrait;
import ascenseur.traitement.etat.ImmobileFerme;
import ascenseur.utils.Constantes;

/**
 * Created by s14000079 on 13/01/16.
 */
public class FabriqueAscenseur {

    public AscenseurAbstrait creerAscenseur () {

        AscenseurAbstrait ascenseur = new Ascenseur (Constantes.ValeursEtat.IMMOBILE_FERME,0 );
        return ascenseur;
    }

    public AscenseurAbstrait ajouterOptions (String option, AscenseurAbstrait ascenseur) throws Exception {

        if (option.equals("Musique")) {
            AscenseurAbstrait ascenseurOption = new MusiqueAscenseur (ascenseur);
            return ascenseurOption;
        }

        else if (option.equals("Rapide")) {
            AscenseurAbstrait ascenseurOption = new AscenseurRapide (ascenseur);
            return ascenseurOption;
        }

        else {
            System.out.println("Option non prise en compte");
            return ascenseur;
        }
    }
}
