package application.data.service;

import application.data.model.BangDiem;
import application.data.model.CustomQueryBangDiemModel;
import application.data.model.PaginableItemList;
import application.data.repository.BangDiemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by hoangmanh on 8/4/18.
 */
@Service
public class BangDiemService {

    @Autowired
    private BangDiemRepository bangDiemRepository;

    public long getTotalBangDiem() {
        return bangDiemRepository.getTotalBangDiem();
    }

    public BangDiem findOne(int idBangDiem) {
        return bangDiemRepository.findOne(idBangDiem);
    }

    public void addNewBangDiem(BangDiem bangDiem) {
        bangDiemRepository.save(bangDiem);
    }

    @Transactional
    public void addNewListBangDiem(List<BangDiem> bangDiemList) {
        bangDiemRepository.save(bangDiemList);
    }

    public PaginableItemList<BangDiem> getListBangDiem(int pageSize, int pageNumber) {
        PaginableItemList<BangDiem> paginableItemList = new PaginableItemList<>();
        paginableItemList.setPageSize(pageSize);
        paginableItemList.setPageNumber(pageNumber);

        Page<BangDiem> pages = bangDiemRepository.findAll(new PageRequest(pageNumber, pageSize));
        paginableItemList.setTotalBangDiem(pages.getTotalElements());
        paginableItemList.setListData(pages.getContent());
        return paginableItemList;
    }

    public boolean deleteBangDiem(int bangDiemId) {
        try {
            bangDiemRepository.delete(bangDiemId);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean updateProduct(BangDiem bangDiem) {
        try {
            bangDiemRepository.save(bangDiem);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<CustomQueryBangDiemModel> getListBangDiemWithLopHoc() {
        return bangDiemRepository.getListBangDiemWithLopHoc();
    }
}
