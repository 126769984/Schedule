package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        TextView time=findViewById(R.id.textTime2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd   HH:mm");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        time.setText(simpleDateFormat.format(date));
    }

    public void clickbgBack2(View view)
    {

        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void  clickNext2(View view)
    {

        Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(intent);
        finish();
    }
}
