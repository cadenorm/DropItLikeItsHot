package com.example.myapplication;

//class to store coordinate system
public class Coordinate
{
    int x; int y;

    public Coordinate(int a,int b)
    {
        this.x = a;
        this.y = b;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}
