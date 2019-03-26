package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;


public class WriteToFiles extends BaseActivity{

    public void createFolder() {

        //BaseActivity.PermissionListener();
        try{
            //新建一个File，传入文件夹目录
            File file = new File(Environment.getExternalStoragePublicDirectory("Schedule")+"");
            //File file = new File("/storage/emulated/0/Schedule");
            //判断文件夹是否存在，如果不存在就创建，否则不创建
            if (!file.exists()) {
                //通过file的mkdirs()方法创建目录中包含却不存在的文件夹
                file.mkdirs();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createFile(String filename){

        try {
            //传入路径 + 文件名
            File mFile = new File(Environment.getExternalStoragePublicDirectory("Schedule")+filename);
            //File mFile = new File("/storage/emulated/0/Schedule/test.txt");
            //判断文件是否存在，存在就删除
            if (!mFile.exists()){
                //mFile.delete();
                // 创建文件
                mFile.createNewFile();
            }

            //给一个吐司提示，提示创建成功
            //Toast.makeText(getApplicationContext(), "文件写入成功", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 创建文件 写入文件内容
    public void crFilewriteData(String files,String filename){

        try {
            File saveFile = new File(Environment.getExternalStoragePublicDirectory("Schedule")+"", filename);
            //File saveFile = new File("/storage/emulated/0/Schedule", "test.txt");
            FileOutputStream outStream = null;
            outStream = new FileOutputStream(saveFile);
            outStream.write(files.getBytes());
            outStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //定义读取文件的方法:
    public String readFiles(String filename) {
        StringBuilder sb = new StringBuilder("");
        try{
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                filename = Environment.getExternalStoragePublicDirectory("Schedule")+  "/" + filename;
                //打开文件输入流
                FileInputStream input = new FileInputStream(filename);
                byte[] temp = new byte[1024];

                int len = 0;
                //读取文件内容:
                while ((len = input.read(temp)) > 0) {
                    sb.append(new String(temp, 0, len));
                }
                //关闭输入流
                input.close();

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
