/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Service.HoaDonChiTietService;
import com.mycompany.Service.HoaDonService;
import com.mycompany.Service.IPM.HDCTServiceIpm;
import com.mycompany.Service.IPM.HoaDonServiceIpm;
import com.mycompany.ViewModel.BanHang.GioHangViewModel;
import com.mycompany.ViewModel.BanHang.HoaDonViewModels;
import com.mycompany.ViewModel.hoaDon.QLHoaDonViewModel;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kunrl
 */
public class HoaDonPanel extends javax.swing.JPanel {

    HoaDonService hoaDonService;
    HoaDonChiTietService hdctService;

    /**
     * Creates new form HoaDonPanel
     */
    public HoaDonPanel() {
        initComponents();
        hoaDonService = new HoaDonServiceIpm();
        hdctService = new HDCTServiceIpm();
        fillToHoaDon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnHoaDon = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQLHoaDon = new javax.swing.JTable();
        lblTimKiem = new javax.swing.JLabel();
        txtTimKiemHD = new javax.swing.JTextField();
        lblTrangThai = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        lblTuNgay = new javax.swing.JLabel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnHDCT = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLHDCT = new javax.swing.JTable();

        pnHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblQLHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HĐ", "Họ và tên NV", "Tên KH", "Tổng tiền", "Ngày Tạo", "Ngày Thanh Toán", "Ghi chú", "Trạng thái"
            }
        ));
        tblQLHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQLHoaDon);

        lblTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTimKiem.setText("Tìm kiếm");

        txtTimKiemHD.setText("Tìm Kiếm...");
        txtTimKiemHD.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemHDCaretUpdate(evt);
            }
        });
        txtTimKiemHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemHDMouseClicked(evt);
            }
        });

        lblTrangThai.setText("Trạng Thái :");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Chưa Thanh Toán", "Chờ Thanh Toán", "Đã Thanh Toán", "Đã Hủy", "Đang Giao Hàng", "Đã Giao Hàng" }));
        cbbTrangThai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTrangThaiItemStateChanged(evt);
            }
        });

        lblTuNgay.setText("Từ Ngày :");

        txtNgayBatDau.setDateFormatString("yyyy-MM-dd");

        jLabel6.setText("Đến :");

        txtNgayKetThuc.setDateFormatString("yyyy-MM-dd");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Quản Lí Hóa Đơn");

        jButton1.setText("Tìm Kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnHoaDonLayout = new javax.swing.GroupLayout(pnHoaDon);
        pnHoaDon.setLayout(pnHoaDonLayout);
        pnHoaDonLayout.setHorizontalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHoaDonLayout.createSequentialGroup()
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnHoaDonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnHoaDonLayout.createSequentialGroup()
                                .addComponent(lblTrangThai)
                                .addGap(18, 18, 18)
                                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTuNgay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTimKiem)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        pnHoaDonLayout.setVerticalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonLayout.createSequentialGroup()
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTimKiem)
                            .addComponent(jButton1))
                        .addGap(20, 20, 20))
                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTrangThai)
                                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnHoaDonLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTuNgay)
                                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnHDCT.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tblQLHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền", "Trạng Thái"
            }
        ));
        jScrollPane1.setViewportView(tblQLHDCT);

        javax.swing.GroupLayout pnHDCTLayout = new javax.swing.GroupLayout(pnHDCT);
        pnHDCT.setLayout(pnHDCTLayout);
        pnHDCTLayout.setHorizontalGroup(
            pnHDCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHDCTLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnHDCTLayout.setVerticalGroup(
            pnHDCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHDCTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnHDCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblQLHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLHoaDonMouseClicked
        try {
            loadHDCT(tblQLHoaDon.getValueAt(tblQLHoaDon.getSelectedRow(), 0).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblQLHoaDonMouseClicked

    private void cbbTrangThaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTrangThaiItemStateChanged
        try {
            if (cbbTrangThai.getSelectedIndex() == 0) {
                fillToHoaDon();
            } else if (cbbTrangThai.getSelectedIndex() == 1) {
                fillToHoaDonByTrangThai(0);
            }
            else if (cbbTrangThai.getSelectedIndex() == 2) {
                fillToHoaDonByTrangThai(1);
            }
            else if (cbbTrangThai.getSelectedIndex() == 3) {
                fillToHoaDonByTrangThai(2);
            }
            else if (cbbTrangThai.getSelectedIndex() == 4) {
                fillToHoaDonByTrangThai(3);
            }
            else if(cbbTrangThai.getSelectedIndex() == 5) {
                fillToHoaDonByTrangThai(4);
            }
            else if(cbbTrangThai.getSelectedIndex() == 6){
                fillToHoaDonByTrangThai(5);
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_cbbTrangThaiItemStateChanged

    private void txtTimKiemHDCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemHDCaretUpdate
        // TODO add your handling code here:
        try {
           if(txtTimKiemHD.getText().equals("")){
               fillToHoaDon();
           }else{
               fillToHoaDonBySearch(txtTimKiemHD.getText());
           }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtTimKiemHDCaretUpdate

    private void txtTimKiemHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemHDMouseClicked
        // TODO add your handling code here:
        try {
            txtTimKiemHD.setText("");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtTimKiemHDMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            fillToHoaDonByNgay(txtNgayBatDau.getDate(), txtNgayKetThuc.getDate());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lblTuNgay;
    private javax.swing.JPanel pnHDCT;
    private javax.swing.JPanel pnHoaDon;
    private javax.swing.JTable tblQLHDCT;
    private javax.swing.JTable tblQLHoaDon;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private javax.swing.JTextField txtTimKiemHD;
    // End of variables declaration//GEN-END:variables

    private void fillToHoaDon() {
        DefaultTableModel tblModel = (DefaultTableModel) tblQLHoaDon.getModel();
        tblModel.setRowCount(0);
        for (QLHoaDonViewModel ql : hoaDonService.getAllHDViewQLHD()) {
            tblModel.addRow(new Object[]{ql.getMaHD(), ql.getHoTenNV(), ql.getTenKH(), ql.getTongTien(), ql.getNgayTao(), ql.getNgayThanhToan(), ql.getGhiChu(), ql.getTrangThai()});
        }
    }

    private void fillToHoaDonByTrangThai(Integer trangThai) {
        DefaultTableModel tblModel = (DefaultTableModel) tblQLHoaDon.getModel();
        tblModel.setRowCount(0);
        for (QLHoaDonViewModel ql : hoaDonService.getAllHDViewQLHDByTrangThai(trangThai)) {
            tblModel.addRow(new Object[]{ql.getMaHD(), ql.getHoTenNV(), ql.getTenKH(), ql.getTongTien(), ql.getNgayTao(), ql.getNgayThanhToan(), ql.getGhiChu(), ql.getTrangThai()});
        }
    }
    private void fillToHoaDonByNgay(Date ngay , Date ngay2) {
        DefaultTableModel tblModel = (DefaultTableModel) tblQLHoaDon.getModel();
        tblModel.setRowCount(0);
        for (QLHoaDonViewModel ql : hoaDonService.getAllHDViewQLHDByNgay(ngay, ngay2)) {
            tblModel.addRow(new Object[]{ql.getMaHD(), ql.getHoTenNV(), ql.getTenKH(), ql.getTongTien(), ql.getNgayTao(), ql.getNgayThanhToan(), ql.getGhiChu(), ql.getTrangThai()});
        }
    }
    private void fillToHoaDonBySearch(String timKiem) {
        DefaultTableModel tblModel = (DefaultTableModel) tblQLHoaDon.getModel();
        tblModel.setRowCount(0);
        for (QLHoaDonViewModel ql : hoaDonService.getAllHDViewQLHDBySearch(timKiem)) {
            tblModel.addRow(new Object[]{ql.getMaHD(), ql.getHoTenNV(), ql.getTenKH(), ql.getTongTien(), ql.getNgayTao(), ql.getNgayThanhToan(), ql.getGhiChu(), ql.getTrangThai()});
        }
    }

    private void loadHDCT(String maHD) {
        DefaultTableModel tblModel = (DefaultTableModel) tblQLHDCT.getModel();
        tblModel.setRowCount(0);
        for (GioHangViewModel gh : hdctService.getAllHDCT(maHD)) {
            tblModel.addRow(new Object[]{gh.getMaSP(), gh.getTenSP(), gh.getSoLuong(), gh.getDonGia(), gh.getThanhTien(), gh.getTrangThai()});
        }
    }
}
