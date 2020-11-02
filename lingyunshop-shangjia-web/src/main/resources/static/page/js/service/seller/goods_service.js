//服务层
app.service('goodsService', function ($http) {


    var TB_ITEM_CAT_CONTROLLER = "../../tbItemCat"
    const TB_TYPE_TEMPLATE = '../../tbTypeTemplate';
    var GOODS_CONTROLLER = "../../tbGoods/"

    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get(GOODS_CONTROLLER + 'findAll.do');
    }
    //分页
    this.findPage = function (page, rows) {
        return $http.get(GOODS_CONTROLLER + 'findPage.do?page=' + page + '&rows=' + rows);
    }
    //查询实体
    this.findOne = function (id) {
        return $http.get(GOODS_CONTROLLER + 'findOne.do?id=' + id);
    }
    //增加
    this.add = function (entity) {
        return $http.post(GOODS_CONTROLLER + 'add', entity);
    }

    //根据上级ID查询下级列表
    this.findByParentId = function (parentId) {
        return $http.get(TB_ITEM_CAT_CONTROLLER + '/findByParentId?parentId=' + parentId);
    };
    /*查询一个*/
    this.selectOne = function (id) {
        return $http.get(TB_ITEM_CAT_CONTROLLER + "/selectOne?id=" + id);
    };

    this.findTypeTemplate = function (id) {
        return $http.get(TB_TYPE_TEMPLATE + '/selectOne?id=' + id);
    }

    //查询规格列表
    this.findSpecList = function (id) {
        return $http.get(TB_TYPE_TEMPLATE + '/findSpecList?id=' + id);
    }


});
