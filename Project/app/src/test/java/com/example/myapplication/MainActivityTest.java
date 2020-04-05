package com.example.myapplication;

import android.media.Image;
import android.widget.ImageView;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Test
    public void createJBlock() {

        MainActivityStub stub = new MainActivityStub();
        int[][] input = new int[7][9];
        input[3][8] = 1;
        input[3][7] = 1;
        input[3][6] = 1;
        input[3][5] = 1;
        int[][] output = stub.createJBlock();
        assertArrayEquals(input, output);

    }

    @Test
    public void moveBlockDown() {
    }

    @Test
    public void moveBlockLeft() {
    }

    @Test
    public void moveBlockRight() {
    }

    @Test
    public void lockBlockPosition() {
    }
}