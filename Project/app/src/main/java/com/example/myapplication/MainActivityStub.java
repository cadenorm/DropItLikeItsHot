package com.example.myapplication;


public class MainActivityStub {

    static boolean blockInMotion = false;
    Piece blockType = Piece.J;

    public int[][] createJBlock() {
        int [][] gridFill = new int [7][9];
        gridFill[3][8] = 1;
        gridFill[3][7] = 1;
        gridFill[3][6] = 1;
        gridFill[3][5] = 1;

        return gridFill;
    }


    public int [][] moveBlockDown(int [][] gridFill){
        if(blockType.toString() == "J"){
            //check if bottom cell:
            for(int i = 0; i < 7; i++){
                if(gridFill[i][0] == 1){
                    lockBlockPosition(gridFill);
                    blockInMotion = false;
                    return gridFill;
                }
            }
            //check if hit block:
            for(int x = 0; x < 7; x++){
                for(int y = 1; y < 9; y++){
                    if(gridFill[x][y] == 1 && gridFill[x][y - 1] == 2){
                        lockBlockPosition(gridFill);
                        blockInMotion = false;
                        return gridFill;
                    }
                }
            }
        }
        for(int x = 1; x < 8; x++){
            for(int y = 2; y < 10; y++) {

                //Log.d("test", "test:" + x + ":" + y + "--" + gridFill[x - 1][y - 1]);
                if(gridFill[x - 1][y - 1] != 1) continue;
                //Log.d("test", "" + "b" + x + y)
                gridFill[x - 1][y - 1] = 0;
                gridFill[x - 1][y - 2] = 1;
            }
        }
        return gridFill;
    }
    int [][] moveBlockLeft(int [][] gridFill){
        for(int x = 1; x < 7; x++){
            for(int y = 0; y < 9; y++){
                if(gridFill[x][y] == 1){
                    if(gridFill[x - 1][y] == 2) return gridFill;
                    gridFill[x][y] = 0;
                    gridFill[x - 1][y] = 1;
                }
            }
        }
        return gridFill;
    }

    int [][] moveBlockRight(int [][] gridFill){
        for(int x = 5; x >= 0; x--){
            for(int y = 0; y < 9; y++){
                if(gridFill[x][y] == 1){
                    if(gridFill[x + 1][y] == 2) return gridFill;
                    gridFill[x][y] = 0;
                    gridFill[x + 1][y] = 1;
                }
            }
        }
        return gridFill;
    }

    int [][] lockBlockPosition(int [][] gridFill){
        for(int x = 0; x < 7; x++){
            for(int y = 0; y < 9; y++){
                if(gridFill[x][y] == 1){
                    gridFill[x][y] = 2;
                }
            }
        }
        return gridFill;
    }


}