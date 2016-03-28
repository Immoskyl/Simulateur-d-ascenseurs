package ascenseur.test;

import ascenseur.traitement.Ascenseur;
import ascenseur.traitement.etat.ImmobileFerme;
import ascenseur.utils.Constantes;
import junit.framework.TestCase;

public class AscenseurTest extends TestCase {

    public AscenseurTest(String name) {
        super(name);
    }

    public void testRequeteBas() {
        System.out.println("-- Test requete bas");
        Ascenseur ascenseur = new Ascenseur(Constantes.ValeursEtat.IMMOBILE_FERME, 4);
        ascenseur.creerRequeteInterne(3);
        ascenseur.action();
        assertEquals(Constantes.ValeursEtat.MOUVEMENT_BAS, ascenseur.getEtat().getValeur());

        ascenseur.action();
        assertEquals(3, ascenseur.getEtage());
        assertEquals(Constantes.ValeursEtat.IMMOBILE_OUVERT, ascenseur.getEtat().getValeur());

        ascenseur.action();
        assertEquals(Constantes.ValeursEtat.IMMOBILE_FERME, ascenseur.getEtat().getValeur());
    }

    public void test2RequetesBas() {
        System.out.println("-- Test 2 requete bas");
        Ascenseur ascenseur = new Ascenseur(Constantes.ValeursEtat.IMMOBILE_FERME, 4);
        ascenseur.creerRequeteInterne(2);
        ascenseur.creerRequeteInterne(3);

        ascenseur.action();
        ascenseur.action();
        assertEquals(Constantes.ValeursEtat.IMMOBILE_OUVERT, ascenseur.getEtat().getValeur());
        ascenseur.action();
        ascenseur.action();
    }

    public void testRequeteHaut() {
        System.out.println("-- Test requete haut");
        Ascenseur ascenseur = new Ascenseur(Constantes.ValeursEtat.IMMOBILE_FERME, 3);
        ascenseur.creerRequeteInterne(5);
        ascenseur.action();
        assertEquals(Constantes.ValeursEtat.MOUVEMENT_HAUT, ascenseur.getEtat().getValeur());

        ascenseur.action();
        assertEquals(Constantes.ValeursEtat.MOUVEMENT_HAUT, ascenseur.getEtat().getValeur());

        ascenseur.action();
        assertEquals(Constantes.ValeursEtat.IMMOBILE_OUVERT, ascenseur.getEtat().getValeur());
        assertEquals(5, ascenseur.getEtage());

        ascenseur.action();
        assertEquals(Constantes.ValeursEtat.IMMOBILE_FERME, ascenseur.getEtat().getValeur());
    }

    public void test2Requetes() {
        System.out.println("-- Test 2 requetes");

        Ascenseur ascenseur = new Ascenseur(Constantes.ValeursEtat.IMMOBILE_FERME, 4);
        ascenseur.creerRequeteInterne(3);
        ascenseur.creerRequeteInterne(6);

        ascenseur.action();
        assertEquals(Constantes.ValeursEtat.MOUVEMENT_BAS, ascenseur.getEtat().getValeur());

        ascenseur.action();
        assertEquals(3, ascenseur.getEtage());
        assertEquals(Constantes.ValeursEtat.IMMOBILE_OUVERT, ascenseur.getEtat().getValeur());

        ascenseur.action();
        assertEquals(Constantes.ValeursEtat.IMMOBILE_FERME, ascenseur.getEtat().getValeur());

        ascenseur.action();
        assertEquals(Constantes.ValeursEtat.MOUVEMENT_HAUT, ascenseur.getEtat().getValeur());

        ascenseur.action();
        ascenseur.action();
        ascenseur.action();
        assertEquals(6, ascenseur.getEtage());
        assertEquals(Constantes.ValeursEtat.IMMOBILE_OUVERT, ascenseur.getEtat().getValeur());
    }

    public void testBloquer() {
        System.out.println("-- Test bloquer");
        Ascenseur ascenseur = new Ascenseur(Constantes.ValeursEtat.IMMOBILE_FERME, 2);
        ascenseur.creerRequeteInterne(4);
        ascenseur.bloquer();

        ascenseur.action();
        assertEquals(2, ascenseur.getEtage());
        assertEquals(Constantes.ValeursEtat.IMMOBILE_FERME, ascenseur.getEtat().getValeur());

        ascenseur.debloquer();
        ascenseur.action();
        assertEquals(Constantes.ValeursEtat.MOUVEMENT_HAUT, ascenseur.getEtat().getValeur());
    }
}
