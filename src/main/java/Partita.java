import it.unimi.di.sweng.blackjack.*;

import java.util.ArrayList;
import java.util.List;

public class Partita {
    public static void main(String[] args) {
        Mazziere banco = new Mazziere();

        Sfidante Martino = new Sfidante("Martino", banco);
        Sfidante Ester = new Sfidante("Ester", banco);
        Sfidante Irne = new Sfidante("Irne", banco);

        List<Sfidante> sfidanti = new ArrayList<>();
        sfidanti.add(Martino);
        sfidanti.add(Ester);
        sfidanti.add(Irne);

        Martino.setStrategia(new StrategyControlParity(new StrategyRandom(Strategia.STAYALWAYS),Martino));
        Ester.setStrategia(new StrategyLookAtTable(new StrategyTable(Strategia.STAYALWAYS,Ester),Ester,banco));
        Irne.setStrategia(new StrategyTable(Strategia.STAYALWAYS,Irne));
        Martino.gioca();
        Ester.gioca();
        Irne.gioca();
        banco.gioca();
        System.out.println(banco.asString());
        for (Sfidante sfidante : sfidanti) {
            System.out.println(sfidante.asString());
            if (sfidante.isSballato() || (sfidante.getPunti() < banco.getPunti() && !banco.isSballato()))
                System.out.println("Vince il banco.");
            else if (banco.isSballato() || sfidante.getPunti() > banco.getPunti())
                System.out.println("Il banco perde!!!");
            else
                System.out.println("Pareggio.");
        }
    }

}
