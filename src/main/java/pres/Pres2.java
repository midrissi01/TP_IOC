package pres;



import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Scanner;

public class Pres2 {
    public static void main (String[] args) throws Exception {
        Scanner scanner= new Scanner(new File("config.txt"));
        String daoClassName=scanner.nextLine();
        Class cDao= Class.forName(daoClassName);
        IDao dao= (IDao) cDao.getConstructor().newInstance();// new Dao

        //MetierImpl metier= new MetierImpl();
        String metierClassname= scanner.nextLine();
        Class cMetier=Class.forName(metierClassname);
        IMetier metier= (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
        //metier.setDao(dao);//
       // Method setDao = cMetier.getDeclaredMethod("setDao",IDao.class);
       // setDao.invoke(metier,dao);//injection des dependances
        System.out.println("RES"+metier.calcul());

    }

}
