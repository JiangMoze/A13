package com.weikun.dao;

import com.weikun.pojo.Hus;
import com.weikun.pojo.Wife;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */
public class HusDAOImpl implements IHusDAO {
    Configuration config = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
    public HusDAOImpl(){
        config = new Configuration().configure("/hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
    }

    public static void main(String[] args) {
        new HusDAOImpl().queryAll();
    }
    @Override
    public void queryAll() {
        session=sessionFactory.openSession();
        try {
            Query q=session.createQuery("from Hus as h");
            List<Hus> list=q.list();

            for(Hus h :list ){
                System.out.println(h.getHname());
                System.out.println(h.getWife().getWname());
            }

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            session.close();
        }


    }

    @Test
    public void add1() {

        session=sessionFactory.openSession();
        try {
            tx=session.beginTransaction();
            Hus h=new Hus();
            h.setId(2);
            h.setHname("JAVA");
            Wife w=new Wife();
            w.setId(2);
            w.setWname("ALICE");
            w.setHus(h);
            h.setWife(w);
            session.saveOrUpdate(h);


            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Test
    @Override
    public void add() {
        session=sessionFactory.openSession();
        try {
            tx=session.beginTransaction();
            Hus h=new Hus();
            h.setId(2);
            h.setHname("JAVA");
            Wife w=new Wife();
            w.setId(2);
            w.setWname("ALICE");
            w.setHus(h);
            h.setWife(w);
            session.save(h);


            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    @Test
    @Override
    public void del() {
        session=sessionFactory.openSession();
        try {
            tx=session.beginTransaction();
            Hus hus=(Hus)session.load(Hus.class,1);
            session.delete(hus);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Test
    @Override
    public void update() {
        session=sessionFactory.openSession();
        try {
            tx=session.beginTransaction();
            Hus hus=(Hus)session.load(Hus.class,2);
            hus.setHname("C++");

            hus.getWife().setWname("PS");
            session.update(hus);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
