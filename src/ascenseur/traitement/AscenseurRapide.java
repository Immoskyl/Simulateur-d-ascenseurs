package ascenseur.traitement;

import ascenseur.traitement.etat.Etat;

public class AscenseurRapide extends Option {

    @Override
    public void action() {
        delegue.action() ;
    }

    public AscenseurRapide(AscenseurAbstrait ascenseurAbstrait) {
        delegue = ascenseurAbstrait ;
    }
    
    public String getOptions() {
        return delegue.getOptions() + " rapide ";
    }
}
