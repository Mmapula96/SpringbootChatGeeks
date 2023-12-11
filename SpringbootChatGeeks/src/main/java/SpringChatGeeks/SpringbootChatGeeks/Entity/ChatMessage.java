package SpringChatGeeks.SpringbootChatGeeks.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ChatMessage")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String sender;

    // Constructors, getters, and setters

    public ChatMessage() {
        // Default constructor required by JPA
    }

    public ChatMessage(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
