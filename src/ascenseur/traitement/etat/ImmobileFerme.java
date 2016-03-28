package ascenseur.traitement.etat;

import ascenseur.traitement.Ascenseur;
import ascenseur.traitement.Requete;
import ascenseur.utils.Constantes;

public class ImmobileFerme implements Etat {

    @Override
    public void effectuerAction(Ascenseur ascenseur) {
    }

    @Override
    public Etat calculerNouvelEtat(Requete req, int etage) {
        if (req != null) {
            if (req.getEtage() < etage)
                return new MouvementBas();
            else if (req.getEtage() > etage)
                return new MouvementHaut();
            else
                return new ImmobileOuvert();
        }
        return this;
    }

    @Override
    public Constantes.ValeursEtat getValeur() {
        return Constantes.ValeursEtat.IMMOBILE_FERME;
    }

    @Override
    public String toString() {
        return "ImmobileFerme";
    }
}
