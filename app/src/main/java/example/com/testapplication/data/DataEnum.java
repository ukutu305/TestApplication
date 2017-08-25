package example.com.testapplication.data;

/**
 * データアクセスのenumクラス
 * Created by ukutu305 on 2017/08/25.
 */
public enum DataEnum {

    LEVEL("LEVEL", DataAccess.TYPE.INT),
    NAME("NAME", DataAccess.TYPE.STRING),
    IS_CONTINUE("IS_CONTINUE", DataAccess.TYPE.BOOLEAN);

    private String key;

    private DataAccess.TYPE type;

    DataEnum(String key, DataAccess.TYPE type) {
        this.key = key;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public DataAccess.TYPE getType() {
        return type;
    }
}
