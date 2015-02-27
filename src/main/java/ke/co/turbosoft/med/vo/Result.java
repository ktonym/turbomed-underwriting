package ke.co.turbosoft.med.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by akipkoech on 2/27/15.
 */
public class Result<T> implements Serializable {

    final private boolean success;
    final private T data;
    final private String msg;

    Result(boolean success, T data){
        this.success = success;
        this.data = data;
        this.msg = null;
    }

    Result(boolean success, String msg){
        this.success = success;
        this.data = null;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\"Result{\"");
        sb.append("success=").append(success);
        sb.append(", msg=").append(msg);

        sb.append(", data=");

        if (data == null){
            sb.append("null");
        } else if (data instanceof List){
            List castList = (List) data;
            if(castList.isEmpty()){
                sb.append("empty list");
            }else {
                Object firstItem = castList.get(0);
                sb.append("List of ").append(firstItem.getClass());
            }

        }else {
            sb.append(data.toString());
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Result<?> result = (Result<?>) o;

        if (success != result.success) return false;
        if (!data.equals(result.data)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (success ? 1 : 0);
        result = 31 * result + data.hashCode();
        return result;
    }
}
