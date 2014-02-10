'use strict';

/* Services */
var services = angular.module('catalogo.services', []);

services.factory(
	    'AuthService',
	    function ($http) {
	        return {
	            login: function (credential, callback, errorCallback) {
	            	console.log('--------CREDENTIAL----------');
	            	console.log(credential);
	                $http({
	                    url: 'api/auth',
	                    method: "POST",
	                    data: credential,
	                    headers: {
	                        'Content-Type': 'application/json;charset=utf8'
	                    }
	                }).success(function (response) {
	                    callback(response.data);
	                }).error(function (response) {
	                    errorCallback(response.data);
	                });
	            }
	        }
	    });
/*,
						
						
						logout : function(callback, errorCallback) {
							$http(
									{
										url : getBaseUrl() + '/api/auth',
										method : "DELETE",
										headers : {
											'Content-Type' : 'application/json;charset=utf8'
										}
							}).success(function(response) {
								console.log(response);
								callback(response);
								currentUser = null;
							}).error(function(response) {
								console.log(response);
							});						},
							
							
						isLoggedIn : function(callback, errorCallback) {
								
						},
							
							
						currentUser : function(callback, errorCallback) {
							$http(
									{
										url : getBaseUrl() + '/api/auth',
										method : "GET",
										headers : {
											'Content-Type' : 'application/json;charset=utf8'
										}
							}).success(function(response) {
								console.log(response);
								callback(response);
							}).error(function(response) {
								console.log(response);
							});					
						}
					};*/