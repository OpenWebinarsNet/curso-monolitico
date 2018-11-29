package org.lordofthejars.games.details.api;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "details")
public class Detail {

    @Id
    private long id;

    @Column
    private String director;

    @Column
    private int year;

    @Column
    private String type;

    @Column
    private String publisher;

    public Detail() {
    }

    public Detail(long id, String name, int year, String type, String publisher) {
        this.id = id;
        this.director = name;
        this.year = year;
        this.type = type;
        this.publisher = publisher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String name) {
        this.director = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Detail detail = (Detail) o;
        return year == detail.year &&
            Objects.equals(director, detail.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(director, year);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Detail{");
        sb.append("id=").append(id);
        sb.append(", name='").append(director).append('\'');
        sb.append(", year=").append(year);
        sb.append(", type='").append(type).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
