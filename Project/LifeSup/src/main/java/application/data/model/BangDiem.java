package application.data.model;

import javax.persistence.*;

/**
 * Created by hoangmanh on 8/3/18.
 */
@Entity(name = "bangdiem")
public class BangDiem {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idbangdiem")
    @Id
    private int id;

    @Column(name = "link")
    private String link;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "idlophoc")
    private LopHoc lopHoc;

    @Column(name = "idlophoc", updatable = false, insertable = false)
    private int lopHocId;

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

    public LopHoc getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(LopHoc lopHoc) {
        this.lopHoc = lopHoc;
    }
}
