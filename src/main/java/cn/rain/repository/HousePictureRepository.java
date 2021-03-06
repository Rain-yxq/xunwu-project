package cn.rain.repository;

import cn.rain.entity.HousePicture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/6/1 14:21
 */
public interface HousePictureRepository extends CrudRepository<HousePicture, Long> {

    List<HousePicture> findAllByHouseId(Long id);
}
