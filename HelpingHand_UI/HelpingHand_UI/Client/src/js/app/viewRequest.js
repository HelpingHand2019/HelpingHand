var app = angular.module('helpingHands');

app.controller('ViewReqController', ['$scope', '$http', '$state', function ($scope, $http, $state) {

    $(document).ready(function () {


        $http({
            url: 'http://localhost:8080/getAllTransactions',
            method: "GET",
            headers: { 'Content-Type': 'application/json' }

        }).then(function (response) {

            $scope.reqDataTemplate = [];
            $scope.reqData = [];
            for (var i = 0; i < response.data.length; i++) {
                $scope.reqDataTemplate.push(response.data[i].requestFrom);
                $scope.reqDataTemplate.push(response.data[i].requestTo);
                if (response.data[i].inProgress == true || response.data[i].inProgress == 'true') {
                    $scope.reqDataTemplate.push("In Progress")
                }
                if (response.data[i].iscompleted == true || response.data[i].iscompleted == 'true') {
                    $scope.reqDataTemplate.push("Completed")
                }
                $scope.reqDataTemplate.push(response.data[i].appointmentDate);

                $scope.reqData.push($scope.reqDataTemplate);
                $scope.reqDataTemplate = [];
            }

            $('#reqTable').DataTable({
                data: $scope.reqData,
                columns: [
                    { title: "Request From" },
                    { title: "Request To" },
                    { title: "Request Status" },
                    { title: "Appointment Date" }

                ]
            });
            $('#reqTable_length').hide();

        }, function errorCallback(err) {
            toastr.options.timeOut = 1500; // 1.5s
            toastr.error("Server is down, Please try after some time.");
        });






    });





}]);