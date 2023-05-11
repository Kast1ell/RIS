package DataBase;

import Pojoes.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateClass {
        public static SessionFactory sessionFactory;

        public HibernateClass() {}

        public static SessionFactory getSessionFactory() {
                if (sessionFactory == null) {
                        try {
                                /* <property name="hibernate.dialect">org.hibernate.dialect.SQLServerDialect</property>
        <property name="hibernate.connection.driver_class">com.microsoft.sqlserver.jdbc.SQLServerDriver</property>
        <property name="hibernate.connection.url">jdbc:sqlserver://localhost:1433;database=MarketingDB5;user=maxim;TrustServerCertificate=True</property>
        <property name="hibernate.connection.characterEncoding">UTF-8</property>
        <property name="hibernate.connection.username">maxim</property>
        <property name="hibernate.connection.password">2412</property>
        <property name="hibernate.enable_lazy_load_no_trans">false</property>
        <property name="hibernate.bytecode.use_reflection_optimizer">false</property>
        <property name="hibernate.bytecode.provider">cglib</property>
        <property name="hibernate.show_sql">true</property>
        <property name="hibernate.format_sql">true</property>*/
                                sessionFactory = new Configuration().configure().buildSessionFactory();
                                Configuration configuration = new Configuration().configure();
                                configuration.configure("hibernate.cfg.xml");
                                configuration.addAnnotatedClass(Users.class);
                                configuration.addAnnotatedClass(UserProfiles.class);
                                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                                sessionFactory = configuration.buildSessionFactory(builder.build());

                        } catch (Exception e) {
                                System.out.println("Исключение!" + e);
                                e.printStackTrace();
                        }
                }
                return sessionFactory;
        }
}