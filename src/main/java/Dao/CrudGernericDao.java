package Dao;

import org.hibernate.Session;

public class CrudGernericDao<T> {

    public boolean salvarDados(T tipio){
        try{
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction(); //inicia transacão
            session.merge(tipio); //pegar dados no banco
            session.getTransaction().commit();//gravar no banco
            session.close(); // fecha a conexao

            return true;

        }catch (Exception erro){
            System.out.println("Erro na conexão " + erro);

            return false;
        }

    }

}
