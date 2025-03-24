package com.example.DAO;

import com.example.entities.Book;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class BookDao {

    // Метод для получения всех книг определенного автора
    public List<Book> getBooksByAuthor(String authorName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            String hql = "FROM Book b WHERE b.author.name = :authorName";
            Query query = session.createQuery(hql);
            query.setParameter("authorName", authorName);
            List<Book> books = query.list();

            // Вывод результатов в консоль
            System.out.println("Книги автора " + authorName + ":");
            for (Book book : books) {
                System.out.println("Название: " + book.getTitle() +
                        ", Автор: " + book.getAuthor().getName());
            }


            session.getTransaction().commit();
            return books;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }

    }

    public static void main(String[] args) {
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.getBooksByAuthor("Tom Hanks");
    }
}