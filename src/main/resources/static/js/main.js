app = angular.module('app',[])

app.controller('appCtrl',function ($scope,$http) {
    $http.get('/meeting/all').then(function (response) {
        $scope.meetings = response.data
        console.log(response.data)
    })
});