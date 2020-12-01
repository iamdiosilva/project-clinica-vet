package dao;

import org.hibernate.Session;

public class CrudGenericDao<T> {

    public boolean saveInformation(T type){
        try{
            Session session = DataBaseConnection.getSessionFactory().openSession();
            session.beginTransaction(); //inicia transacão
            session.merge(type); //pegar dados no banco
            session.getTransaction().commit();//gravar no banco
            session.close(); // fecha a conexao

            return true;

        }catch (Exception erro){
            System.out.println("Erro na conexão " + erro);

            return false;
        }

    }

}
