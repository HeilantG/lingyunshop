app.controller('type_template_controller', function ($scope, $controller, type_template_service) {

    /*引入基本操作*/
    $controller('base_controller', {$scope: $scope});

    /*用于保存添加*/
    $scope.entity = {
        id: '',
        name: '',
        specIds: '',
        brandIds: '',
        customAttributeItems: []
    };
    //品牌列表
    $scope.brandList = {data: []};
    //规格列表
    $scope.specList = {data: []};
    /*加载列表*/
    $scope.findPage = function (page, row) {
        type_template_service.findPage(page, row).success(
            function (response) {
                $scope.list = response.data.rows; //当前页的数据
                $scope.paginationConf.totalItems = response.data.total;//更新总记录数
            }
        )
    };

    /*保存*/
    $scope.save = function () {
        if ($scope.entity.id === '') {
            $scope.entity.customAttributeItems = JSON.stringify(angular.copy($scope.entity.customAttributeItems))
            console.log($scope.entity)
            type_template_service.save($scope.entity).success(
                function (response) {
                    $scope.reloadList()
                }
            )
        } else {
            type_template_service.update($scope.entity).success(function (response) {
                if (response.code === 200)
                    $scope.reloadList()
            })
        }

    };

    /*批量删除*/
    $scope.delete = function () {
        type_template_service.delete($scope.selectIds).success(function (response) {
            if (response.code === 200)
                $scope.reloadList()
        })
    };
    /*修改前查询*/
    $scope.findOne = function (id) {
        type_template_service.selectOne(id).success(function (response) {
            if (response.code === 200)
                $scope.entity = response.data
        })
    };
    /*模糊查询*/
    $scope.blurrySelect = function () {
        type_template_service.blurrySelect($scope.name).success(function (response) {
            if (response.code === 200) {
                $scope.list = response.data; //当前页的数据
            }
        });
    };
    /*添加前查询*/
    $scope.initBrandList = function () {
        //品牌
        type_template_service.selectBrandList().success(response => {
            //格式化数组
            response.data.forEach(it => {
                it.text = it.name;
                delete it.firstChar;
                delete it.name;
            })
            $scope.brandList = {data: response.data}
        })

    }
    $scope.initSpecList = function () {
        //规格
        type_template_service.selectSpecList().success(response => {
            //格式化数组
            response.data.forEach(it => {
                it.text = it.specName;
                delete it.specName
            })
            $scope.specList = {data: response.data}
        })
    }
    /*添加行*/
    $scope.addTableRow = function () {
        $scope.entity.customAttributeItems.push({});
    }
    /*移除行*/
    $scope.removeTableRow = function (id) {
        $scope.entity.customAttributeItems.splice(id, 1);
    }

})

