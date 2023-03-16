package codegym.vn.repository;

import codegym.vn.model.BaiHat;

import java.util.List;

public interface IBaiHatRepository {
    void create(BaiHat baiHat);
    List<BaiHat>findAll();
}
