package codegym.vn.repository;

import codegym.vn.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
    private static List<Product>productList;
    static {
        productList=new ArrayList<>();
        productList.add(new Product(1,"banh",22,"kk","kd"));
        productList.add(new Product(1,"banh1",223,"kk1","kd1"));
        productList.add(new Product(3,"banh2",224,"kk2","kd2"));
        productList.add(new Product(4,"banh3",225,"kk3","kd3"));
        productList.add(new Product(5,"banh4",226,"kk4","kd4"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void addNew(Product product) {
        productList.add(product);
    }

    @Override
    public void update(Product product) {
        int index= index(product.getId());
        productList.set(index,product);

    }
    public int index(int id){
        for(int i=0; i<productList.size(); i++){
            if(id==productList.get(i).getId()){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void remove(int id) {
        productList.remove(index(id));
    }

    @Override
    public Product findById(int id) {
        return productList.get(index(id));
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product>result=new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                result.add(product);
            }
        }
        return result;
    }
}
