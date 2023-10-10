package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres22 {
    public static void main (String[] args) throws Exception {
        Scanner scanner= new Scanner(System.in);
        System.out.print("donner la classe de la couche DAO:");
        String daoClassName=scanner.nextLine();
        Class cDao= Class.forName(daoClassName);
        IDao dao= (IDao) cDao.getConstructor().newInstance();// new Dao

        //MetierImpl metier= new MetierImpl();
        String metierClassname= scanner.nextLine();
        System.out.print("donner la classe de la metier:");

        Class cMetier=Class.forName(metierClassname);
        IMetier metier= (IMetier) cMetier.getConstructor().newInstance();
        //metier.setDao(dao);
        Method setDao = cMetier.getDeclaredMethod("setDao",IDao.class);
        setDao.invoke(metier,dao);//injection des dependances
        System.out.println("RES"+metier.calcul());

    }

}
