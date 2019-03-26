package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    //private static final long DELAY =  3000;//延迟三秒
   // private TimerTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        //设置定时器，一段时间（3秒）后页面自动跳转
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run(){
                Intent localIntent=new Intent(MainActivity.this,Main2Activity.class);//你要转向的Activity
                startActivity(localIntent);//执行
            }
        };
        timer.schedule(task,DELAY);
*/
    }

    public void clickStart(View view)
    {
        Intent localIntent=new Intent(MainActivity.this,Main2Activity.class);//你要转向的Activity
        startActivity(localIntent);//执行
        finish();
    }

    public void clickExit(View view)
    {
        //弹出对话框，询问是否退出程序
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure to quit？");
        dialog.setPositiveButton("OK",click1);
        dialog.setNegativeButton("Cancle",click2);
        AlertDialog Dialog=dialog.create();
        Dialog.show();
        //finish();
        //android.os.Process.killProcess(android.os.Process.myPid());
        //System.exit(0);
    }

    private DialogInterface.OnClickListener click2 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();//取消操作
        }
    };

    private DialogInterface.OnClickListener click1 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            finish();
            //android.os.Process.killProcess(android.os.Process.myPid());//点击确定后，执行退出
            //System.exit(0);
        }
    };
}
