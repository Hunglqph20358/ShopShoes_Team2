/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.DomainModels.Hang;
import com.mycompany.DomainModels.MauSac;
import com.mycompany.DomainModels.NhaCungCap;
import com.mycompany.DomainModels.NhaSanXuat;
import com.mycompany.DomainModels.SanPham;
import com.mycompany.Util.DBContext;
import com.mycompany.ViewModel.ThongKe.ThongKeViewModel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.bridj.cpp.std.list;

/**
 *
 * @author kunrl
 */
public class ThongKeRepository {

    public ArrayList<ChiTietSP> getAllSP() {
        ArrayList<ChiTietSP> list = new ArrayList<>();
        try ( Connection con = DBContext.getConnection()) {

            String sql = "select SanPham.Ma as 'Ma', SanPham.Ten as 'TenSP', MauSac.Ten as 'TenMS', NhaCungCap.Ten as 'TenNCC', NSX.Ten as 'TenNSX', Hang.Ten as 'TenHang', SoLuong, Size, GiaBan, GiaNhap from ChiTietSP\n"
                    + "join SanPham on SanPham.Id = ChiTietSP.IdGiay\n"
                    + "join MauSac on MauSac.Id = ChiTietSP.IdMauSac\n"
                    + "join NhaCungCap on NhaCungCap.Id = ChiTietSP.IdNhaCC\n"
                    + "join NSX on NSX.Id = ChiTietSP.IdNsx\n"
                    + "join Hang on Hang.Id = ChiTietSP.IdHang\n"
                    + "where SoLuong < 10";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                String masp = rs.getString("Ma");
                String tensp = rs.getString("TenSP");
                String tenms = rs.getString("TenMS");
                String tenncc = rs.getString("TenNCC");
                String tennsx = rs.getString("TenNSX");
                String tenhang = rs.getString("TenHang");
                int soluong = rs.getInt("SoLuong");
                int size = rs.getInt("Size");
                BigDecimal GiaBan = rs.getBigDecimal("GiaBan");
                BigDecimal GiaNhap = rs.getBigDecimal("GiaNhap");
                MauSac ms = new MauSac();
                ms.setTen(tenms);
                SanPham sp = new SanPham();
                sp.setMa(masp);
                sp.setTen(tensp);
                NhaSanXuat nsx = new NhaSanXuat();
                nsx.setTen(tennsx);
                Hang hang = new Hang();
                hang.setTen(tenhang);
                NhaCungCap ncc = new NhaCungCap();
                ncc.setTen(tenncc);
            
                ChiTietSP tk = new ChiTietSP(null,sp,null, nsx, ms, hang, ncc, null,null,size, soluong, GiaNhap, GiaBan,null,null);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
//    public static void main(String[] args) {
//        new ThongKeRepository().getAllSP().forEach(c -> System.out.println(c.toString()));
//    }

}
