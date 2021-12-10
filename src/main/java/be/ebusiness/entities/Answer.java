package be.ebusiness.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the answers database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "answers", schema = "ebusiness")
public class Answer implements Serializable {

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

    //uni-directional many-to-one association to Message
    @ManyToOne
    @JoinColumn(name="id_message")
    private Message messageInit;


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

    public Message getMessageInit() { return messageInit; }

    public void setMessageInit(Message messageInit) { this.messageInit = messageInit; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id == answer.id &&
                active == answer.active &&
                Objects.equals(title, answer.title) &&
                Objects.equals(message, answer.message) &&
                Objects.equals(createdAt, answer.createdAt) &&
                Objects.equals(updatedAt, answer.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, message, active, createdAt, updatedAt);
    }
}
