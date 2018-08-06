package application.controller.web;

import application.constant.Constant;
import application.data.model.CustomQueryBangDiemModel;
import application.data.model.LopHoc;
import application.data.service.BangDiemService;
import application.data.service.LopHocService;
import application.model.LopHocDataModel;
import application.viewmodel.home.HomeVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoangmanh on 8/3/18.
 */
@Controller
@RequestMapping(path = "/")
public class HomeController {

    @Autowired
    private LopHocService lopHocService;

    @Autowired
    private BangDiemService bangDiemService;

    @GetMapping(path="/")
    public String homePage(Model model, @RequestParam(value = "pageNumber", required = false) Integer pageNumber) {

        int pageSize = Constant.DEFAULT_PAGE_SIZE;

        HomeVM vm = new HomeVM();

        long totalLopHoc = lopHocService.getTotalLopHoc();
        vm.setMessageTotalLopMonHoc("Tổng số : " + totalLopHoc + " lớp môn học");

        try {
            ModelMapper modelMapper = new ModelMapper();
            List<CustomQueryBangDiemModel> listBangDiemWithLopHoc = bangDiemService.getListBangDiemWithLopHoc();
            ArrayList<CustomQueryBangDiemModel> dataModelArrayList = new ArrayList<>();
            for (CustomQueryBangDiemModel item : listBangDiemWithLopHoc) {
                dataModelArrayList.add(modelMapper.map(item, CustomQueryBangDiemModel.class));
            }
            vm.setListLopHoc(dataModelArrayList);
        } catch (Exception e) {

        }

        model.addAttribute("vm", vm);
        return "index";
    }
}
