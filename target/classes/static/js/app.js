var app = angular.module('demo', ['ngMaterial', 'ngMessages', 'md.data.table']);
app.controller('Reservation', function($scope, $http, $mdDialog) {

    $http.get('http://localhost:8080/admin/reservations/').
    then(function(response) {
        $scope.reservations = response.data;
    });


    $scope.updateData = function(reservation){
        $mdDialog.show({
            locals:{reservation: reservation},
            controller: ReservationFormController,
            templateUrl: 'reservation_form_dialog.html',
            parent: angular.element(document.body),
            targetEvent: reservation,
            clickOutsideToClose:true,
            fullscreen: $scope.customFullscreen
        }).then(function(answer) {
            if(answer) {
                $http.get('http://localhost:8080/admin/reservations/').
                then(function(response) {
                    $scope.reservations = response.data;
                });
            }
        }, function() {
            console.log("");
        });
    };

    $scope.customFullscreen = false;

    $scope.deleteData = function (id) {
        $http.delete('http://localhost:8080/admin/reservations/' + id).then(function (response) {
            $scope.msg = "Data Deleted Successfully!";
            $http.get('http://localhost:8080/admin/reservations/').then(function (response) {
                $scope.reservations = response.data;
            });
        }, function (response) {
            $scope.msg = "Service not Exists";
            $scope.statusval = response.status;
            $scope.statustext = response.statusText;
            $scope.headers = response.headers();
        })};

    $scope.showReservationFormDialog = function(ev) {
        $mdDialog.show({
            locals:{reservation: null},
            controller: ReservationFormController,
            templateUrl: 'reservation_form_dialog.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose:true,
            fullscreen: $scope.customFullscreen
        }).then(function(answer) {
            if(answer) {
                $http.get('http://localhost:8080/admin/reservations/').
                then(function(response) {
                    $scope.reservations = response.data;
                });
            }
        }, function() {
            console.log("");
        });
    };

    function ReservationFormController($scope, $mdDialog, reservation) {
        if(reservation){
            $scope.userId = reservation.userId;
            $scope.date = reservation.date;
            $scope.time = reservation.time;
            $scope.pairsOfShoes = reservation.pairsOfShoes;
            $scope.numberOfPlayers = reservation.numberOfPlayers;
        }
        
        $scope.hide = function() {
            $mdDialog.hide();
        };

        $scope.cancel = function() {
            $mdDialog.cancel();
        };

        $scope.answer = function(answer) {
            $mdDialog.hide(answer);
        };

        $scope.saveData = function(){
            if(reservation){
                var dataObj = {
                    'userId': $scope.userId,
                    'date': $scope.date,
                    'time': $scope.time,
                    'pairsOfShoes': $scope.pairsOfShoes,
                    'numberOfPlayers': $scope.numberOfPlayers
                };
                $http.put('http://localhost:8080/admin/reservations/'+ reservation.id, dataObj) .then(function(response) {
                    $mdDialog.hide(true);
                }, function(error){
                    $mdDialog.hide(false);
                });
            }else{
                var dataObj = {
                    'userId': $scope.userId,
                    'date': $scope.date,
                    'time': $scope.time,
                    'pairsOfShoes': $scope.pairsOfShoes,
                    'numberOfPlayers': $scope.numberOfPlayers
                };
                $http.post('http://localhost:8080/admin/reservations/', dataObj).then(function(response) {
                    $mdDialog.hide(true);
                }, function(error){
                    $mdDialog.hide(false);
                });
            }
        };
    }
});







