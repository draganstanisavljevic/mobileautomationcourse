public class User {

    private int age;
    private String name;
    private Role role;

    public User(int age, String name, Role role) {
        this.age = age;
        this.name = name;
        this.role = role;
    }

    public User() {
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "; Age: " + this.age + "; Role: " + role.getValue();
    }
}