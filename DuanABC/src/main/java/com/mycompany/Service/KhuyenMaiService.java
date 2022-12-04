/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.NhaCungCap;
import com.mycompany.DomainModels.PhieuGiamGia;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface KhuyenMaiService {
     List<PhieuGiamGia> GetALLGG();

    void insert(PhieuGiamGia sp);

    void update(String Ma, PhieuGiamGia sp);
    void delete(String Ma);

}
