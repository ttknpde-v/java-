package ttknpdev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ttknpdev.enums.Status;
/* Lombok it's Nice dependency !*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Toy {
   // real field name
   // toy_id
   private Long toyId;
   // toy_product_name
   private String productName;
   // toy_product_price
   private Float productPrice;
   // toy_product_status
   private Enum<Status> productStatus;
   // toy_product_build
   private String productBuild;
   
}
