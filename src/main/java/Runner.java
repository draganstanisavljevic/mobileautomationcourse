public class Runner {

    public static void main(String[] args) {
        Role role = new Role();
        role.setSuperUser(true);
        role.setValue("administrator");

        User user = new User(24, "Dragan", role);

        System.out.println(user.toString());
    }
}
