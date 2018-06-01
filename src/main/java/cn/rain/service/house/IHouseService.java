package cn.rain.service.house;

import cn.rain.base.ServiceMultiResult;
import cn.rain.base.ServiceResult;
import cn.rain.web.dto.HouseDTO;
import cn.rain.web.form.DatatableSearch;
import cn.rain.web.form.HouseForm;

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
     * 查看房源列表的service接口
     * @param searchBody DataTables插件规定的参数传输格式
     * @return 房源列表对象
     */
    ServiceMultiResult<HouseDTO> adminQuery(DatatableSearch searchBody);
}
