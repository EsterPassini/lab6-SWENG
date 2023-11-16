package it.unimi.di.sweng.blackjack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiMazzoTest {

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
}