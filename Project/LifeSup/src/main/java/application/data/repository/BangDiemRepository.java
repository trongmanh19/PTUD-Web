package application.data.repository;

import application.data.model.BangDiem;
import application.data.model.CustomQueryBangDiemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by hoangmanh on 8/4/18.
 */
public interface BangDiemRepository extends JpaRepository<BangDiem, Integer>{

    @Query("select count(b.id) from bangdiem b")
    long getTotalBangDiem();

    @Query(value = "select new application.data.model.CustomQueryBangDiemModel(bd.id, lh.tenlop) " +
            "from bangdiem bd, lophoc lh " +
            "where bd.lopHocId = lh.id")
    List<CustomQueryBangDiemModel> getListBangDiemWithLopHoc();

}
