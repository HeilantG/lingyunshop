//控制层
app.controller('goods_controller', function ($scope, $controller, goodsService, uploadService) {

        $scope.entity = {goodsDesc: {itemImages: [], specificationItems: []}};//定义页面实体结构


        $scope.image_entity = ''
        $controller('base_controller', {$scope: $scope});//继承
//新增
        $scope.add = function () {
            $scope.entity.goodsDesc.introduction = editor.html();
            console.log($scope.entity.goodsDesc.introduction)
            goodsService.add($scope.entity).success(
                function (response) {
                    if (response.code === 200) {
                        alert('保存成功');
                        $scope.entity = {};
                        editor.html('');//清空富文本编辑器
                    } else {
                        alert(response.message);
                    }
                }
            );
        }
        /**
         * 上传图片
         */
        $scope.uploadFile = function () {
            uploadService.uploadFile().success(function (response) {
                if (response.code === 200) {//如果上传成功，取出url
                    $scope.image_entity = response.data;//设置文件地址
                } else {
                    alert("解析错误");
                }
            }).error(function () {
                alert("上传发生错误");
            });
        };
        //添加图片列表
        $scope.add_image_entity = function () {
            console.log("save")
            console.log($scope.image_entity)
            $scope.entity.goodsDesc.itemImages.push($scope.image_entity);
            console.log($scope.entity)
        }

        //列表中移除图片
        $scope.remove_image_entity = function (index) {
            $scope.entity.goodsDesc.itemImages.splice(index, 1);
        }
        //读取一级分类
        $scope.selectItemCat1List = function () {
            goodsService.findByParentId(0).success(
                function (response) {
                    $scope.itemCat1List = response.data;
                }
            );
        }
        //读取二级分类
        $scope.$watch('entity.goods.category1Id', function (newValue, oldValue) {
            //根据选择的值，查询二级分类
            goodsService.findByParentId(newValue).success(
                function (response) {
                    $scope.itemCat2List = response.data;
                }
            );
        });
        //读取三级分类
        $scope.$watch('entity.goods.category2Id', function (newValue, oldValue) {
            //根据选择的值，查询二级分类
            goodsService.findByParentId(newValue).success(
                function (response) {
                    $scope.itemCat3List = response.data;
                }
            );
        });
        //三级分类选择后  读取模板ID
        $scope.$watch('entity.goods.category3Id', function (newValue, oldValue) {
            goodsService.selectOne(newValue).success(
                function (response) {
                    $scope.entity.goods.typeTemplateId = response.data.typeId; //更新模板ID
                }
            );
        });

        //模板ID选择后  更新品牌列表
        $scope.$watch('entity.goods.typeTemplateId', function (newValue, oldValue) {
            goodsService.findTypeTemplate(newValue).success(
                function (response) {
                    $scope.typeTemplate = response.data;//获取类型模板
                    $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);//品牌列表
                }
            );
        });

        //模板ID选择后  更新模板对象
        $scope.$watch('entity.goods.typeTemplateId', function (newValue, oldValue) {
            goodsService.findTypeTemplate(newValue).success(
                function (response) {
                    $scope.typeTemplate = response.data;//获取类型模板
                    $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);//品牌列表
                    $scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.typeTemplate.customAttributeItems);//扩展属性
                }
            );
        });

        //模板ID选择后  更新模板对象
        $scope.$watch('entity.goods.typeTemplateId', function (newValue, oldValue) {
            goodsService.findTypeTemplate(newValue).success(
                function (response) {
                    $scope.typeTemplate = response.data;//获取类型模板
                    $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);//品牌列表
                    $scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.typeTemplate.customAttributeItems);//扩展属性
                }
            );
            //查询规格列表
            goodsService.findSpecList(newValue).success(
                function (response) {
                    $scope.specList = response.data;
                    console.log($scope.specList)
                }
            );
        });


        //更新
        $scope.updateSpecAttribute = function ($event, name, value) {
            var object = $scope.searchObjectByKey($scope.entity.goodsDesc.specificationItems, 'attributeName', name);
            if (object != null) {
                if ($event.target.checked) {
                    object.attributeValue.push(value);
                } else {//取消勾选object.attributeValue.splice( object.attributeValue.indexOf(value ) ,1);//移除选项
                    //如果选项都取消了，将此条记录移除
                    if (object.attributeValue.length == 0) {
                        $scope.entity.goodsDesc.specificationItems.splice(
                            $scope.entity.goodsDesc.specificationItems.indexOf(object), 1);
                    }
                }
            } else {
                $scope.entity.goodsDesc.specificationItems.push(
                    {"attributeName": name, "attributeValue": [value]});
            }
        }

        //创建SKU列表
        $scope.createItemList = function () {
            $scope.entity.itemList = [{spec: {}, price: 0, num: 99999, status: '0', isDefault: '0'}];//初始
            var items = $scope.entity.goodsDesc.specificationItems;
            for (var i = 0; i < items.length; i++) {
                $scope.entity.itemList = addColumn($scope.entity.itemList, items[i].attributeName, items[i].attributeValue);
            }
        }
//添加列值
        addColumn = function (list, columnName, conlumnValues) {
            var newList = [];//新的集合
            for (var i = 0; i < list.length; i++) {
                var oldRow = list[i];
                for (var j = 0; j < conlumnValues.length; j++) {
                    var newRow = JSON.parse(JSON.stringify(oldRow));//深克隆
                    newRow.spec[columnName] = conlumnValues[j];
                    newList.push(newRow);
                }
            }
            return newList;
        }


    }
)
