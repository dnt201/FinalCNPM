package utl;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class FormUtil {

    public static <T> T toModel(Class<T> tClass, HttpServletRequest req){
        T value = null;
        try{
            value = tClass.newInstance();
            BeanUtils.populate(value, req.getParameterMap());
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return value;
    }
}
