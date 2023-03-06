package codegym.vn.repository;

import java.util.HashMap;
import java.util.Map;

public class DictionaryRepository {
    public String dictionary(String eng){
        Map<String,String>map=new HashMap<>();
        map.put("mango","xoai");
        map.put("apple","tao");
        map.put("banana","chuoi");
        String result =map.get(eng);
        if(result==null){
            result="not found";
        }else {
            result=map.get(eng);    
        }
        return result;
    }
}
