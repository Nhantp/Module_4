package codegym.vn.repository;

import codegym.vn.model.HomDienTu;

import java.util.List;

public interface IHomDienTuRepository {
    void create(HomDienTu homDienTu);
    List<HomDienTu>findAll();
    HomDienTu findById(String id);
}
