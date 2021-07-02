package amazonviewer.dao;


import model.Movie;

import java.util.ArrayList;
import java.util.Date;

public interface MovieDAO {

    default Movie setMovieViewed(Movie movie){
        return movie;
    }

    default ArrayList<Movie> read(){
        ArrayList<Movie> movies = new ArrayList<>();
        return movies;
    }
    private boolean getMovieViewed(){
        return false;
    }
}
