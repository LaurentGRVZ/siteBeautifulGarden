package be.ebusiness.entities;

import be.ebusiness.enumerations.MessageStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the messages database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "messages", schema = "ebusiness")
public class Message implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    @NotNull
    @Size(max = 100)
    private String title;

    @Column(name = "message")
    @NotNull
    @Lob
    @Size(max = 512)
    private String message;

    @Column(name = "status")
    @NotNull
    @Enumerated(EnumType.STRING)
    private MessageStatusEnum messageStatusEnum;

    @Column(name = "active")
    @NotNull
    private boolean active;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageStatusEnum getStatusMessageEnum() { return messageStatusEnum; }

    public void setStatusMessageEnum(MessageStatusEnum messageStatusEnum) { this.messageStatusEnum = messageStatusEnum; }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return id == message1.id &&
                active == message1.active &&
                Objects.equals(title, message1.title) &&
                Objects.equals(message, message1.message) &&
                Objects.equals(messageStatusEnum, message1.messageStatusEnum) &&
                Objects.equals(createdAt, message1.createdAt) &&
                Objects.equals(updatedAt, message1.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, message, messageStatusEnum, active, createdAt, updatedAt);
    }
}
