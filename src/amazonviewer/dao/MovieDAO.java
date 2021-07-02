package amazonviewer.dao;


import amazonviewer.db.IDBconnection;
import model.Movie;

import java.sql.*;
import java.util.ArrayList;
import static amazonviewer.db.DataBase.*;
import java.util.Date;

public interface MovieDAO extends IDBconnection {

    default Movie setMovieViewed(Movie movie){
        return movie;
    }

    default ArrayList<Movie> read(){
        ArrayList<Movie> movies = new ArrayList<>();
        try (Connection connection = connectToDB()){
            String query = "SELECT * FROM " + TMOVIE;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Movie movie = new Movie(
                        rs.getString(TMOVIE_TITLE),
                        rs.getString(TMOVIE_GENRE),
                        rs.getString(TMOVIE_CREATOR),
                        Integer.valueOf(rs.getString(TMOVIE_DURATION)),
                        Short.valueOf(rs.getString(TMOVIE_YEAR)));

                movie.setID(Integer.valueOf(rs.getString(TMOVIE_ID)));
                movies.add(movie);
            }

        }catch (SQLException e){

        }
        return movies;
    }
    private boolean getMovieViewed(){
        return false;
    }
}
