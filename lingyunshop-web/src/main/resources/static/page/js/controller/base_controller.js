app.controller('base_controller', function ($scope) {
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };
    //重新加载列表 数据
    $scope.reloadList = function () {
        //切换页码
        $scope.findPage(this.paginationConf.currentPage, this.paginationConf.itemsPerPage);
    }
    $scope.selectIds = [];//选中的ID集合
    //更新复选
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {//如果标签是被选中,则增加到数组
            $scope.selectIds.push(id);
        } else {
            $scope.selectIds.splice($scope.selectIds.indexOf(id), 1);//删除
        }
        //console.log($scope.selectIds)
    }
    //全选
    $scope.selectAll = function ($event) {
        if ($event.target.checked) {//如果标签是被选中,则增加到数组
            $scope.list.forEach(en => $scope.selectIds.push(en.id))
            //  $scope.selectIds.push($scope.list.selectIds);
        } else {
            $scope.selectIds = [];//删除
        }
        //console.log($scope.selectIds)
    }
    //提取json字符串数据中某个属性，返回拼接字符串 逗号分隔
    $scope.jsonToString=function(jsonString,key){
        var json=JSON.parse(jsonString);//将json字符串转换为json对象
        var value="";
        for(var i=0;i<json.length;i++){
            if(i>0){
                value+=","
            }
            value+=json[i][key];
        }
        return value;
    }

});
