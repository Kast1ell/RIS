/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaApp;

/**
 *
 * @author User
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import jakarta.jms.*;

import java.util.ArrayList;
import java.util.List;


public class MessageReceiver implements Runnable {

    private ConnectionFactory connectionFactory;
    private Topic topic;
    private PrintWriter writer;
    private int messageCount;

    public MessageReceiver(ConnectionFactory connectionFactory, Topic topic) {
        this.connectionFactory = connectionFactory;
        this.topic = topic;
        this.messageCount = 0;
    }

    @Override
    public void run() {
        Connection connection = null;
        Session session = null;
        MessageConsumer consumer = null;
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            consumer = session.createConsumer(topic);
            connection.start();
            writer = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            List<String> fulltext = new ArrayList<>();
            List<Integer> Indexes = new ArrayList<>();
            while (true) {
                Message message = consumer.receive(5000);
                if (message == null) {
                    System.out.println("Breaked");
                    break;
                }
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                    System.out.println("Message getted:" + text);
                    Integer index = fulltext.indexOf(text);
                    
                    if (index != -1) {
                        System.out.println("Message writed into file:" + text);
                        writer.println("Mes " + (messageCount+1) + "::  " + text);
                        writer.println("Сообщение " + (messageCount+1) + " Совпадает с " + (index+1));
                        writer.println();
                    } else {
                        System.out.println("Message writed into List:" + text);
                        fulltext.add(text);
                        Indexes.add(messageCount);
                    }
                    
                    messageCount++;
                    if (messageCount >= 10) { // Проверяем, достигли ли мы нужного количества сообщений
                        break; // Если да, выходим из цикла
                    }
                }
            }
        } catch (JMSException | IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}

