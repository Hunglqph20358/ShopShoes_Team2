/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.DomainModels.KhachHang;
import com.mycompany.Service.IPM.KHServiceIpm;
import com.mycompany.Service.KHService;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kunrl
 */
public class ThungRacKHForm extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    KHService svKH = new KHServiceIpm();
    private int row;

    public ThungRacKHForm() {
        initComponents();
        setLocationRelativeTo(null);
        loadTable();
    }
    
    public void loadTable() {
        model = (DefaultTableModel) tblThungRacKH.getModel();
        model.setRowCount(0);
        for (KhachHang kh : svKH.getListThungRacKH()) {
            Object[] rowData = {
                kh.getMa(),
                kh.getHoTen(),
                kh.getNgaySinh(),
                kh.getSdt(),
                kh.getDiaChi(),
                kh.getTrangThai()== 1 ?"Đang hoạt động":"Không hoạt động" 
            };
            model.addRow(rowData);

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

        PopMenu = new javax.swing.JPopupMenu();
        MenuKhoiPhucKH = new javax.swing.JMenuItem();
        MenuXoaKH = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThungRacKH = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        MenuKhoiPhucKH.setText("Khôi phục");
        MenuKhoiPhucKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuKhoiPhucKHMouseClicked(evt);
            }
        });
        MenuKhoiPhucKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuKhoiPhucKHActionPerformed(evt);
            }
        });
        PopMenu.add(MenuKhoiPhucKH);

        MenuXoaKH.setText("Xóa");
        PopMenu.add(MenuXoaKH);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tblThungRacKH.setModel(new javax.swing.table.DefaultTableModel(
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
        tblThungRacKH.setOpaque(false);
        tblThungRacKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblThungRacKHMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblThungRacKH);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icons/reload.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblThungRacKHMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThungRacKHMouseReleased
        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (evt.isPopupTrigger() && tblThungRacKH.getSelectedRowCount() != 0) {
                PopMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_tblThungRacKHMouseReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void MenuKhoiPhucKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuKhoiPhucKHMouseClicked

    }//GEN-LAST:event_MenuKhoiPhucKHMouseClicked

    private void MenuKhoiPhucKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuKhoiPhucKHActionPerformed
        int row = tblThungRacKH.getSelectedRow();

        if (row == - 1) {
            JOptionPane.showMessageDialog(this, "Mời chọn dòng");
            return;
        }

        int comfirm = JOptionPane.showConfirmDialog(this, "Xác nhận Khôi phục ?");
        if (comfirm != JOptionPane.YES_OPTION) {
            return;
        }
        String ma = tblThungRacKH.getValueAt(row, 0).toString();
        svKH.KhoiPhucThungRacKH(ma);
        loadTable();
    }//GEN-LAST:event_MenuKhoiPhucKHActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThungRacKHForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThungRacKHForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThungRacKHForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThungRacKHForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThungRacKHForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuKhoiPhucKH;
    private javax.swing.JMenuItem MenuXoaKH;
    private javax.swing.JPopupMenu PopMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThungRacKH;
    // End of variables declaration//GEN-END:variables
}
