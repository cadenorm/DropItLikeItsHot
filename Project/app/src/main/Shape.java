package com.example.myapplication;


public class Shape {
    Coordinate a, b, c, d;
    public Piece id;
    int rotatedCount = 0;
    static final int BOARD_HEIGH = 9;
    static final int BOARD_WIDTH = 7;


    private Shape(Coordinate a, Coordinate b, Coordinate c, Coordinate d, Piece id) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.id = id;
    }

    public Shape S() {
        this.a = new Coordinate(3, 9);
        this.b = new Coordinate(3, 8);
        this.c = new Coordinate(4, 9);
        this.d = new Coordinate(4, 8);
        Shape retShape = new Shape(a,b,c,d, Piece.S);
        return retShape;
    }

    public Shape L()
    {
        this.a = new Coordinate(4,9);
        this.b = new Coordinate(4,8);
        this.c = new Coordinate(4,7);
        this.d = new Coordinate(3,7);
        Shape retShape = new Shape(a,b,c,d,Piece.L);
        return retShape;

    }
    public Shape Z()
    {
        this.a = new Coordinate(3,8);
        this.b = new Coordinate(4,8);
        this.c = new Coordinate(4,9);
        this.d = new Coordinate(5,9);
        Shape retShape = new Shape(a,b,c,d,Piece.Z);
        return retShape;
    }
    public Shape T()
    {
        this.a = new Coordinate(4,9);
        this.b = new Coordinate(3,8);
        this.c = new Coordinate(4, 8);
        this.d = new Coordinate(5,8);
        Shape retShape = new Shape(a,b,c,d,Piece.T);
        return retShape;
    }
    public Shape LL()
    {
        this.a = new Coordinate(4,9);
        this.b = new Coordinate(4,8);
        this.c = new Coordinate(4, 7);
        this.d = new Coordinate(5,7);
        Shape retShape = new Shape(a,b,c,d,Piece.LL);
        return retShape;
    }
