package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.dao.HomeDao;
import com.cybage.model.Client;
import com.cybage.model.Domain;
import com.cybage.model.User;


@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeDao dao;
	
	public HomeServiceImpl() {
		System.out.println("HomeServiceImpl Ctor");
	}
	
	
	@Override
	public String registerClient(Client client) {
		return dao.registerClient(client);
	}

	@Override
	public List<Domain> getDomain() {
		
		return dao.getDomain();
	}

	@Override
	public Long getLastClientId() {
	
		return dao.getLastClientId();
	}

	@Override
	public List<Client> getClients() {
		
		return dao.getClients();
	}

	@Override
	public String deleteClientById(String id) {
	
		return dao.deleteClientById(id);
	}

	@Override
	public String registerUser(User user) {
		// TODO Auto-generated method stub
		return dao.registerUser(user);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return dao.getUsers();
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		return dao.deleteUserById(id);
	}

	@Override
	public Client findById(String id) {
		
            return dao.findById(id);
	}


	@Override
	public void updateClient(Client client) {
		 dao.updateClient(client);
		
	}

	/*@Override
	public String registerUsers(Users user1) {
		return dao.registerUsers(user1);
	}

	*/

}
