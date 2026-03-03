import java.time.LocalTime;

public class TimeSpan {
    LocalTime start;
    LocalTime end;

    public TimeSpan(LocalTime lastLogin, LocalTime lastLogout){
        start=lastLogin;
        end = lastLogout;
    }

    public LocalTime getStart(){
        return start;
    }

    public LocalTime getEnd(){
        return end;
    }
}
