package com.example.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;


public class Main4Activity extends BaseActivity{


    private TextView getTime1;
    private TextView getTime2;
    private TextView getTime3;
    private TextView getTime4;
    private Calendar calendar;// 用来装日期的
    private DatePickerDialog dialog;//选择日期的对话框


    @Override




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        WriteToFiles file = new WriteToFiles();
        TextView textproj1=findViewById(R.id.textProj1);
        textproj1.setText(file.readFiles("fileProj1.txt"));
        TextView textDaysProj1=findViewById(R.id.textDaysProj1);
        textDaysProj1.setText(file.readFiles("fileDaysProj1.txt"));

        TextView textproj2=findViewById(R.id.textProj2);
        textproj2.setText(file.readFiles("fileProj2.txt"));
        TextView textDaysProj2=findViewById(R.id.textDaysProj2);
        textDaysProj2.setText(file.readFiles("fileDaysProj2.txt"));

        TextView textproj3=findViewById(R.id.textProj3);
        textproj3.setText(file.readFiles("fileProj3.txt"));
        TextView textDaysProj3=findViewById(R.id.textDaysProj3);
        textDaysProj3.setText(file.readFiles("fileDaysProj3.txt"));

        TextView textproj4=findViewById(R.id.textProj4);
        textproj4.setText(file.readFiles("fileProj4.txt"));
        TextView textDaysProj4=findViewById(R.id.textDaysProj4);
        textDaysProj4.setText(file.readFiles("fileDaysProj4.txt"));


    }

    public void creatCalender1(){
        calendar = Calendar.getInstance();
        getTime1 = (TextView) findViewById(R.id.textDaysProj1);
        getTime1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dialog = new DatePickerDialog(Main4Activity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                monthOfYear=monthOfYear+1;
                                System.out.println("Year-->" + year + "Month-->"
                                        + monthOfYear + "Day-->" + dayOfMonth);
                                getTime1.setText(year + "/" + monthOfYear + "/"
                                        + dayOfMonth);
                                WriteToFiles fileDaysProj1 = new WriteToFiles();

                                fileDaysProj1.createFile("fileDaysProj1.txt");
                                fileDaysProj1.crFilewriteData(year + "/" + monthOfYear + "/"
                                        + dayOfMonth,"fileDaysProj1.txt");
                                getTime1.setText(fileDaysProj1.readFiles("fileDaysProj1.txt"));
                            }
                        }, calendar.get(Calendar.YEAR), calendar
                        .get(Calendar.MONTH), calendar
                        .get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
    }

    public void creatCalender2(){
        calendar = Calendar.getInstance();
        getTime2 = (TextView) findViewById(R.id.textDaysProj2);
        getTime2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dialog = new DatePickerDialog(Main4Activity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                monthOfYear=monthOfYear+1;
                                System.out.println("Year-->" + year + "Month-->"
                                        + monthOfYear + "Day-->" + dayOfMonth);
                                getTime2.setText(year + "/" + monthOfYear + "/"
                                        + dayOfMonth);
                                WriteToFiles fileDaysProj2 = new WriteToFiles();

                                fileDaysProj2.createFile("fileDaysProj2.txt");
                                fileDaysProj2.crFilewriteData(year + "/" + monthOfYear + "/"
                                        + dayOfMonth,"fileDaysProj2.txt");
                                getTime2.setText(fileDaysProj2.readFiles("fileDaysProj2.txt"));
                            }
                        }, calendar.get(Calendar.YEAR), calendar
                        .get(Calendar.MONTH), calendar
                        .get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
    }

    public void creatCalender3(){
        calendar = Calendar.getInstance();
        getTime3 = (TextView) findViewById(R.id.textDaysProj3);
        getTime3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dialog = new DatePickerDialog(Main4Activity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                monthOfYear=monthOfYear+1;
                                System.out.println("Year-->" + year + "Month-->"
                                        + monthOfYear + "Day-->" + dayOfMonth);
                                getTime3.setText(year + "/" + monthOfYear + "/"
                                        + dayOfMonth);
                                WriteToFiles fileDaysProj3 = new WriteToFiles();

                                fileDaysProj3.createFile("fileDaysProj3.txt");
                                fileDaysProj3.crFilewriteData(year + "/" + monthOfYear + "/"
                                        + dayOfMonth,"fileDaysProj3.txt");
                                getTime3.setText(fileDaysProj3.readFiles("fileDaysProj3.txt"));
                            }
                        }, calendar.get(Calendar.YEAR), calendar
                        .get(Calendar.MONTH), calendar
                        .get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
    }

    public void creatCalender4(){
        calendar = Calendar.getInstance();
        getTime4 = (TextView) findViewById(R.id.textDaysProj4);
        getTime4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dialog = new DatePickerDialog(Main4Activity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                monthOfYear=monthOfYear+1;
                                System.out.println("Year-->" + year + "Month-->"
                                        + monthOfYear + "Day-->" + dayOfMonth);
                                getTime4.setText(year + "/" + monthOfYear + "/"
                                        + dayOfMonth);
                                WriteToFiles fileDaysProj4 = new WriteToFiles();

                                fileDaysProj4.createFile("fileDaysProj4.txt");
                                fileDaysProj4.crFilewriteData(year + "/" + monthOfYear + "/"
                                        + dayOfMonth,"fileDaysProj4.txt");
                                getTime4.setText(fileDaysProj4.readFiles("fileDaysProj4.txt"));
                            }
                        }, calendar.get(Calendar.YEAR), calendar
                        .get(Calendar.MONTH), calendar
                        .get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
    }


