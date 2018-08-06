package application.data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoangmanh on 8/3/18.
 */
@Entity(name = "lophoc")
public class LopHoc {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idlophoc")
    @Id
    private int id;

    @Column(name = "tenlop")
    private String tenlop;

    @OneToMany(mappedBy = "lopHoc")
    private List<BangDiem> products = new ArrayList<BangDiem>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public List<BangDiem> getProducts() {
        return products;
    }

    public void setProducts(List<BangDiem> products) {
        this.products = products;
    }
}
