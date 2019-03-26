package com.example.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;



public class WeatherActivity extends BaseActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        new DownloadUpdate().execute();
    }


    private class DownloadUpdate extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String stringUrl = "http://t.weather.sojson.com/api/weather/city/101040100";
            HttpURLConnection urlConnection = null;
            BufferedReader reader;

            try {
                URL url = new URL(stringUrl);

                // Create the request to get the information from the server, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    Toast.makeText(getApplicationContext(),"Please link the Internet!",Toast.LENGTH_LONG).show();
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Mainly needed for debugging
                    Log.d("TAG", line);
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                //The temperature
                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
    protected void onPostExecute(String All) {
        //Update the temperature displayed
        try{
            JSONObject obj = new JSONObject(All);
            int result = obj.getInt("status");
            if (result == 200) {
                JSONObject cityInfo = obj.getJSONObject("cityInfo");
                JSONObject data = obj.getJSONObject("data");
                JSONArray forecastArray = data.getJSONArray("forecast");

                String date = obj.getString("time");
                String city = cityInfo.getString("city");
                String wendu = data.getString("wendu");

                String week[] = new String[6];
                String type[] = new String[6];

                for(int i=0;i<6;i++){
                    week[i] = forecastArray.getJSONObject(i).getString("week");
                    type[i] = forecastArray.getJSONObject(i).getString("type");
                }

                for(int i=0;i<6;i++){
                    switch (week[i]){
                        case "星期一":{week[i]="Monday";}break;
                        case "星期二":{week[i]="Tuesday";}break;
                        case "星期三":{week[i]="Wednesday";}break;
                        case "星期四":{week[i]="Thursday";}break;
                        case "星期五":{week[i]="Friday";}break;
                        case "星期六":{week[i]="Saturday";}break;
                        case "星期日":{week[i]="Sunday";}break;
                    }
                }

                String temHigh[] = new String[5];
                String temLow[] = new String[5];
                for(int i=0;i<5;i++){
                    temHigh[i] = forecastArray.getJSONObject(i).getString("high").substring(3);
                    temLow[i] = forecastArray.getJSONObject(i).getString("low").substring(3);
                }
                ((TextView) findViewById(R.id.textTimeWea)).setText(date);

                ((TextView) findViewById(R.id.textTodayT)).setText(wendu);
                ((TextView) findViewById(R.id.textDay1TH)).setText(temHigh[0]);
                ((TextView) findViewById(R.id.textDay1TL)).setText(temLow[0]);
                ((TextView) findViewById(R.id.textDay2TH)).setText(temHigh[1]);
                ((TextView) findViewById(R.id.textDay2TL)).setText(temLow[1]);
                ((TextView) findViewById(R.id.textDay3TH)).setText(temHigh[2]);
                ((TextView) findViewById(R.id.textDay3TL)).setText(temLow[2]);
                ((TextView) findViewById(R.id.textDay4TH)).setText(temHigh[3]);
                ((TextView) findViewById(R.id.textDay4TL)).setText(temLow[3]);
                ((TextView) findViewById(R.id.textDay5TH)).setText(temHigh[4]);
                ((TextView) findViewById(R.id.textDay5TL)).setText(temLow[4]);

                ((TextView) findViewById(R.id.textToday)).setText(week[0]);
                switch (type[0]){
                    case "晴" :{ ImageView imageview = (ImageView)findViewById(R.id.imageToday);
                        imageview.setImageResource(R.drawable.sunny_small); }break;
                    case "小雨" :{ImageView imageview = (ImageView)findViewById(R.id.imageToday);
                        imageview.setImageResource(R.drawable.rainy_small); }break;
                    case "多云" :{ImageView imageview = (ImageView)findViewById(R.id.imageToday);
                        imageview.setImageResource(R.drawable.partly_sunny_small); }break;
                    case "阴" :{ImageView imageview = (ImageView)findViewById(R.id.imageToday);
                        imageview.setImageResource(R.drawable.windy_small); }break;
                }

                ((TextView) findViewById(R.id.textDay1)).setText(week[1]);
                switch (type[1]){
                    case "晴" :{ ImageView imageview = (ImageView)findViewById(R.id.imageDay1);
                        imageview.setImageResource(R.drawable.sunny_small); }break;
                    case "小雨" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay1);
                        imageview.setImageResource(R.drawable.rainy_small); }break;
                    case "多云" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay1);
                        imageview.setImageResource(R.drawable.partly_sunny_small); }break;
                    case "阴" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay1);
                        imageview.setImageResource(R.drawable.windy_small); }break;
                }

                ((TextView) findViewById(R.id.textDay2)).setText(week[2]);
                switch (type[3]){
                    case "晴" :{ ImageView imageview = (ImageView)findViewById(R.id.imageDay2);
                        imageview.setImageResource(R.drawable.sunny_small); }break;
                    case "小雨" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay2);
                        imageview.setImageResource(R.drawable.rainy_small); }break;
                    case "多云" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay2);
                        imageview.setImageResource(R.drawable.partly_sunny_small); }break;
                    case "阴" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay2);
                        imageview.setImageResource(R.drawable.windy_small); }break;
                }

                ((TextView) findViewById(R.id.textDay3)).setText(week[3]);
                switch (type[3]){
                    case "晴" :{ ImageView imageview = (ImageView)findViewById(R.id.imageDay3);
                        imageview.setImageResource(R.drawable.sunny_small); }break;
                    case "小雨" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay3);
                        imageview.setImageResource(R.drawable.rainy_small); }break;
                    case "多云" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay3);
                        imageview.setImageResource(R.drawable.partly_sunny_small); }break;
                    case "阴" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay3);
                        imageview.setImageResource(R.drawable.windy_small); }break;
                }

                ((TextView) findViewById(R.id.textDay4)).setText(week[4]);
                switch (type[4]){
                    case "晴" :{ ImageView imageview = (ImageView)findViewById(R.id.imageDay4);
                        imageview.setImageResource(R.drawable.sunny_small); }break;
                    case "小雨" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay4);
                        imageview.setImageResource(R.drawable.rainy_small); }break;
                    case "多云" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay4);
                        imageview.setImageResource(R.drawable.partly_sunny_small); }break;
                    case "阴" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay4);
                        imageview.setImageResource(R.drawable.windy_small); }break;
                }

                ((TextView) findViewById(R.id.textDay5)).setText(week[5]);
                switch (type[4]){
                    case "晴" :{ ImageView imageview = (ImageView)findViewById(R.id.imageDay5);
                        imageview.setImageResource(R.drawable.sunny_small); }break;
                    case "小雨" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay5);
                        imageview.setImageResource(R.drawable.rainy_small); }break;
                    case "多云" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay5);
                        imageview.setImageResource(R.drawable.partly_sunny_small); }break;
                    case "阴" :{ImageView imageview = (ImageView)findViewById(R.id.imageDay5);
                        imageview.setImageResource(R.drawable.windy_small); }break;
                }

            }
        }catch(JSONException e){
            e.printStackTrace();
        }
    }
    }
    public void clickBackWea(View view)
    {
        Intent localIntent=new Intent(WeatherActivity.this,Main4Activity.class);//你要转向的Activity
        startActivity(localIntent);//执行
        finish();
    }

    public void clickBgBackWea(View view)
    {
        Intent localIntent=new Intent(WeatherActivity.this,MainActivity.class);//你要转向的Activity
        startActivity(localIntent);//执行
        finish();
    }

}
