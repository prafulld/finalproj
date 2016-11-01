package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cybage.model.Client;
import com.cybage.model.Domain;
import com.cybage.model.User;
import com.cybage.service.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	HomeService service;
	
	String lastid;
	
	public HomeController() {
		System.out.println("Home Controller Ctor");
	}
	
	
	//------------------- Add a Client --------------------------------------------------------
	@RequestMapping(value = "/registerclient", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody Client client,    UriComponentsBuilder ucBuilder) {
        System.out.println("*******"+client);
 
        
      lastid= service.registerClient(client);
       System.out.println(lastid);
        HttpHeaders headers = new HttpHeaders();
        
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
	
	//------------------- View a Domain --------------------------------------------------------
	@RequestMapping(value = "/getdomain", method = RequestMethod.GET)
    public ResponseEntity<List<Domain>> listAllDomain() {
        List<Domain> domain = service.getDomain();
        if(domain.isEmpty()){
            return new ResponseEntity<List<Domain>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Domain>>(domain, HttpStatus.OK);
    }
	
	//------------------- VIew a Client --------------------------------------------------------
	@RequestMapping(value = "/getclients", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> listAllClients() {
        List<Client> client = service.getClients();
        if(client.isEmpty()){
            return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Client>>(client, HttpStatus.OK);
    }
	
	
	//------------------- Get last Client --------------------------------------------------------
	@SuppressWarnings("unused")
	@RequestMapping(value = "/getlastclientid", method = RequestMethod.GET)
    public ResponseEntity<String> getlastclientid() {
		 
		
		String lastid1 = "\""+lastid+"\"";
		//String lastid1 = "{id:"+ lastid +"}";
        if(lastid1==null){
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<String>(lastid1, HttpStatus.OK);
    }
	
	
	//------------------- Delete a Client --------------------------------------------------------
	 @RequestMapping(value = "/deleteclient/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Client> deleteClient(@PathVariable("id") String id) {
	        System.out.println("Fetching & Deleting User with id " + id);
	 
	        /*Client user = userService.findById(id);
	        if (user == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }*/
	 
	        service.deleteClientById(id);
	        return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	    }
	 
	 
	//------------------- Update a Client --------------------------------------------------------
     
	    @RequestMapping(value = "/updateclient/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Client> updateClient(@PathVariable("id") String id, @RequestBody Client client) {
	        
	        Client currentClient = service.findById(id);
	          
	        if (currentClient==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
	        }
	        
	        
	        System.out.println("User with id " + id + "  found " +currentClient.getName());
	        currentClient.setName(client.getName());
	        currentClient.setAddress(client.getAddress());
	        currentClient.setDescription(client.getDescription());
	        currentClient.setRevenue(client.getRevenue());
	        currentClient.setEmployess(client.getEmployess());
	        currentClient.setPresence(client.getPresence());
	        currentClient.setCeo(client.getCeo());
	        currentClient.setCto(client.getCto());
	        currentClient.setStatus(client.getStatus());
	          
	        service.updateClient(currentClient);
	        return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
	    }
	
	
	  //------------------- Register a User --------------------------------------------------------
	 @RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	    public ResponseEntity<String> registerUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
	        System.out.println("*******"+user);
	 
	        
	      lastid= service.registerUser(user);
	       System.out.println(lastid);
	        HttpHeaders headers = new HttpHeaders();
	        
	        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	    }
	 
	 
	 
	//------------------- View a User --------------------------------------------------------
	 @RequestMapping(value = "/getusers", method = RequestMethod.GET)
	    public ResponseEntity<List<User>> listAllUsers() {
	        List<User> user = service.getUsers();
	        if(user.isEmpty()){
	            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	    }
	 
	//------------------- Delete a User --------------------------------------------------------
	 @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
	        System.out.println("Fetching & Deleting User with id " + id);
	 
	        /*Client user = userService.findById(id);
	        if (user == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }*/
	 
	        service.deleteUserById(id);
	        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	    }
	 
	 
	
	
}
