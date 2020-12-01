package Dao;

import model.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConexaoBanco {
    private static SessionFactory conexao = null;
    private static Configuration configuration;

    private static SessionFactory buildSessionFactory() {
       configuration = new Configuration().configure();
       configuration.setProperty("hibernate.connection.username","root");
       configuration.setProperty("hibernate.connection.password","");

       //Mapeamento das class//
        configuration.addPackage("E.P_Clinica_Vet.model").addAnnotatedClass(Person.class);
        configuration.addPackage("E.P_Clinica_Vet.model").addAnnotatedClass(Client.class);

        //recebe a construcao da sessao com o banco
        conexao = configuration.buildSessionFactory();

        return conexao;
    }

    // MTD para acessar a conexao bild
    public  static SessionFactory getSessionFactory(){
        if(conexao == null){
            conexao = buildSessionFactory();
        }
        System.out.println("ConexaoBanco.getSessionFactory"+ conexao);

        return conexao;
    }
}
