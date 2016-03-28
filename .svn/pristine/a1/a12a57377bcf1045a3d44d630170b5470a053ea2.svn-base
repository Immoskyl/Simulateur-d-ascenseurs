package ascenseur.test;

import ascenseur.traitement.Ascenseur;
import ascenseur.traitement.AscenseurAbstrait;
import ascenseur.traitement.AscenseurRapide;
import ascenseur.traitement.MusiqueAscenseur;
import ascenseur.traitement.etat.ImmobileFerme;
import ascenseur.traitement.etat.MouvementHaut;
import ascenseur.utils.Constantes;
import junit.framework.TestCase;

/**
 * Created by r14003530 on 13/01/16.
 */
public class AscenseurOptionTest extends TestCase {

    public AscenseurOptionTest(String name) {
        super(name);
    }

    public void testMusique() {
        System.out.println("-- Musique");
        AscenseurAbstrait ascenseur = new MusiqueAscenseur(new Ascenseur(Constantes.ValeursEtat.IMMOBILE_FERME, 2));
        ascenseur.creerRequeteInterne(4);
        ascenseur.action();
    }

    public void testRapide() {
        System.out.println("-- Rapide");
        AscenseurAbstrait ascenseur = new AscenseurRapide(new Ascenseur(Constantes.ValeursEtat.IMMOBILE_FERME, 2));
        ascenseur.action();
    }

    public void testDeuxOptions() {
        System.out.println("-- les 2");
        AscenseurAbstrait ascenseur = new AscenseurRapide(new MusiqueAscenseur(new Ascenseur(Constantes.ValeursEtat.IMMOBILE_FERME, 2)));
        ascenseur.action();
    }
}