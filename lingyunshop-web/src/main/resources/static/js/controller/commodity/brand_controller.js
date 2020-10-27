app.controller('brand_controller', function ($scope, $controller, brand_service) {


    /*引入基本操作*/
    $controller('base_controller', {$scope: $scope});

    /*用于保存添加*/
    $scope.entity = {
        id: '',
        name: '',
        firstChar: ''
    };

    $scope.cleanEntity = function (){
        $scope.entity = {
            id: '',
            name: '',
            firstChar: ''
        };
    }

    /*加载列表*/
    $scope.findPage = function (page, row) {
        brand_service.findPage(page, row).success(
            function (response) {
                $scope.list = response.data.rows; //当前页的数据
                $scope.paginationConf.totalItems = response.data.total;//更新总记录数
            }
        )
    };

    /*保存*/
    $scope.save = function () {
        if ($scope.entity.id === '') {
            brand_service.save($scope.entity).success(
                function (response) {
                    $scope.reloadList()
                }
            )
        } else {
            brand_service.update($scope.entity).success(function (response) {
                if (response.code === 200)
                    $scope.reloadList()
            })
        }

    };

    /*批量删除*/
    $scope.delete = function () {
        brand_service.delete($scope.selectIds).success(function (response) {
            if (response.code === 200)
                $scope.reloadList()
        })
    };
    /*修改前查询*/
    $scope.findOne = function (id) {
        brand_service.selectOne(id).success(function (response) {
            if (response.code === 200)
                $scope.entity = response.data
        })
    };
    /*模糊查询*/
    $scope.blurrySelect = function () {
        brand_service.blurrySelect($scope.name).success(function (response) {
            if (response.code === 200) {
                $scope.list = response.data; //当前页的数据
            }
        });
    };
})

