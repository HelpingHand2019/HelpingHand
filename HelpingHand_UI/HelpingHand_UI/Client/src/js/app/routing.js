var app = angular.module('helpingHands');

app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('viewRequest', {
            url: "/viewApplication",
            templateUrl: "../Client/src/views/viewReq.html"
        })
        .state('registerPatient', {
            url: "/registerPatient",
            templateUrl: "../Client/src/views/RegisterPatient.html"
        })
        .state('registerHospital', {
            url: "/registerHospital",
            templateUrl: "../Client/src/views/RegisterHospital.html"
        })
}]);

