package SpringChatGeeks.SpringbootChatGeeks.response;

import SpringChatGeeks.SpringbootChatGeeks.Entity.User;

import java.util.Optional;

public class LoginResponse {
    String message;
    Boolean status;

    private Optional<User> user;

    public LoginResponse() {
    }

    public LoginResponse(String message, Boolean status, Optional<User> user) {
        this.message = message;
        this.status = status;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Optional<User> getUser() {
        return user;
    }

    public void setUser(Optional<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
