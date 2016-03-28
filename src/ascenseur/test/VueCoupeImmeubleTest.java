package ascenseur.test;

import ascenseur.affichage.VueCoupeImmeuble;
import ascenseur.traitement.*;
import ascenseur.utils.Constantes;

import java.util.ArrayList;

public class VueCoupeImmeubleTest {

    // Test affichage immeuble ascii
    public void test1 () {
        Controleur controleur = Controleur.getInstance() ;
        Ascenseur a1 = new Ascenseur(Constantes.ValeursEtat.IMMOBILE_FERME, 4) ;
        AscenseurAbstrait a2 = new AscenseurRapide(new MusiqueAscenseur(new Ascenseur(Constantes.ValeursEtat.IMMOBILE_OUVERT, 5)));
        AscenseurAbstrait a3 = new MusiqueAscenseur(new Ascenseur(Constantes.ValeursEtat.MOUVEMENT_HAUT, 2)) ;
        Ascenseur a4 = new Ascenseur(Constantes.ValeursEtat.MOUVEMENT_BAS, 1) ;
        controleur.ajouterAscenseur(a1);
        controleur.ajouterAscenseur(a2);
        controleur.ajouterAscenseur(a3);
        controleur.ajouterAscenseur(a4);
        VueCoupeImmeuble vueTest = new VueCoupeImmeuble(controleur, 5) ;
        vueTest.afficher();
    }

    public static void main(String[] arg0) {
        VueCoupeImmeubleTest testor = new VueCoupeImmeubleTest () ;
        testor.test1() ;
    }

}
