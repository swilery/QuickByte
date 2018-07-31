package com.revature.overknight.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.overknight.beans.Users;
import com.revature.overknight.utils.HibernateUtil;

public class UserDaoImpl implements UserDao {

	public Integer insertUser(Users user) 
	{
		// SETUP
		Session session = HibernateUtil.getSession();
		Transaction trans = null;
		trans = session.beginTransaction();
		Integer id = null;

		try
		{
			id = (Integer)session.save(user);
			trans.commit();			
		}
		catch(HibernateException e)
		{
			if(trans!=null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return id;
	}


	public List<Users> selectAllUsers() {
		List<Users> users = null; 
		Session session = HibernateUtil.getSession();
		Transaction trans = null;
		
		try
		{
			trans = session.beginTransaction();
<<<<<<< HEAD
			users = session.createQuery("FROM User WHERE isDeleted = 0").list();
						
		}catch(HibernateException e){
			if(trans!=null){
=======
			users = session.createQuery("FROM User").list();				
		}
		catch(HibernateException e)
		{
			if(trans!=null)
			{
>>>>>>> c5861c969399da7a3e412d05c149dbfa44724463
				trans.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return users;
	}

	public Users selectUserById(Integer id) 
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Users user = null;
		
		try 
		{
			tx = session.beginTransaction();
<<<<<<< HEAD
			
			user = (User)session.get(User.class, id);
				
=======
			user = (Users)session.get(Users.class, id);
>>>>>>> c5861c969399da7a3e412d05c149dbfa44724463
			tx.commit();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			if(tx!=null)
			{
				tx.rollback();
			}
		}
		finally 
		{
			session.close();
		}
		if(user.getIsDeleted()==0) {
			return user;
		}else {
			return null;
		}
		 
	}

	public Boolean deleteUserById(Integer id) 
	{
		Users user = null;
		Session session = HibernateUtil.getSession();
		Transaction trans = null;
		Boolean result = false;

		try
		{
			trans = session.beginTransaction();
<<<<<<< HEAD
			user = (User)session.get(User.class, id);
			if(user!=null){
				if(user.getIsDeleted()!=null) {
					user.setIsDeleted(1);
				}
=======
			user = (Users)session.get(Users.class, id);
			if(user!=null)
			{
				session.delete(user);
>>>>>>> c5861c969399da7a3e412d05c149dbfa44724463
				result = true;
			}
			trans.commit();
			
		}
		catch(HibernateException e)
		{
			if(trans!=null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close(); 
		}
		
		return result;
	}

	public Users updateUser(Users user) {
		Users u = null;
		Session session = HibernateUtil.getSession();
		Transaction trans = null;

		try{
			trans = session.beginTransaction();
<<<<<<< HEAD
			u = (User)session.get(User.class, user.getId());
			if(null != u && u.getIsDeleted()!=1){
				if(user.getUsername()!=null){
=======
			u = (Users)session.get(Users.class, user.getId());
			if(null != u)
			{
				if(user.getUsername()!=null)
				{
>>>>>>> c5861c969399da7a3e412d05c149dbfa44724463
					u.setUsername(u.getUsername());
				}
				if(user.getPassword()!=null)
				{
					u.setPassword(u.getPassword());
				}
				if(user.getUserStatus()!=null)
				{
					u.setUserStatus(u.getUserStatus());
				}
				if(user.getfName()!=null)
				{
					u.setfName(u.getfName());
				}
				if(user.getlName()!=null)
				{
					u.setlName(u.getlName());
				}
				if(user.getEmail()!=null)
				{
					u.setEmail(u.getEmail());
				}
				if(user.getPhone()!=null){
					u.setPhone(u.getPhone());
				}
				if(user.getCreditCardNumber()!=null)
				{
					u.setCreditCardNumber(u.getCreditCardNumber());
				}
				if(user.getProfileImgKey()!=null)
				{
					u.setProfileImgKey(u.getProfileImgKey());
				}
				session.save(u);
			}
			trans.commit();
			
		}
		catch(HibernateException e)
		{
			if(trans!=null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close(); 
		}
		
		return user;
	}

	
	
	public Users selectUserByUsername(String username) {
		
		// Setup
		Session session = HibernateUtil.getSession();
		Users user = null;
		String hql;
		Query query;
		
		// Actually query the database
		hql = "FROM Users WHERE username = :username";
		query = session.createQuery(hql);
		query.setParameter("username", username);
		user = (Users)query.uniqueResult();
		session.close();
			//System.out.println(query.uniqueResult());
			//System.out.println("user = " + user.getfName());
		
<<<<<<< HEAD
		try {
			trans = session.beginTransaction();
			
			user = (User)session.get(User.class, username);
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(trans!=null){
				trans.rollback();
			}
		}finally {
			session.close();
		}
		if (user.getIsDeleted()!=1) {	
=======
>>>>>>> c5861c969399da7a3e412d05c149dbfa44724463
		return user; 
		}else {
			return null;
		}
	}

	

}
