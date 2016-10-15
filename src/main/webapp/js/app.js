/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var myApp = angular.module('demoApp', []);

myApp.controller('memberController', function($scope, $http){
    
    $http.get("http://localhost:8080/AngularJquery/api/member/complete")
            .then(function(response){
                
             $scope.members = response.data;
    
    });
});
