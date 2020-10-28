var app = angular.module('lingyunshop', ['pagination']);
app.service('type_template_service', function ($http) {
    const TB_TYPE_TEMPLATE = '../../tbTypeTemplate/';
    const TB_BRAND_CONTROLLER = '../../tbBrand/';
    const TB_SPECIFICATION_CONTROLLER = '../../tbSpecification/';

    //保存
    this.save = function (entity) {
        return $http.post(TB_TYPE_TEMPLATE + 'save', entity)
    };

    //删除
    this.delete = function (entity) {
        return $http.post(TB_TYPE_TEMPLATE + 'deleteList', entity);
    }

    /*分页*/
    this.findPage = function (page, rows) {
        return $http.get(TB_TYPE_TEMPLATE + 'findPage?page=' + page + '&rows=' + rows);
    }

    /*查询一个*/
    this.selectOne = function (id) {
        return $http.get(TB_TYPE_TEMPLATE + 'selectOne?id=' + id);
    }

    /*修改*/
    this.update = function (entity) {
        return $http.post(TB_TYPE_TEMPLATE + 'update', entity);
    }
    /*模糊查询*/
    this.blurrySelect = function (name) {
        return $http.get(TB_TYPE_TEMPLATE + 'blurrySelect?name=' + name);
    }
    this.selectBrandList = function () {
        return $http.get(TB_BRAND_CONTROLLER + 'queryAll')
    }
    this.selectSpecList = function () {
        return $http.get(TB_SPECIFICATION_CONTROLLER + 'queryAll')
    }
    /*根据*/
    /*    this.queryBySpecId = function (id) {
            return $http.get(TB_SPECIFICATION_OPTION_CONTROLLER + 'queryBySpecId?specId=' + id)
        }*/
})
