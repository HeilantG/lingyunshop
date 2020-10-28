var app = angular.module('lingyunshop', ['pagination']);
app.service('brand_service', function ($http) {
    var TB_BRAND_CONTROLLER = "../../tbBrand"

    //保存
    this.save = function (entity) {
        return $http.post(TB_BRAND_CONTROLLER + '/saveBand', entity)
    };

    //删除
    this.delete = function (entity) {
        return $http.post(TB_BRAND_CONTROLLER + '/deleteList', entity);
    }

    /*分页*/
    this.findPage = function (page, rows) {
        return $http.get(TB_BRAND_CONTROLLER + '/findPage?page=' + page + "&rows=" + rows);
    }

    /*查询一个*/
    this.selectOne = function (id) {
        return $http.get(TB_BRAND_CONTROLLER + "/selectOne?id=" + id);
    }

    /*修改*/
    this.update = function (entity) {
        return $http.post(TB_BRAND_CONTROLLER + "/update", entity);
    }
    /*模糊查询*/
    this.blurrySelect = function (name) {
        return $http.get(TB_BRAND_CONTROLLER + "/blurrySelect?name=" + name);
    }

})
