package cn.rain.repository;

import cn.rain.entity.HouseTag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/6/1 14:23
 */
public interface HouseTagRepository extends CrudRepository<HouseTag, Long> {

    List<HouseTag> findAllByHouseId(Long id);

    HouseTag findByNameAndHouseId(String tag, Long houseId);

    List<HouseTag> findAllByHouseIdIn(List<Long> houseIds);
}
