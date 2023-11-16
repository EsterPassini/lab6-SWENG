package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;
import ca.mcgill.cs.stg.solitaire.cards.Suit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BJTest {

    @ParameterizedTest
    @ValueSource(ints={4,3,2,1})
    void multiMazzoTest(int n){
        MultiMazzo multi=new MultiMazzo(n);
        int i=0;
        while(!multi.isEmpty()){
                multi.draw();
                i++;
        }
        assertThat(i).isEqualTo(n*52);
    }

    @Test
    void mazziereCarteInizialiTest (){
        Mazziere m = new Mazziere();
        assertThat(m).size().isEqualTo(1);
    }
    @Test
    void mazziereGiocaTest(){
        Mazziere m=new Mazziere();
        m.gioca();
        assertThat(m.getPunti()).isGreaterThanOrEqualTo(17);
    }

    @Test
    void strategyTableTest(){
        Sfidante g = mock(Sfidante.class);
        when(g.getPunti()).thenReturn(16);

        StrategyTable ts = new StrategyTable(null, g);
        assertThat(ts.chiediCarta()).isTrue();
    }
    @Test
    void  lookAtTableStrategyTest(){
        Sfidante g= mock(Sfidante.class);
        Mazziere m=mock(Mazziere.class);
        when(m.getPunti()).thenReturn(10);
        when(g.getPunti()).thenReturn(6);
        StrategyLookAtTable lk=new StrategyLookAtTable(null,g,m);
        assertThat(lk.chiediCarta()).isTrue();
    }
    @Test
    void controlParityStrategyTest(){
        Sfidante sf=mock(Sfidante.class);
        when(sf.numCards()).thenReturn(3);
        StrategyControlParity pt=new StrategyControlParity(null,sf);
        assertThat(pt.chiediCarta()).isTrue();
    }
    @Test
    void  sfidanteCarteInizialiTest(){
        Mazziere m=mock(Mazziere.class);
        when(m.daiCarta()).thenReturn(Card.get(Rank.TWO, Suit.CLUBS));
        Sfidante s = new Sfidante("tino", m);
        s.carteIniziali();
        assertThat(s).size().isEqualTo(2);
        assertThat(s.getName()).isEqualTo("tino");
    }

}