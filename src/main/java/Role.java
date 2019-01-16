public class Role {

    private boolean isSuperUser;
    private String value;

    public boolean isSuperUser() {
        return isSuperUser;
    }

    public String getValue() {
        return value;
    }

    public void setSuperUser(boolean superUser) {
        isSuperUser = superUser;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Role(boolean isSuperUser, String value) {
        this.isSuperUser = isSuperUser;
        this.value = value;
    }

    public Role() {
    }
}
