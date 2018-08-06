package application.model;

/**
 * Created by hoangmanh on 8/5/18.
 */
public class BangDiemDetailModel {

    private int id;
    private String link;
    private LopHocDataModel lopHoc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LopHocDataModel getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(LopHocDataModel lopHoc) {
        this.lopHoc = lopHoc;
    }
}
