var  app = angular.module('app',['ngRoute'])

app.config(function ($routeProvider) {
    $routeProvider
        .when('/',{
            template: '<h1>This is my homepage</h1>'
        })
})
