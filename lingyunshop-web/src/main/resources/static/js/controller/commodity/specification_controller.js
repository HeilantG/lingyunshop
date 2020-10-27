app.controller('specification_controller', function ($scope, $controller, specification_service) {

    /*引入基本操作*/
    $controller('base_controller', {$scope: $scope});

    /*用于保存添加*/
    $scope.entity = {
        entity: {
            id: '',
            specName: ''
        },
        entityList: []
    };

    //增加规格选项行
    $scope.addTableRow = function () {
        $scope.entity.entityList.push({});
    }

    /*加载列表*/
    $scope.findPage = function (page, row) {
        specification_service.findPage(page, row).success(
            function (response) {
                $scope.list = response.data.rows; //当前页的数据
                $scope.paginationConf.totalItems = response.data.total;//更新总记录数
            }
        );
    };

    /*清空entity*/
    $scope.clearEntity = function () {
        $scope.entity = {
            entity: {
                id: '',
                specName: ''
            },
            entityList: []
        }
    }
    /*保存*/
    $scope.save = function () {
        console.log($scope.entity)
        if ($scope.entity.entity.id === '') {
            /*添加*/
            specification_service.save($scope.entity).success(
                function (response) {
                    $scope.reloadList()
                    $scope.entity = {
                        entity: {
                            id: '',
                            specName: ''
                        },
                        entityList: []
                    }
                }
            )
        } else {
            /*修改*/
            specification_service.update($scope.entity).success(function (response) {
                if (response.code === 200)
                    $scope.reloadList()
            })
        }
    };

    /*批量删除*/
    $scope.delete = function () {
        console.log($scope.selectIds)
        specification_service.delete($scope.selectIds).success(function (response) {
            if (response.code === 200)
                $scope.reloadList()
        })
    };
    /*修改前查询*/
    $scope.findOne = function (id) {
        $scope.clearEntity()
        specification_service.selectOne(id).success(function (response) {
            if (response.code === 200) {
                $scope.entity.entity = response.data

            }
        });
        specification_service.queryBySpecId(id).success(function (response) {

            if (response.code === 200) {
                $scope.entity.entityList = response.data
            }
        })
    };
    /*模糊查询*/
    $scope.blurrySelect = function () {
        specification_service.blurrySelect($scope.name).success(function (response) {
            if (response.code === 200) {
                $scope.list = response.data; //当前页的数据
            }
        });
    };
})

