package ascenseur.traitement;

import ascenseur.traitement.strategie.SelectionAscenceur;

import java.util.ArrayList;
import java.util.Iterator;

public class Controleur extends ControleurAbstrait {

    private ArrayList<AscenseurAbstrait> listeAscenseurs = new ArrayList<>();
    private ArrayList<RequeteExterne> listerequetesExternes = new ArrayList<>();
    private SelectionAscenceur strategieDeSelection;

    public SelectionAscenceur getStrategieDeSelection() {
        return strategieDeSelection;
    }

    public void setStrategieDeSelection(SelectionAscenceur strategieDeSelection) {
        this.strategieDeSelection = strategieDeSelection;
    }

    public ArrayList<AscenseurAbstrait> getListeAscenseurs() {
        return listeAscenseurs;
    }

    public ArrayList<RequeteExterne> getListeRequetesExternes() {
        ArrayList<RequeteExterne> resultat = new ArrayList<>();
        for (AscenseurAbstrait ascenseur : listeAscenseurs) {
            resultat.addAll(ascenseur.getRequetesExternes());
        }
        resultat.addAll(listerequetesExternes);
        return resultat;
    }

    @Override
    public ArrayList<RequeteInterne> getListeRequetesInternes() {
        ArrayList<RequeteInterne> resultat = new ArrayList<>();
        for (AscenseurAbstrait ascenseur : listeAscenseurs) {
            resultat.addAll(ascenseur.getRequetesInternes());
        }
        return resultat;
    }

    //              -----SINGLETON-----

    // L'utilisation du mot clé volatile, en Java version 5 et supérieur,
    // permet d'éviter le cas où "Controleur.instance" est non-nul,
    // mais pas encore "réellement" instancié.
    private static volatile Controleur instance = null;

    /**
     * Constructeur de l'objet.
     */
    private Controleur() {
        // La présence d'un constructeur privé supprime le constructeur public par défaut.
        // De plus, seul le Controleur peut s'instancier lui-même.
        super();
        listeAscenseurs = new ArrayList<>();
        listerequetesExternes = new ArrayList<>();
    } //Controleur()

    /**
     * Méthode permettant de renvoyer une instance de la classe Controleur
     * @return Retourne l'instance du Controleur.
     */
    public static Controleur getInstance() {
        //Le "Controleur doublement vérifié" permet
        //d'éviter un appel coûteux à synchronized,
        //une fois que l'instanciation est faite.
        if (Controleur.instance == null) {
            // Le mot-clé synchronized sur ce bloc empêche toute instanciation
            // multiple même par différents "threads".
            // Il est TRES important.
            synchronized(Controleur.class) {
                if (Controleur.instance == null) {
                    Controleur.instance = new Controleur();
                }
            }
        }
        return Controleur.instance;
    }//getInstance()

    public static Controleur TEST_creerInstance() {
        return new Controleur();
    }

    //              -----SINGLETON-----


    public void creerRequeteExterne (int etage, boolean direction) {
        RequeteExterne requete = new RequeteExterne(etage, direction);
        this.listerequetesExternes.add(requete);
    }

    public void choisirAscenseur (RequeteExterne requete) {
        strategieDeSelection.choisirAscenseur(requete, listeAscenseurs);
    }

    public void ajouterAscenseur(AscenseurAbstrait ascenseur) {
        listeAscenseurs.add(ascenseur);
    }

    public void affecterRequetes() {
        Iterator<RequeteExterne> iter = listerequetesExternes.iterator();
        while (iter.hasNext()) {
            choisirAscenseur(iter.next());
            iter.remove();
        }
    }

    public void actionAscenseurs() {
        for (AscenseurAbstrait ascenseur : listeAscenseurs) {
            ascenseur.action();
        }
    }

    public void afficheOptions() {
        System.out.println();
        int numeroAscenseur = 0 ;
        for (AscenseurAbstrait ascenseurAbstrait : listeAscenseurs) {
            if (ascenseurAbstrait.getOptions().length() != 0) {
                System.out.print("L'ascenseur " + numeroAscenseur + " a les options suivantes : ");
                System.out.println(ascenseurAbstrait.getOptions());
            }
            ++numeroAscenseur ;
        }
    }


}


