package com.cybage.dao;

import java.util.List;

import com.cybage.model.Client;
import com.cybage.model.Domain;
import com.cybage.model.User;


public interface HomeDao {
	
	//String registerUser(User user);
	//User getUser(Integer id);
	String registerClient(Client client);
	List<Domain> getDomain();
	Long getLastClientId();
	List<Client> getClients();
	String deleteClientById(String id);
	String registerUser(User user);
	List<User>getUsers();
	String deleteUserById(String id);
	Client findById(String id);
	void updateClient(Client client);
	//String registerUsers(Users user1);
}
