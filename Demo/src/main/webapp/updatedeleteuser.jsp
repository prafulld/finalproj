<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-route.min.js"></script>
</head>
<body>
<div ng-app="myapp" ng-controller="UserController">
		<form name="myform">
		<table border="1">
		<tr><th>FIRSTNAME</th><th>MIDDLENAME</th><th>LASTNAME</th><th>GENDER</th><th>STATUS</th><th>OPTIONS</th></tr>
 		<tr ng-repeat="u in users"><td>{{u.fname}}</td>
 									<td>{{u.mname}}</td>
 									<td>{{u.lname}}</td>
 									<td>{{u.gender}}</td>
 									<td>{{u.status}}</td>
 									<td>{{u.id}}</td>
 									<td><button ng-click="deleteuser(u.id)">DELETE</button></td>
 									</tr>
		</table>
		
		</form>
		
	{{status}}
	{{status1}}
	
	
	</div>
<script >

var App = angular.module("myapp", []);

 App.controller('UserController',function($scope,userservice,$window) {
      
	
	 userservice.getUsers ()
     .then(function (response) {
         $scope.users= response.data;
     }, function (error) {
         $scope.status = 'Unable to load customer data: ' + error.message;
     });
	 
	
	 
	/* clientservice.getDomain()
            .then(function (response) {
                $scope.domains = response.data;
            }, function (error) {
                $scope.status1 = 'Unable to load domain data: ' + error.message;
            });   */
	 		
	 /* $scope.deleteuser=function(id)
	{
         window.alert(id);
         console.log(id);
		 userservice.deleteUser(id)
         .then(function (response) {
        	
             $scope.status = 'Deleted User Successfully!!.';
           //  $scope.users.push($scope.user);
             $window.location.reload();
         }, function(error) {
             $scope.status = 'Unable to delete User: ' + error.message;
         });
	}  
    */
    });
 
	App.service('userservice',function($http)
			{
		var urlBase = 'http://localhost:8080/Demo';

		 this.getDomain = function () {
	            return $http.get(urlBase+"/home/getdomain");
	        };
	        
	    this.insertClient = function (client) {
	            return $http.post(urlBase+"/home/registerclient", client);
	        }; 
	        
	   this.getUsers = function () {
	            return $http.get(urlBase+"/home/getusers");
	        };
	        
	    this.deleteUser = function (id) {
	           //return $http.delete(urlBase + '/' + id);
	          return $http({
	        	   
	        	   url:'http://localhost:8090/Demo/home/deleteuser/' + id,
	        	   method:'DELETE'
	        	   
	           }); 
	        };
			}); 
</script>
</body>
</html>