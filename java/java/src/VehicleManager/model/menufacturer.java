package VehicleManager.model;

public class menufacturer {
    private int code;
    private String name;
    private String country;

    public menufacturer(int code, String name, String country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "menufacturer{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
