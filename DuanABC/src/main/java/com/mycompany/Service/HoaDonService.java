/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.HoaDon;
import com.mycompany.DomainModels.ThongKe;
import com.mycompany.ViewModel.BanHang.HoaDonViewModels;
import com.mycompany.ViewModel.hoaDon.QLHoaDonViewModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FPT
 */
public interface HoaDonService {

    List<HoaDonViewModels> getAllHD();

    List<QLHoaDonViewModel> getAllHDViewQLHD();

    List<QLHoaDonViewModel> getAllHDViewQLHDByTrangThai(Integer trangThai);
    
    List<QLHoaDonViewModel> getAllHDViewQLHDByNgay(Date ngay, Date ngay2);
    
    List<QLHoaDonViewModel> getAllHDViewQLHDBySearch(String timKiem);

    List<HoaDonViewModels> getAllHDByTrangThai(int tt);

    List<HoaDon> getAllHDCheckMa();

    Integer updateHDDatHang(HoaDon hd);

    Integer addHD(HoaDon hd);

    Integer updateHD(HoaDon hd);

    Integer updateHDDatHangThanhCong(HoaDon hd);
    
     //tinhph23160-----------------
    ArrayList<HoaDonViewModels> finbyngaythanhToan(String hd);

    ArrayList<HoaDon> finbyngaytrangThai(int ma);

    ArrayList<HoaDon> finbyngaythanhToanhomNay(int ma);

    ArrayList<HoaDon> finByNgayThanhToanandHDTK(int ma);

    ArrayList<HoaDon> finByNgayThanhToanandHDH(int ma);

    List<HoaDon> finByKhoangNgayThanhToan(String timkiem, String tk);

    List<HoaDonViewModels> GetListHoaSon();

    ArrayList<ThongKe> finByBieuDo();
}
