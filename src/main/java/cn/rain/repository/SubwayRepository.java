package cn.rain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cn.rain.entity.Subway;

/**
 * 获取支持的地铁线路
 * @author 任伟
 */
public interface SubwayRepository extends CrudRepository<Subway, Long>{
    /**
     * 通过城市名获取所有地铁线路
     * @param cityEnName 城市英文名
     * @return 所有地铁线路
     */
    List<Subway> findAllByCityEnName(String cityEnName);
}
