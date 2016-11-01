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

<div ng-app="myapp" ng-controller="UserController">
		<form name="myform" method="post">
		<table>
		<tr><td>Username :</td><td><input type="text",name="username", ng-model="user.username" required/></td>
								<td><span  style="color:red" ng-show="myform.username.$error.required">Username is required.</span></td></tr>  
		<tr><td>Password :</td><td><input type="text",name="password", ng-model="user.password" required/></td>
								<td><span  style="color:red" ng-show="myform.password.$error.required">Password is required.</span></td></tr>  
		<tr><td>Name :</td><td><input type="text",name="uname", placeholder="FIRST NAME", ng-model="user.fname" required/></td>
							<td><input type="text",name="uname", placeholder="MIDDLE NAME", ng-model="user.mname" required/></td>
							<td><input type="text",name="uname", placeholder="LAST NAME", ng-model="user.lname" required/></td>
							<td><span  style="color:red" ng-show="myform.uname.$error.required">Name is required.</span></td></tr> 
		<tr><td>Gender :</td><td><input type="text" name="gender" ng-model="user.gender" required/></td>
								<td><span  style="color:red" ng-show="myform.gender.$error.required">Gender is required.</span></td></tr>  
		
		
		<tr><td>Status :</td><td><input type="text",name="status", ng-model="user.status" required/></td><td><span  style="color:red" ng-show="myform.status.$error.required">Status is required.</span></td></tr>  
		
		</table>
		<button ng-click="adduser(user)">ADD CLIENT</button>
		</form>
		
	{{status}}
	
	
	
	</div>

<script >

 var App = angular.module("myapp", []);

 App.controller('UserController',function($scope,userservice) {
      
	
		
	/* clientservice.getDomain()
            .then(function (response) {
                $scope.domains = response.data;
            }, function (error) {
                $scope.status1 = 'Unable to load domain data: ' + error.message;
            });   */
			
	  $scope.adduser=function()
	{
        
         console.log($scope.user);
		 userservice.insertUser($scope.user)
         .then(function (response) {
        	
             $scope.status = 'Inserted User! Refreshing customer list.';
           //  $scope.users.push($scope.user);
            // $window.location.reload();
         }, function(error) {
             $scope.status = 'Unable to insert User: ' + error.message;
         });
	}  
   
    });
 
	App.service('userservice',function($http)
			{
		var urlBase = 'http://localhost:8080/Demo';

		 this.getDomain = function () {
	            return $http.get(urlBase+"/home/getdomain");
	        };
	        
	    this.insertUser = function (user) {
	            return $http.post(urlBase+"/home/registeruser", user);
	        }; 
			}); 
</script> 
</body>
</html>