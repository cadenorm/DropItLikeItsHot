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

    public void moveRight(){
        Coordinate maxCoord = new Coordinate(0, 0);
        maxCoord = this.getMaxCoordinate();

        if (maxCoord.getX() < BOARD_WIDTH){
            this.a.setX(this.a.getX() + 1);
            this.b.setX(this.b.getX() + 1);
            this.c.setX(this.c.getX() + 1);
            this.d.setX(this.d.getX() + 1);
        }
    }

    public void rotateLeft(){
        switch (id.toString()){
            case "S":
                break;
            case "T":   //rotate around c coordinate
                if (rotatedCount == 0){
                    this.a.setX(this.a.getX() + 1);
                    this.a.setY(this.a.getY() - 1);
                    this.b.setX(this.b.getX() + 1);
                    this.b.setY(this.b.getY() + 1);
                    this.d.setX(this.d.getX() - 1);
                    this.d.setY(this.d.getY() - 1);
                    rotatedCount ++;
                }
                else if (rotatedCount == 1){
                    this.a.setX(this.a.getX() - 1);
                    this.a.setY(this.a.getY() - 1);
                    this.b.setX(this.b.getX() + 1);
                    this.b.setY(this.b.getY() - 1);
                    this.d.setX(this.d.getX() - 1);
                    this.d.setY(this.d.getY() + 1);
                    rotatedCount ++;
                }
                else if (rotatedCount == 2){
                    this.a.setX(this.a.getX() - 1);
                    this.a.setY(this.a.getY() + 1);
                    this.b.setX(this.b.getX() - 1);
                    this.b.setY(this.b.getY() - 1);
                    this.d.setX(this.d.getX() + 1);
                    this.d.setY(this.d.getY() + 1);
                    rotatedCount ++;
                }
                else if (rotatedCount == 3){
                    this.a.setX(this.a.getX() + 1);
                    this.a.setY(this.a.getY() + 1);
                    this.b.setX(this.b.getX() - 1);
                    this.b.setY(this.b.getY() + 1);
                    this.d.setX(this.d.getX() + 1);
                    this.d.setY(this.d.getY() - 1);
                    rotatedCount = 0;
                }
                break;
            case "LL":   //rotate around b coordinate
                if (rotatedCount == 0){
                    this.a.setX(this.a.getX() + 1);
                    this.a.setY(this.a.getY() - 1);
                    this.c.setX(this.c.getX() - 1);
                    this.c.setY(this.c.getY() + 1);
                    this.d.setX(this.d.getX() + 0);
                    this.d.setY(this.d.getY() + 2);
                    rotatedCount ++;
                }
                else if (rotatedCount == 1){
                    this.a.setX(this.a.getX() - 1);
                    this.a.setY(this.a.getY() - 1);
                    this.c.setX(this.c.getX() + 1);
                    this.c.setY(this.c.getY() + 1);
                    this.d.setX(this.d.getX() + 2);
                    this.d.setY(this.d.getY() + 0);
                    rotatedCount ++;
                }
                else if (rotatedCount == 2){
                    this.a.setX(this.a.getX() - 1);
                    this.a.setY(this.a.getY() + 1);
                    this.c.setX(this.c.getX() + 1);
                    this.c.setY(this.c.getY() - 1);
                    this.d.setX(this.d.getX() + 0);
                    this.d.setY(this.d.getY() - 2);
                    rotatedCount ++;
                }
                else if (rotatedCount == 3){
                    this.a.setX(this.a.getX() + 1);
                    this.a.setY(this.a.getY() + 1);
                    this.c.setX(this.c.getX() - 1);
                    this.c.setY(this.c.getY() - 1);
                    this.d.setX(this.d.getX() - 2);
                    this.d.setY(this.d.getY() + 0);
                    rotatedCount = 0;
                }
                break;
            case "Z":   //rotate around c coordinate
                if (rotatedCount == 0){
                    this.a.setX(this.a.getX() + 0);
                    this.a.setY(this.a.getY() + 2);
                    this.b.setX(this.b.getX() - 1);
                    this.b.setY(this.b.getY() + 1);
                    this.d.setX(this.d.getX() - 1);
                    this.d.setY(this.d.getY() - 1);
                    rotatedCount ++;
                }
                else if (rotatedCount == 1){
                    this.a.setX(this.a.getX() + 2);
                    this.a.setY(this.a.getY() + 0);
                    this.b.setX(this.b.getX() + 1);
                    this.b.setY(this.b.getY() + 1);
                    this.d.setX(this.d.getX() - 1);
                    this.d.setY(this.d.getY() + 1);
                    rotatedCount ++;
                }
                else if (rotatedCount == 2){
                    this.a.setX(this.a.getX() + 0);
                    this.a.setY(this.a.getY() - 2);
                    this.b.setX(this.b.getX() + 1);
                    this.b.setY(this.b.getY() - 1);
                    this.d.setX(this.d.getX() + 1);
                    this.d.setY(this.d.getY() + 1);
                    rotatedCount ++;
                }
                else if (rotatedCount == 3){
                    this.a.setX(this.a.getX() - 2);
                    this.a.setY(this.a.getY() + 0);
                    this.b.setX(this.b.getX() - 1);
                    this.b.setY(this.b.getY() - 1);
                    this.d.setX(this.d.getX() + 1);
                    this.d.setY(this.d.getY() - 1);
                    rotatedCount = 0;
                }
                break;
            case "L":   //rotate around b coordinate
                if (rotatedCount == 0){
                    this.a.setX(this.a.getX() + 1);
                    this.a.setY(this.a.getY() - 1);
                    this.c.setX(this.c.getX() - 1);
                    this.c.setY(this.c.getY() + 1);
                    this.d.setX(this.d.getX() - 2);
                    this.d.setY(this.d.getY() + 0);
                    rotatedCount ++;
                }
                else if (rotatedCount == 1){
                    this.a.setX(this.a.getX() - 1);
                    this.a.setY(this.a.getY() - 1);
                    this.c.setX(this.c.getX() + 1);
                    this.c.setY(this.c.getY() + 1);
                    this.d.setX(this.d.getX() + 0);
                    this.d.setY(this.d.getY() + 2);
                    rotatedCount ++;
                }
                else if (rotatedCount == 2){
                    this.a.setX(this.a.getX() - 1);
                    this.a.setY(this.a.getY() + 1);
                    this.c.setX(this.c.getX() + 1);
                    this.c.setY(this.c.getY() - 1);
                    this.d.setX(this.d.getX() + 2);
                    this.d.setY(this.d.getY() + 0);
                    rotatedCount ++;
                }
                else if (rotatedCount == 3){
                    this.a.setX(this.a.getX() + 1);
                    this.a.setY(this.a.getY() + 1);
                    this.c.setX(this.c.getX() - 1);
                    this.c.setY(this.c.getY() - 1);
                    this.d.setX(this.d.getX() + 0);
                    this.d.setY(this.d.getY() - 2);
                    rotatedCount = 0;
                }
                break;
            default: break;
        }

    }

    public void moveLeft(){
        Coordinate minCoord = new Coordinate(0, 0);
        minCoord = this.getMinCoordinate();

        if (minCoord.getX() > 1){
            this.a.setX(this.a.getX() - 1);
            this.b.setX(this.b.getX() - 1);
            this.c.setX(this.c.getX() - 1);
            this.d.setX(this.d.getX() - 1);
        }
    }

    public Coordinate getMaxCoordinate(){
        Coordinate result = new Coordinate(0, 0);
        if (this.a.getX() > this.b.getX())
                if (this.a.getX() > this.c.getX())
                    if (this.a.getX() > this.d.getX())
                        result.setX(this.a.getX());
                    else result.setX(this.d.getX());
                else if (this.c.getX() > this.d.getX())
                        result.setX(this.c.getX());
                    else result.setX(this.d.getX());
        else if (this.b.getX() > this.c.getX())
                if (this.b.getX() > this.d.getX())
                    result.setX(this.b.getX());
                else result.setX(this.d.getX());
             else if (this.c.getX() > this.d.getX())
                     result.setX(this.c.getX());
                    else result.setX(this.d.getX());

        if (this.a.getY() > this.b.getY())
                if (this.a.getY() > this.c.getY())
                if (this.a.getY() > this.d.getY())
                result.setY(this.a.getY());
                    else result.setY(this.d.getY());
                else if (this.c.getY() > this.d.getY())
                        result.setY(this.c.getY());
                    else result.setY(this.d.getY());
        else if (this.b.getY() > this.c.getY())
                if (this.b.getY() > this.d.getY())
                result.setY(this.b.getY());
                else result.setY(this.d.getY());
             else if (this.c.getY() > this.d.getY())
                     result.setY(this.c.getY());
                    else result.setY(this.d.getY());
        return result;
    }

    Coordinate getMinCoordinate(){
        Coordinate result = new Coordinate(0, 0);
        if (this.a.getX() < this.b.getX())
        if (this.a.getX() < this.c.getX())
        if (this.a.getX() < this.d.getX())
        result.setX(this.a.getX());
                    else result.setX(this.d.getX());
                else if (this.c.getX() < this.d.getX())
        result.setX(this.c.getX());
                    else result.setX(this.d.getX());
        else if (this.b.getX() < this.c.getX())
        if (this.b.getX() < this.d.getX())
        result.setX(this.b.getX());
                else result.setX(this.d.getX());
             else if (this.c.getX() < this.d.getX())
        result.setX(this.c.getX());
                    else result.setX(this.d.getX());

        if (this.a.getY() < this.b.getY())
        if (this.a.getY() < this.c.getY())
        if (this.a.getY() < this.d.getY())
        result.setY(this.a.getY());
                    else result.setY(this.d.getY());
                else if (this.c.getY() < this.d.getY())
        result.setY(this.c.getY());
                    else result.setY(this.d.getY());
        else if (this.b.getY() < this.c.getY())
        if (this.b.getY() < this.d.getY())
        result.setY(this.b.getY());
                else result.setY(this.d.getY());
             else if (this.c.getY() < this.d.getY())
        result.setY(this.c.getY());
                    else result.setY(this.d.getY());
        return result;
    }
}
