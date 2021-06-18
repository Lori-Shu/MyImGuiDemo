package prodetail;

public class CityDetail {
    private Integer id;
    private String name;
    private Integer provinceid;

    public CityDetail() {
    }

    public CityDetail(Integer id, String name, Integer provinceid) {
        this.id = id;
        this.name = name;
        this.provinceid = provinceid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }
}
