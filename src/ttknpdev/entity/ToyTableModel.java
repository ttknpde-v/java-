package ttknpdev.entity;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import ttknpdev.enums.Status;

public class ToyTableModel extends AbstractTableModel {

   private List<Toy> toys;

   private final String[] columnNames = new String[]{ // set columns
      "ID" , "Product name" , "Product price" , "Product status" , "Product build"
   };

   private final Class[] columnClass = new Class[]{ // set type of each fields
      Long.class , String.class , Float.class , Enum.class , String.class
   };

   public ToyTableModel(List<Toy> toys) { // First constructor
      this.toys = toys;
      /*for testing
      Toy toy = new Toy();
      toy.setToyId(10001L);
      toy.setProductName("XIK-1123");
      toy.setProductPrice(16600.60F);
      toy.setProductStatus(Status.use);
      toy.setProductBuild("2021-12-25 08:05:09");
      this.toys = new ArrayList<>();
      this.toys.add(toy);
      toy.setProductName("XIO-1125");
      toy.setToyId(10002L);
      this.toys.add(toy);*/
   }

   public ToyTableModel() { // Second constructor
      /* for demo (set Toy to list<Toy>) */
      Toy toy = new Toy();
      toy.setToyId(null);
      toy.setProductName(null);
      toy.setProductPrice(null);
      toy.setProductStatus(null);
      toy.setProductBuild(null);
      this.toys = new ArrayList<>();
      this.toys.add(toy);
   }

   public void setToys(List<Toy> toys) {
      this.toys = toys;
   }

   public void setToy(Toy toy) {
      this.toys.remove(0); // remove element 0 because I seted demo 
      toys.add(toy);
   }

   @Override
   public Class<?> getColumnClass(int columnIndex) {
      return columnClass[columnIndex]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
   }

   @Override
   public String getColumnName(int column) {
      return columnNames[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
   }

   @Override
   public int getRowCount() {
      // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      return toys.size();
   }

   @Override
   public int getColumnCount() {
      // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      return columnNames.length;
   }

   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
      /* method for getting value to table */
      Toy toy = toys.get(rowIndex);
      switch (columnIndex) {
         case 0 -> {
            return toy.getToyId();
         }
         case 1 -> {
            return toy.getProductName();
         }
         case 2 -> {
            return toy.getProductPrice();
         }
         case 3 -> {
            return toy.getProductStatus();
         }
         case 4 -> {
            return toy.getProductBuild();
         }
         default -> {
         }
      }
      return null;
   }

   /*
   For testing
   public void removeRow() {
      try {
         toys.remove(toys.size() - 1);
      } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "there were no data in your table", "warning", JOptionPane.WARNING_MESSAGE);
         throw new RuntimeException(e.getMessage());
      }
   }*/
}
