package ascenseur.traitement;

public abstract class Requete {

    private int etage;

    public Requete(int etage) {
        this.etage = etage;
    }

    public int getEtage() {
        return etage;
    }
}
