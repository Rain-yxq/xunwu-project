package cn.rain.repository;

import cn.rain.entity.House;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * description: 这里由于houseService要完成房源列表的分页功能，因此这里我们不再继承CrudRepository，
 * 而是通过继承PagingAndSortingRepository来实现分页和排序的功能。
 *
 * @author 任伟
 * @date 2018/6/1 14:18
 */
public interface HouseRepository extends PagingAndSortingRepository<House, Long> {
}
