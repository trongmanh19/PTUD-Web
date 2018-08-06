package application.data.service;

import application.data.model.LopHoc;
import application.data.repository.LopHocRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoangmanh on 8/4/18.
 */
@Service
public class LopHocService {

    private static final Logger logger = LogManager.getLogger(LopHocService.class);

    @Autowired
    private LopHocRepository lopHocRepository;

    public LopHoc findOne(int idLopHoc) {
        return lopHocRepository.findOne(idLopHoc);
    }

    public List<LopHoc> getListAllLopHoc() {
        try {
            return lopHocRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    public long getTotalLopHoc() {
        return lopHocRepository.getTotalLopHoc();
    }

}
