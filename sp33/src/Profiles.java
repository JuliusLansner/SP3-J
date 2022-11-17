package sp33.src;

public class Profiles {
    String userName;
    String passWord;
    public Profiles(String userName, String passWord){
        this.userName=userName;
        this.passWord=passWord;

    }

    @Override
    public String toString() {
        return "Profiles{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
