import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void SomeMoviesAdded() {
        MovieManager manager = new MovieManager();

        manager.addNewMovie("Movie 1");
        manager.addNewMovie("Movie 2");
        manager.addNewMovie("Movie 3");
        manager.addNewMovie("Movie 4");
        manager.addNewMovie("Movie 5");

        String[] expected = {"Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ZeroMoviesAdded() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void OneMovieAdded() {
        MovieManager manager = new MovieManager();

        manager.addNewMovie("Movie 1");

        String[] expected = {"Movie 1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShowLastMoviesIfFiveMovies() {
        MovieManager manager = new MovieManager();

        manager.addNewMovie("Movie 1");
        manager.addNewMovie("Movie 2");
        manager.addNewMovie("Movie 3");
        manager.addNewMovie("Movie 4");
        manager.addNewMovie("Movie 5");

        String[] expected = {"Movie 5", "Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShowLastMoviesIfLessFiveMovies() {
        MovieManager manager = new MovieManager();

        manager.addNewMovie("Movie 1");
        manager.addNewMovie("Movie 2");
        manager.addNewMovie("Movie 3");

        String[] expected = {"Movie 3", "Movie 2", "Movie 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShowLastMoviesIfMoreFiveMovies() {
        MovieManager manager = new MovieManager();

        manager.addNewMovie("Movie 1");
        manager.addNewMovie("Movie 2");
        manager.addNewMovie("Movie 3");
        manager.addNewMovie("Movie 4");
        manager.addNewMovie("Movie 5");
        manager.addNewMovie("Movie 6");
        manager.addNewMovie("Movie 7");

        String[] expected = {"Movie 7", "Movie 6", "Movie 5", "Movie 4", "Movie 3"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShowMoreFiveMovies() {
        MovieManager manager = new MovieManager(7);

        manager.addNewMovie("Movie 1");
        manager.addNewMovie("Movie 2");
        manager.addNewMovie("Movie 3");
        manager.addNewMovie("Movie 4");
        manager.addNewMovie("Movie 5");
        manager.addNewMovie("Movie 6");
        manager.addNewMovie("Movie 7");

        String[] expected = {"Movie 7", "Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}