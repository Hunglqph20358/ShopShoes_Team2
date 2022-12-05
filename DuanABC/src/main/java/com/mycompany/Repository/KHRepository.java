/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.KhachHang;
import com.mycompany.Util.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author FPT
 */
public class KHRepository {
    
    //HungLQPH20358 
    public List<KhachHang> getAllKH(){
        List<KhachHang> lst = new ArrayList<>();
        String hql = "Select kh From KhachHang kh";
        try(Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
    
    public  KhachHang getByKH(String sdt){
        KhachHang kh = new KhachHang();
        String hql = "Select kh From KhachHang kh where kh.Sdt = :sdt";
        try(Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            q.setParameter("sdt", sdt);
            kh = (KhachHang) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return kh;
    }
    public Integer addKH(KhachHang kh){
        try(Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            sess.save(kh);
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
    //HungLQPH20358
    //-----------------------
    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> listKH = new ArrayList<>();
        try {
            Connection con = DBContext.getConnection();
            String sql = "select * from khachhang where TrangThai = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String maStr = rs.getString("MA");
                String hotenStr = rs.getString("HOTEN");
                Date ngaysinhStr = rs.getDate("NGAYSINH");
                String sdtStr = rs.getString("SDT");
                String diachiStr = rs.getString("DIACHI");
                int trangthaiStr = rs.getInt("TRANGTHAI");

                KhachHang kh = new KhachHang(null, maStr, hotenStr, ngaysinhStr, sdtStr, diachiStr, trangthaiStr);
                listKH.add(kh);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public Integer insert(KhachHang kh) {
        try {
            Connection con = DBContext.getConnection();
            String sql = "INSERT INTO KHACHHANG (MA,HOTEN,NGAYSINH,SDT,DIACHI,TRANGTHAI) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getHoTen());
            ps.setDate(3, (Date) kh.getNgaySinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getDiaChi());
            ps.setInt(6, kh.getTrangThai());

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer update(KhachHang kh, String ma) {
        try {
            Connection con = DBContext.getConnection();
            String sql = "UPDATE KHACHHANG SET Ma =?, HOTEN = ?, NGAYSINH = ?, SDT = ?, DIACHI = ? ,TRANGTHAI = ? WHERE MA = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getHoTen());
            ps.setDate(3, (Date) kh.getNgaySinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getDiaChi());
            ps.setInt(6, kh.getTrangThai());
            ps.setString(8, ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhachHang delete(String ma) {
        try {
            Connection con = DBContext.getConnection();
            String sql = "DELETE from KHACHHANG WHERE MA = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<KhachHang> findKhachHang(String sdt) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            Connection con = DBContext.getConnection();
            String sql = "select * from khachhang where Sdt like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%"+sdt+"%");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String maStr = rs.getString("MA");
                String hotenStr = rs.getString("HOTEN");
                Date ngaysinhStr = rs.getDate("NGAYSINH");
                String sdtStr = rs.getString("SDT");
                String diachiStr = rs.getString("DIACHI");
                int trangthaiStr = rs.getInt("TRANGTHAI");

                KhachHang kh = new KhachHang(null, maStr, hotenStr, ngaysinhStr, sdtStr, diachiStr, trangthaiStr);
                list.add(kh);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
     //namtvph23205
    
      public ArrayList<KhachHang> getAllThungRacKH() {
        ArrayList<KhachHang> listKH = new ArrayList<>();
        try {
            Connection con = DBContext.getConnection();
            String sql = "select * from KhachHang where TrangThai = 0";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String maStr = rs.getString("MA");
                String hotenStr = rs.getString("HOTEN");
                Date ngaysinhStr = rs.getDate("NGAYSINH");
                String sdtStr = rs.getString("SDT");
                String diachiStr = rs.getString("DIACHI");
                int trangthaiStr = rs.getInt("TRANGTHAI");

                KhachHang kh = new KhachHang(null, maStr, hotenStr, ngaysinhStr, sdtStr, diachiStr, trangthaiStr);
                listKH.add(kh);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }
      
       public Integer updateThungRacKH(String ma) {
        try {
            Connection con = DBContext.getConnection();
            String sql = "update KhachHang set TrangThai = 0 where Ma = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
       
        public Integer KhoiPhucThungRacKH(String ma) {
        try {
            Connection con = DBContext.getConnection();
            String sql = "update KhachHang set TrangThai = 1 where Ma = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        
        public static void main(String[] args) {
        new KHRepository().getAllKhachHang().forEach(c -> System.out.println(c));
    }
}
