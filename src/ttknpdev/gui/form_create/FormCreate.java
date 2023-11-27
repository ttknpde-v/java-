package ttknpdev.gui.form_create;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ttknpdev.entity.Toy;
import ttknpdev.enums.Status;
import ttknpdev.gui.frame.MyFrame;
import ttknpdev.service.ToyService;

public class FormCreate extends javax.swing.JPanel implements ActionListener {

   private MyFrame frame;
   private ButtonGroup buttonGroupStatus;
   private ToyService toyService;
   private Toy toy;

   public FormCreate() {
      initComponents();
      frame = new MyFrame("CREATE");
      frame.setSize(500, 310);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      // group radio button
      buttonGroupStatus = new ButtonGroup();
      buttonGroupStatus.add(jRadioButtonUnused);
      buttonGroupStatus.add(jRadioButtonUse);
      toy = new Toy();
      toyService = new ToyService();
   }

   /**
    * This method is called from within the constructor to
    * initialize the form. WARNING: Do NOT modify this code.
    * The content of this method is always regenerated by
    * the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabelTitle = new javax.swing.JLabel();
      jLabelProductName = new javax.swing.JLabel();
      jLabelProductPrice = new javax.swing.JLabel();
      jRadioButtonUse = new javax.swing.JRadioButton();
      jRadioButtonUnused = new javax.swing.JRadioButton();
      jButtonCreate = new javax.swing.JButton();
      jTextFieldProductName = new javax.swing.JTextField();
      jTextFieldProductPrice = new javax.swing.JTextField();
      jLabelUnit = new javax.swing.JLabel();

      jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
      jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabelTitle.setText("Form create toy");

      jLabelProductName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      jLabelProductName.setText("Product name");

      jLabelProductPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      jLabelProductPrice.setText("Product price");

      jRadioButtonUse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      jRadioButtonUse.setText("use");
      jRadioButtonUse.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jRadioButtonUseActionPerformed(evt);
         }
      });

      jRadioButtonUnused.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      jRadioButtonUnused.setText("unused");

      jButtonCreate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
      jButtonCreate.setText("create");

      jTextFieldProductName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      jTextFieldProductName.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextFieldProductNameActionPerformed(evt);
         }
      });

      jTextFieldProductPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

      jLabelUnit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      jLabelUnit.setText("฿");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jLabelProductName)
                           .addComponent(jLabelProductPrice))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                              .addComponent(jTextFieldProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(jLabelUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addComponent(jTextFieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                     .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jButtonCreate)
                           .addGroup(layout.createSequentialGroup()
                              .addComponent(jRadioButtonUnused)
                              .addGap(29, 29, 29)
                              .addComponent(jRadioButtonUse)))))
                  .addGap(0, 74, Short.MAX_VALUE)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addComponent(jLabelTitle)
            .addGap(31, 31, 31)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabelProductName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(layout.createSequentialGroup()
                  .addGap(1, 1, 1)
                  .addComponent(jTextFieldProductName)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabelProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jTextFieldProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabelUnit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jRadioButtonUnused)
               .addComponent(jRadioButtonUse))
            .addGap(18, 18, 18)
            .addComponent(jButtonCreate)
            .addGap(36, 36, 36))
      );
   }// </editor-fold>//GEN-END:initComponents

   private void jRadioButtonUseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUseActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_jRadioButtonUseActionPerformed

   private void jTextFieldProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductNameActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_jTextFieldProductNameActionPerformed


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButtonCreate;
   private javax.swing.JLabel jLabelProductName;
   private javax.swing.JLabel jLabelProductPrice;
   private javax.swing.JLabel jLabelTitle;
   private javax.swing.JLabel jLabelUnit;
   private javax.swing.JRadioButton jRadioButtonUnused;
   private javax.swing.JRadioButton jRadioButtonUse;
   private javax.swing.JTextField jTextFieldProductName;
   private javax.swing.JTextField jTextFieldProductPrice;
   // End of variables declaration//GEN-END:variables

   public void display() {
      
      frame.setContentPane(this);
      frame.setVisible(true);
      
      jButtonCreate.addActionListener(this);
      
   }

   @Override
   public void actionPerformed(ActionEvent e) {

      toy.setProductName(jTextFieldProductName.getText());
      toy.setProductPrice(Float.valueOf(jTextFieldProductPrice.getText()));
      if (jRadioButtonUnused.isSelected()) {
         toy.setProductStatus(Status.valueOf(jRadioButtonUnused.getText()));
      } else if (jRadioButtonUse.isSelected()) {
         toy.setProductStatus(Status.valueOf(jRadioButtonUse.getText()));
      }
      create(toy); // method for processing to create new toy

   }

   private void create(Toy toy) {
      
      ImageIcon icon;
      Image image;
      Image newimg;
      
      Integer result = toyService.create(toy); // connect and query and close connect
      
      if (result > 0 && result != null) { // used than check
         
         icon = new ImageIcon("src/resources/images/checked.png");
         image = icon.getImage(); // transform it 
         newimg = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
         icon = new ImageIcon(newimg); // transform it back
         JOptionPane.showMessageDialog(this, "created", "warning", JOptionPane.INFORMATION_MESSAGE, icon);
      
      } else {
         
         icon = new ImageIcon("src/resources/images/remove.png");
         image = icon.getImage(); // transform it 
         newimg = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
         icon = new ImageIcon(newimg); // transform it back
         JOptionPane.showMessageDialog(this, "failed", "warning", JOptionPane.INFORMATION_MESSAGE, icon);
      
      }
      /* reset fields input */
      jTextFieldProductName.setText("");
      jTextFieldProductPrice.setText("");
      buttonGroupStatus.clearSelection(); // clear all jradio button
      
   }
   
   
}
