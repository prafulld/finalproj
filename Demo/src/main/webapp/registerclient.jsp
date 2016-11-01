<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-route.min.js"></script>
</head>
<body>

<div ng-app="myapp" ng-controller="ClientController">
		<form name="myform" method="post">
		<table>
		<tr><td>Name :</td><td><input type="text",name="cname", ng-model="client.name" required/></td><td><span  style="color:red" ng-show="myform.cname.$error.required">Name is required.</span></td></tr> 
		<tr><td>Address :</td><td><input type="text",name="addr", ng-model="client.address" required/></td><td><span  style="color:red" ng-show="myform.addr.$error.required">Address is required.</span></td></tr>  
		<tr><td>Description :</td><td><input type="text",name="description", ng-model="client.description" required/></td><td><span  style="color:red" ng-show="myform.description.$error.required">CTO is required.</span></td></tr>  
		<tr><td>Revenue:</td><td><input type="text",name="revenue", ng-model="client.revenue" required/></td><td><span  style="color:red" ng-show="myform.revenue.$error.required">Revenue is required.</span></td></tr>  
		<tr><td>Employees :</td><td><input type="text",name="empl", ng-model="client.employess" required/></td><td><span  style="color:red" ng-show="myform.empl.$error.required">Employees is required.</span></td></tr>  
		<tr><td>Presence :</td><td><input type="text",name="presence", ng-model="client.presence" required/></td><td><span  style="color:red" ng-show="myform.presence.$error.required">Presence is required.</span></td></tr>  
		<tr><td>CEO :</td><td><input type="text",name="ceo", ng-model="client.ceo" required/></td><td><span  style="color:red" ng-show="myform.ceo.$error.required">CEO is required.</span></td></tr>  
		<tr><td>CTO :</td><td><input type="text",name="cto", ng-model="client.cto" required/></td><td><span  style="color:red" ng-show="myform.cto.$error.required">CTO is required.</span></td></tr>  
		
		<tr><td>Status :</td><td><input type="text",name="status", ng-model="client.status" required/></td><td><span  style="color:red" ng-show="myform.status.$error.required">Status is required.</span></td></tr>  
		
		</table>
		<button ng-click="addclient(client)">ADD CLIENT</button>
		</form>
		<a href="selectdomain.jsp">PROCEED FOR FURTHER DETAILS</a>
	{{status}}
	{{status1}}
	
	
	</div>

<script >

var App = angular.module("myapp", []);

 App.controller('ClientController',function($scope,clientservice) {
      
	
		
	/* clientservice.getDomain()
            .then(function (response) {
                $scope.domains = response.data;
            }, function (error) {
                $scope.status1 = 'Unable to load domain data: ' + error.message;
            });   */
			
	 $scope.addclient=function()
	{
         window.alert($scope.client.name);
         console.log($scope.client);
		 clientservice.insertClient($scope.client)
         .then(function (response) {
        	
             $scope.status = 'Inserted Customer! Refreshing customer list.';
           //  $scope.users.push($scope.user);
            // $window.location.reload();
         }, function(error) {
             $scope.status = 'Unable to insert customer: ' + error.message;
         });
	} 
   
    });
 
	App.service('clientservice',function($http)
			{
		var urlBase = 'http://localhost:8080/Demo';

		 this.getDomain = function () {
	            return $http.get(urlBase+"/home/getdomain");
	        };
	        
	    this.insertClient = function (client) {
	            return $http.post(urlBase+"/home/registerclient", client);
	        }; 
			}); 
</script>
</body>
</html>