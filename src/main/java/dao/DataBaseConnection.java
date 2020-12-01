package dao;

import model.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataBaseConnection {
    private static SessionFactory connection = null;
    private static Configuration configuration;

    private static SessionFactory buildSessionFactory() {
       configuration = new Configuration().configure();
       configuration.setProperty("hibernate.connection.username","root");
       configuration.setProperty("hibernate.connection.password","");

       //Mapeamento das class//
        configuration.addPackage("E.P_Clinica_Vet.model").addAnnotatedClass(Person.class);
        configuration.addPackage("E.P_Clinica_Vet.model").addAnnotatedClass(Client.class);

        //recebe a construcao da sessao com o banco
        connection = configuration.buildSessionFactory();

        return connection;
    }

    // MTD para acessar a conexao bild
    public  static SessionFactory getSessionFactory(){
        if(connection == null){
            connection = buildSessionFactory();
        }
        System.out.println("ConexaoBanco.getSessionFactory"+ connection);

        return connection;
    }
}
