/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.Customer.Customer;
import Business.EcoSystem;
import Business.Organization;
import Business.Restaurant.Dishes;
import Business.Restaurant.Restaurant;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class MenuPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Restaurant restaurant;
    private UserAccount userAccount;
    private EcoSystem ecosystem;
    ArrayList<Dishes> items=new ArrayList<Dishes>();
    int sum = 0;
    /**
     * Creates new form RequestLabTestJPanel
     */
    public MenuPanel(JPanel userProcessContainer, UserAccount account, EcoSystem ecosystem, Restaurant restaurant) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.userAccount = account;
        this.restaurant = restaurant;
        
        populateMenuTable();
    }
    
    public void populateMenuTable(){
         DefaultTableModel tablemodel = (DefaultTableModel) tblMenu.getModel();
        
            tablemodel.setRowCount(0);
                Object[] row = new Object[3];
                for(Dishes dish:restaurant.getMenu()){
                     row[0] = dish;
                     row[1] = dish.getDescription();
                     row[2] = dish.getPrice();
                     tablemodel.addRow(row);
                } 
    }
    
    public void populateCart(Dishes dishitem){
        DefaultTableModel tablemodel = (DefaultTableModel) tblCart.getModel();
        tablemodel.setRowCount(0);
        
         items.add(dishitem);
         Object[] row = new Object[3];
         sum = 0;
                for(Dishes dish:items){
                     row[0] = dish;
                     row[1] = dish.getDescription();
                     row[2] = dish.getPrice();
                     sum=sum+Integer.parseInt(dish.getPrice());
                     tablemodel.addRow(row);
                     
                }
          String s = String.valueOf(sum);
          total.setText("$" + s);
    }
    
    public void populateCartRemove(Dishes dishitem){
        DefaultTableModel tablemodel = (DefaultTableModel) tblCart.getModel();
        tablemodel.setRowCount(0);
        
         items.remove(dishitem);
         Object[] row = new Object[3];
         sum = 0;
                for(Dishes dish:items){
                     row[0] = dish;
                     row[1] = dish.getDescription();
                     row[2] = dish.getPrice();
                     sum=sum+Integer.parseInt(dish.getPrice());
                     tablemodel.addRow(row);
//                     System.out.println(dish.getDescription());
                }
          String s = String.valueOf(sum);
          total.setText("$" + s);      
    }
    
//    public void backback(){
//        
//        userProcessContainer.remove(this);
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        layout.previous(userProcessContainer);
//        
//    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnOrder = new javax.swing.JButton();
        total = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        btnAddToCart = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMenu = new javax.swing.JTable();
        btnRemoveFromCart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnOrder1 = new javax.swing.JButton();
        txtAddress1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOrder.setBackground(new java.awt.Color(0, 0, 0));
        btnOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnOrder.setText("Proceed to checkout");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        add(btnOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 170, -1));

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 150, -1));

        backJButton.setBackground(new java.awt.Color(0, 0, 0));
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 130, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Your Cart :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 120, 30));

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Name", "Description", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCart);
        if (tblCart.getColumnModel().getColumnCount() > 0) {
            tblCart.getColumnModel().getColumn(0).setResizable(false);
            tblCart.getColumnModel().getColumn(1).setResizable(false);
            tblCart.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, 130));

        btnAddToCart.setBackground(new java.awt.Color(0, 0, 0));
        btnAddToCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, -1, -1));

        tblMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Name", "Description", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblMenu);
        if (tblMenu.getColumnModel().getColumnCount() > 0) {
            tblMenu.getColumnModel().getColumn(0).setResizable(false);
            tblMenu.getColumnModel().getColumn(1).setResizable(false);
            tblMenu.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, 130));

        btnRemoveFromCart.setBackground(new java.awt.Color(0, 0, 0));
        btnRemoveFromCart.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveFromCart.setText("Remove Item");
        btnRemoveFromCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromCartActionPerformed(evt);
            }
        });
        add(btnRemoveFromCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("TOTAL");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 80, -1));

        btnOrder1.setBackground(new java.awt.Color(0, 0, 0));
        btnOrder1.setForeground(new java.awt.Color(255, 255, 255));
        btnOrder1.setText("Cancel Order");
        btnOrder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrder1ActionPerformed(evt);
            }
        });
        add(btnOrder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 190, -1));

        txtAddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddress1ActionPerformed(evt);
            }
        });
        add(txtAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ADDRESS:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 80, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
//        if(items == null){
//            
//          JOptionPane.showMessageDialog(null, "Add items to your cart");
//        
//        }
        DefaultTableModel tablemodel = (DefaultTableModel) tblCart.getModel();
        
        int selectedRow = tblCart.getRowCount();
        if(selectedRow == 0)
        {
            JOptionPane.showMessageDialog(null,"Your Cart is Empty","Warning",JOptionPane.WARNING_MESSAGE);
        }
        
        else if(total.getText().equals("") ){
            
                JOptionPane.showMessageDialog(null, "Please enter your location");
        }   
    
        else 
            
        {
        String address=total.getText();
        restaurant.addOrder(restaurant.getName(), userAccount.getUsername(), null, items, String.valueOf(sum) , address);
        for(Customer cust:ecosystem.getCustomerDirectory().getCustomerDirectory()){
            if(userAccount.getUsername().equals(cust.getUserName())){
                cust.addOrder(restaurant.getName(), userAccount.getUsername(), null, items, String.valueOf(sum) , address);
                //JOptionPane.showMessageDialog(null, "You Order placed successfully");
                 PaymentPanel1 paymentPanel1=new PaymentPanel1(userProcessContainer, userAccount, ecosystem, restaurant);
                 userProcessContainer.add("PaymentPanel1",paymentPanel1);
                 CardLayout layout=(CardLayout)userProcessContainer.getLayout();
                 layout.next(userProcessContainer);
            }
            }
        }        
        
    }//GEN-LAST:event_btnOrderActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        /**
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CustomerAreaJPanel dwjp = (CustomerAreaJPanel) component;
        dwjp.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        **/
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMenu.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select a row from the table to add","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else{
            Dishes dishItem=(Dishes)tblMenu.getValueAt(selectedRow, 0);
            
            populateCart(dishItem);
          
        }
        
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnRemoveFromCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromCartActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCart.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select a row from the table to remove from cart","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else{
            Dishes item=(Dishes)tblCart.getValueAt(selectedRow, 0);
//            items.remove(item);
//            DefaultTableModel model = (DefaultTableModel) tblCart.getModel();
//        model.setRowCount(0);
           // commented no use
           populateCartRemove(item);
                }  
    }//GEN-LAST:event_btnRemoveFromCartActionPerformed

    private void btnOrder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrder1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrder1ActionPerformed

    private void txtAddress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddress1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddress1ActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnOrder1;
    private javax.swing.JButton btnRemoveFromCart;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblMenu;
    private javax.swing.JTextField total;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
