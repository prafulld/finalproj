	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-route.min.js"></script>
</head>
<body ng-app="myapp" ng-controller="ClientController">

	<div >
		<form name="myform1" method="post">
			<table border="1">
				<tr>
					<th>NAME</th>
					<th>ADDRESS</th>
					<th>Description</th>
					<th>REVENUE</th>
					<th>EMPLOYEES</th>
					<th>PRESENCE</th>
					<th>CEO</th>
					<th>CTO</th>
					<th>STATUS</th>
					<th>OPTIONS</th>
				</tr>
				<tr ng-repeat="c in clients" data-ng-click="edit(c)">
					<td>{{c.name}}</td>
					<td>{{c.address}}</td>
					<td>{{c.description}}</td>
					<td>{{c.revenue}}</td>
					<td>{{c.employess}}</td>
					<td>{{c.presence}}</td>
					<td>{{c.ceo}}</td>
					<td>{{c.cto}}</td>
					<td>{{c.status}}</td>
					<td>{{c.id}}</td>
					<td><button ng-click="deleteclient(c.id)">DELETE</button></td>
					
				</tr>
			</table>
			
			 <table>  
            <tr>  
                <td>EmpId: </td>  
                <td>  
                    <span>{{clientc.id}}</span></td>  
            </tr>  
            <tr>  
                <td>Name:</td>  
                <td>  
                    <input type="text" data-ng-model="clientc.name" /></td>  
            </tr>  
            <tr>  
                <td>Address::</td>  
                <td>  
                    <input type="text" data-ng-model="clientc.address" /></td>  
            </tr>  
            <tr>  
                <td>description::</td>  
                <td>  
                    <input type="text" data-ng-model="clientc.description" /></td>  
            </tr>  
            <tr>  
                <td>revenue::</td>  
                <td>  
                    <input type="number" data-ng-model="clientc.revenue" /></td>  
            </tr>  
            <tr>  
                <td>employess::</td>  
                <td>  
                    <input type="number" data-ng-model="clientc.employess" /></td>  
            </tr>
            <tr>  
                <td>presence::</td>  
                <td>  
                    <input type="text" data-ng-model="clientc.presence" /></td>  
            </tr>
            <tr>  
                <td>ceo::</td>  
                <td>  
                    <input type="text" data-ng-model="clientc.ceo" /></td>  
            </tr>
             <tr>  
                <td>cto::</td>  
                <td>  
                    <input type="text" data-ng-model="clientc.cto" /></td>  
            </tr>
            <tr>  
                <td>status::</td>  
                <td>  
                    <input type="text" data-ng-model="clientc.status" /></td>  
            </tr>
        </table>  
			<td><button ng-click="updateclient(clientc,clientc.id)">UPDATE CLIENT</button></td>
				<td><button ng-click="addclient(clientc)">ADD CLIENT</button></td>
		</form>

		


	</div>
	
	

	<script>
		var App = angular.module("myapp", []);
		App.controller('ClientController',function($scope, clientservice, $window) {

			$scope.clientc = {  
					name: '',  
			 		address:'', 
			 		description:'',  
			 		revenue:'',
					employess: '',
			 		presence:'', 
					ceo:'',
					cto:'',
					status:''  
	                
	            };  
	  
	            $scope.clientList = [];
	
	            $scope.updateclient = function(c,id) {
					
					console.log(c);
					clientservice
							.updateClient(c,id)
							.then(
									function(response) {

										$scope.status = 'Updating Customer! Refreshing customer list.';
										//  $scope.users.push($scope.user);
										$window.location.reload();
									},
									function(error) {
										$scope.status = 'Unable to insert customer: '
												+ error.message;
									});
				}
	            
	            
	            
	            
							$scope.addclient = function(clientc) {
								 window.alert($scope.clientc.name);
						         console.log($scope.clientc);
								clientservice
										.insertClient(clientc)
										.then(
												function(response) {

													$scope.status = 'Inserted Customer! Refreshing customer list.';
													//  $scope.users.push($scope.user);
													$window.location.reload();
													
												},
												function(error) {
													$scope.status = 'Unable to insert customer: '
															+ error.message;
												});
							}

							clientservice
									.getClients()
									.then(
											function(response) {
												$scope.clients = response.data;
											},
											function(error) {
												$scope.status = 'Unable to load customer data: '
														+ error.message;
											});

							/* clientservice.getDomain()
							        .then(function (response) {
							            $scope.domains = response.data;
							        }, function (error) {
							            $scope.status1 = 'Unable to load domain data: ' + error.message;
							        });   */

							$scope.deleteclient = function(id) {
								window.alert(id);
								console.log(id);		
								clientservice
										.deleteClient(id)
										.then(
												function(response) {

													$scope.status = 'Deleted Client Successfully!!.';
													//  $scope.users.push($scope.user);
													$window.location.reload();
												},
												function(error) {
													$scope.status = 'Unable to delete client: '
															+ error.message;
												});
							}

							$scope.edit = function(c) {
								console.log('id to be edited', c.id);
								window.alert(c.name);
								$scope.clientc.id = c.id;  
								 $scope.clientc.name = c.name;  
								 $scope.clientc.address = c.address;  
								 $scope.clientc.description = c.description;  
								 $scope.clientc.revenue = c.revenue;  
								 $scope.clientc.employess = c.employess;  
								 $scope.clientc.presence = c.presence;  
								 $scope.clientc.ceo = c.ceo;  
								 $scope.clientc.cto = c.cto;  
								 $scope.clientc.status = c.status;  
							}

						});

		App.service('clientservice', function($http) {
			var urlBase = 'http://localhost:8080/Demo';

			this.getDomain = function() {
				return $http.get(urlBase + "/home/getdomain");
			};

			this.insertClient = function(client) {
				return $http.post(urlBase + "/home/registerclient", client);
			};

			this.getClients = function() {
				return $http.get(urlBase + "/home/getclients");
			};

			this.deleteClient = function(id) {
				
				return $http({

					url : 'http://localhost:8080/Demo/home/deleteclient/' + id,
					method : 'DELETE'

				});

				$scope.getClients();
			};

			this.getDomain = function() {
				return $http.get(urlBase + "/home/getdomain");
			};

			this.insertClient = function(client) {
				return $http.post(urlBase + "/home/registerclient", client);
				$scope.getClients();
			};

			this.updateClient = function(client, id) {
				window.alert("In angular service");
				return $http.put(urlBase+"/home/updateclient/"+id, client);
				$scope.getClients();
				
			};
			
		});
	</script>
</body>
</html>