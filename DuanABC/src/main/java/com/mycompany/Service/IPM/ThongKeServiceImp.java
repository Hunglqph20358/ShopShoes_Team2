/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.Repository.ThongKeRepository;
import com.mycompany.Service.ThongKeService;
import com.mycompany.ViewModel.ThongKe.ThongKeViewModel;
import java.util.ArrayList;

/**
 *
 * @author kunrl
 */
public class ThongKeServiceImp implements ThongKeService {

    ThongKeRepository thongkerepo = new ThongKeRepository();

    @Override
    public ArrayList<ThongKeViewModel> getAllSanPhamThongKe() {
        ArrayList<ChiTietSP> list = thongkerepo.getAllSP();
        ArrayList<ThongKeViewModel> list_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : list) {
            ThongKeViewModel tkv = new ThongKeViewModel();
            tkv.setMa(chiTietSP.getSanPham().getMa());
            tkv.setTenSp(chiTietSP.getSanPham().getTen());
            tkv.setTenMausac(chiTietSP.getMauSac().getTen());
            tkv.setTenNcc(chiTietSP.getNcc().getTen());
            tkv.setTenNsx(chiTietSP.getNsx().getTen());
            tkv.setTenHang(chiTietSP.getHang().getTen());
            tkv.setSoLuong(chiTietSP.getSoLuong());
            tkv.setSize(chiTietSP.getSize());
            tkv.setGiaNhap(chiTietSP.getGiaNhap());
            tkv.setGiaban(chiTietSP.getGiaBan());
            list_view.add(tkv);
        }
        return list_view;
    }

}
