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
                movie.setViewed(getMovieViewed(preparedStatement,
                        connection,
                        Integer.valueOf(rs.getString(TMOVIE_ID))));
                movies.add(movie);
            }

        }catch (SQLException e){

        }
        return movies;
    }
    private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection, int id_movie){
        boolean viewed = false;
        String query = "SELECT * FROM " + TVIEWED +
                " WHERE " +TVIEWED_IDMATERIAL + "= ?" +
                " AND " + TVIEWED_IDELEMENT + "= ?" +
                " AND " +TVIEWED_IDUSUARIO + "= ?";
        ResultSet rs = null;
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ID_TMATERIALS[0]);
            preparedStatement.setInt(2, id_movie);
            preparedStatement.setInt(3, TUSER_IDUSUARIO);
            rs = preparedStatement.executeQuery();
            viewed = rs.next();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return viewed;
    }
}
