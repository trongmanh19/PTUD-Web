package application.data.repository;

import application.data.model.LopHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by hoangmanh on 8/4/18.
 */
public interface LopHocRepository extends JpaRepository<LopHoc, Integer> {
    @Query("select count(lh.id) from lophoc lh")
    long getTotalLopHoc();
}
