package com.msb.datastructure.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CardsInLineTest {
    private CardsInLine target;

    @Before
    public void setup() {
        this.target = new CardsInLine();
    }

    @Test
    public void getWin() {
        // arrange
        int[] arr = new int[] {2, 28, 45, 13,200, 9};

        // act
        int actual = this.target.win(arr);
        int expected = 247;

        // assert
        assertEquals(expected, actual);

    }


}

