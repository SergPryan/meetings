app = angular.module('meetingApp',['ngRoute'])

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        // .when('/meeting', {
        //     templateUrl: 'meeting.html',
        // })
        .when('/edit_meeting:id', {
            templateUrl: 'meeting.html',
            controller: 'meetingCtrl'
        })
        .when('/list_meetings', {
            templateUrl: 'list_meetings.html',
            controller: 'appCtrl'
        })
        // .otherwise({redirectTo:'/items/computers'});
}]);

app.controller('appCtrl',function ($scope,$http,$filter) {
    $http.get('/employee/all').then(function (response) {
        $scope.employees = response.data
    })
    $http.get('/department/all').then(function (response) {
        $scope.departments = response.data
    })
    $scope.applyFilter = function () {
        var request = '/meeting/all?'
        var topic = $scope.topic
        var dateFrom = $scope.dateFrom
        var dateTo = $scope.dateTo
        var departmentId = $scope.departmentId
        var employeeId = $scope.employeeId

        if (topic !== undefined){
            request+='topic='+topic+'&'
        }
        if (dateFrom !== undefined){
            dateFrom = $filter('date')(dateFrom, "yyyy-MM-dd")
            request+='dateFrom='+dateFrom+'&'
        }
        if (dateTo !== undefined){
            dateTo = $filter('date')(dateTo, "yyyy-MM-dd");
            request+='dateTo='+dateTo+'&'
        }
        if (departmentId !== undefined){
            request+='departmentId='+departmentId+'&'
        }
        if (employeeId !== undefined){
            request+='employeeId='+employeeId+'&'
        }
        $http.get(request).then(function (response) {
            $scope.meetings = response.data
        })
    }

    $scope.getEmployeesByDepartmentId = function () {
        $http.get('/employee/all' +'?departmentId='+$scope.departmentId).then(function (response) {
            $scope.employees = response.data
        })
    }
});

app.controller('meetingCtrl',function ($scope, $routeParams, $http,$filter) {
    $http.get('/meeting/'+$routeParams.id).then(function (response) {
        $scope.meeting = response.data

    })
    $scope.getEmployeeByDepartmentId = function () {
        $http.get('/employee/all' + '?departmentId=' + $scope.defaultDepartment).then(function (response) {
            $scope.employees = response.data
        })
    }
    $scope.deleteEmployee = function (index) {
        $scope.meeting.listOfParticipants.splice(index,1)
    }
    $scope.fillAllEmployees = function () {
        $http.get('/employee/all').then(function (response) {
            $scope.allEmployees = response.data
        })
    }
    $scope.addParticipant = function () {
        $scope.meeting.listOfParticipants.push($scope.newParticipant)
    }

})