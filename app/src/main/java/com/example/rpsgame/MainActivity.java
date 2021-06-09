package com.example.rpsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.example.rpsgame.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String n1,n2;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Context context;
        dialog=new Dialog(this);
        binding.Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.human.setImageResource(R.drawable.rock_hand);
                n1="Rock";
                display();
                result();
            }
        });
        binding.Paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.human.setImageResource(R.drawable.paper_hand);
                n1="Paper";
                display();
                result();
            }
        });
        binding.Scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.human.setImageResource(R.drawable.scissor_hand);
                n1="Scissor";
                display();
                result();
            }
        });
    }
    public void display(){
        Random rnd = new Random();
        int n=rnd.nextInt(3);
        if(n==0){
            n2="Rock";
            binding.robot.setImageResource(R.drawable.rock_hand);
            binding.robot.setRotation(180);
        }else if (n==1){
            n2="Paper";
            binding.robot.setImageResource(R.drawable.paper_hand);
            binding.robot.setRotation(180);
        }else if (n==2){
            n2="Scissor";
            binding.robot.setImageResource(R.drawable.scissor_hand);
            binding.robot.setRotation(180);
        }
    }
    public void result(){
       if (n1.equals(n2)){
           //Here user and robot is same value so u can tie.
           new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   showtiedialog();
               }
           },1000);

       }else if (n1.equals("Rock") && n2.equals("Scissor") || n1.equals("Paper") && n2.equals("Rock") || n1.equals("Scissor") && n2.equals("Paper")){
           new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   showwindialog();
               }
           },1000);
       }else{
           new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   showlossdialog();
               }
           },1000);
       }
    }

    private void showlossdialog() {
        dialog.setContentView(R.layout.loss_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView close=dialog.findViewById(R.id.close);
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Reset();
            }
        });
    }

    private void showwindialog() {
        dialog.setContentView(R.layout.win_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView close=dialog.findViewById(R.id.close);
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Reset();
            }
        });
    }

    private void showtiedialog() {
        dialog.setContentView(R.layout.tie_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView close=dialog.findViewById(R.id.close);
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Reset();
            }
        });
    }
    private void Reset(){
        binding.human.setImageResource(R.drawable.human);
        binding.robot.setImageResource(R.drawable.robot);
        binding.robot.setRotation(0);
    }
}