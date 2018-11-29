package org.lordofthejars.games.game.api;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "games")
public class Game {

    @Id
    private long id;

    @Column
    private String title;

    @Column
    private String descriptionHtml;

    @Column
    private String cover;

    @Column
    private String screenshot;


    public Game() {
    }

    public Game(long id, String title, String descriptionHtml, String cover, String screenshot) {
        this.id = id;
        this.title = title;
        this.descriptionHtml = descriptionHtml;
        this.cover = cover;
        this.screenshot = screenshot;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    public void setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Game game = (Game) o;
        return id == game.id &&
            Objects.equals(title, game.title) &&
            Objects.equals(descriptionHtml, game.descriptionHtml) &&
            Objects.equals(cover, game.cover) &&
            Objects.equals(screenshot, game.screenshot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, descriptionHtml, cover, screenshot);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Game{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", descriptionHtml='").append(descriptionHtml).append('\'');
        sb.append(", cover='").append(cover).append('\'');
        sb.append(", screenshot='").append(screenshot).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
