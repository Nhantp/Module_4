package codegym.vn.service;

import codegym.vn.model.BaiHat;

import java.util.List;

public interface IBaiHatService {
    void create(BaiHat baiHat);
    List<BaiHat> findAll();
}
