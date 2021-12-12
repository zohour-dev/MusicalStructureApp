package jo.zohour_zo3bi.android_app_developer.musicalstructureapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {
    private ArrayList<Song> songsList;
    private Context context;

    // Pass the songsList into the constructor
    public SongsAdapter(Context context, ArrayList<Song> songs) {
        this.songsList = songs;
        this.context = context;
    }//end constructor

    // Inflating an item layout from xml and returning a view holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the custom item layout
        View songView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        // Return a new view holder instance
        return new ViewHolder(context, songView);
    }//end onCreateViewHolder()

    // Populating data into the item view components through holder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Song song = songsList.get(position);

        TextView songNameTextView = holder.songName;
        songNameTextView.setText(song.getSongName());
    }//end onBindViewHolder

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return songsList.size();
    }//end getItemCount()

    // Provide a direct reference to each of the subviews within a view item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Define a variable for each subview in the view item (row)
        private TextView songName;
        private Context context;

        // Define a constructor
        public ViewHolder(Context context, View itemView) {
            super(itemView);
            // Find the subviews for each item view (row)
            this.songName = itemView.findViewById(R.id.song_name_text_view);
            this.context = context;
            // Make each item row clickable by using setOnClickListener
            itemView.setOnClickListener(this);
        }//end constructor

        // Set the action to be taken when an item view -which is the
        // selected song here- is clicked
        @Override
        public void onClick(View v) {
            // Get the selected song (clicked row) position & retrieve it's name and singer name
            // to send them to the PlaySongActivity using an intent!
            int position = getAdapterPosition();
            Song selectedSong = songsList.get(position);
            String singer_name = selectedSong.getSingerName();
            String song_name = selectedSong.getSongName();

            // Check if the clicked item view is exist! if yes, an intent with song name and
            // singer name will be sent to the playSongActivity
            if (position != RecyclerView.NO_POSITION) {
                Intent intent = new Intent(context, PlaySongActivity.class);
                intent.putExtra("SINGER_NAME", singer_name);
                intent.putExtra("SONG_NAME", song_name);
                context.startActivity(intent);
            }//end if
        }//end onClick()
    }//end SongsViewHolder class
}//end SongsAdapter class
