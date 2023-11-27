package ttknpdev.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import ttknpdev.log.MyLog;

public class ConnectDatabase {
   /* 
      we can use ResourceBundle class for accessing any properties file that you define
      First , we will create the object of the resource bundle and will pass the properties file name to it.
      Next, we have to use the getString(key) method to call the value. 
   */
   private ResourceBundle resourceBundle;
   private Connection connect;
   private Class loadDriver; /* for storing some driver MYSQL */

   public ConnectDatabase() {
      /* Note!  it starts on src folder */
      //*** so you can use absolute path if you need absolute it has way but hard code 
      resourceBundle = ResourceBundle.getBundle("resources/info/my_info");
      setLoadDriver(); // loading the driver mysql (.jar) 
      initialConnectDatabase(); // connect the database after setting the driver
   }

   private void setLoadDriver() {
      try {
         loadDriver = Class.forName(resourceBundle.getString("MYSQLL_DRIVER"));
         loadDriver.getClasses(); //  called Load Driver
      } catch (ClassNotFoundException cnfe) {
         MyLog.connecttion.warn("ClassNotFoundException class has error : " + cnfe.getMessage());
         throw new RuntimeException(cnfe.getCause());
      }
   }

   private void initialConnectDatabase() {
      // Class loadDriver = null;
      try {
         // use getString("MYSQLL_USERNAME") for access key
         final String URL = resourceBundle.getString("MYSQLL_URL");
         connect = DriverManager.getConnection(
                 URL,
                 resourceBundle.getString("MYSQLL_USERNAME"),
                 resourceBundle.getString("MYSQLL_PASSWORD")
         ); // connect to database
         MyLog.connecttion.info("connected");

      } catch (SQLException sqle) {
         MyLog.connecttion.warn("SQLException class has error : " + sqle.getMessage());
         throw new RuntimeException(sqle.getCause());
      }
   }

   public Connection getConnection() {
       /* Before get connect must create object class first (for injects)*/
      return connect;
   }

}
