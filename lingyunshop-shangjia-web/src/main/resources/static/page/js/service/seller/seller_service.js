//服务层
app.service('sellerService', function ($http) {

    var SELLER_CONTROLLER = "../tbSeller/"

    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get(SELLER_CONTROLLER + 'findAll.do');
    }
    //分页
    this.findPage = function (page, rows) {
        return $http.get(SELLER_CONTROLLER + 'findPage.do?page=' + page + '&rows=' + rows);
    }
    //查询实体
    this.findOne = function (id) {
        return $http.get(SELLER_CONTROLLER + 'findOne.do?id=' + id);
    }
    //增加
    this.add = function (entity) {
        return $http.post(SELLER_CONTROLLER + 'add', entity);
    }

});
