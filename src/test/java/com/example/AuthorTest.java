package com.example;

import com.example.entities.Author;
import com.example.entities.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorTest {

    @Test
    void testAddBookToAuthor() {
        // Arrange
        Author author = new Author();
        author.setName("Test Author");

        Book book = new Book();
        book.setTitle("Test Book");

        // Act
        book.setAuthor(author);
        author.getBooks().add(book);

        // Assert
        assertEquals(1, author.getBooks().size(), "Коллекция книг автора должна содержать 1 элемент");
        assertTrue(author.getBooks().contains(book), "Коллекция автора должна содержать добавленную книгу");
        assertEquals(author, book.getAuthor(), "У книги должен быть установлен правильный автор");
    }
}