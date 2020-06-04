package tw.org.httpimagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy =  new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy( policy);

        URL url = null;
        try {
            url = new URL("https://media.nownews.com/nn_media/thumbnail/2020/05/1589871384988-2e73659aaf0440b1bb47ddb240ac7b7b-696x869.jpg?unShow=false");
            URLConnection conn=url.openConnection();
            InputStream streamIn=conn.getInputStream();


            Bitmap pic = BitmapFactory.decodeStream(streamIn);

            ImageView img =findViewById(R.id.imageHttp);
            img.setImageBitmap(pic);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
