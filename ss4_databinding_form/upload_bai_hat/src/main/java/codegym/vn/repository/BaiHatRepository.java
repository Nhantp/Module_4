package codegym.vn.repository;

import codegym.vn.model.BaiHat;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BaiHatRepository implements IBaiHatRepository{

    @Override
    public void create(BaiHat baiHat) {

    }

    @Override
    public List<BaiHat> findAll() {
        return null;
    }
}
