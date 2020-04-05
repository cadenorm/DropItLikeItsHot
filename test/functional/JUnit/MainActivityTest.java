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
        MainActivityStub stub = new MainActivityStub();
        int [][] output = stub.createJBlock();
        output = stub.moveBlockDown(output);
        int [][] input = new int [7][9];

        input[3][7] = 1;
        input[3][6] = 1;
        input[3][5] = 1;
        input[3][4] = 1;

        assertArrayEquals(input, output);

    }
    @Test
    public void moveBlockLeft(){
        MainActivityStub stub = new MainActivityStub();
        int [][] output = stub.createJBlock();
        output = stub.moveBlockLeft(output);
        int [][] input = new int [7][9];

        input[2][8] = 1;
        input[2][7] = 1;
        input[2][6] = 1;
        input[2][5] = 1;

        assertArrayEquals(input, output);
    }

    @Test
    public void moveBlockRight() {
        MainActivityStub stub = new MainActivityStub();
        int [][] output = stub.createJBlock();
        output = stub.moveBlockRight(output);
        int [][] input = new int [7][9];

        input[4][8] = 1;
        input[4][7] = 1;
        input[4][6] = 1;
        input[4][5] = 1;

        assertArrayEquals(input, output);
    }

    @Test
    public void lockBlockPosition() {
        MainActivityStub stub = new MainActivityStub();
        int [][] output = stub.createJBlock();
        output = stub.lockBlockPosition(output);
        int [][] input = new int [7][9];

        input[3][8] = 2;
        input[3][7] = 2;
        input[3][6] = 2;
        input[3][5] = 2;

        assertArrayEquals(input, output);
    }
}