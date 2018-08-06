package application.data.model;

/**
 * Created by hoangmanh on 8/5/18.
 */
public class CustomQueryBangDiemModel {

    private int bangDiemId;
    private String lopHocName;

    public CustomQueryBangDiemModel(int bangDiemId, String lopHocName) {
        this.bangDiemId = bangDiemId;
        this.lopHocName = lopHocName;
    }

    public int getBangDiemId() {
        return bangDiemId;
    }

    public void setBangDiemId(int bangDiemId) {
        this.bangDiemId = bangDiemId;
    }

    public String getLopHocName() {
        return lopHocName;
    }

    public void setLopHocName(String lopHocName) {
        this.lopHocName = lopHocName;
    }
}
