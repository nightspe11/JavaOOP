package hw6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Film {
    private String title;
    private int year;
    private List<String> actors;
    private List<Genre> genre;

    public Film(String title, int year, List<String> actors, List<Genre> genre) {
        this.title = title;
        this.year = year;
        this.actors = actors;
        this.genre = genre;
    }

    public Film(String title, int year) {
        this(title, year, new ArrayList<>(), new ArrayList<>());
    }

    public Film() {
        this("unknown", 1970);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getActors() {
        return actors;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public Film addGenre(Genre genre) {
        this.genre.add(genre);
        this.genre = this.genre.stream().sorted(Enum::compareTo).collect(Collectors.toList());
        return this;
    }

    public Film addAllGenres(Genre... genres) {
        for (Genre g : genres) {
            this.addGenre(g);
        }
        return this;
    }

    public Film addActor(String a) {
        this.actors.add(a);
        return this;
    }

    public Film addAllActors(String... actors) {
        for (String actor : actors) {
            this.addActor(actor);
        }
        return this;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", year=" + year +
                ", actors=" + actors +
                ", genre=" + genre;
    }
}