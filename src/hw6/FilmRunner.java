package hw6;

import java.util.Arrays;

public class FilmRunner {
    public static void main(String[] args) {
        Films filmsList = new Films();
        Film f1 = new Film("Film1", 2015);
        Film f2 = new Film("f2", 2010, Arrays.asList("fug", "uyfw"), Arrays.asList(Genre.DRAMA));
        Film f3 = new Film();
        f1.addAllGenres(Genre.WAR, Genre.ADVENTURE);
        f1.addGenre(Genre.HORROR).addGenre(Genre.HISTORICAL);
        f1.addActor("f1a1");
        f1.addAllActors("A1", "A2");
        filmsList.addFilm(f1).addFilm(f2).addFilm(f3);

        System.out.println("Sort by year: " + filmsList.sortYear());
        System.out.println("Search by year: " + filmsList.filterYear(2010,2011));
        System.out.println("Search by genres: " + filmsList.filterGenres(Genre.HORROR, Genre.DRAMA));
        System.out.println("Search by actors: " + filmsList.filterActors("uyfw", "A1"));
    }
}
