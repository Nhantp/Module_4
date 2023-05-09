package validate_music.validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import validate_music.model.Music;
import validate_music.service.IMusicService;

import java.util.regex.Pattern;

@Component
public class MusicValidate implements Validator {
    @Autowired


    @Override
    public boolean supports(Class<?> clazz) {
        return Music.class.isAnonymousClass();
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(!(target instanceof Music)){
            return;
        }
        Music music= (Music) target;
        if (music.getName()==null||music.getName().isEmpty()){
            errors.rejectValue("productName","create.notEmpty","error");
        }
        if(music.getName().length()>=800){
            errors.rejectValue("productName","create.maxSize","error");
        }
        Pattern pattern=Pattern.compile("^[a-zA-Z0-9]+$");
        if(!pattern.matcher(music.getName()).matches()) {
            errors.rejectValue("productName", "create.characters", "error");
        }


}
