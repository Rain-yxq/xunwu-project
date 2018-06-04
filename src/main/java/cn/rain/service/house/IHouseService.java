package cn.rain.service.house;

import cn.rain.base.ServiceMultiResult;
import cn.rain.base.ServiceResult;
import cn.rain.web.dto.HouseDTO;
import cn.rain.web.form.DatatableSearch;
import cn.rain.web.form.HouseForm;
import cn.rain.web.form.RentSearch;

/**
 * description: 房屋管理接口
 * @author 任伟
 * @date 2018/6/1 14:25
 */
public interface IHouseService {
    /**
     * 新增房源的service接口
     * @param houseForm 前端提交的新增房源的表单
     * @return 操作结果
     */
    ServiceResult<HouseDTO> save(HouseForm houseForm);

    /**
     * 编辑房源的service接口
     * @param houseForm 前端提交的新增房源的表单
     * @return 操作结果
     */
    ServiceResult update(HouseForm houseForm);

    /**
     * 查看房源列表的service接口
     * @param searchBody DataTables插件规定的参数传输格式
     * @return 房源列表对象
     */
    ServiceMultiResult<HouseDTO> adminQuery(DatatableSearch searchBody);

    /**
     * 查询完整的房源信息
     * @param id 房源id
     * @return 要查询房源的完整信息或错误结果
     */
    ServiceResult<HouseDTO> findCompleteOne(Long id);

    /**
     * 移除图片
     */
    ServiceResult removePhoto(Long id);

    /**
     * 更新封面
     */
    ServiceResult updateCover(Long coverId, Long targetId);

    /**
     * 新增标签
     */
    ServiceResult addTag(Long houseId, String tag);

    /**
     * 移除标签
     */
    ServiceResult removeTag(Long houseId, String tag);

    /**
     * 更新房源状态
     */
    ServiceResult updateStatus(Long id, int status);

    /**
     * 查询房源信息的结果集
     */
    ServiceMultiResult<HouseDTO> query(RentSearch rentSearch);
}
