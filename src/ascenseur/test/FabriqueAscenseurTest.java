package ascenseur.test;

import ascenseur.affichage.VueCoupeImmeuble;
import ascenseur.traitement.AscenseurAbstrait;
import ascenseur.traitement.Controleur;
import ascenseur.traitement.ControleurAbstrait;
import ascenseur.traitement.FabriqueAscenseur;

/**
 * Created by David on 18/01/2016.
 */
public class FabriqueAscenseurTest {

    public void test() throws Exception {
        System.out.println("Test fabrique");

        FabriqueAscenseur fabrique = new FabriqueAscenseur() ;
        AscenseurAbstrait a1 = fabrique.creerAscenseur();
        ControleurAbstrait controleur = Controleur.getInstance();
        a1 = fabrique.ajouterOptions("Musique", a1) ;
        a1 = fabrique.ajouterOptions("Rapide", a1) ;

        controleur.ajouterAscenseur(a1);

        VueCoupeImmeuble v1 = new VueCoupeImmeuble(controleur, 4) ;
        v1.afficher();
    }

    public static void main(String[] args) throws Exception {
        FabriqueAscenseurTest fabriqueTest = new FabriqueAscenseurTest() ;
        fabriqueTest.test();
    }
}
