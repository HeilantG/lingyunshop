var app = angular.module('lingyunshop', ['pagination']);
app.service('brand_service', function ($http) {

    //保存
    this.save = function (entity) {
        return $http.post('../tbBrand/saveBand', entity)
    };

    //删除
    this.delete = function (entity) {
        return $http.post('../tbBrand/deleteList', entity);
    }

    /*分页*/
    this.findPage = function (page, rows) {
        return $http.get('../tbBrand/findPage?page=' + page + "&rows=" + rows);
    }

    /*查询一个*/
    this.selectOne = function (id) {
        return $http.get("../tbBrand/selectOne?id=" + id);
    }

    /*修改*/
    this.update = function (entity) {
        return $http.post("../tbBrand/update", entity);
    }
    /*模糊查询*/
    this.blurrySelect = function (name) {
        return $http.get("../tbBrand/blurrySelect?name=" + name);
    }

})
