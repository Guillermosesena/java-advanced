package extra;

import java.util.ArrayList;

public class ExerciseSopotify {
    public static void main(String[] args) {
        Album album = new Album();
    }
}

class Album{
    private  String name;

    ArrayList<Song> songs = new ArrayList<Song>();

    class Song{
        private String name;
    }
}