package codegym.vn.repository;

import codegym.vn.model.HomDienTu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomDienTuRepository implements IHomDienTuRepository{
    static Map<String,HomDienTu> homDienTuMap;
    static {
        homDienTuMap=new HashMap<>();
        homDienTuMap.put("HDT01",new HomDienTu("HDT01","English",5,"Enable spams filter","dd"));
        homDienTuMap.put("HDT02",new HomDienTu("HDT02","Vietnamese",5,"Enable spams filter","dd"));
        homDienTuMap.put("HDT03",new HomDienTu("HDT03","Japanese",5,"Enable spams filter","dd"));
        homDienTuMap.put("HDT04",new HomDienTu("HDT04","English",5,"","dd"));
    }
    public void create(HomDienTu homDienTu){
        homDienTuMap.put(homDienTu.getId(),homDienTu);
    }
    public List<HomDienTu> findAll(){
        return new ArrayList<>(homDienTuMap.values());
    }

    @Override
    public HomDienTu findById(String id) {
        return homDienTuMap.get(id);
    }

}