/*
*  calendar.get(Calendar.YEAR), calendar
                        .get(Calendar.MONTH), calendar
                        .get(Calendar.DAY_OF_MONTH));,calendar.get(Calendar.DATE)
* */



    /**
     * 获取两个日期之间的间隔天数
     * @return
     */
    public static int getGapCount(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
    }





    public void clickBack3(View view)
    {
        Intent localIntent=new Intent(Main4Activity.this,Main3Activity.class);//你要转向的Activity
        startActivity(localIntent);//执行
        finish();
    }

    public void clickBgBack3(View view)
    {
        Intent localIntent=new Intent(Main4Activity.this,MainActivity.class);//你要转向的Activity
        startActivity(localIntent);//执行
        finish();
    }

    public void clickNext3(View view)
    {
        Intent localIntent=new Intent(Main4Activity.this,WeatherActivity.class);//你要转向的Activity
        startActivity(localIntent);//执行
        finish();
    }

    public void clickAddProj1(View view)
    {
        final EditText et = new EditText(this);

        new AlertDialog.Builder(this).setTitle("Input")
                .setView(et)
                .setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String inputProject = et.getText().toString();
                        if (inputProject.equals("")) {
                            Toast.makeText(getApplicationContext(), "Please make sure not blank!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            WriteToFiles fileProj1 = new WriteToFiles();
                            TextView textproj1=findViewById(R.id.textProj1);
                            fileProj1.createFolder();
                            fileProj1.createFile("fileProj1.txt");
                            fileProj1.crFilewriteData(inputProject,"fileProj1.txt");
                            textproj1.setText(fileProj1.readFiles("fileProj1.txt"));
                            creatCalender1();
                        }
                    }
                })
                .setNegativeButton("cancle", null)
                .show();

    }

    public void clickAddProj2(View view)
    {
        final EditText et = new EditText(this);

        new AlertDialog.Builder(this).setTitle("Input")
                .setView(et)
                .setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String inputProject = et.getText().toString();
                        if (inputProject.equals("")) {
                            Toast.makeText(getApplicationContext(), "Please make sure not blank!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            WriteToFiles fileProj2 = new WriteToFiles();
                            TextView textproj2=findViewById(R.id.textProj2);
                            fileProj2.createFolder();
                            fileProj2.createFile("fileProj2.txt");
                            fileProj2.crFilewriteData(inputProject,"fileProj2.txt");
                            textproj2.setText(fileProj2.readFiles("fileProj2.txt"));
                            creatCalender2();
                        }
                    }
                })
                .setNegativeButton("cancle", null)
                .show();

    }

    public void clickAddProj3(View view)
    {
        final EditText et = new EditText(this);

        new AlertDialog.Builder(this).setTitle("Input")
                .setView(et)
                .setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String inputProject = et.getText().toString();
                        if (inputProject.equals("")) {
                            Toast.makeText(getApplicationContext(), "Please make sure not blank!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            WriteToFiles fileProj3 = new WriteToFiles();
                            TextView textproj3=findViewById(R.id.textProj3);
                            fileProj3.createFolder();
                            fileProj3.createFile("fileProj3.txt");
                            fileProj3.crFilewriteData(inputProject,"fileProj3.txt");
                            textproj3.setText(fileProj3.readFiles("fileProj3.txt"));
                            creatCalender3();
                        }
                    }
                })
                .setNegativeButton("cancle", null)
                .show();

    }

    public void clickAddProj4(View view)
    {
        final EditText et = new EditText(this);

        new AlertDialog.Builder(this).setTitle("Input")
                .setView(et)
                .setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String inputProject = et.getText().toString();
                        if (inputProject.equals("")) {
                            Toast.makeText(getApplicationContext(), "Please make sure not blank!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            WriteToFiles fileProj4 = new WriteToFiles();
                            TextView textproj4=findViewById(R.id.textProj4);
                            fileProj4.createFolder();
                            fileProj4.createFile("fileProj4.txt");
                            fileProj4.crFilewriteData(inputProject,"fileProj4.txt");
                            textproj4.setText(fileProj4.readFiles("fileProj4.txt"));
                            creatCalender4();
                        }
                    }
                })
                .setNegativeButton("cancle", null)
                .show();

    }

    public void clickDelProj1(View view){
        WriteToFiles fileProj1 = new WriteToFiles();
        TextView textproj1=findViewById(R.id.textProj1);
        fileProj1.crFilewriteData("","fileProj1.txt");
        textproj1.setText(fileProj1.readFiles("fileProj1.txt"));

        WriteToFiles fileDaysProj1 = new WriteToFiles();
        TextView textDaysProj1=findViewById(R.id.textDaysProj1);
        fileDaysProj1.crFilewriteData("----/--/--","fileDaysProj1.txt");
        textDaysProj1.setText(fileDaysProj1.readFiles("fileDaysProj1.txt"));

    }
    public void clickDelProj2(View view){
        WriteToFiles fileProj2 = new WriteToFiles();
        TextView textproj2=findViewById(R.id.textProj2);
        fileProj2.crFilewriteData("","fileProj2.txt");
        textproj2.setText(fileProj2.readFiles("fileProj2.txt"));

        WriteToFiles fileDaysProj2 = new WriteToFiles();
        TextView textDaysProj2=findViewById(R.id.textDaysProj2);
        fileDaysProj2.crFilewriteData("----/--/--","fileDaysProj2.txt");
        textDaysProj2.setText(fileDaysProj2.readFiles("fileDaysProj2.txt"));

    }
    public void clickDelProj3(View view){
        WriteToFiles fileProj3 = new WriteToFiles();
        TextView textproj3=findViewById(R.id.textProj3);
        fileProj3.crFilewriteData("","fileProj3.txt");
        textproj3.setText(fileProj3.readFiles("fileProj3.txt"));

        WriteToFiles fileDaysProj3 = new WriteToFiles();
        TextView textDaysProj3=findViewById(R.id.textDaysProj3);
        fileDaysProj3.crFilewriteData("----/--/--","fileDaysProj3.txt");
        textDaysProj3.setText(fileDaysProj3.readFiles("fileDaysProj3.txt"));

    }
    public void clickDelProj4(View view){
        WriteToFiles fileProj4 = new WriteToFiles();
        TextView textproj4=findViewById(R.id.textProj4);
        fileProj4.crFilewriteData("","fileProj4.txt");
        textproj4.setText(fileProj4.readFiles("fileProj4.txt"));

        WriteToFiles fileDaysProj4 = new WriteToFiles();
        TextView textDaysProj4=findViewById(R.id.textDaysProj4);
        fileDaysProj4.crFilewriteData("----/--/--","fileDaysProj4.txt");
        textDaysProj4.setText(fileDaysProj4.readFiles("fileDaysProj4.txt"));

    }

}


