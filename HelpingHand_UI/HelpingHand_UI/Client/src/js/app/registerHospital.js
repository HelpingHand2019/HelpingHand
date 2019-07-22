var app = angular.module('helpingHands');

app.controller('RegisterHospitalController', ['$scope', '$http', '$state', function ($scope, $http, $state) {

 $scope.hospitalData = {'hospitalId':'','hospitalName':'','hospitalEmail':'','hospitalPhoneNumber':'','hospitalAddress':'', 'registrationDate':''};
 

 $('#hospitalId').on('input', function (event) {
  this.value = this.value.replace(/[^0-9]/g, '');
});

$('#hospitalPhoneNumber').on('input', function (event) {
  this.value = this.value.replace(/[^0-9]/g, '');
});

 $scope.registerHospital = function () {

   
  if ((   $scope.hospitalData.hospitalEmail.includes("@") &&   $scope.hospitalData.hospitalEmail.includes(".com"))) {


    $http({
      url: 'http://localhost:8080/registerHospital',
      method: "PUT",
      headers: { 'ContentType': 'application/json' },
      data:  $scope.hospitalData
    }).then(function (response) {
      $scope.hospitalData = {'hospitalId':'','hospitalName':'','hospitalEmail':'','hospitalPhoneNumber':'','hospitalAddress':'', 'registrationDate':''};
      toastr.options.timeOut = 1500; // 1.5s
      toastr.success("Registered Successfully");
    }, function (err) {
      toastr.options.timeOut = 1500; // 1.5s
      toastr.error("Server is down, Please try after some time.");
    });

  }
}

}]);