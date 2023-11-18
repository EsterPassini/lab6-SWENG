package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;
import ca.mcgill.cs.stg.solitaire.cards.Suit;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
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
    @Mock
    List<Card> mano;
    @InjectMocks
    Mazziere SUT;

    @Test
    void getPuntiTest(){
        MockUtils.whenIterated(mano,Card.get(Rank.ACE,Suit.CLUBS),Card.get(Rank.QUEEN,Suit.DIAMONDS));
        SUT.gioca();
        assertThat(SUT.getPunti()).isEqualTo(21);
    }


    @Mock
    Mazziere mazziere;
    @InjectMocks
    Sfidante sfidanteSUT;
    @Test
    void giocaGiocatoreTest(){
        Strategia s = new StrategyControlParity(new StrategyTable(Strategia.STAYALWAYS,sfidanteSUT), sfidanteSUT);

        sfidanteSUT.setStrategia(s);
        when(mazziere.daiCarta()).thenReturn(Card.get(Rank.TWO, Suit.CLUBS), Card.get(Rank.QUEEN, Suit.CLUBS), Card.get(Rank.EIGHT, Suit.CLUBS), Card.get(Rank.ACE, Suit.CLUBS));
        sfidanteSUT.carteIniziali();

        assertThat(sfidanteSUT.getPunti()).isEqualTo(12);
        sfidanteSUT.gioca();
        assertThat(sfidanteSUT.getPunti()).isEqualTo(21);

        ///////////////////////////////////////////////////////////////////////////

        s = new StrategyControlParity(new StrategyTable(Strategia.STAYALWAYS,sfidanteSUT), sfidanteSUT);

        sfidanteSUT.setStrategia(s);
        when(mazziere.daiCarta()).thenReturn(Card.get(Rank.EIGHT, Suit.CLUBS), Card.get(Rank.QUEEN, Suit.CLUBS), Card.get(Rank.EIGHT, Suit.CLUBS), Card.get(Rank.ACE, Suit.CLUBS));
        sfidanteSUT.carteIniziali();

        assertThat(sfidanteSUT.getPunti()).isEqualTo(18);
        sfidanteSUT.gioca();
        assertThat(sfidanteSUT.getPunti()).isEqualTo(18);

        ///////////////////////////////////////////////////////////////////////////
        when(mazziere.getPunti()).thenReturn(11);
        when(mazziere.daiCarta()).thenReturn(Card.get(Rank.TWO, Suit.CLUBS), Card.get(Rank.TWO, Suit.HEARTS), Card.get(Rank.EIGHT, Suit.CLUBS), Card.get(Rank.ACE, Suit.CLUBS));

        s = new StrategyLookAtTable(new StrategyControlParity(Strategia.STAYALWAYS,sfidanteSUT), sfidanteSUT, mazziere);

        sfidanteSUT.setStrategia(s);
        sfidanteSUT.carteIniziali();

        assertThat(sfidanteSUT.getPunti()).isEqualTo(4);
        sfidanteSUT.gioca();
        assertThat(sfidanteSUT.getPunti()).isEqualTo(13);

    }
}