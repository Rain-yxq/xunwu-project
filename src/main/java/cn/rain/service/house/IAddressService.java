package cn.rain.service.house;

import cn.rain.base.ServiceMultiResult;
import cn.rain.base.ServiceResult;
import cn.rain.entity.SupportAddress;
import cn.rain.web.dto.SubwayDTO;
import cn.rain.web.dto.SubwayStationDTO;
import cn.rain.web.dto.SupportAddressDTO;

import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/6/1 9:37
 */
public interface IAddressService {
    /**
     * 获取所有支持的城市列表
     * @return 城市列表
     */
    ServiceMultiResult<SupportAddressDTO> findAllCities();

    /**
     * 根据英文简写获取具体区域的信息
     */
    Map<SupportAddress.Level, SupportAddressDTO> findCityAndRegion(String cityEnName, String regionEnName);

    /**
     * 根据城市英文简写获取该城市所有支持的区域信息
     */
    ServiceMultiResult<SupportAddressDTO> findAllRegionsByCityName(String cityName);

    /**
     * 获取该城市所有的地铁线路
     */
    List<SubwayDTO> findAllSubwayByCity(String cityEnName);

    /**
     * 获取地铁线路所有的站点
     */
    List<SubwayStationDTO> findAllStationBySubway(Long subwayId);

    /**
     * 获取地铁线信息
     */
    ServiceResult<SubwayDTO> findSubway(Long subwayId);

    /**
     * 获取地铁站点信息
     */
    ServiceResult<SubwayStationDTO> findSubwayStation(Long stationId);

    /**
     * 根据城市英文简写获取城市详细信息
     */
    ServiceResult<SupportAddressDTO> findCity(String cityEnName);
}
