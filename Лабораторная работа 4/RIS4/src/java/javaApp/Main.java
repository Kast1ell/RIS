/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaApp;

/**
 *
 * @author User
 */
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Topic;
import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

public class Main {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Topic topic = new ActiveMQTopic("myTopic");
        MessageReceiver receiver = new MessageReceiver(connectionFactory, topic);
        Thread thread = new Thread(receiver);
        thread.start();
    }
}
