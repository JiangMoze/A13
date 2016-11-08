package com.weikun.dao;

import com.weikun.pojo.Father;
import com.weikun.pojo.Report;
import com.weikun.pojo.Son;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.beanvalidation.HibernateTraversableResolver;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/8.
 */
public class FatherDAO {

    Configuration config = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
    public FatherDAO(){
        config = new Configuration().configure("/hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
    }
    @Test
    public void testLazy(){
        Father f= queryFather();
        System.out.print(f.getFname());

        Set<Son> s=f.getSons();

        Iterator<Son> it=s.iterator();

        while(it.hasNext()){
            System.out.println(it.next().getSname());
        }

    }

    @Test
    public void dynamicQuery(){

        session=sessionFactory.openSession();

        try {

            Query q=session.createQuery("select new com.weikun.pojo.Report(fid,fname) from Father as f");

            Iterator <Report>it=q.list().iterator();

            while(it.hasNext()){

                Report r=it.next();
                System.out.println(r.getFname()+"--"+r.getFid());
            }

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Test
    public void queryField(){
        session=sessionFactory.openSession();

        try {

            Query q=session.createQuery("select fname,fid from Father as f");
            Iterator it=q.list().iterator();

            while(it.hasNext()){

                Object [] os=(Object [])it.next();
                System.out.println(os[0]+"---"+os[1]);
            }

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public Father queryFather(){

        session=sessionFactory.openSession();
        Father f=null;
        try {
            f=session.load(Father.class,2);
            if(!Hibernate.isInitialized(f.getSons())){
                Hibernate.initialize(f.getSons());
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            session.close();
        }
        return f;
    }

    @Test
    public void queryAll(){
        session=sessionFactory.openSession();
        Query q=session.createQuery("from Father as f ");//Hibernate Query Language
        q.setCacheable(true);
        List<Father> list=q.list();
        System.out.print(list);
        list=q.list();
        System.out.print(list);
//        for( Father f:list){
//
//            System.out.print(f.getFname());
//
//            Set <Son> s=f.getSons();
//            Iterator <Son>it=s.iterator();
//
//            while(it.hasNext()){
//               System.out.println(it.next().getSname());
//            }
//        }






    }

    @Test
    public void update(){
        session=sessionFactory.openSession();
        try {
            tx=session.beginTransaction();

            Father f=session.load(Father.class,2);

            f.setFname("Language");

            Set<Son> s=f.getSons();
            Object ss[]=s.toArray();

            ((Son)ss[0]).setSname("ASP");

            session.update(f);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
    @Test
    public void del(){
        session=sessionFactory.openSession();
        try {
            tx=session.beginTransaction();

            Father f=session.load(Father.class,1);
            session.delete(f);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
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

            Father f=new Father();
            f.setFname("JACK");

            Son s1=new Son();
            s1.setSname("JAVA");
            s1.setFather(f);

            Son s2=new Son();
            s2.setSname("C#");
            s2.setFather(f);


            f.getSons().add(s1);

            f.getSons().add(s2);


            session.save(f);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
