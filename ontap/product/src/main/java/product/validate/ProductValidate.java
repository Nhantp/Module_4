//package product.validate;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//import product.model.Product;
//import product.service.IProductService;
//
//import java.util.regex.Pattern;
//
//@Component
//public class ProductValidate implements Validator {
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Product.class.isAnonymousClass();
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        if (!(target instanceof Product)) {
//            return;
//        }
//        Product product = (Product) target;
//        if (product.getProductName() == null || product.getProductName().isEmpty()) {
//            errors.rejectValue("productName", "create.notEmpty", "error");
//        }
//        if (product.getProductName().length() >= 800) {
//            errors.rejectValue("productName", "create.maxSize", "error");
//        }
//        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
//        if (!pattern.matcher(product.getProductName()).matches()) {
//            errors.rejectValue("productName", "create.characters", "error");
//        }
//    }
//}
