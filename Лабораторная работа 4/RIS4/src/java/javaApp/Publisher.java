/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaApp;

/**
 *
 * @author User
 */
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import jakarta.jms.Topic;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {

    public static void main(String[] args) throws IOException, JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        String workingDir = System.getProperty("user.dir");
            System.out.println("Working Directory = " + workingDir);
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("myTopic");
            MessageProducer producer = session.createProducer(topic);
            connection.start();
            for (int i = 0; i < 5; i++) {
                TextMessage message = session.createTextMessage("Message + 4");
                TextMessage message2 = session.createTextMessage("Message + 5");
                producer.send(message);
                producer.send(message2);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
