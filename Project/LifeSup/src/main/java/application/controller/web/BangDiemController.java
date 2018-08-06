package application.controller.web;

import application.data.model.BangDiem;
import application.data.service.BangDiemService;
import application.model.BangDiemDetailModel;
import application.viewmodel.bangdiem.BangDiemIndexVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Created by hoangmanh on 8/5/18.
 */
@Controller
@RequestMapping("/view-point")
public class BangDiemController {

    @Autowired
    private BangDiemService bangDiemService;

    @GetMapping(path = "/detail/{bangDiemId}")
    public String bangDiem(Model model, @PathVariable int bangDiemId) {

        BangDiemIndexVM vm = new BangDiemIndexVM();
        BangDiem existBangDiem = bangDiemService.findOne(bangDiemId);
        if (existBangDiem != null) {
            ModelMapper modelMapper = new ModelMapper();
            BangDiemDetailModel bangDiemDetailModel = modelMapper.map(existBangDiem, BangDiemDetailModel.class);
            vm.setInfo(bangDiemDetailModel);

            model.addAttribute("vm", vm);
            return "bangdiem";
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }
}
