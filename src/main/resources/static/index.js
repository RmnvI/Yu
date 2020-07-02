angular.module('demo', [])
    .controller('Employee', function ($scope, $http) {
        $http.get('http://localhost:8080/employee')
            .then(function (response) {
                $scope.employees = response.data;
            });
        $scope.showEmployees = function(){
            $http.get('http://localhost:8080/employee')
                .then(function (response) {
                    $scope.employees = response.data;
                });
        }
        $scope.sortBy = function (propertyName) {
            $scope.propertyName = propertyName;
            $http.get('http://localhost:8080/employee?sortBy=' + propertyName)
                .then(function (response) {
                    $scope.employees = response.data;
                });
        };

        $scope.addEmployee = function (name, surname, start, end) {
            $http({
                method : 'POST',
                url : 'employee',
                data : {
                    firstName : name,
                    lastName: surname,
                    startTime: start,
                    endTime: end
                }
            });
            location.reload();
        }

        $scope.deleteEmployee = function (id) {
            $http({
                method : 'DELETE',
                url : 'employee/' + id
            });
            location.reload();
        }
        $scope.findByName = function (name) {
            $http.get('/employee/' + name)
                .then(function (response) {
                    $scope.searchEmployees = response.data;
                })
        }

    });