package demoblaze.models;

public class SignupAndLoginRequest {
    private String password;
    private String username;

    public SignupAndLoginRequest(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
}
