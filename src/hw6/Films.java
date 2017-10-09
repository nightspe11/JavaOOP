package hw6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Films {
    private List<Film> films = new ArrayList<>();

    public Films addFilm(Film film) {
        films.add(film);
        return this;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void printFilms() {
        films.stream().forEach(System.out::println);
    }

    public List<Film> filterYear(int b, int e) {
        if (b > e) throw new IllegalArgumentException("Wrong input parameters");
        else
            return films.stream().filter(film -> (film.getYear() >= b) && (film.getYear() <= e)).collect(Collectors.toList());
    }

    public List<Film> filterYear(int y) {
        return this.filterYear(y, y);
    }

    public List<Film> sortYear() {
        return films.stream().sorted((f1, f2) -> f1.getYear() > f2.getYear() ? 1 : -1).collect(Collectors.toList());
    }


    public List<Film> filterGenres(Genre... genres) {
        List<Film> filtered = new ArrayList<>();
        for (Genre g : genres) {
            filtered.addAll(films.stream().filter(film -> film.getGenre().contains(g)).collect(Collectors.toList()));
        }
        return filtered;
    }

    public List<Film> filterActors(String... actors) {
        List<Film> filtered = new ArrayList<>();
        for (String a : actors) {
            filtered.addAll(films.stream().filter(film -> film.getActors().contains(a)).collect(Collectors.toList()));
        }
        return filtered;
    }
}