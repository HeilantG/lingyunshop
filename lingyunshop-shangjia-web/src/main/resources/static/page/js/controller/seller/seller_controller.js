//控制层
app.controller('seller_controller', function ($scope, $controller, sellerService) {

        $scope.entity = {}
        $controller('base_controller', {$scope: $scope});//继承
//新增
        $scope.add = function () {
            sellerService.add($scope.entity).success(
                function (response) {
                    if (response.flag) {
                        //如果注册成功，跳转到登录页
                        location.href = "shoplogin.html";
                    } else {
                        alert(response.message);
                    }
                }
            );
        }
    }
)
