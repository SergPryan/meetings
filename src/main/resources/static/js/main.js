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
        var request = '/meeting/all?'
        if ($scope.filterMeeting.topic !== undefined){
            request+='topic='+$scope.filterMeeting.topic+'&'
        }
        if ($scope.filterMeeting.dateFrom !== undefined){
            var dateFrom = $filter('date')($scope.filterMeeting.dateFrom, "yyyy-MM-dd")
            request+='dateFrom='+dateFrom+'&'
        }
        if ($scope.filterMeeting.dateTo !== undefined){
            var dateTo = $filter('date')($scope.filterMeeting.dateTo, "yyyy-MM-dd");
            request+='dateTo='+dateTo+'&'
        }
        if ($scope.filterMeeting.departmentId !== undefined){
            request+='departmentId='+$scope.filterMeeting.departmentId+'&'
        }
        if ($scope.filterMeeting.employeeId !== undefined){
            request+='employeeId='+$scope.filterMeeting.employeeId+'&'
        }
        console.log(request)

        $http.get(request).then(function (response) {
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