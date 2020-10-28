//登陆服务层
app.service('indexService', function ($http) {
    var TB_USER_CONTROLLER = "../tbUser/"
    //读取登录人名称
    this.loginName = function () {
        return $http.get('../tbUser/name');
    }
});
