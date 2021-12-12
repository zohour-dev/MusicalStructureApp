package jo.zohour_zo3bi.android_app_developer.musicalstructureapp;

public class Song {
    private String songName;
    private String singerName;

    public Song(String songName, String singerName) {
        this.songName = songName;
        this.singerName = singerName;
    }//end constructor

    public String getSongName() {
        return songName;
    }//end getSongName()

    public String getSingerName() {
        return singerName;
    }//end getSingerName()
}//end Song class
