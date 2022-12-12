/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.DomainModels.GiamGiaChiTiet;
import com.mycompany.DomainModels.LoaiSP;
import com.mycompany.DomainModels.MauSac;
import com.mycompany.DomainModels.SanPham;
import com.mycompany.Util.DBContext;
import com.mycompany.Util.HibernateUtil;
import com.mycompany.ViewModel.BanHang.SanPhamViewModelBanHang;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
public class ChiTietSPRepository {

    //HungLQPH20358
    public List<ChiTietSP> getAll() {
        List<ChiTietSP> lst = new ArrayList<>();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            CriteriaBuilder builder = sess.getCriteriaBuilder();
            CriteriaQuery<ChiTietSP> query = builder.createQuery(ChiTietSP.class);
            Root<ChiTietSP> ctspRoot = query.from(ChiTietSP.class);
            Root<SanPham> spRoot = query.from(SanPham.class);
            Root<LoaiSP> loaispRoot = query.from(LoaiSP.class);
            Root<MauSac> msRoot = query.from(MauSac.class);
            query = query.where(builder.equal(ctspRoot.get("sanPham"), spRoot.get("Id")),
                    builder.equal(ctspRoot.get("loaiSP"), loaispRoot.get("Id")),
                    builder.equal(ctspRoot.get("mauSac"), msRoot.get("Id")));
            query.select(ctspRoot);
            Query q = sess.createQuery(query);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
    public List<ChiTietSP> getAllPhanTrang(int soTrang) {
        List<ChiTietSP> lst = new ArrayList<>();
        String sql = "select TOP 5 ctsp.Id, sp.Ma as MaSP, sp.Ten as TenSP ,loai.Ten as tenLoai ,ms.Ten as tenMauSac,ctsp.Size,ctsp.SoLuong,ctsp.GiaBan from ChiTietSP ctsp join SanPham sp on ctsp.IdGiay = sp.Id \n" +
"  join LoaiSP loai on ctsp.IdLoaiSP = loai.Id join MauSac ms on ctsp.IdMauSac = ms.Id where ctsp.Id not in (select top "+(soTrang-1) * 5 +" Id from ChiTietSP)";
        try (Connection con = DBContext.getConnection();PreparedStatement ps = con.prepareCall(sql)) {
         ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
               SanPham sp = new SanPham();
               sp.setMa(rs.getString("MaSP"));
               sp.setTen(rs.getString("TenSP"));
               LoaiSP loaisp = new LoaiSP();
               loaisp.setTen(rs.getString("tenLoai"));
               MauSac ms = new MauSac();
               ms.setTen(rs.getString("tenMauSac"));
               ChiTietSP ctsp = new ChiTietSP();
               ctsp.setId(rs.getString("Id"));
               ctsp.setSanPham(sp);
               ctsp.setLoaiSP(loaisp);
               ctsp.setMauSac(ms);
               ctsp.setSize(rs.getInt("Size"));
               ctsp.setSoLuong(rs.getInt("SoLuong"));
               ctsp.setGiaBan(rs.getBigDecimal("GiaBan"));
               lst.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
    public int countSanPhamBanHang() {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery("select Count(*) from ChiTietSP ctsp");
            return Integer.parseInt(q.getSingleResult().toString());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    } 
    
    
    public List<ChiTietSP> getAllBySearch(String timKiem) {
        List<ChiTietSP> lst = new ArrayList<>();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery("Select ctsp From ChiTietSP ctsp join "
                    + "ctsp.sanPham sp join ctsp.loaiSP loai join ctsp.mauSac ms"
                    + " where sp.Ma like :tt1 OR sp.Ten like :tt2 or loai.Ten like :tt3 or ms.Ten like :tt4");
            q.setParameter("tt1", "%" + timKiem + "%");
            q.setParameter("tt2", "%" + timKiem + "%");
            q.setParameter("tt3", "%" + timKiem + "%");
            q.setParameter("tt4", "%" + timKiem + "%");
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
    public List<ChiTietSP> getAllByKhoangGia(BigDecimal gia, BigDecimal gia2) {
        List<ChiTietSP> lst = new ArrayList<>();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery("Select ctsp From ChiTietSP ctsp join "
                    + "ctsp.sanPham sp join ctsp.loaiSP loai join ctsp.mauSac ms"
                    + " where ctsp.GiaBan between :gia and :gia2");
            q.setParameter("gia",  gia);
            q.setParameter("gia2",  gia2);
            
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public Integer updateSPKhiMua(ChiTietSP sp) {
        Integer row = null;
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            String hql = "update ChiTietSP set SoLuong = :sl where Id = :id";
            sess.getTransaction().begin();
            Query q = sess.createQuery(hql);
            q.setParameter("sl", sp.getSoLuong());
            q.setParameter("id", sp.getId());
            row = q.executeUpdate();
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return row;
    }

    public ChiTietSP getSPByQRCode(String barcode) {
        ChiTietSP ctsp = new ChiTietSP();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select ctsp From ChiTietSP ctsp join ctsp.sanPham sp "
                    + "join ctsp.loaiSP lsp join ctsp.mauSac ms  where Barcode = :qr";
            Query q = sess.createQuery(hql);
            q.setParameter("qr", barcode);
            ctsp = (ChiTietSP) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ctsp;
    }
    //HUNGLQPH20358
    //-------------///

//     public ArrayList<SanPhamViewModel> All() {
//        ArrayList<SanPhamViewModel> list = new ArrayList<>();
//        try {
//
//            Connection conn = DBContext.getConnection();
//            String select = "select ChiTietSP.Id, ChiTietSP.TrangThai, SanPham.Ma,SanPham.Ten as 'TenSP',MauSac.Ten as 'TenMS',NhaCungCap.Ten as 'TenNCC',NSX.Ten as 'TenNSX',Hang.Ten as 'TenHang',LoaiSP.Ten as 'TenLoai',ChiTietSP.Size,ChiTietSP.SoLuong,ChiTietSP.GiaNhap,ChiTietSP.GiaBan from ChiTietSP \n"
//                    + "join NSX on NSX.Id=ChiTietSP.IdNsx\n"
//                    + "join NhaCungCap on NhaCungCap.Id=ChiTietSP.IdNhaCC\n"
//                    + "join MauSac on MauSac.Id=ChiTietSP.IdMauSac\n"
//                    + "join Hang on Hang.Id=ChiTietSP.IdHang\n"
//                    + "join LoaiSP on LoaiSP.Id=ChiTietSP.IdLoaiSP\n"
//                    + "join SanPham on SanPham.Id=ChiTietSP.IdGiay";
//            PreparedStatement ps = conn.prepareStatement(select);
//            ps.execute();
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String Id = rs.getString("Id");
//                String masp = rs.getString("Ma");
//                String tensp = rs.getString("TenSP");
//                String tenmausac = rs.getString("TenMS");
//                String tenncc = rs.getString("TenNCC");
//                String tennsx = rs.getString("TenNSX");
//                String tenhang = rs.getString("TenHang");
//                String tenloai = rs.getString("TenLoai");
//                String size = rs.getString("Size");
//                int soluongton = rs.getInt("SoLuong");
//                int gianhap = rs.getInt("GiaNhap");
//                int giaban = rs.getInt("GiaBan");
//                int tt = rs.getInt("TrangThai");
//                SanPhamViewModel ctsp = new SanPhamViewModel(Id, masp, tensp, tenmausac, tenncc, tennsx, tenhang, tenloai, size, soluongton, gianhap, giaban,null,tt);
//                list.add(ctsp);
//
//            }
//        } catch (Exception ex) {
//
//        }
//        return list;
//    }
    public Integer Update(ChiTietSP ct) {
        Integer row = null;
        try {
            Connection con = DBContext.getConnection();
            String sql = "update ChiTietSP set IdLoaiSP = ? , IdNsx = ?, IdMauSac = ?,IdHang = ?, IdNhaCC = ?  , MoTa = ? , Size = ? , SoLuong = ?\n"
                    + ",GiaNhap = ? , GiaBan = ? , TrangThai = ? where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            String idLoai = null;
            String idNsx = null;
            String IdMauSac = null;
            String IdHang = null;
            String IdNCC = null;
            if (ct.getLoaiSP() != null) {
                idLoai = ct.getLoaiSP().getId();
            }
            if (ct.getNsx() != null) {
                idNsx = ct.getNsx().getId();
            }
            if (ct.getMauSac() != null) {
                IdMauSac = ct.getMauSac().getId();
            }
            if (ct.getNcc() != null) {
                IdNCC = ct.getNcc().getId();
            }
            if (ct.getHang() != null) {
                IdHang = ct.getHang().getId();
            }
            ps.setString(1, idLoai);
            ps.setString(2, idNsx);
            ps.setString(3, IdMauSac);
            ps.setString(4, IdHang);
            ps.setString(5, IdNCC);

            ps.setString(6, ct.getMoTa());
            ps.setInt(7, ct.getSize());
            ps.setInt(8, ct.getSoLuong());
            ps.setBigDecimal(9, ct.getGiaNhap());
            ps.setBigDecimal(10, ct.getGiaBan());
            ps.setInt(11, ct.getTrangThai());
            ps.setString(12, ct.getId());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer Add(ChiTietSP ctsp) {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            sess.save(ctsp);
            sess.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
}
