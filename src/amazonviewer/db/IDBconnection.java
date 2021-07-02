package amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static amazonviewer.db.DataBase.*;

public interface IDBconnection {
    default Connection connectToBB (){
        Connection connection = null;
        try{
            Class.forName("mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL+DB,USER, PASSWORD);
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            return connection;
        }
    }
}
