<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.js"></script>
 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-route.min.js"></script>
</head>
<body>
<div ng-app="myapp" ng-controller="ClientController">
<table>
<tr><td>Domain:</td><td><select ng-model= "clientdomainlnk" >
		<option  ng-repeat="d in domains" value="{{clientdomainlnk.domain=d.id}}">{{d.name}}</option>
		</select> </td></tr>
	
</table>
<input type="hidden" ng-model="clientdomainlnk.client" />
<button ng-click="add(clientdomainlnk)">ADD CLIENT</button>
{{id}}
</div>

<script>
var App = angular.module("myapp", []);

 App.controller('ClientController',function($scope,clientservice) {
      
	
		
	clientservice.getDomain()
            .then(function (response) {
                $scope.domains = response.data;
                console.log($scope.domains);
            }, function (error) {
                $scope.status1 = 'Unable to load domain data: ' + error.message;
            });  
			
	clientservice.getlastclientid()
    .then(function (response) {
    	
        id= response.data;
        console.log(id);
    }, function (error) {
        $scope.status1 = 'Unable to load domain data: ' + error.message;
    });  
	
	
	
	 $scope.add=function()
	{
		window.alert($scope.clientdomainlnk.domain)
         console.log($scope.clientdomainlnk);
		$scope.clientdomainlnk.client=id;
		 console.log(id);
		  console.log($scope.clientdomainlnk.client);
		 clientservice.insert($scope.client)
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
	        
	        
	      this.getlastclientid=function()
	      {
	    	 return $http.get(urlBase+"/home/getlastclientid");
	      };
	    /* this.insertClient = function (client) {
	            return $http.post(urlBase+"/home/registerclient", client);
	        }; */
			}); 
</script>
</body>

</html>