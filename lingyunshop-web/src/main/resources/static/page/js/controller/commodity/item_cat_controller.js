app.controller('item_cat_controller', function ($scope, $controller, item_cat_service) {

    /*引入基本操作*/
    $controller('base_controller', {$scope: $scope});

    /*用于保存添加*/
    $scope.entity = {};

    $scope.cleanEntity = function () {
        $scope.entity = {};
    }

    $scope.grade = 1;//默认为1级
    //设置级别
    $scope.setGrade = function (value) {
        $scope.grade = value;
    }
    //读取列表
    $scope.selectList = function (p_entity) {
        if ($scope.grade === 1) {//如果为1级
            $scope.entity_1 = null;
            $scope.entity_2 = null;
        }
        if ($scope.grade === 2) {//如果为2级
            $scope.entity_1 = p_entity;
            $scope.entity_2 = null;
        }
        if ($scope.grade === 3) {//如果为3级
            $scope.entity_2 = p_entity;
        }
        $scope.findByParentId(p_entity.id);	//查询此级下级列表
    }


    $scope.parentId = 0;//上级ID

    //根据上级ID显示下级列表
    $scope.findByParentId = function (parentId) {
        $scope.parentId = parentId;//记住上级ID
        item_cat_service.findByParentId(parentId).success(
            function (response) {
                $scope.list = response.data;
            }
        );
    }
    //保存
    $scope.save = function () {
        var serviceObject;//服务层对象
        console.log($scope.entity.id)
        if ($scope.entity.id !== '') {//如果有ID
            serviceObject = item_cat_service.update($scope.entity); //修改
        } else {
            $scope.entity.parentId = $scope.parentId;//赋予上级ID
            serviceObject = item_cat_service.save($scope.entity);//增加
        }
        serviceObject.success(function (response) {
                if (response.flag) {
                    //重新查询
                    $scope.cleanEntity();
                    $scope.findByParentId($scope.parentId);//重新加载
                } else {
                    alert(response.msg);
                }
            }
        );
    }

    //修改前查询

    $scope.findOne = function (id) {
        item_cat_service.selectOne(id).success(function (response) {
            if (response.code === 200)
                $scope.entity = response.data
        })
    };

    //批量删除
    $scope.delete = function () {
        console.log($scope.selectIds)
        item_cat_service.delete($scope.selectIds).success(function (response) {
            if (response.code === 200)
                $scope.selectIds = [];
            $scope.findByParentId($scope.parentId);//重新加载
        })
    };


    /*




        /!*模糊查询*!/
        $scope.blurrySelect = function () {
            brand_service.blurrySelect($scope.name).success(function (response) {
                if (response.code === 200) {
                    $scope.list = response.data; //当前页的数据
                }
            });
        };*/
})

