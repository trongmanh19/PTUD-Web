package application.viewmodel.common;

import application.model.LopHocDataModel;

/**
 * Created by hoangmanh on 8/4/18.
 */
public class BangDiemVM {
    private int id;
    private String link;
    private LopHocDataModel lophoc;

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

    public LopHocDataModel getLophoc() {
        return lophoc;
    }

    public void setLophoc(LopHocDataModel lophoc) {
        this.lophoc = lophoc;
    }
}
