package amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static amazonviewer.db.DataBase.*;

public interface IDBconnection {
    default Connection connectToDB (){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL + DB ,USER,PASSWORD);
            //connection = DriverManager.getConnection(URL_);
            if(connection != null){
                System.out.println("The connection was established");
            }
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            return connection;
        }
    }
}
