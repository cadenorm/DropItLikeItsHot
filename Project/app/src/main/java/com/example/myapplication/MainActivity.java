package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public static boolean blockInMotion = false;
    public static int[][] gridFill = new int[7][9];
    public static Piece blockType;
    public static boolean gameOver;
    public TextView txt;
    public String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView2);
        Button startGameButton = findViewById(R.id.startButton);
        startGameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //textView.setText("Sorry, this button doesn't do anything yet!");
                setContentView(R.layout.game);

                Button leftButton = findViewById(R.id.leftButton);
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        moveBlockLeft();
                    }
                });

                Button rightButton = findViewById(R.id.rightButton);
                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        moveBlockRight();
                    }
                });

                runGame();
            }
        });
    }

    void runGame(){

        final Timer timer = new Timer();
        TimerTask nextStep = new TimerTask() {
            @Override
            public void run(){
                if(gridFill[3][8] == 2 || gridFill[3][7] == 2 || gridFill[3][6] == 2 || gridFill[3][5] == 2){
                    endGame(true);
                }
                if(gameOver){
                    timer.cancel();
                    txt = findViewById(R.id.textView3);
                    txt.post(new Runnable(){
                        public void run(){
                            txt.setText("GameOver");
                        }
                    });
                }
                if(blockInMotion){
                    moveBlockDown();
                }
                else{
                    createRandomBlock();
                }
            }
        };
        timer.scheduleAtFixedRate(nextStep, 1000, 2000);

    }

    void createRandomBlock(){
        createJBlock();
    }

    int getHighScore(int playerID){
        playerID = playerID % 6;
        int highScore = 0;
        switch (playerID){
            case 0:
                highScore = 100;
            case 1:
                highScore = 150;
            case 2:
                highScore = 575;
            case 3:
                highScore = 410;
            case 4:
                highScore = 90;
            default:
                highScore = 115;
        }
        send sendMsg = new send();
        message = String.valueOf(highScore);
        sendMsg.execute();
        return highScore;
    }

    void endGame(boolean end){
        gameOver = end;
        send sendMsg = new send();
        message = "Game Over!!";
        sendMsg.execute();
    }

    void createJBlock(){
        ImageView img = findViewById(R.id.b49);
        img.setColorFilter(Color.argb(255, 0, 255, 255));
        gridFill[3][8] = 1;
        img = findViewById(R.id.b48);
        img.setColorFilter(Color.argb(255, 0, 255, 255));
        gridFill[3][7] = 1;
        img = findViewById(R.id.b47);
        img.setColorFilter(Color.argb(255, 0, 255, 255));
        gridFill[3][6] = 1;
        img = findViewById(R.id.b46);
        img.setColorFilter(Color.argb(255, 0, 255, 255));
        gridFill[3][5] = 1;
        blockInMotion = true;
        blockType = Piece.J;
    }

    void moveBlockDown(){
        ImageView img;
        if(blockType.toString() == "J"){
            //check if bottom cell:
            for(int i = 0; i < 7; i++){
                if(gridFill[i][0] == 1){
                    lockBlockPosition();
                    blockInMotion = false;
                    return;
                }
            }
            //check if hit block:
            for(int x = 0; x < 7; x++){
                for(int y = 1; y < 9; y++){
                    if(gridFill[x][y] == 1 && gridFill[x][y - 1] == 2){
                        lockBlockPosition();
                        blockInMotion = false;
                        return;
                    }
                }
            }
        }
        for(int x = 1; x < 8; x++){
            for(int y = 2; y < 10; y++) {

                //Log.d("test", "test:" + x + ":" + y + "--" + gridFill[x - 1][y - 1]);
                if(gridFill[x - 1][y - 1] != 1) continue;
                //Log.d("test", "" + "b" + x + y);
                img = (ImageView) getBlockView("b" + x + y);
                img.setColorFilter(Color.argb(0, 0, 0, 0));
                gridFill[x - 1][y - 1] = 0;
                img = (ImageView) getBlockView("b" + x + (y - 1));
                img.setColorFilter(Color.argb(255, 0, 255, 255));
                gridFill[x - 1][y - 2] = 1;
            }
        }
    }

    void moveBlockLeft(){
        ImageView img;
        for(int x = 1; x < 7; x++){
            for(int y = 0; y < 9; y++){
                if(gridFill[x][y] == 1){
                    if(gridFill[x - 1][y] == 2) return;
                    img = (ImageView) getBlockView("b" + (x + 1) + (y + 1));
                    img.setColorFilter(Color.argb(0, 0, 0, 0));
                    gridFill[x][y] = 0;
                    img = (ImageView) getBlockView("b" + x + (y + 1));
                    img.setColorFilter(Color.argb(255, 0, 255, 255));
                    gridFill[x - 1][y] = 1;
                }
            }
        }
    }

    void moveBlockRight(){
        ImageView img;
        for(int x = 5; x >= 0; x--){
            for(int y = 0; y < 9; y++){
                if(gridFill[x][y] == 1){
                    if(gridFill[x + 1][y] == 2) return;
                    img = (ImageView) getBlockView("b" + (x + 1) + (y + 1));
                    img.setColorFilter(Color.argb(0, 0, 0, 0));
                    gridFill[x][y] = 0;
                    Log.d("test", "b" + (x + 2) + (y + 1));
                    img = (ImageView) getBlockView("b" + (x + 2) + (y + 1));
                    img.setColorFilter(Color.argb(255, 0, 255, 255));
                    gridFill[x + 1][y] = 1;
                }
            }
        }
    }

    void lockBlockPosition(){
        for(int x = 0; x < 7; x++){
            for(int y = 0; y < 9; y++){
                if(gridFill[x][y] == 1){
                    gridFill[x][y] = 2;
                }
            }
        }
    }

    View getBlockView(String str){
        switch (str){
            case "b11":
                return findViewById(R.id.b11);
            case "b12":
                return findViewById(R.id.b12);
            case "b13":
                return findViewById(R.id.b13);
            case "b14":
                return findViewById(R.id.b14);
            case "b15":
                return findViewById(R.id.b15);
            case "b16":
                return findViewById(R.id.b16);
            case "b17":
                return findViewById(R.id.b17);
            case "b18":
                return findViewById(R.id.b18);
            case "b19":
                return findViewById(R.id.b19);
            case "b21":
                return findViewById(R.id.b21);
            case "b22":
                return findViewById(R.id.b22);
            case "b23":
                return findViewById(R.id.b23);
            case "b24":
                return findViewById(R.id.b24);
            case "b25":
                return findViewById(R.id.b25);
            case "b26":
                return findViewById(R.id.b26);
            case "b27":
                return findViewById(R.id.b27);
            case "b28":
                return findViewById(R.id.b28);
            case "b29":
                return findViewById(R.id.b29);
            case "b31":
                return findViewById(R.id.b31);
            case "b32":
                return findViewById(R.id.b32);
            case "b33":
                return findViewById(R.id.b33);
            case "b34":
                return findViewById(R.id.b34);
            case "b35":
                return findViewById(R.id.b35);
            case "b36":
                return findViewById(R.id.b36);
            case "b37":
                return findViewById(R.id.b37);
            case "b38":
                return findViewById(R.id.b38);
            case "b39":
                return findViewById(R.id.b39);
            case "b41":
                return findViewById(R.id.b41);
            case "b42":
                return findViewById(R.id.b42);
            case "b43":
                return findViewById(R.id.b43);
            case "b44":
                return findViewById(R.id.b44);
            case "b45":
                return findViewById(R.id.b45);
            case "b46":
                return findViewById(R.id.b46);
            case "b47":
                return findViewById(R.id.b47);
            case "b48":
                return findViewById(R.id.b48);
            case "b49":
                return findViewById(R.id.b49);
            case "b51":
                return findViewById(R.id.b51);
            case "b52":
                return findViewById(R.id.b52);
            case "b53":
                return findViewById(R.id.b53);
            case "b54":
                return findViewById(R.id.b54);
            case "b55":
                return findViewById(R.id.b55);
            case "b56":
                return findViewById(R.id.b56);
            case "b57":
                return findViewById(R.id.b57);
            case "b58":
                return findViewById(R.id.b58);
            case "b59":
                return findViewById(R.id.b59);
            case "b61":
                return findViewById(R.id.b61);
            case "b62":
                return findViewById(R.id.b62);
            case "b63":
                return findViewById(R.id.b63);
            case "b64":
                return findViewById(R.id.b64);
            case "b65":
                return findViewById(R.id.b65);
            case "b66":
                return findViewById(R.id.b66);
            case "b67":
                return findViewById(R.id.b67);
            case "b68":
                return findViewById(R.id.b68);
            case "b69":
                return findViewById(R.id.b69);
            case "b71":
                return findViewById(R.id.b71);
            case "b72":
                return findViewById(R.id.b72);
            case "b73":
                return findViewById(R.id.b73);
            case "b74":
                return findViewById(R.id.b74);
            case "b75":
                return findViewById(R.id.b75);
            case "b76":
                return findViewById(R.id.b76);
            case "b77":
                return findViewById(R.id.b77);
            case "b78":
                return findViewById(R.id.b78);
            default:
                return findViewById(R.id.b79);
        }
    }

    // WEB SERVICE //
    //sends data to python server
    class send extends AsyncTask<Void,Void,Void> {
        Socket webService;
        PrintWriter pw;
        @Override
        protected Void doInBackground(Void...params){
            try {
                webService = new Socket("208.180.239.26",8000); //IP address should be for your machine and should match python server
                pw = new PrintWriter(webService.getOutputStream());
                pw.write(message);
                pw.flush();
                pw.close();
                webService.close();
            } catch (UnknownHostException e) {
                System.out.println("Fail");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Fail");
                e.printStackTrace();
            }
            return null;
        }
    }
}
