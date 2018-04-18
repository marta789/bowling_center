
var app = angular.module('demo', []);
    app.controller('Reservation', function($scope, $http) {
        $http.get('http://localhost:8080/admin/reservations/').
        then(function(response) {
            $scope.reservations = response.data;
        });


        $scope.saveData = function(){
            $scope.reservations.push ({
                    'userId': $scope.userId,
                    'date': $scope.date,
                    'time': $scope.time,
                    'pairsOfShoes': $scope.pairsOfShoes,
                    'numberOfPlayers': $scope.numberOfPlayers});
            var dataObj = {
                'userId': $scope.userId,
                'date': $scope.date,
                'time': $scope.time,
                'pairsOfShoes': $scope.pairsOfShoes,
                'numberOfPlayers': $scope.numberOfPlayers
            };
            var res = $http.post('http://localhost:8080/admin/reservations/', dataObj);
            res.success(function(data, status, headers, config) {
                $scope.message = data;
            });
            res.error(function(data, status, headers, config) {
                alert( "failure message: " + JSON.stringify({data: data}));
            });
            // Making the fields empty
            //
            $scope.userId="";
            $scope.date="";
            $scope.time="";
            $scope.pairsOfShoes="";
            $scope.numberOfPlayers="";
        };


        //////////////
        $scope.deleteData = function (id) {
            $http.delete('http://localhost:8080/admin/reservations/' + id).then(function (response) {

                if (response.data)

                    $scope.msg = "Data Deleted Successfully!";

            }, function (response) {

                $scope.msg = "Service not Exists";

                $scope.statusval = response.status;

                $scope.statustext = response.statusText;

                $scope.headers = response.headers();

            })};



        // $http({
        //     method: 'DELETE',
        //     url: '/roles/' + roleid,
        //     data: {
        //         user: userId
        //     },
        //     headers: {
        //         'Content-type': 'application/json;charset=utf-8'
        //     }
        // })

        // $scope.SendData = function () {
        //     // use $.param jQuery function to serialize data from JSON
        //     var data = {
        //         userId: $scope.userId,
        //         date: $scope.date,
        //         time: $scope.time,
        //         pairsOfShoes: $scope.pairsOfShoes,
        //         numberOfPlayers: $scope.numberOfPlayers
        //     };
        //
        //     var config = {
        //         headers : {
        //             'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        //         }
        //     }
        //
        //     $http.post('http://localhost:8080/admin/reservations/', data, config)
        //         .success(function (data, status, headers, config) {
        //             $scope.createNote = data;
        //         })
        //
        // };
    });







