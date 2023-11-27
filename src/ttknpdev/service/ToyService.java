package ttknpdev.service;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.List;
import java.sql.SQLException;
import ttknpdev.connection.ConnectDatabase;
import ttknpdev.enums.Status;
import ttknpdev.entity.Toy;
import ttknpdev.service.CommandSQL;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import ttknpdev.log.MyLog;

public class ToyService {

   private ConnectDatabase connectDatabase;
   private Connection connect;
   private PreparedStatement preparedStatement;

   public ToyService() {
      // inject connect
      connectDatabase = new ConnectDatabase();
      open();
   }

   public final void open() {
      connect = connectDatabase.getConnection();
   }


   public List<Toy> reads() {
      ResultSet resultSet;
      // Toy toy;
      List<Toy> toys;
      try {
         toys = new ArrayList<>();
         preparedStatement = connect.prepareStatement(CommandSQL.READS);
         // System.err.println(preparedStatement.executeQuery());  return address you know
         resultSet = preparedStatement.executeQuery();
         while (resultSet.next()) { // loop untill null use .next() 
            /* toy = new Toy(); Why ? 
            toy.setToyId(resultSet.getLong("toy_id"));
            toy.setProductName(resultSet.getString("toy_product_name"));
            toy.setProductPrice(resultSet.getFloat("toy_product_price"));
            // String status = resultSet.getString("toy_product_status");
            toy.setProductStatus(Status.valueOf(resultSet.getString("toy_product_status"))); // way to convert Enum
            toy.setProductBuild(resultSet.getString("toy_product_build"));
            toys.add(toy);*/
            toys.add(new Toy(resultSet.getLong("toy_id"),
                    resultSet.getString("toy_product_name"),
                    resultSet.getFloat("toy_product_price"),
                    Status.valueOf(resultSet.getString("toy_product_status")),
                    resultSet.getString("toy_product_build")));
         }
         // MyLog.toyService.info(toys.get(0));
         // connect.close();
         return toys;

      } catch (SQLException sqle) {
         MyLog.toyService.warn("SQLException class has error : " + sqle.getMessage());
         throw new RuntimeException("SQLException class has error : " + sqle.getMessage());
      }
   }

   public Toy read(Long toyId) {
      ResultSet resultSet;
      Toy toy = null;
      try {
         preparedStatement = connect.prepareStatement(CommandSQL.READ);
         // (order , value)
         preparedStatement.setLong(1, toyId);
         resultSet = preparedStatement.executeQuery();
         if (resultSet.next()) {
            toy = new Toy(resultSet.getLong("toy_id"),
                    resultSet.getString("toy_product_name"),
                    resultSet.getFloat("toy_product_price"),
                    Status.valueOf(resultSet.getString("toy_product_status")),
                    resultSet.getString("toy_product_build"));
         }
         MyLog.toyService.info(toy);
         // connect.close();
         return toy;
      } catch (SQLException sqle) {
         MyLog.toyService.warn("SQLException class has error : " + sqle.getMessage());
         throw new RuntimeException("SQLException class has error : " + sqle.getMessage());
      }
   }

   public Integer create(Toy toy) {
      LocalDateTime myDateObj = LocalDateTime.now();
      DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
      String formattedDate = myDateObj.format(myFormatObj);
      try {
         preparedStatement = connect.prepareStatement(CommandSQL.CREATE);
         preparedStatement.setString(1, toy.getProductName());
         preparedStatement.setFloat(2, toy.getProductPrice());
         preparedStatement.setString(3, String.valueOf(toy.getProductStatus()));
         preparedStatement.setString(4, formattedDate);
         int resultQuery = preparedStatement.executeUpdate(); // when has some query it will return 1 
         // System.err.println(resultQuery);
         connect.close();
         return resultQuery;
      } catch (SQLException sqle) {
         MyLog.toyService.warn("SQLException class has error : " + sqle.getMessage());
         // throw new RuntimeException("SQLException class has error : " + sqle.getMessage());
      }
      return 0;
   }

   public Integer update(Toy toy) {
      try {
         preparedStatement = connect.prepareStatement(CommandSQL.UPDATE);
         preparedStatement.setString(1, toy.getProductName());
         preparedStatement.setFloat(2, toy.getProductPrice());
         preparedStatement.setString(3, String.valueOf(toy.getProductStatus()));
         preparedStatement.setLong(4, toy.getToyId());
         int resultQuery = preparedStatement.executeUpdate(); // when has some query it will return 1 
         // System.err.println(resultQuery);
         // connect.close(); I need to connect always till close program 
         return resultQuery;
      } catch (SQLException sqle) {
         MyLog.toyService.warn("SQLException class has error : " + sqle.getMessage());
         // throw new RuntimeException("SQLException class has error : " + sqle.getMessage());
      }
      return 0;
   }

   public Integer delete() {
      try {
         preparedStatement = connect.prepareStatement(CommandSQL.DELETE);
         int resultQuery = preparedStatement.executeUpdate(); // when has some query it will return 1 
         // System.err.println(resultQuery);
         // connect.close(); I need to connect always till close program 
         return resultQuery;
      } catch (SQLException sqle) {
         MyLog.toyService.warn("SQLException class has error : " + sqle.getMessage());
         // throw new RuntimeException("SQLException class has error : " + sqle.getMessage());
      }
      return 0;
   }

   public void closeConnect() {
      try {
         connect.close();
      } catch (SQLException sqle) {
         MyLog.toyService.warn("SQLException class has error : " + sqle.getMessage());
         throw new RuntimeException("SQLException class has error : " + sqle.getMessage());
      }
   }
}
