/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.NhaCungCap;
import com.mycompany.DomainModels.PhieuGiamGia;
import com.mycompany.Util.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ACER
 */
public class KhuyenMaiRepository {

    public List<PhieuGiamGia> getALLGG() {
        List<PhieuGiamGia> lst = new ArrayList<>();
        try (Connection con = DBContext.getConnection()) {
            String sql = "select * from PhieuGiamGia";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String loaiGG = rs.getString("LoaiGiamGia");
                Date ngaybd = rs.getDate("NgayBD");
                Date ngaykt = rs.getDate("NgayKT");
                int tt = rs.getInt("TrangThai");
                PhieuGiamGia pgg = new PhieuGiamGia(id, ma, loaiGG, ngaybd, ngaykt, tt);
                lst.add(pgg);
            }
        } catch (Exception e) {
        }
        return lst;
    }

    public void insert(PhieuGiamGia b) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO PhieuGiamGia(Ma,LoaiGiamGia,NgayBD,NgayKT,TrangThai)VALUES(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, b.getMa());
            ps.setString(2, b.getLoaiGiamGia());
            ps.setDate(3, new java.sql.Date( b.getNgayBD().getTime()));
            ps.setDate(4,new java.sql.Date( b.getNgayKT().getTime()));
            ps.setInt(5, b.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String Id, PhieuGiamGia b) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE PhieuGiamGia SET LoaiGiamGia=?,NgayBD=?,NgayKT=?,TrangThai=? WHERE Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getLoaiGiamGia());
            ps.setDate(2, new java.sql.Date( b.getNgayBD().getTime()));
            ps.setDate(3,new java.sql.Date( b.getNgayKT().getTime()));
            ps.setInt(4, b.getTrangThai());
            ps.setString(5, b.getMa());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(String Ma){
        try {
            Connection conn =DBContext.getConnection();
            String sql="DELETE PhieuGiamGia WHERE Ma=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,Ma );
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
