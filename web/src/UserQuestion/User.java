package UserQuestion;

public class User {
    private int no;
    private String name;
    private String sex;
    private String age;
    private String phone;
    public User() {
    }

    public User(int no, String name, String sex, String age, String phone) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
