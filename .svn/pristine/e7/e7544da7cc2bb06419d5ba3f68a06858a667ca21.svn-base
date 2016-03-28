package ascenseur.traitement;

import java.util.ArrayList;
import java.util.List;

import ascenseur.affichage.Observateur;
import ascenseur.traitement.strategie.SelectionAscenceur;

public abstract class ControleurAbstrait {

    private SelectionAscenceur strategieDeSelection;
    private ArrayList<Observateur> listeObservateurs = new ArrayList<>();


    public abstract void creerRequeteExterne (int etage, boolean direction);
    public abstract void choisirAscenseur (RequeteExterne requete);
    public abstract void ajouterAscenseur(AscenseurAbstrait ascenseur);
    public abstract void affecterRequetes ();
    public abstract void actionAscenseurs();

    public abstract ArrayList<AscenseurAbstrait> getListeAscenseurs();
    public abstract ArrayList<RequeteExterne> getListeRequetesExternes();
    public abstract ArrayList<RequeteInterne> getListeRequetesInternes();

    public abstract SelectionAscenceur getStrategieDeSelection();
    public abstract void setStrategieDeSelection(SelectionAscenceur strategieDeSelection);


    public void attacherObservateur (Observateur observateur) {
        listeObservateurs.add(observateur);
    }
    public void detacherObservateur (Observateur observateur) {
        listeObservateurs.remove(observateur);
    }

    public void informerObservateurs () {
        for (Observateur observateur : listeObservateurs)
            observateur.actualiser(this);
    }

    public abstract void afficheOptions() ;

}
