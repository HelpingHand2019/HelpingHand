var app = angular.module('helpingHands');

app.controller('DashboardController', ['$scope', '$http', '$state', '$window','$rootScope', function ($scope, $http, $state, $window, $rootScope) {

    function onload() {
        $state.go('viewRequest');
        $scope.activeMenu = 'viewReq';
    } onload();

    $scope.logOut = function () {
        $window.location.href = '/';
    }

}]);