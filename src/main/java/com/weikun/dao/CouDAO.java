package com.weikun.dao;

import com.weikun.pojo.Cou;
import com.weikun.pojo.Father;
import com.weikun.pojo.Pro;
import com.weikun.pojo.Son;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/11/8.
 */
public class CouDAO {


    Configuration config = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
    public CouDAO(){
        config = new Configuration().configure("/hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
    }
    @Test
    public void add() {
        session=sessionFactory.openSession();
        try {
            tx=session.beginTransaction();

            Cou f=new Cou();
            f.setCname("Frense");

            Pro s1=new Pro();
            s1.setPname("JAVA");
            s1.setCou(f);

            Pro s2=new Pro();
            s2.setPname("C++");
            s2.setCou(f);


            f.getPros().add(s1);

            f.getPros().add(s2);


            session.save(f);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    @Test
    public void queryAll() {
        session = sessionFactory.openSession();
        Query q = session.createQuery("from Cou as c ");//Hibernate Query Language
        q.setCacheable(true);
        List<Cou> list = q.list();
        for(Cou c:list){

            System.out.println(c.getCname());
        }
    }
}
