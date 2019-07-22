var app = angular.module('helpingHands');

app.controller('LoginController', ['$scope', '$http', '$window', '$rootScope', function ($scope, $http, $window, $rootScope) {

$scope.username = "";
$scope.password = "";

var aadharNo = 12345678;
var pwd = "Prathu@2019";

toastr.options.timeOut = 1500; // 1.5s

$scope.login = function () {


    if ($scope.username == aadharNo && $scope.password == pwd) {
        $window.location.href = '/home';       
    } else {
        toastr.error("Invalid Credentials");
    }


    
}

}]);