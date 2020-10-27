var app = angular.module('lingyunshop', ['pagination']);
app.service('specification_service', function ($http) {
    const TB_SPECIFICATION_CONTROLLER = '../tbSpecification/';
    const TB_SPECIFICATION_OPTION_CONTROLLER = '../tbSpecificationOption/';

    //保存
    this.save = function (entity) {
        return $http.post(TB_SPECIFICATION_CONTROLLER + 'save', entity)
    };

    //删除
    this.delete = function (entity) {
        return $http.post(TB_SPECIFICATION_CONTROLLER + 'deleteList', entity);
    }

    /*分页*/
    this.findPage = function (page, rows) {
        return $http.get(TB_SPECIFICATION_CONTROLLER + 'findPage?page=' + page + '&rows=' + rows);
    }

    /*查询一个*/
    this.selectOne = function (id) {
        return $http.get(TB_SPECIFICATION_CONTROLLER + 'selectOne?id=' + id);
    }

    /*修改*/
    this.update = function (entity) {
        return $http.post(TB_SPECIFICATION_CONTROLLER + 'update', entity);
    }
    /*模糊查询*/
    this.blurrySelect = function (name) {
        return $http.get(TB_SPECIFICATION_CONTROLLER + 'blurrySelect?name=' + name);
    }
    /*根据*/
    this.queryBySpecId = function (id) {
        return $http.get(TB_SPECIFICATION_OPTION_CONTROLLER + 'queryBySpecId?specId=' + id)
    }
})
