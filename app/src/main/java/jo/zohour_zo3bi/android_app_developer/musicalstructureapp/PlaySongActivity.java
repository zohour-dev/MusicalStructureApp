package jo.zohour_zo3bi.android_app_developer.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PlaySongActivity extends AppCompatActivity {

    private TextView songNameTextView;
    private TextView singerNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        songNameTextView = findViewById(R.id.play_activity_song_name_text_view);
        singerNameTextView = findViewById(R.id.play_activity_singer_name_text_view);

        // Get the intent sent from the previous activity and retrieve the name
        // of the selected song and it's singer
        Intent songIntent = getIntent();
        String songName = songIntent.getStringExtra("SONG_NAME");
        String singerName = songIntent.getStringExtra("SINGER_NAME");

        songNameTextView.setText(songName);
        singerNameTextView.setText(singerName);
    }//end onCreate()
}//end PlaySongActivity class
