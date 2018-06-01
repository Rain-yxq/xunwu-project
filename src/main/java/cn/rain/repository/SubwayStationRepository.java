package cn.rain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cn.rain.entity.SubwayStation;

/**
 * @author 任伟
 */
public interface SubwayStationRepository extends CrudRepository<SubwayStation, Long> {
    List<SubwayStation> findAllBySubwayId(Long subwayId);
}
