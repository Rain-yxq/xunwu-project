package cn.rain.repository;

import cn.rain.entity.House;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * description: 这里由于houseService要完成房源列表的分页功能，因此这里我们不再继承CrudRepository，
 * 而是通过继承PagingAndSortingRepository来实现分页和排序的功能。
 *
 * @author 任伟
 * @date 2018/6/1 14:18
 */
public interface HouseRepository extends PagingAndSortingRepository<House, Long>, JpaSpecificationExecutor<House> {

    /**
     * 修改封面
     * @param id 要修改封面的房源的house.id
     * @param cover 修改后的封面url
     */
    @Modifying
    @Query("update House as house set house.cover = :cover where house.id = :id")
    void updateCover(@Param(value = "id") Long id, @Param(value = "cover") String cover);

    /**
     * 修改房源的审核状态
     * @param id 房源id
     * @param status 审核状态码
     */
    @Modifying
    @Query("update House as house set house.status = :status where house.id = :id")
    void updateStatus(@Param(value = "id") Long id, @Param(value = "status") int status);

    /**
     * 修改房源的被看次数
     * @param houseId 房源id
     */
    @Modifying
    @Query("update House as house set house.watchTimes = house.watchTimes + 1 where house.id = :id")
    void updateWatchTimes(@Param(value = "id") Long houseId);

}
