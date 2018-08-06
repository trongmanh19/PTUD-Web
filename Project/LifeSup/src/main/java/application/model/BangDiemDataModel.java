package application.model;

/**
 * Created by hoangmanh on 8/4/18.
 */
public class BangDiemDataModel {

    private int id;
    private String link;
    private int idLopHoc;

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

    public int getIdLopHoc() {
        return idLopHoc;
    }

    public void setIdLopHoc(int idLopHoc) {
        this.idLopHoc = idLopHoc;
    }
}
