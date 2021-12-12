package jo.zohour_zo3bi.android_app_developer.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    private RecyclerView songsRecyclerView;
    // An array list to store the available songs of a particular singer
    private ArrayList<Song> songsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        songsRecyclerView = findViewById(R.id.songs_recycler_view);

        // Set a linear layout manager to position the items
        LinearLayoutManager manager = new LinearLayoutManager(this);
        songsRecyclerView.setLayoutManager(manager);

        // Create the songs list depending on the chosen singer
        createSongsList();

        // Create an adapter to pass songs list items
        // & attach it to the recycler view to populate those items
        SongsAdapter adapter = new SongsAdapter(this, songsList);
        songsRecyclerView.setAdapter(adapter);
    }//end onCreate()

    /**
     * Create the list of songs depending on which singer was chosen in the previous activity
     *
     * @return songsList
     */
    private ArrayList<Song> createSongsList() {
        Intent intent = getIntent();
        String singerName = intent.getStringExtra("SINGER_NAME");
        switch (singerName) {
            case "Singer 1":
                this.setTitle("Songs. " + singerName);
                for (int i = 0; i < 10; i++) {
                    songsList.add(new Song("Song " + (i + 1), singerName));
                }//end for
                break;
            case "Singer 2":
                this.setTitle("Songs. " + singerName);
                for (int i = 0; i < 5; i++) {
                    songsList.add(new Song("Song " + (i + 1), singerName));
                }//end for
                break;
            case "Singer 3":
                this.setTitle("Songs. " + singerName);
                for (int i = 0; i < 20; i++) {
                    songsList.add(new Song("Song " + (i + 1), singerName));
                }//end for
                break;
        }//end switch
        return songsList;
    }//end createSongsList()
}//end SongsActivity class
