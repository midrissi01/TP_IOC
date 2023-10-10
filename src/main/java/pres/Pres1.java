package pres;

import dao.DaoImpl;
import metier.MetierImpl;


public class Pres1 {
    public static void main (String[] args){
        DaoImpl dao= new DaoImpl();//instantiation statique
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);//injection de dependances
        System.out.println("RES"+metier.calcul());
    }


}
