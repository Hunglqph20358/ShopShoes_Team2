/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.HinhThucThanhToan;
import com.mycompany.DomainModels.HoaDon;
import com.mycompany.DomainModels.KhachHang;
import com.mycompany.DomainModels.NhanVien;
import com.mycompany.DomainModels.ThongKe;
import com.mycompany.Util.DBContext;
import com.mycompany.Util.HibernateUtil;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author FPT
 */
public class HoaDonRepository {

    //HungLQPH20358
    public List<HoaDon> getAllHD() {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "select hd From HoaDon hd join hd.nhanVien nv where hd.TrangThai = 0 or hd.TrangThai = 1 or hd.TrangThai = 3";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
    public List<HoaDon> getAllHDViewQLHD() {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "select hd From HoaDon hd left join hd.khachHang kh left join hd.nhanVien nv";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
    public List<HoaDon> getAllHDViewQLHDByTrangThai(Integer trangThai) {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "select hd From HoaDon hd left join hd.khachHang kh left join hd.nhanVien nv where hd.TrangThai = :tt";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            q.setParameter("tt", trangThai);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
    
    public List<HoaDon> getAllHDByTrangThai(int tt) {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "select hd From HoaDon hd join hd.nhanVien nv where hd.TrangThai = :tt1 or hd.TrangThai = :tt2 or hd.TrangThai = :tt3";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            q.setParameter("tt1", tt);
            q.setParameter("tt2", tt);
            q.setParameter("tt3", tt);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
    public List<HoaDon> getAllHDCheckMa() {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "select hd From HoaDon hd";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
    
    
    public Integer addHD(HoaDon hd) {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            sess.save(hd);
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    public Integer updateHD(HoaDon hd) {
        Integer row = null;
        String hql = "update HoaDon set TongTien = :tong , TrangThai = :trangThai , IdKH = :kh, NgayThanhToan = :ntt, GhiChu = :gc where Id = :id";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            Query q = sess.createQuery(hql);
            String idKH = null;
            if(hd.getKhachHang() != null){
                idKH = hd.getKhachHang().getId();
            }
            q.setParameter("tong", hd.getTongTien());
            q.setParameter("trangThai", hd.getTrangThai());
            q.setParameter("id", hd.getId());
            q.setParameter("kh", idKH);
            q.setParameter("ntt", hd.getNgayThanhToan());
            q.setParameter("gc", hd.getGhiChu());
            row = q.executeUpdate();
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return row;
    }
    
    
    public Integer updateHDDatHangThanhCong(HoaDon hd) {
        Integer row = null;
        String hql = "update HoaDon set TongTien = :tong, NgayThanhToan = :ngayttoan ,NgayDaNhanHang = :ngayDaNhanHang ,TrangThai = :tt where Id = :id";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            Query q = sess.createQuery(hql);
            q.setParameter("ngayttoan", hd.getNgayThanhToan());
            q.setParameter("tong", hd.getTongTien());
            q.setParameter("ngayDaNhanHang", hd.getNgayDaNhanHang());
            q.setParameter("tt", hd.getTrangThai());
            q.setParameter("id", hd.getId());
            row = q.executeUpdate();
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return row;
    }
     public Integer updateHDDatHang(HoaDon hd) {
        Integer row = null;
        String hql = "update HoaDon set TrangThai = :trangThai,"
                + "NgayShip = :ngayShip, NgayNhanHang = :ngayDuKien , "
                + "IdKH = :kh,PhiShip = :phiShip,DiaChiGiaoHang = :dc , GhiChu = :gc,SDTNguoiGiaoHang = :sdt where Id = :id";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            Query q = sess.createQuery(hql);
//            q.setParameter("tong", hd.getTongTien());
            q.setParameter("trangThai", hd.getTrangThai());
            q.setParameter("id", hd.getId());
            q.setParameter("kh", hd.getKhachHang());
            q.setParameter("ngayShip", hd.getNgayShip());
            q.setParameter("ngayDuKien", hd.getNgayNhanHang());
            q.setParameter("phiShip", hd.getPhiShip());
            q.setParameter("gc", hd.getGhiChu());
            q.setParameter("dc", hd.getDiaChiGiaoHang());
            q.setParameter("sdt", hd.getSDTNguoiGiaoHang());
            
            row = q.executeUpdate();
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return row;
    }
    //Hunglqph20358
    //------------------------
    
     //tinhph23160
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> lst = new ArrayList<>();
        Transaction tran = null;
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            tran = sess.beginTransaction();
            lst = sess.createQuery("FROM HoaDon").list();
            tran.commit();
        }
        return lst;
    }

    public ArrayList<HoaDon> finByTrangThai(int ma) {
        ArrayList<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT MaHD, NgayThanhToan, TongTien, TrangThai\n"
                    + " FROM     dbo.HoaDon where TrangThai like '%" + ma + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getDate(2), rs.getBigDecimal(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    public static ArrayList<HoaDon> finByNgayThanhToan(String ma) {
        ArrayList<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT MaHD, NgayThanhToan, TongTien, TrangThai\n"
                    + " FROM     dbo.HoaDon where NgayThanhToan like '%" + ma + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getDate(2), rs.getBigDecimal(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    public static ArrayList<HoaDon> finByNgayThanhToanHomNay(int ma) {
        ArrayList<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT MaHD, NgayThanhToan, TongTien, TrangThai\n"
                    + " FROM     dbo.HoaDon where NgayThanhToan like '%" + ma + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getDate(2), rs.getBigDecimal(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

    public ArrayList<HoaDon> finByNgayThanhToanandHDTK(int ma) {
        ArrayList<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT MaHD, NgayThanhToan, TongTien, TrangThai\n"
                    + " FROM     dbo.HoaDon where NgayThanhToan like '%" + ma + "%' and TrangThai = 5";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getDate(2), rs.getBigDecimal(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    public ArrayList<HoaDon> finByNgayThanhToanandHDH(int ma) {
        ArrayList<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT MaHD, NgayThanhToan, TongTien, TrangThai\n"
                    + " FROM     dbo.HoaDon where NgayThanhToan like '%" + ma + "%' and TrangThai = 2";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getDate(2), rs.getBigDecimal(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

//    public static List<HoaDon> finByKhoangNgayThanhToan(Date min, Date max) {
//        List<HoaDon> listsp = new ArrayList<>();
//        Connection con;
//        try {
//            con = DBContext.getConnection();
//            String sql = "MaHD, NgayThanhToan, TongTien, TrangThai \n"
//                    + "    FROM HoaDon  where NgayThanhToan  between '%" + min + "%' and  '%" + max + "%'";
//
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getDate(2), rs.getBigDecimal(3), rs.getInt(4));
//                listsp.add(bhsp);
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return listsp;
//    }
    public List<HoaDon> finByKhoangNgayThanhToan(String gia, String gia2) {
        List<HoaDon> lst = new ArrayList<>();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery("SELECT MaHD, NgayTao, NgayThanhToan, TongTien \n"
                    + "    FROM HoaDon  where NgayThanhToan  between :gia and :gia2");
            q.setParameter("gia",  gia);
            q.setParameter("gia2",  gia2);
            
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
    
    public ArrayList<ThongKe> finByBieuDo() {

        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT YEAR(NgayThanhToan) as Ngay, sum(TongTien) as Tien\n" +
"                     FROM HoaDon \n" +
"					 Group by YEAR(NgayThanhToan)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("Tien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    //-----------------
    //----------------------
    
}
