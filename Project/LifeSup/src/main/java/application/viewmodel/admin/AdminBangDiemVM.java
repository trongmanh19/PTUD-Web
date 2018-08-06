package application.viewmodel.admin;

import application.model.LopHocDataModel;
import application.viewmodel.common.BangDiemVM;

import java.util.ArrayList;

/**
 * Created by hoangmanh on 8/4/18.
 */
public class AdminBangDiemVM {
    private String messageTotalBangDiem;
    private ArrayList<BangDiemVM> listPagingBangDiem;
    private int totalPagingItems;
    private int currentPage;
    private ArrayList<LopHocDataModel> listLopHoc;

    public String getMessageTotalBangDiem() {
        return messageTotalBangDiem;
    }

    public void setMessageTotalBangDiem(String messageTotalBangDiem) {
        this.messageTotalBangDiem = messageTotalBangDiem;
    }

    public ArrayList<BangDiemVM> getListPagingBangDiem() {
        return listPagingBangDiem;
    }

    public void setListPagingBangDiem(ArrayList<BangDiemVM> listPagingBangDiem) {
        this.listPagingBangDiem = listPagingBangDiem;
    }

    public int getTotalPagingItems() {
        return totalPagingItems;
    }

    public void setTotalPagingItems(int totalPagingItems) {
        this.totalPagingItems = totalPagingItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public ArrayList<LopHocDataModel> getListLopHoc() {
        return listLopHoc;
    }

    public void setListLopHoc(ArrayList<LopHocDataModel> listLopHoc) {
        this.listLopHoc = listLopHoc;
    }
}
