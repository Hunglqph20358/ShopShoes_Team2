/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.HoaDon;
import com.mycompany.Repository.HoaDonRepository;
import com.mycompany.Service.HoaDonService;
import com.mycompany.ViewModel.BanHang.HoaDonViewModels;
import com.mycompany.ViewModel.hoaDon.QLHoaDonViewModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FPT
 */
public class HoaDonServiceIpm implements HoaDonService {

    private HoaDonRepository hoaDonRepository;

    public HoaDonServiceIpm() {
        this.hoaDonRepository = new HoaDonRepository();
    }

    @Override
    public List<HoaDonViewModels> getAllHD() {
        List<HoaDon> lst = hoaDonRepository.getAllHD();
        List<HoaDonViewModels> lst_view = new ArrayList<>();
        for (HoaDon hoaDon : lst) {
            HoaDonViewModels hoaDonViewModels = new HoaDonViewModels();
            hoaDonViewModels.setId(hoaDon.getId());
            hoaDonViewModels.setMa(hoaDon.getMaHD());
            hoaDonViewModels.setNgayTao(hoaDon.getNgayTao());
            hoaDonViewModels.setTenNV(hoaDon.getNhanVien().getHoTen());
            hoaDonViewModels.setTrangThai(hoaDon.getTrangThai());
            hoaDonViewModels.setNgayShip(hoaDon.getNgayShip());
            hoaDonViewModels.setKhachHang(hoaDon.getKhachHang());
            hoaDonViewModels.setNgayNhanHang(hoaDon.getNgayNhanHang());
            hoaDonViewModels.setNgayDaNhanHang(hoaDon.getNgayDaNhanHang());
            hoaDonViewModels.setPhiShip(hoaDon.getPhiShip());
            hoaDonViewModels.setDiaChiNhan(hoaDon.getDiaChiGiaoHang());
            hoaDonViewModels.setGhiChu(hoaDon.getGhiChu());
            hoaDonViewModels.setSDTNguoiGiaoHang(hoaDon.getSDTNguoiGiaoHang());
            lst_view.add(hoaDonViewModels);
        }
        return lst_view;
    }

    @Override
    public Integer addHD(HoaDon hd) {
        return hoaDonRepository.addHD(hd);
    }

    @Override
    public Integer updateHD(HoaDon hd) {
        return hoaDonRepository.updateHD(hd);
    }

    @Override
    public Integer updateHDDatHang(HoaDon hd) {
        return hoaDonRepository.updateHDDatHang(hd);
    }

    @Override
    public List<HoaDon> getAllHDCheckMa() {
        return hoaDonRepository.getAllHDCheckMa();
    }

    @Override
    public Integer updateHDDatHangThanhCong(HoaDon hd) {
        return hoaDonRepository.updateHDDatHangThanhCong(hd);
    }

    @Override
    public List<HoaDonViewModels> getAllHDByTrangThai(int tt) {
        List<HoaDon> lst = hoaDonRepository.getAllHDByTrangThai(tt);
        List<HoaDonViewModels> lst_view = new ArrayList<>();
        for (HoaDon hoaDon : lst) {
            HoaDonViewModels hoaDonViewModels = new HoaDonViewModels();
            hoaDonViewModels.setId(hoaDon.getId());
            hoaDonViewModels.setMa(hoaDon.getMaHD());
            hoaDonViewModels.setNgayTao(hoaDon.getNgayTao());
            hoaDonViewModels.setTenNV(hoaDon.getNhanVien().getHoTen());
            hoaDonViewModels.setTrangThai(hoaDon.getTrangThai());
            hoaDonViewModels.setNgayShip(hoaDon.getNgayShip());
            hoaDonViewModels.setKhachHang(hoaDon.getKhachHang());
            hoaDonViewModels.setNgayNhanHang(hoaDon.getNgayNhanHang());
            hoaDonViewModels.setNgayDaNhanHang(hoaDon.getNgayDaNhanHang());
            hoaDonViewModels.setPhiShip(hoaDon.getPhiShip());
            hoaDonViewModels.setDiaChiNhan(hoaDon.getDiaChiGiaoHang());
            hoaDonViewModels.setGhiChu(hoaDon.getGhiChu());
            hoaDonViewModels.setSDTNguoiGiaoHang(hoaDon.getSDTNguoiGiaoHang());
            lst_view.add(hoaDonViewModels);
        }
        return lst_view;
    }

    @Override
    public List<QLHoaDonViewModel> getAllHDViewQLHD() {
        List<HoaDon> lst = hoaDonRepository.getAllHDViewQLHD();
        List<QLHoaDonViewModel> lst_view = new ArrayList<>();
        for (HoaDon hd : lst) {
            String hoTen= null;
            if(hd.getKhachHang() == null){
                hoTen = " ";
            }else{
                hoTen = hd.getKhachHang().getHoTen();
            }
            QLHoaDonViewModel ql = new QLHoaDonViewModel(hd.getMaHD(),
                    hd.getNhanVien().getHoTen(),hoTen,hd.getTongTien()
                    ,hd.getNgayTao(), hd.getNgayThanhToan(), hd.getGhiChu(),hd.getTrangThai());
            
            lst_view.add(ql);
        }
        return lst_view;
    }

}