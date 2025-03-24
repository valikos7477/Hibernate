package com.example;

import com.example.entities.*;
import com.example.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Создаем автора
        Author author = new Author();
        author.setName("Tom Hanks");
        session.save(author);

        // Создаем издателя
        Publisher publisher = new Publisher();
        publisher.setName("Arnold Shvarcnegger");
        session.save(publisher);

        // Создаем книгу
        Book book = new Book();
        book.setTitle("Terminator");
        book.setAuthor(author);
        book.setPublisher(publisher);
        session.save(book);

        // Создаем покупателя
        Customer customer = new Customer();
        customer.setName("Silvestr Stalone");
        customer.setEmail("sliy@example.com");
        session.save(customer);

        // Создаем заказ
        Order order = new Order();
        order.setCustomer(customer);
        order.getBooks().add(book);
        session.save(order);

        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();

    }


}