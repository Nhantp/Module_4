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
    IMusicService iMusicService;

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
            errors.rejectValue("name","create.notEmpty","error");
        }
        if(music.getName().length()>=800){
            errors.rejectValue("name","create.maxSize","error");
        }
        Pattern pattern=Pattern.compile("^[a-zA-Z0-9]+$");
        if(!pattern.matcher(music.getName()).matches()){
            errors.rejectValue("name","create.characters","error");
        }

        //validate Singer
        if (music.getSinger()==null||music.getSinger().isEmpty()){
            errors.rejectValue("singer","create.notEmpty","error");
        }
        if(music.getSinger().length()>=800){
            errors.rejectValue("singer","create.maxSize","error");
        }
        Pattern pattern1=Pattern.compile("^[a-zA-Z0-9]+$");
        if(!pattern1.matcher(music.getSinger()).matches()){
            errors.rejectValue("singer","create.characters","error");
        }

        //validate category
        if (music.getCategory()==null||music.getCategory().isEmpty()){
            errors.rejectValue("category","create.notEmpty","error");
        }
        if(music.getCategory().length()>=800){
            errors.rejectValue("category","create.maxSize","error");
        }
        Pattern pattern2=Pattern.compile("^[a-zA-Z0-9,]+$");
        if(!pattern2.matcher(music.getCategory()).matches()){
            errors.rejectValue("category","create.characters","error");
        }
    }
//
//    public IMusicService getIMusicService() {
//        return iMusicService;
//    }
//
//    public void setIMusicService(IMusicService iMusicService) {
//        this.iMusicService = iMusicService;
//    }
}
