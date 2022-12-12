/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.Repository.ChiTietSPRepository;
import com.mycompany.Service.ChiTietSPService;
import com.mycompany.ViewModel.BanHang.SanPhamViewModelBanHang;
import com.mycompany.ViewModel.SanPham.SanPhamViewModelSP;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT
 */
public class CTSPSerivceIpm implements ChiTietSPService {

    private ChiTietSPRepository chiTietSPRepository;

    public CTSPSerivceIpm() {
        this.chiTietSPRepository = new ChiTietSPRepository();
    }

    @Override
    public List<SanPhamViewModelBanHang> getSPBanHang(int soTrang) {
        List<ChiTietSP> lst = chiTietSPRepository.getAllPhanTrang(soTrang);
        List<SanPhamViewModelBanHang> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelBanHang sp = new SanPhamViewModelBanHang();
            sp.setId(chiTietSP.getId());
            sp.setMaSP(chiTietSP.getSanPham().getMa());
            sp.setTenSP(chiTietSP.getSanPham().getTen());
            sp.setLoaiSP(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLunog(chiTietSP.getSoLuong());
            sp.setDonGia(chiTietSP.getGiaBan());
            lst_view.add(sp);
        }
        return lst_view;
    }
     @Override
    public int countSanPhamBanHang() {
        return chiTietSPRepository.countSanPhamBanHang();
    }
    //--------------------------------------

    @Override
    public List<SanPhamViewModelSP> getAllSP() {
        List<ChiTietSP> lst = chiTietSPRepository.getAll();
        List<SanPhamViewModelSP> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
         sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setNhaCungCap(chiTietSP.getNcc().getTen());
            sp.setHang(chiTietSP.getHang().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLuong(chiTietSP.getSoLuong());
            sp.setGiaNhap(chiTietSP.getGiaNhap());
            sp.setGiaBan(chiTietSP.getGiaBan());
            sp.setTrangThai(chiTietSP.getTrangThai());
            lst_view.add(sp);
        }
        return lst_view;
    }

    @Override
    public Integer updateSPKhiMua(ChiTietSP sp) {
        return chiTietSPRepository.updateSPKhiMua(sp);
    }

    @Override
    public Integer Update(ChiTietSP sp) {

        return chiTietSPRepository.Update(sp);
    }

    @Override
    public ChiTietSP getSPByQRCode(String barcode) {
        return chiTietSPRepository.getSPByQRCode(barcode);
    }

    @Override
    public Integer add(ChiTietSP ct) {
        return chiTietSPRepository.Add(ct);
    }

    @Override
    public List<SanPhamViewModelBanHang> getSPBanHangBySearch(String timKiem) {
        List<ChiTietSP> lst = chiTietSPRepository.getAllBySearch(timKiem);
        List<SanPhamViewModelBanHang> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelBanHang sp = new SanPhamViewModelBanHang();
            sp.setId(chiTietSP.getId());
            sp.setMaSP(chiTietSP.getSanPham().getMa());
            sp.setTenSP(chiTietSP.getSanPham().getTen());
            sp.setLoaiSP(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLunog(chiTietSP.getSoLuong());
            sp.setDonGia(chiTietSP.getGiaBan());
            lst_view.add(sp);
        }
        return lst_view;
    }

    @Override
    public List<SanPhamViewModelBanHang> getSPBanHangByKhoangGia(BigDecimal gia, BigDecimal gia2) {
        List<ChiTietSP> lst = chiTietSPRepository.getAllByKhoangGia(gia, gia2);
        List<SanPhamViewModelBanHang> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelBanHang sp = new SanPhamViewModelBanHang();
            sp.setId(chiTietSP.getId());
            sp.setMaSP(chiTietSP.getSanPham().getMa());
            sp.setTenSP(chiTietSP.getSanPham().getTen());
            sp.setLoaiSP(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLunog(chiTietSP.getSoLuong());
            sp.setDonGia(chiTietSP.getGiaBan());
            lst_view.add(sp);
        }
        return lst_view;
    }

   

}
