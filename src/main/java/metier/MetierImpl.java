package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;// couplage faible
    @Override
    public double calcul() {
        double d=dao.getData();
        double res= d*11.4;
        return res;
    }

    /**
     * pour permettre d'injecter dans la variable dao
     * un objet d'une classe qui implemente l'interface Idao
     * @param dao
     */

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
