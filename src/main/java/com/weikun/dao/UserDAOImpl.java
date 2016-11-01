package com.weikun.dao;

import com.weikun.pojo.Bbsuser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
public class UserDAOImpl implements IUserDAO{
    Configuration config = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;

    public  UserDAOImpl() {
        config = new Configuration().configure("/hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();


    }


    @Test
    @Override
    public void add() {
        session = sessionFactory.openSession();
        tx=session.beginTransaction();
        Bbsuser bbsuser=new Bbsuser();
        bbsuser.setUsername("root");
        bbsuser.setPwd("root");
        session.save(bbsuser);

        tx.commit();
        session.close();

        System.out.println("ok");

    }
    @Test
    @Override
    public void del() {
        session = sessionFactory.openSession();
        tx=session.beginTransaction();
        Bbsuser user=(Bbsuser)session.get(Bbsuser.class,1300);//查询1350的Bbsuser的记录

        session.delete(user);

        tx.commit();
        session.flush();
        session.close();
    }
    @Test
    @Override
    public void update() {
        session = sessionFactory.openSession();
        tx=session.beginTransaction();
        Bbsuser user=(Bbsuser)session.load(Bbsuser.class,1333);//查询1300的Bbsuser的记录
        user.setUsername("哈尔滨");
        user.setPwd("999");
        session.update(user);

        tx.commit();
        session.flush();
        session.close();
    }
    @Test
    @Override
    public void queryAll() {
        session = sessionFactory.openSession();
        Query q=session.createQuery("from Bbsuser as a");//Hibernate QL
        List<Bbsuser> list=q.list();
       for(Bbsuser b :list){
         System.out.println(b.getUsername()+"---"+b.getPwd());
       }
        session.flush();
        session.close();
    }
    @Test
    @Override
    public void queryByid() {
        session = sessionFactory.openSession();
        Query q=session.createQuery("from Bbsuser as a where id=22");//Hibernate QL
        List<Bbsuser> list=q.list();
        for(Bbsuser b :list){
            System.out.println(b.getUsername()+"---"+b.getPwd());
        }
        session.flush();
        session.close();
    }
}
