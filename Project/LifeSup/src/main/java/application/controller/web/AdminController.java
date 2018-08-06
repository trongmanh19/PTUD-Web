package application.controller.web;

import application.constant.Constant;
import application.data.model.BangDiem;
import application.data.model.LopHoc;
import application.data.model.PaginableItemList;
import application.data.service.BangDiemService;
import application.data.service.LopHocService;
import application.model.LopHocDataModel;
import application.viewmodel.admin.AdminBangDiemVM;
import application.viewmodel.common.BangDiemVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoangmanh on 8/4/18.
 */
@Controller
@RequestMapping(path = "/admin", method = RequestMethod.GET)
public class AdminController {

    @Autowired
    private BangDiemService bangDiemService;

    @Autowired
    private LopHocService lopHocService;

    @RequestMapping(path = "/bangdiem-management", method = RequestMethod.GET)
    public String admin(Model model, @RequestParam(value = "pageNumber", required = false) Integer pageNumber) {

        int pageSize = Constant.DEFAULT_PAGE_SIZE;

        AdminBangDiemVM vm = new AdminBangDiemVM();

        long totalBangDiem = bangDiemService.getTotalBangDiem();
        vm.setMessageTotalBangDiem("Tổng số bảng điểm: " + totalBangDiem);

        if (pageNumber == null) {
            pageNumber = 1;
        }

        try {
            PaginableItemList<BangDiem> paginableItemList = bangDiemService.getListBangDiem(pageSize, pageNumber - 1);

            List<BangDiem> listBangDiem = paginableItemList.getListData();
            ArrayList<BangDiemVM> listBangDiemVM = new ArrayList<>();
            ModelMapper modelMapper = new ModelMapper();

            for (BangDiem product : listBangDiem) {
                BangDiemVM productVM = modelMapper.map(product, BangDiemVM.class);
                listBangDiemVM.add(productVM);
            }
            vm.setListPagingBangDiem(listBangDiemVM);

            int totalPages = 0;
            if (paginableItemList.getTotalBangDiem() % pageSize == 0) {
                totalPages = (int) (paginableItemList.getTotalBangDiem() / pageSize);
            } else {
                totalPages = (int) (paginableItemList.getTotalBangDiem() / pageSize) + 1;
            }
            vm.setTotalPagingItems(totalPages);
            vm.setCurrentPage(pageNumber);

            List<LopHoc> listCategories = lopHocService.getListAllLopHoc();
            ArrayList<LopHocDataModel> dataModelArrayList = new ArrayList<>();
            for (LopHoc lop : listCategories) {
                dataModelArrayList.add(modelMapper.map(lop, LopHocDataModel.class));
            }
            vm.setListLopHoc(dataModelArrayList);
        } catch (Exception e) {

        }

        model.addAttribute("vm", vm);
        return "admin";
    }
}
