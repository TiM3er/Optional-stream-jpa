package pl.tim3erland.omecon.code.review.optionalstreamjpa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.tim3erland.omecon.code.review.optionalstreamjpa.dto.Book;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Slf4j
@Component
public class StreamService implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        streamSort();
        parallelStream();
        List<Book> list = getBooks();
        ZonedDateTime now = ZonedDateTime.now();
        log.info("Books: {}", usingStreamParallel(list, 2000));
        log.info("{}", Duration.between(now, ZonedDateTime.now()).toMillis());
        now = ZonedDateTime.now();
        log.info("Books: {}", usingStream(list, 2000));
        log.info("{}", Duration.between(now, ZonedDateTime.now()).toMillis());
    }

    private static List<Book> getBooks() {
        return Arrays.asList(
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2002),
                new Book("Test1", "Test2", 2033),
                new Book("Test1", "Test2", 2043),
                new Book("Test1", "Test2", 2070),
                new Book("Test1", "Test2", 2008),
                new Book("Test1", "Test2", 2005),
                new Book("Test1", "Test2", 2008),
                new Book("Test1", "Test2", 2006),
                new Book("Test1", "Test2", 2002),
                new Book("Test1", "Test2", 2004),
                new Book("Test1", "Test2", 2002),
                new Book("Test1", "Test2", 2001),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2003),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2002),
                new Book("Test1", "Test2", 2001),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2008),
                new Book("Test1", "Test2", 2007),
                new Book("Test1", "Test2", 2006),
                new Book("Test1", "Test2", 2003),
                new Book("Test1", "Test2", 2002),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000),
                new Book("Test1", "Test2", 2000)
        );
    }

    private void streamSort() {
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
        List<String> result = names.stream().sorted().collect(Collectors.toList());
        result.forEach(o -> log.info(String.valueOf(result)));
    }

    private void parallelStream() {
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
        List<String> result = names.parallelStream().sorted().collect(Collectors.toList());
        result.forEach(o -> log.info(String.valueOf(result)));
    }

    long usingStreamParallel(Collection<Book> listOfBooks, int year) {
        AtomicLong countOfBooks = new AtomicLong();
        listOfBooks.parallelStream()
                .forEach(book -> {
                    if (book.getYearPublished() == year) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        countOfBooks.getAndIncrement();
                    }
                });
        return countOfBooks.get();
    }

    long usingStream(Collection<Book> listOfBooks, int year) {
        AtomicLong countOfBooks = new AtomicLong();
        listOfBooks.stream()
                .forEach(book -> {
                    if (book.getYearPublished() == year) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        countOfBooks.getAndIncrement();
                    }
                });
        return countOfBooks.get();
    }
}
