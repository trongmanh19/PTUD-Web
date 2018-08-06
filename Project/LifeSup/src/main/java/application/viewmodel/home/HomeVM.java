package application.viewmodel.home;

import application.data.model.CustomQueryBangDiemModel;
import java.util.ArrayList;

/**
 * Created by hoangmanh on 8/4/18.
 */
public class HomeVM {

    private ArrayList<CustomQueryBangDiemModel> listLopHoc;
    private String messageTotalLopMonHoc;

    public ArrayList<CustomQueryBangDiemModel> getListLopHoc() {
        return listLopHoc;
    }

    public void setListLopHoc(ArrayList<CustomQueryBangDiemModel> listLopHoc) {
        this.listLopHoc = listLopHoc;
    }

    public String getMessageTotalLopMonHoc() {
        return messageTotalLopMonHoc;
    }

    public void setMessageTotalLopMonHoc(String messageTotalLopMonHoc) {
        this.messageTotalLopMonHoc = messageTotalLopMonHoc;
    }
}
