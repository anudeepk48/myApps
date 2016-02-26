package com.service;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.TransactionManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;
import com.repository.UserRepository;

@Service
public class UserImpl implements UserRepository {

//	@Autowired
//	TransactionManager transactionManager;
	
	@Autowired
	HibernateTransactionManager transactionManager;
	
	Session session;
	
	@PostConstruct
	public void setBeans(){
		session = transactionManager.getSessionFactory().openSession();
	}
	
	@Transactional
	public void save(final User user){
		session = getSession();
		session.saveOrUpdate(user);
	}
	
	public Session getSession(){
		session = transactionManager.getSessionFactory().openSession();
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		String query = "from User";
		return (List<User>)session.createQuery(query).list();
	}

	@Override
	public User get(Long id) {
		return (User)session.get(User.class, id);
	}
	
}
