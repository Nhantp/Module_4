package codegym.vn.repository;

import codegym.vn.model.KhaiBao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class KhaiBaoRepository implements IKhaiBaoRepository {
    private List<KhaiBao> khaiBaoList = new ArrayList<>();

    @Override
    public void create(KhaiBao khaiBao) {
        khaiBaoList.add(khaiBao);
    }

    @Override
    public List<KhaiBao> findAll() {
        return khaiBaoList;
    }
}
