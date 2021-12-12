package jo.zohour_zo3bi.android_app_developer.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView firstSingerTextView;
    private TextView secondSingerTextView;
    private TextView thirdSingerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstSingerTextView = findViewById(R.id.first_singer_text_view);
        secondSingerTextView = findViewById(R.id.second_singer_text_view);
        thirdSingerTextView = findViewById(R.id.third_singer_text_view);

        // Set the listener for clicks applied over the name text views of the available singers
        firstSingerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongsActivity.class);
                intent.putExtra("SINGER_NAME", firstSingerTextView.getText().toString());
                startActivity(intent);
            }//end onClick()
        });

        secondSingerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongsActivity.class);
                intent.putExtra("SINGER_NAME", secondSingerTextView.getText().toString());
                startActivity(intent);
            }//end onClick()
        });

        thirdSingerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongsActivity.class);
                intent.putExtra("SINGER_NAME", thirdSingerTextView.getText().toString());
                startActivity(intent);
            }//end onClick()
        });
    }//end onCreate()
}//end MainActivity
