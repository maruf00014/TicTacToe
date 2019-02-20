package com.maruf.game.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;

public class tttActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    TextView resultText,turnText;
    ImageView resultImage;
    LinearLayout playground;
    int turn;
     public void checkGame(){
        if(checkWinner(b1,b2,b3));
        else if(checkWinner(b4,b5,b6));
        else if(checkWinner(b7,b8,b9));
        else if(checkWinner(b1,b4,b7));
        else if(checkWinner(b2,b5,b8));
        else if(checkWinner(b3,b6,b9));
        else if(checkWinner(b1,b5,b9));
        else if(checkWinner(b3,b5,b7));
    }

    public boolean checkWinner(Button b1,Button b2,Button b3){
        if (b1.getText()==b2.getText().toString() && b2.getText().toString()==b3.getText().toString() && b3.getText().toString()=="X"){
            b1.setBackgroundResource(android.R.color.black);
            b2.setBackgroundResource(android.R.color.black);
            b3.setBackgroundResource(android.R.color.black);
            b1.setTextColor(getResources().getColor(R.color.white));
            b2.setTextColor(getResources().getColor(R.color.white));
            b3.setTextColor(getResources().getColor(R.color.white));

            View pg = findViewById(R.id.playground);
            setContentView(R.layout.activity_result);
            resultText = (TextView) findViewById(R.id.resultText);
            resultText.setText(" X is winner !");

            resultImage = (ImageView) findViewById(R.id.resultImage);
            resultImage.setImageBitmap(createBitmapFromView(pg));

            return true;

        }
        if (b1.getText()==b2.getText().toString() && b2.getText().toString()==b3.getText().toString() && b3.getText().toString()=="O"){

            b1.setBackgroundResource(android.R.color.black);
            b2.setBackgroundResource(android.R.color.black);
            b3.setBackgroundResource(android.R.color.black);
            b1.setTextColor(getResources().getColor(R.color.white));
            b2.setTextColor(getResources().getColor(R.color.white));
            b3.setTextColor(getResources().getColor(R.color.white));



            View pg = findViewById(R.id.playground);
            setContentView(R.layout.activity_result);
            resultText = (TextView) findViewById(R.id.resultText);
            resultText.setText(" O is winner !");

            resultImage = (ImageView) findViewById(R.id.resultImage);
            resultImage.setImageBitmap(createBitmapFromView(pg));

            return true;
        }
         return false;
    }
    public void reset(View view){
        turn =1;
        b1.setBackgroundResource(android.R.drawable.btn_default);
        b2.setBackgroundResource(android.R.drawable.btn_default);
        b3.setBackgroundResource(android.R.drawable.btn_default);
        b4.setBackgroundResource(android.R.drawable.btn_default);
        b5.setBackgroundResource(android.R.drawable.btn_default);
        b6.setBackgroundResource(android.R.drawable.btn_default);
        b7.setBackgroundResource(android.R.drawable.btn_default);
        b8.setBackgroundResource(android.R.drawable.btn_default);
        b9.setBackgroundResource(android.R.drawable.btn_default);
        b1.setTextColor(getResources().getColor(R.color.colorAccent));
        b2.setTextColor(getResources().getColor(R.color.colorAccent));
        b3.setTextColor(getResources().getColor(R.color.colorAccent));
        b4.setTextColor(getResources().getColor(R.color.colorAccent));
        b5.setTextColor(getResources().getColor(R.color.colorAccent));
        b6.setTextColor(getResources().getColor(R.color.colorAccent));
        b7.setTextColor(getResources().getColor(R.color.colorAccent));
        b8.setTextColor(getResources().getColor(R.color.colorAccent));
        b9.setTextColor(getResources().getColor(R.color.colorAccent));
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        turnText.setText("---- X player turn ----");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void start(View view){
        setContentView(R.layout.activity_ttt);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3);
        b4=(Button) findViewById(R.id.b4);
        b5=(Button) findViewById(R.id.b5);
        b6=(Button) findViewById(R.id.b6);
        b7=(Button) findViewById(R.id.b7);
        b8=(Button) findViewById(R.id.b8);
        b9=(Button) findViewById(R.id.b9);

        playground =(LinearLayout) findViewById(R.id.playground);
        turnText = (TextView) findViewById(R.id.turnTextView);

        b1.setBackgroundResource(android.R.drawable.btn_default);
        b2.setBackgroundResource(android.R.drawable.btn_default);
        b3.setBackgroundResource(android.R.drawable.btn_default);
        b4.setBackgroundResource(android.R.drawable.btn_default);
        b5.setBackgroundResource(android.R.drawable.btn_default);
        b6.setBackgroundResource(android.R.drawable.btn_default);
        b7.setBackgroundResource(android.R.drawable.btn_default);
        b8.setBackgroundResource(android.R.drawable.btn_default);
        b9.setBackgroundResource(android.R.drawable.btn_default);


        turn=1;
        turnText.setText("---- X player turn ----");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b1.getText().toString().equals("")){
                    afterButtonClick(b1);
                }
                checkGame();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b2.getText().toString().equals("")){
                    afterButtonClick(b2);
                }
                checkGame();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b3.getText().toString().equals("")){
                    afterButtonClick(b3);
                }
                checkGame();
            }

        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b4.getText().toString().equals("")){
                    afterButtonClick(b4);
                }
                checkGame();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b5.getText().toString().equals("")){
                    afterButtonClick(b5);
                }
                checkGame();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b6.getText().toString().equals("")) {
                    afterButtonClick(b6);
                }
                checkGame();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b7.getText().toString().equals("")){
                    afterButtonClick(b7);
                }
                checkGame();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b8.getText().toString().equals("")){
                    afterButtonClick(b8);
                }
                checkGame();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b9.getText().toString().equals("")){
                    afterButtonClick(b9);
                }
                checkGame();
            }
        });
    }

    public void afterButtonClick(Button button){
        if (turn==1) {
            button.setText("X");
            turnText.setText("---- O player turn ----");
            turn = 2;
        }

        else if (turn==2) {
            button.setText("O");
            turnText.setText("---- X player turn ----");
            turn = 1;
        }
    }

    private Bitmap createBitmapFromView(View iv) {

        Bitmap bitmap = Bitmap.createBitmap(
                iv.getWidth(),
                iv.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        iv.draw(c);
        Bitmap finalbitmap = Bitmap.createScaledBitmap(bitmap, 320, 320, false);

        return finalbitmap;
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(tttActivity.this);
        dialog.setCancelable(false);
        dialog.setTitle("Quit?");
        dialog.setMessage("Are you sure you want to quit?" );
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        })
                .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        final AlertDialog alert = dialog.create();
        alert.show();



    }
}
