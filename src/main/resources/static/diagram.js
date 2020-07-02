var app = angular.module('myApp', ['zingchart-angularjs']);

app.controller('MainController', function($scope, $http) {
    $scope.myJson = {
        type: "pie",
        legend: {
            layout: "x5",
            position: "50%",
            borderColor: "transparent",
            marker: {
                borderRadius: 10,
                borderColor: "transparent"
            }
        },
        title: {
            textAlign: 'center',
            text: "Time Diagram"
        },
        tooltip: {
            text: "%v requests"
        },
        plot: {
            refAngle: "-90",
            borderWidth: "0px",
            valueBox: {
                placement: "in",
                text: "%npv %",
                fontSize: "15px",
                textAlpha: 1,
            }
        },

        series: []
    };
    $http.get('http://localhost:8080/diagramInfo')
        .then(function (response) {
            $scope.employees = response.data;
            $scope.employees.forEach(function (r) {
                $scope.myJson.series.push({
                    text: r.startTime + '--' + r.endTime,
                    values: [r.count]
                })
            })
        });
});