package SpringChatGeeks.SpringbootChatGeeks.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chatMessage")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String sender;
    private String conversationId;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime timestamp;

    // Constructors, getters, and setters

    public ChatMessage() {
        this.timestamp = LocalDateTime.now();
    }

    public ChatMessage(String content, String sender, String conversationId) {
        this.content = content;
        this.sender = sender;
        this.conversationId = conversationId;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", conversationId='" + conversationId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
