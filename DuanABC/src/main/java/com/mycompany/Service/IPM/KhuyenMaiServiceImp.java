/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.PhieuGiamGia;
import com.mycompany.Repository.KhuyenMaiRepository;
import com.mycompany.Service.KhuyenMaiService;
import java.util.List;

/**
 *
 * @author ACER
 */
public class KhuyenMaiServiceImp implements KhuyenMaiService{
    KhuyenMaiRepository khuyenMaiRepository=new KhuyenMaiRepository();
    @Override
    public List<PhieuGiamGia> GetALLGG() {
        return khuyenMaiRepository.getALLGG();
    }

    @Override
    public void insert(PhieuGiamGia sp) {
       khuyenMaiRepository.insert(sp);
    }

    @Override
    public void update(String Ma, PhieuGiamGia sp) {
        khuyenMaiRepository.update(Ma, sp);
    }

    @Override
    public void delete(String Ma) {
        khuyenMaiRepository.delete(Ma);
    }
    
}
