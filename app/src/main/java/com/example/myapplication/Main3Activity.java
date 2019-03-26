package com.example.myapplication;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.IOException;


public class Main3Activity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView time=findViewById(R.id.textTime3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd   HH:mm");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        time.setText(simpleDateFormat.format(date));
        WriteToFiles file = new WriteToFiles();
        TextView textMor=findViewById(R.id.textMor);
        textMor.setText(file.readFiles("fileMor.txt"));
        TextView textNoon=findViewById(R.id.textNoon);
        textNoon.setText(file.readFiles("fileNoon.txt"));
        TextView textEve=findViewById(R.id.textEve);
        textEve.setText(file.readFiles("fileEve.txt"));
    }

    private void requestPermission(){
        requestRunTimePermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}
                , new PermissionListener() {
                    @Override
                    public void onGranted() {  //所有权限授权成功
                    }

                    @Override
                    public void onGranted(List<String> grantedPermission) { //授权失败权限集合
                    }

                    @Override
                    public void onDenied(List<String> deniedPermission) { //授权成功权限集合
                    }
                });
    }


    public void clickadd31(View view)
    {
        final EditText et = new EditText(this);

        new AlertDialog.Builder(this).setTitle("Input")
                .setView(et)
                .setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String inputMor = et.getText().toString();
                        if (inputMor.equals("")) {
                            Toast.makeText(getApplicationContext(), "Please make sure not blank!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            WriteToFiles fileMor = new WriteToFiles();
                            TextView textMor=findViewById(R.id.textMor);

                            fileMor.createFolder();
                            fileMor.createFile("fileMor.txt");
                            fileMor.crFilewriteData(inputMor,"fileMor.txt");
                            textMor.setText(fileMor.readFiles("fileMor.txt"));
                        }
                    }
                })
                .setNegativeButton("cancle", null)
                .show();

    }

    public void clickadd32(View view)
    {
        final EditText et = new EditText(this);

        new AlertDialog.Builder(this).setTitle("Input")
                .setView(et)
                .setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String inputNoon = et.getText().toString();
                        if (inputNoon.equals("")) {
                            Toast.makeText(getApplicationContext(), "Please make sure not blank!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            WriteToFiles fileNoon = new WriteToFiles();
                            TextView textNoon=findViewById(R.id.textNoon);

                            fileNoon.createFolder();
                            fileNoon.createFile("fileNoon.txt");
                            fileNoon.crFilewriteData(inputNoon,"fileNoon.txt");
                            textNoon.setText(fileNoon.readFiles("fileNoon.txt"));
                        }
                    }
                })
                .setNegativeButton("cancle", null)
                .show();

    }

    public void clickadd33(View view)
    {
        final EditText et = new EditText(this);

        new AlertDialog.Builder(this).setTitle("Input")
                .setView(et)
                .setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String inputEve = et.getText().toString();
                        if (inputEve.equals("")) {
                            Toast.makeText(getApplicationContext(), "Please make sure not blank!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            WriteToFiles fileEve = new WriteToFiles();
                            TextView textEve=findViewById(R.id.textEve);

                            fileEve.createFolder();
                            fileEve.createFile("fileEve.txt");
                            fileEve.crFilewriteData(inputEve,"fileEve.txt");
                            textEve.setText(fileEve.readFiles("fileEve.txt"));
                        }
                    }
                })
                .setNegativeButton("cancle", null)
                .show();

    }

    public void clickbgBack3(View view)
    {
        Intent localIntent=new Intent(Main3Activity.this,MainActivity.class);//你要转向的Activity
        startActivity(localIntent);//执行
        finish();
    }

    public void clickBack2(View view)
    {
        Intent localIntent=new Intent(Main3Activity.this,Main2Activity.class);//你要转向的Activity
        startActivity(localIntent);//执行
        finish();
    }

    public void clickNext2(View view)
    {
        Intent localIntent=new Intent(Main3Activity.this,Main4Activity.class);//你要转向的Activity
        startActivity(localIntent);//执行
        finish();
    }

    public void clickDelMor(View view)
    {
        WriteToFiles fileMor = new WriteToFiles();
        TextView textMor=findViewById(R.id.textMor);
        fileMor.crFilewriteData("","fileMor.txt");
        textMor.setText(fileMor.readFiles("fileMor.txt"));
    }
    public void clickDelNoon(View view)
    {
        WriteToFiles fileNoon = new WriteToFiles();
        TextView textNoon=findViewById(R.id.textNoon);
        fileNoon.crFilewriteData("","fileNoon.txt");
        textNoon.setText(fileNoon.readFiles("fileNoon.txt"));
    }
    public void clickDelEve(View view)
    {
        WriteToFiles fileEve = new WriteToFiles();
        TextView textEve=findViewById(R.id.textEve);
        fileEve.crFilewriteData("","fileEve.txt");
        textEve.setText(fileEve.readFiles("fileEve.txt"));
    }

}
