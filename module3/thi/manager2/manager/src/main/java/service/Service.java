package service;

import model.BenhAn;

import java.util.List;

public interface Service {
    List<BenhAn> getAll();
    BenhAn getById(String id);
    void update(String id,String name,String ngay_vao,String ngay_ra,String ly_do);
}
