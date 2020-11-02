app.service('itemCatService', function ($http) {
    var TB_ITEM_CAT_CONTROLLER = "../../tbItemCat"

    //保存
    this.save = function (entity) {
        return $http.post(TB_ITEM_CAT_CONTROLLER + '/save', entity)
    };

    //删除
    this.delete = function (entity) {
        return $http.post(TB_ITEM_CAT_CONTROLLER + '/deleteList', entity);
    };

    /*分页*/
    this.findPage = function (page, rows) {
        return $http.get(TB_ITEM_CAT_CONTROLLER + '/findPage?page=' + page + "&rows=" + rows);
    };

    /*查询一个*/
    this.selectOne = function (id) {
        return $http.get(TB_ITEM_CAT_CONTROLLER + "/selectOne?id=" + id);
    };

    /*修改*/
    this.update = function (entity) {
        return $http.post(TB_ITEM_CAT_CONTROLLER + "/update", entity);
    };
    /*模糊查询*/
    this.blurrySelect = function (name) {
        return $http.get(TB_ITEM_CAT_CONTROLLER + "/blurrySelect?name=" + name);
    };
    //根据上级ID查询下级列表
    this.findByParentId = function (parentId) {
        return $http.get(TB_ITEM_CAT_CONTROLLER + '/findByParentId?parentId=' + parentId);
    };


})
