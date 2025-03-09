package vn.hcmute.baitap04.models;

public class MonHoc {
    private String name;
    private String desc;
    private int pic;

    public MonHoc(String name, String desc, int pic) {
        this.name = name;
        this.desc = desc;
        this.pic = pic;
    }

    public int getPic() {
        return pic;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
