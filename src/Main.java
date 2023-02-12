import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Album album1 = new Album("Doorie", "Atif Aslam");
         album1.addSongToAlbum("Kaash Is Tarha",4.5);
         album1.addSongToAlbum("Ehsaas", 5.4);
         album1.addSongToAlbum("Maula", 6.3);
         album1.addSongToAlbum("Mahi Ve", 5.2);
         album1.addSongToAlbum("O Re Piya",4.9);
         album1.findSong("Mahi V");



         List<Song> myPlayList = new LinkedList<>();
        System.out.println(album1.addSongToPlaylistFromAlbum("Kaash Is Tarha", myPlayList));
        System.out.println(album1.addSongToPlaylistFromAlbum("Ehsaas", myPlayList));
        System.out.println(album1.addSongToPlaylistFromAlbum("Maula", myPlayList));
        System.out.println(album1.addSongToPlaylistFromAlbum("Mahi Ve", myPlayList));
        System.out.println(album1.addSongToPlaylistFromAlbum("O Re Piya", myPlayList));

        playSong(myPlayList);
    }
    public static void playSong(List<Song> myPlayList) {
        if (myPlayList.size() == 0) {
            System.out.println("Playlist is Empty.");
            return;
        }
            boolean isNext = true;
            ListIterator<Song> itr = myPlayList.listIterator();
            System.out.println("Currently playing: ");
            System.out.println(itr.next());  ///we have overridden song in song class & it will give toString() as output.

            // taking input from the user that which action he wants to perform

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Enter your choice");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        if (!isNext) {
                            itr.next();
                        }
                        if (itr.hasNext()) {
                            System.out.println("Now playing: ");
                            System.out.println(itr.next());
                        } else {
                            System.out.println("You have reached the end of the playlist.");
                        }
                        isNext = true;
                        break;
                    case 2:
                        if (isNext) {
                            itr.previous();
                        }
                        if (itr.hasPrevious()) {
                            System.out.println("Now playing: ");
                            System.out.println(itr.previous());
                        } else {
                            System.out.println("You are at the top of the playlist.");
                        }
                        isNext = false;
                        break;
                    case 3:
                        System.out.println("Now playing: ");
                        if(!isNext){
                            System.out.println(itr.next());
                            isNext = true;
                        }
                        else{
                            System.out.println(itr.previous());
                            isNext = false;
                        }
                        break;
                    case 4:
                        if(!isNext){
                            itr.next();
                            itr.remove();
                        }
                        else{
                            itr.previous();
                            itr.remove();
                        }
                        break;
                    case 5:
                        printSong(myPlayList);
                        break;
                    case 6:
                        printMenu();
                        break;
                    case 7:
                        return;

                }
            }
    }
    public static void printSong(List <Song> myPlayList){
        for(Song s: myPlayList){
            System.out.println(s);
        }
    }
    public static void printMenu(){
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Play current song again");
        System.out.println("4. Delete current song from playlist.");
        System.out.println("5. Show all songs of the playlist");
        System.out.println("6. Show menu again");
        System.out.println("7. Exit");
    }
}