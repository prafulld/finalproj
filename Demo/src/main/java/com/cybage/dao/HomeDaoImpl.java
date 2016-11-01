package com.cybage.dao;

import java.math.BigInteger;
import java.text.BreakIterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.model.Client;
import com.cybage.model.Domain;
import com.cybage.model.User;

@Repository
@Transactional
public class HomeDaoImpl implements HomeDao {

	@Autowired
	private SessionFactory factory;

	public HomeDaoImpl() {
		System.out.println("HomeDaoImpl Ctor");
	}

	@Override
	public String registerClient(Client client) {

		String lastid = (String) factory.getCurrentSession().save(client);
		return lastid;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> getDomain() {
		// TODO Auto-generated method stub
		return factory.getCurrentSession()
				.createQuery("select d from Domain d").list();
	}

	@Override
	public Long getLastClientId() {
		Long lastid = ((BigInteger) factory.getCurrentSession()
				.createSQLQuery("SELECT LAST_INSERT_ID() from Client c")
				.uniqueResult()).longValue();
		System.out.println(lastid);
		return lastid;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClients() {
		// TODO Auto-generated method stub

		return factory.getCurrentSession()
				.createQuery("select c from Client c").list();
	}

	@Override
	public String deleteClientById(String id) {
		System.out.println("inside delete method" + id);
		try {
			factory.getCurrentSession()
					.createQuery("delete from Client c where c.id=:id")
					.setParameter("id", id).executeUpdate();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String registerUser(User user) {

		String lastid = (String) factory.getCurrentSession().save(user);
		return lastid;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		return factory.getCurrentSession().createQuery("select u from User u")
				.list();
	}

	@Override
	public String deleteUserById(String id) {
		System.out.println("inside delete method1" + id);
		try {
			factory.getCurrentSession()
					.createQuery("delete from User u where u.id=:id")
					.setParameter("id", id).executeUpdate();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Client findById(String id) {
		@SuppressWarnings("unchecked")
		List<Client> clientc = factory.getCurrentSession()
				.createQuery("select c from Client c").list();

		for (Client client : clientc) {
			System.out.println("Client names " + client.getName()
					+ "finding ID " + id);
			if (client.getId().equalsIgnoreCase(id)) {
				return client;
			}
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateClient(Client client) {
		// @SuppressWarnings("unchecked")
		// List<Client> clientc
		// =factory.getCurrentSession().createQuery("select c from Client c").list();
		// int index =
		// factory.getCurrentSession().createQuery("select c from Client c").list().indexOf(client);
		// factory.getCurrentSession().createQuery("select c from Client c").list().set(index,
		// client);
		System.out.println("inside delete method" + client.getId());

		String query = "update Client c set c.name='" + client.getName() + "',"
				+ "c.address='" + client.getAddress() + "',"
				+ "c.description='" + client.getDescription() + "',"
				+ "c.revenue='" + client.getRevenue() + "'," + "c.employess='"
				+ client.getEmployess() + "'," + "c.presence='"
				+ client.getPresence() + "'," + "c.ceo='" + client.getCeo()
				+ "'," + "c.cto='" + client.getCto() + "'," + "c.status='"
				+ client.getStatus() + "' where c.id='" + client.getId() + "' ";

		factory.getCurrentSession().createQuery(query).executeUpdate();

	}

}
