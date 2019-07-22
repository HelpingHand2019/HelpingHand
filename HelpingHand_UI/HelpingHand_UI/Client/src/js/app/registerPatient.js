var app = angular.module('helpingHands');

app.controller('RegisterPatientController', ['$scope', '$http', '$state', function ($scope, $http, $state) {

  $scope.patientData = { 'patientId': '', 'patientName': '', 'patientAge': '', 'patientEmail': '', 'patientPhoneNumber': '', 'patientAddress': '', 'patientDisease': '' };

  $('#patientId').on('input', function (event) {
    this.value = this.value.replace(/[^0-9]/g, '');
  });

  $('#patientAge').on('input', function (event) {
    this.value = this.value.replace(/[^0-9]/g, '');
  });

  $('#patientPhoneNumber').on('input', function (event) {
    this.value = this.value.replace(/[^0-9]/g, '');
  });

  $scope.registerPatient = function () {


    if ((  $scope.patientData.patientEmail.includes("@") &&   $scope.patientData.patientEmail.includes(".com"))) {


      $http({
        url: 'http://localhost:8080/registerPatient',
        method: "PUT",
        headers: { 'ContentType': 'application/json' },
        data: $scope.patientData
      }).then(function (response) {
        $scope.patientData = { 'patientId': '', 'patientName': '', 'patientAge': '', 'patientEmail': '', 'patientPhoneNumber': '', 'patientAddress': '', 'patientDisease': '' };
        toastr.options.timeOut = 1500; // 1.5s
        toastr.success("Registered Successfully");
      }, function (err) {
        toastr.options.timeOut = 1500; // 1.5s
        toastr.error("Server is down, Please try after some time.");
      });

    }

  }

}
]);