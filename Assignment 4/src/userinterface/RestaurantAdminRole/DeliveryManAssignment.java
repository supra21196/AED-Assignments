/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RestaurantAdminRole;

import Business.DeliveryMan.DeliveryMan;
import Business.EcoSystem;
import Business.Order.Order;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sukhada
 */
public class DeliveryManAssignment extends javax.swing.JPanel {

    /**
     * Creates new form DeliveryManAssignment
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private Order order;
    private EcoSystem ecosystem;
    
    public DeliveryManAssignment(JPanel userProcessContainer, UserAccount account, Order order, EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.order = order;
        this.ecosystem = ecosystem;
        
        populateDeliveryManTable();
    }

    public void populateDeliveryManTable(){
        DefaultTableModel tablemodel = (DefaultTableModel) tblDeliveryMan.getModel();
        
        tablemodel.setRowCount(0);
        
        for(DeliveryMan deliveryMan:ecosystem.getDeliveryManDirectory().getDeliveryManDirectory()){
               Object[] row = new Object[1];
               row[0] = deliveryMan;
               tablemodel.addRow(row);
                
                
    }
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeliveryMan = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnOrderAssignment = new javax.swing.JButton();

        tblDeliveryMan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDeliveryMan);
        if (tblDeliveryMan.getColumnModel().getColumnCount() > 0) {
            tblDeliveryMan.getColumnModel().getColumn(0).setResizable(false);
        }

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnOrderAssignment.setBackground(new java.awt.Color(0, 0, 0));
        btnOrderAssignment.setForeground(new java.awt.Color(255, 255, 255));
        btnOrderAssignment.setText("Assign Order");
        btnOrderAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderAssignmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btnOrderAssignment))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnOrderAssignment)
                .addContainerGap(161, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderAssignmentActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDeliveryMan.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select a row from the table to assign the order","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            
            DeliveryMan deliveryMan  = (DeliveryMan)tblDeliveryMan.getValueAt(selectedRow, 0);   
            deliveryMan.getOrderList().add(order);
            order.setStatus("Assigned to Deliveryman");
            JOptionPane.showMessageDialog(null, "Assigned to Delivery Man");
            
        }
    }//GEN-LAST:event_btnOrderAssignmentActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnOrderAssignment;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDeliveryMan;
    // End of variables declaration//GEN-END:variables
}
