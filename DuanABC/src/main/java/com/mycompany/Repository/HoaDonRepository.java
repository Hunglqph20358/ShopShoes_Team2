/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.HinhThucThanhToan;
import com.mycompany.DomainModels.HoaDon;
import com.mycompany.DomainModels.KhachHang;
import com.mycompany.DomainModels.NhanVien;
import com.mycompany.Util.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
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
    
    public static void main(String[] args) {
        new HoaDonRepository().getAllHDViewQLHD().forEach(c -> System.out.println(c.toString()));
    }
    
}
