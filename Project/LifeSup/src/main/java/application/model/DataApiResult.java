package application.model;

/**
 * Created by hoangmanh on 8/4/18.
 */
public class DataApiResult extends BaseApiResult {

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

