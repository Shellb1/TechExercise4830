import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class Util {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<ItemModel> getAll() {
      List<ItemModel> resultList = new ArrayList<ItemModel>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> items = session.createQuery("FROM ItemModel").list();
         for (Iterator<?> iterator = items.iterator(); iterator.hasNext();) {
            ItemModel item = (ItemModel) iterator.next();
            resultList.add(item);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<ItemModel> query(String store, String itemName, String category) {
      List<ItemModel> resultList = new ArrayList<ItemModel>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> items = session.createQuery("FROM ItemModel").list();
         for (Iterator<?> iterator = items.iterator(); iterator.hasNext();) {
            ItemModel item = (ItemModel) iterator.next();
            if (store != null) {
            	if (item.getStore().startsWith(store) && !resultList.contains(item)) {
            		resultList.add(item);
            	}
            }
            if (itemName != null) {
            	if (item.getItem().startsWith(itemName) && !resultList.contains(item)) {
            		resultList.add(item);
            	}
            }
            if (category != null) {
            	if (item.getCategory().startsWith(category) && !resultList.contains(item)) {
            		resultList.add(item);
            	}
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static void createItem(String store, String item, Integer quantity, String category) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new ItemModel(store, item, quantity, category));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
}
