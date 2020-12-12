package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   boolean gameActive=true;
  int  activePlayer=0;
  int gameState[]={2,2,2,2,2,2,2,2,2};
  int winPosition[][]={{0,1,2},{3,4,5},{6,7,8},
                      {0,3,6},{1,4,7},{2,5,8},
          {0,4,8},{2,4,6}};
  public void tap(View view) {
      ImageView img = (ImageView) view;
      int tappedimg = Integer.parseInt(img.getTag().toString());
      if (!gameActive) {
          gameReset(view);
      }
      if (gameState[tappedimg] == 2) {
          gameState[tappedimg] = activePlayer;
          if (activePlayer == 0) {
              img.setImageResource(R.drawable.x);
              activePlayer = 1;
              TextView status = findViewById(R.id.status);
              status.setText("0's turn!");
          } else {
              img.setImageResource(R.drawable.o);
              activePlayer = 0;
              TextView status = findViewById(R.id.status);
              status.setText("x's turn!");
          }
      }
      for (int[] win : winPosition) {
          if (gameState[win[0]] == gameState[win[1]] && gameState[win[0]] == gameState[win[2]]&&gameState[win[1]] == gameState[win[2]] && gameState[win[0]] != 2) {
              String winnerstr;
              gameActive = false;
              if (gameState[win[0]] == 0) {

                  winnerstr = "x has won";
              } else {
                  winnerstr = "o has won";

              }
              TextView status = findViewById(R.id.status);
              status.setText(winnerstr);

          }

      }
  }
  public void reset(View view){
      gameReset(view);
  }
    public void gameReset(View view){
      activePlayer=0;
      gameActive=true;
      for(int i=0;i<gameState.length;i++){
          gameState[i]=2;
      }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("x's turn!");
  }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}