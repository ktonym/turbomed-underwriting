package ke.co.turbosoft.med.vo;

/**
 * Created by akipkoech on 2/27/15.
 */
public class ResultFactory {

    public static <T> Result<T> getSuccessResult(T data){
        return new Result(true, data);
    }

    public static <T> Result<T> getSuccessResult(T data, String msg){
        return new Result(true, msg);
    }

    public static <T> Result<T> getSuccessResult(String msg){
        return new Result(true, msg);
    }

    public static <T> Result<T> getFailResult(String msg){
        return new Result(false,msg);
    }

}
