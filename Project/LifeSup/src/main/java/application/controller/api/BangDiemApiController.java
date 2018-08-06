package application.controller.api;

import application.data.model.BangDiem;
import application.data.service.BangDiemService;
import application.data.service.LopHocService;
import application.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hoangmanh on 8/4/18.
 */
@RestController
@RequestMapping("/api/bangdiem")
public class BangDiemApiController {

    @Autowired
    private BangDiemService bangDiemService;

    @Autowired
    private LopHocService lopHocService;

    @PostMapping("/create-bangdiem")
    public DataApiResult createNewBangDiem(@RequestBody BangDiemDataModel bangDiemDataModel) {
        DataApiResult result = new DataApiResult();
        try {
            if (!"".equals(bangDiemDataModel.getLink())) {
                ModelMapper modelMapper = new ModelMapper();
                BangDiem bangDiemEntity = modelMapper.map(bangDiemDataModel, BangDiem.class);
                bangDiemEntity.setLopHoc(lopHocService.findOne(bangDiemDataModel.getIdLopHoc()));
                bangDiemService.addNewBangDiem(bangDiemEntity);
                result.setSuccess(true);
                result.setMessage("Create success bangdiem");
            } else {
                result.setSuccess(false);
                result.setMessage("Invalid model");
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }

        return result;
    }

    @PostMapping("/delete-bangdiem")
    public BaseApiResult deleteProduct(@RequestBody BangDiemDeleteModel bangdiem) {
        BaseApiResult result = new BaseApiResult();
        try {
            if (bangDiemService.deleteBangDiem(bangdiem.getIdBangDiem())) {
                result.setSuccess(true);
                result.setMessage("Delete BangDiem Successfully!");
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("/update-bangdiem/{bangDiemId}")
    public BaseApiResult updateBangDiem(@PathVariable int bangDiemId, @RequestBody BangDiemDataModel bangDiemDataModel) {
        DataApiResult result = new DataApiResult();

        try {
            if (!"".equals(bangDiemDataModel.getLink())) {
                BangDiem existBangDiem = bangDiemService.findOne(bangDiemId);
                if (existBangDiem == null) {
                    result.setSuccess(false);
                    result.setMessage("Invalid BangDiem");
                } else {
                    existBangDiem.setLink(bangDiemDataModel.getLink());
                    existBangDiem.setLopHoc(lopHocService.findOne(bangDiemDataModel.getIdLopHoc()));
                    bangDiemService.updateProduct(existBangDiem);
                    result.setSuccess(true);
                    result.setMessage("SUCCESS TO UPDATE BANG DIEM!");
                    result.setData(bangDiemDataModel);
                }
            } else {
                result.setSuccess(false);
                result.setMessage("Invalid Bangdiem");
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @GetMapping("/detail/{bangDiemId}")
    public BaseApiResult detailBangDiem(@PathVariable int bangDiemId) {
        DataApiResult result = new DataApiResult();

        try {
            BangDiem existBangDiem = bangDiemService.findOne(bangDiemId);
            if (existBangDiem == null) {
                result.setSuccess(false);
                result.setMessage("BangDiem Not Found");
            } else {
                result.setSuccess(true);
                result.setMessage("Found");
                ModelMapper modelMapper = new ModelMapper();
                BangDiemDetailModel bangDiemDetailModel = modelMapper.map(existBangDiem, BangDiemDetailModel.class);
                result.setData(bangDiemDetailModel);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
