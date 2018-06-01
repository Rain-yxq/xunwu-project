package cn.rain.web.dto;


/**
 * @author 任伟
 */
public class SubwayDTO {
    private Long id;
    private String name;
    private String cityEnName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityEnName() {
        return cityEnName;
    }

    public void setCityEnName(String cityEnName) {
        this.cityEnName = cityEnName;
    }

    @Override
    public String toString() {
        return "SubwayDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cityEnName='" + cityEnName + '\'' +
                '}';
    }
}
