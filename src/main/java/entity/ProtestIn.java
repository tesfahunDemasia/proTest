package entity;

import jakarta.persistence.*;

import java.sql.Date;
@NamedQuery(name="select_protestID",query="SELECT id FROM ProtestIn WHERE topic=?1")
@Entity
@Table(name = "protest_in", schema = "public", catalog = "Protest")
public class ProtestIn {
    private int id;
    private String topic;
    private Date date;
    private String location;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "topic", nullable = true, length = -1)
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "location", nullable = true, length = -1)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProtestIn protestIn = (ProtestIn) o;

        if (id != protestIn.id) return false;
        if (topic != null ? !topic.equals(protestIn.topic) : protestIn.topic != null) return false;
        if (date != null ? !date.equals(protestIn.date) : protestIn.date != null) return false;
        if (location != null ? !location.equals(protestIn.location) : protestIn.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
