import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class User {
    String name;
    List<String> messages = new ArrayList<>();

    LocalTime lastLogin;
    LocalTime lastLogout;

    public void addMessage(String message){
        messages.add(message);
    }

    public List<String> getMessages(){
        return messages;
    }

    public LocalTime getLastLogin(){
        return lastLogin;
    }
    public LocalTime getLastLogout(){
        return lastLogout;
    }
    public void setLastLogin(LocalTime lastLogin){
        this.lastLogin=lastLogin;
    }
    public void setLastLogout(LocalTime lastLogout){
        this.lastLogout=lastLogout;
    }

    public TimeSpan getOnlineTimeSpan(){
        return new TimeSpan(lastLogin, lastLogout);
    }
}

