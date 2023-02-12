import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class Album {
    private String title;
    private String artist;
    List<Song> songs;
    Album(String title, String artist){
        this.title = title;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
     /// finding a song in Album
    public boolean findSong(String name){
        for(Song s: songs){
            if(s.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    //// Adding a song in Album
     String addSongToAlbum(String name, double duration){
        if(!findSong(name)){
            Song newSong = new Song(name,duration);
            songs.add(newSong);
            return "Song added to Album";
        }
        return  "Song already present in Album";
    }

    //// Adding a song to Playlist by its name
    String addSongToPlaylistFromAlbum(String name, List<Song> playlist){
          if(findSong(name)){
              for(Song s: songs){
                  if(s.getName().equals(name)){
                      playlist.add(s);
                      return "Song added to Playlist from Album";
                  }
              }
          }
        return "Song not present in the Album";
    }

    //// Adding a song to Playlist by its position
    String addSongToPlaylistFromAlbum(int trackNo, List<Song> playlist){
           if(trackNo>0 && trackNo<=songs.size()){    //checking whether the trackNo is  valid or not
                    playlist.add(songs.get(trackNo-1));
                    return "Song added to Playlist from Album";
                }
        return "Invalid Track Number!";
    }

}
