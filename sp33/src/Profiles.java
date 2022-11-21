package sp33.src;

public class Profiles {
    String puserName;
    String ppassWord;
    public Profiles(String puserName, String ppassWord){
        this.puserName = puserName;
        this.ppassWord = ppassWord;

    }

    @Override
    public String toString() {
        return "Profiles{" +
                "userName='" + puserName + '\'' +
                ", passWord='" + ppassWord + '\'' +
                '}';
    }
}
