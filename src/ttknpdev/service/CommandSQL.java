package ttknpdev.service;

public class CommandSQL {

   public static final String READS = "select * from toys";
   public static final String READ = "select * from toys where toy_id = ? ";
   public static final String CREATE = "insert into toys (toy_product_name,toy_product_price,toy_product_status,toy_product_build) "
           + "values(?,?,?,?) ";
   public static final String UPDATE = "update toys set toy_product_name = ? , toy_product_price = ? , toy_product_status = ? where toy_id = ?";
   public static final String DELETE = "delete from toys order by toy_id desc limit 1";
}  
