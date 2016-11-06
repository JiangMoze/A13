package com.weikun.dao;

import com.weikun.pojo.Father;
import com.weikun.pojo.Son;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/6.
 */
public class FatherDAOImpl implements  IFatherDAO {

    Configuration config = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
    public FatherDAOImpl(){
        config = new Configuration().configure("/hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
    }
    @Test
    @Override
    public void queryAll() {
        session=sessionFactory.openSession();

        Query q=session.createQuery("from Father as f");


        List<Father> list=q.list();

        for( Father f  :list){
            System.out.println(f.getFname());
            Set<Son> s=f.getSon();

            for(  Son s1:s){

                System.out.println(s1.getSname());
            }

        }

    }
    @Test
    @Override
    public void add() {
        session=sessionFactory.openSession();
        try {
            tx=session.beginTransaction();
            Father f=new Father();
            f.setFid(2);
            f.setFname("MIKE");

            Son s1=new Son();
            s1.setSid(0);
            s1.setFid(2);

            s1.setSname("hlj");
            s1.setFather(f);

            Son s2=new Son();
            s2.setSid(1);
            s2.setFid(2);

            s2.setSname("ln");
            s2.setFather(f);

            Set s=new HashSet();

            s.add(s1);
            s.add(s2);

            f.setSon(s);

//
//
//
            session.save(f);


            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void del() {

    }

    @Override
    public void update() {

    }
}
