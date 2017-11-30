app = angular.module('app',[])

app.controller('appCtrl',function ($scope,$http,$filter) {
    $http.get('/meeting/all').then(function (response) {
        $scope.meetings = response.data
        console.log(response.data)
    })
    $http.get('/employee/all').then(function (response) {
        $scope.employees = response.data
        console.log(response.data)
    })
    $http.get('/department/all').then(function (response) {
        $scope.departments = response.data
        console.log(response.data)
    })
    $scope.applyFilter = function () {
        console.log('apply filter')
        var dateFrom = $filter('date')($scope.filterMeeting.dateFrom, "yyyy-MM-dd");
        var dateTo = $filter('date')($scope.filterMeeting.dateTo, "yyyy-MM-dd");
        // var dateTo = $filter('date')($scope.filterMeeting.dateTo, "dd/MM/yyyy");
        $http.get('/meeting/all?'+
        'topic='+$scope.filterMeeting.topic+'&'+
        'dateFrom='+dateFrom+'&'+
        'dateTo='+dateTo+'&'+
        'departmentId='+$scope.filterMeeting.departmentId+'&'+
        'employeeId='+$scope.filterMeeting.employeeId+'&'
        ).then(function (response) {
            $scope.meetings = response.data
            console.log(response.data)
        })
    }

    $scope.getEmployeesByDepartmentId = function () {
        console.log($scope.filterMeeting.departmentId)
        $http.get('/employee/all' +'?departmentId='+$scope.filterMeeting.departmentId).then(function (response) {
            $scope.employees = response.data
            console.log(response.data)
        })
    }
});