package codegym.vn.service;

import codegym.vn.model.BaiHat;
import codegym.vn.repository.BaiHatRepository;
import codegym.vn.repository.IBaiHatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaiHatService implements IBaiHatService{
    @Autowired
    private IBaiHatRepository iBaiHatRepository;
    @Override
    public void create(BaiHat baiHat) {
        iBaiHatRepository.create(baiHat);
    }

    @Override
    public List<BaiHat> findAll() {
        return iBaiHatRepository.findAll();
    }
    public IBaiHatRepository getBaiHatRepository(){
        return iBaiHatRepository;
    }
    public void setIBaiHatRepository(IBaiHatRepository iBaiHatRepository){
        this.iBaiHatRepository=iBaiHatRepository;
    }

}
