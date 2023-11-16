package it.unimi.di.sweng.blackjack;

import org.junit.jupiter.api.RepeatedTest;
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
        m.carteIniziali();
        assertThat(m).size().isEqualTo(1);
    }
    @Test
    void mazziereGiocaTest(){
        Mazziere m=new Mazziere();
        m.carteIniziali();
        m.gioca();
        assertThat(m.getPunti()).isGreaterThanOrEqualTo(17);
    }

    @Test
    void strategyTableTest(){
        Sfidante g = mock(Sfidante.class);
        when(g.getPunti()).thenReturn(16);

        TableStrategy ts = new TableStrategy(null, g);
        assertThat(ts.chiediCarta()).isTrue();
    }
    @Test
    void  lookAtTableStrategyTest(){
        Sfidante g= mock(Sfidante.class);
        Mazziere m=mock(Mazziere.class);
        when(m.getPunti()).thenReturn(10);
        when(g.getPunti()).thenReturn(6);
        LookAtTableStrategy lk=new LookAtTableStrategy(null,g,m);
        assertThat(lk.chiediCarta()).isTrue();
    }

    @Test
    void  sfidanteCarteInizialiTest(){
        Mazziere m=mock(Mazziere.class);
        Sfidante s = new Sfidante("tino", m);
        s.carteIniziali();
        assertThat(s).size().isEqualTo(2);
        assertThat(s.getName()).isEqualTo("tino");
    }
}