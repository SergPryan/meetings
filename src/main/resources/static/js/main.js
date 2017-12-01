app = angular.module('meetingApp',['ngRoute'])


app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/meeting', {
            template: '<h1>items/computers</h1>',
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

        console.log(topic)

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