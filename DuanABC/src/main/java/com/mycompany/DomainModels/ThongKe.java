/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DomainModels;

/**
 *
 * @author nqtin
 */
public class ThongKe {
    private String Ngay;
    private int Tien;

    public ThongKe() {
    }

    public ThongKe(String Ngay, int Tien) {
        this.Ngay = Ngay;
        this.Tien = Tien;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String Ngay) {
        this.Ngay = Ngay;
    }

    
    public int getTien() {
        return Tien;
    }

    public void setTien(int Tien) {
        this.Tien = Tien;
    }
    
}
