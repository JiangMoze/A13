package com.weikun.dao;

import com.weikun.pojo.Hus;
import com.weikun.pojo.Stu;
import com.weikun.pojo.Tea;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by Administrator on 2016/11/8.
 */
public class TeaDAO {
    Configuration config = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
    public TeaDAO(){
        config = new Configuration().configure("/hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
    }
    @Test
    public void del(){
        session=sessionFactory.openSession();
        try {
            tx=session.beginTransaction();
            Tea tea=(Tea)session.load(Tea.class,3);
            session.delete(tea);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    @Test
    public void add(){
        session=sessionFactory.openSession();
        try {
            tx=session.beginTransaction();


            Tea t=new Tea();

            t.setTid(3);
            t.setTname("TOM");

            Tea t1=new Tea();

            t1.setTid(4);
            t1.setTname("NIKE");


            Stu s=new Stu();
            s.setSid(5);
            s.setSname("anna");

            Stu s1=new Stu();
            s1.setSid(6);
            s1.setSname("alisha");

            t.getStus().add(s);
            s.getTeas().add(t);
            t.getStus().add(s1);
            s1.getTeas().add(t);



            t1.getStus().add(s);
            s.getTeas().add(t1);
            t1.getStus().add(s1);
            s1.getTeas().add(t1);

            session.save(t);
            session.save(t1);



            tx.commit();


        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
