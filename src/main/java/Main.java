import entity.ConPersonToProtest;
import entity.Person;
import entity.ProtestIn;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
public class Main {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();

    //insert function
    public static void insert_person(String name,String last_name,String phone){
        try {
            transaction.begin();
            Person person = new Person();
            person.setName(name);
            person.setLastName(last_name);
            person.setPhoneNumber(phone);
            entityManager.persist(person);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }


    public static void insert_in_protest(String name,String last_name,String topic){

        Query a = entityManager.createNamedQuery("select_personID",Person.class);
        Query b = entityManager.createNamedQuery("select_protestID", ProtestIn.class);
        a.setParameter(1, name);
        a.setParameter(2, last_name);
        b.setParameter(1, topic);
        List<Integer> id_protest_in=b.getResultList();
        List<Integer> id_person = a.getResultList();
        try {
            transaction.begin();
            ConPersonToProtest newCon = new ConPersonToProtest();
            newCon.setIdPerson(id_person.get(0));
            newCon.setIdPrtestIn(id_protest_in.get(0));
            entityManager.persist(newCon);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }



    //הצגת כל המפגינים בהפגנה מסויימת
    public static void print_protesters_list(String protest_name){
        Query prt_id= entityManager.createNamedQuery("select_protestID",ProtestIn.class);
        prt_id.setParameter(1,protest_name);
        List<Integer> select_protestID=prt_id.getResultList();
        try {
            transaction.begin();
            Query people_id=entityManager.createNamedQuery("select_pplID",ConPersonToProtest.class);
            people_id.setParameter(1,select_protestID.get(0));
            List<Integer> list_pplID=people_id.getResultList();

            //list_pplID has all the ids of ppl from table ConPersonTo...
            // getting all the ppl_ids works but dont know how to print them

            Query print_ppl=entityManager.createNamedQuery("select_person",Person.class);
            String first_name;
            String last_name;
            for (Integer a:list_pplID){

            }
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }


    public static void main(String[] args) {
//        insert_person("yohonatan","yizhak","054341265");
//        insert_in_protest("yohonatan","yizhak","taxs");
        print_protesters_list("taxs");
    }
}

