package application.data.model;

import java.util.List;

/**
 * Created by hoangmanh on 8/4/18.
 */
public class PaginableItemList<T> {
    private int pageSize;
    private int pageNumber;
    private long totalBangDiem;
    private List<T> listData;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getTotalBangDiem() {
        return totalBangDiem;
    }

    public void setTotalBangDiem(long totalBangDiem) {
        this.totalBangDiem = totalBangDiem;
    }

    public List<T> getListData() {
        return listData;
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }
}
