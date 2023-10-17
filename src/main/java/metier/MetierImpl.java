package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    private IDao dao;// couplage faible

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }


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
