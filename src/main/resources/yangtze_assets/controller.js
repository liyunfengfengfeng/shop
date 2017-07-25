/**
 * Created by Administrator on 2017/6/9 0009.
 */
app.controller('SidebarController',function ($rootScope, $http, $scope) {
    //获取用户的id和权限
    let user_id = Number(document.getElementById("user_id").value);
    let user_role = Number(document.getElementById("user_role").value);
    //存入$rootScope
    $rootScope.user_id=user_id;
    $rootScope.user_role=user_role;
    let nodes = [];
    $http.post('functions',$.param({userId:user_id}),{headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data){
            angular.forEach(data,function (f,index) {
                let node = {};
                node.id=f.id;
                node.name=f.name;
                node.icon=f.icon;
                node.url=f.urls;
                node.child=Number(f.child);
                $scope.class=String("tpl-left-nav-item");
                node.show=false;
                //有子节点将url改为#
                if (node.child==1){
                    node.sons=f.nodes;
                }else{
                }
                nodes.push(node);
            });
            $rootScope.nodes=nodes;
            $scope.nodes=nodes;
            console.log($scope.nodes);
        }).error(function () {
        alert("服务端错误");
    });
    $scope.displayUL=function (param) {
        let ul=document.getElementById(param);
        for (let i=0;i<$scope.nodes.length;i++){
            if ($scope.nodes[i].id==param){
                if ($scope.nodes[i].show){
                    ul.setAttribute("style","display:none;");
                }else {
                    ul.setAttribute("style","display:block;");
                }
                $scope.nodes[i].show=!$scope.nodes[i].show;
                break;
            }
        }
    };
    $http.post('storeNumber',$.param({user_id:user_id}),
        {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data){
            $rootScope.storeNumber=String(data);
            //获取店铺id
            $http.post('storeId',$.param({storeNumber:$rootScope.storeNumber}),{headers:{'Content-Type':'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    $rootScope.storeId=data;
                }).error(function () {

            });
        }).error(function () {
        // alert("服务端错误");
    });
});
app.controller('TopMessageController',function ($rootScope,$http,$scope) {
    $scope.messageNumber=Number();//消息数量
    $scope.message=[];
    $scope.user_id=$rootScope.user_id;
    $scope.user_role=$rootScope.user_role;
});
app.controller('UserController',function ($scope,$rootScope,$http) {
    let user_id = $rootScope.user_id;
    $http.post('AllUsers',$.param({user_id:user_id}),
        {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data){
            angular.forEach(data,function (f,index) {
                if(f.enabled==0){
                    f.style=String("启用");
                }else {
                    f.style=String("未启用");
                }
                f.check=false;//初始化所有用户没有被选定
            });
            $scope.users=data;
            $rootScope.users=$scope.users;
        }).error(function () {
        alert("服务端错误");
    });
    //当选则不同类别时，显示的数据不同
    $scope.changeData=function (style) {
        if(style=="option1"){
            return;
        }
        let parameter=Number(style);
        //获取启用的数据
        if (parameter==0){
            $http.post('EnabledUsers',$.param({user_id:user_id}),
                {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    angular.forEach(data,function (f,index) {
                        f.style=String("启用");
                    });
                    $scope.users=data;
                }).error(function () {
                alert("服务端错误");
            });
        }else{
            $http.post('DisabledUsers',$.param({user_id:user_id}),
                {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    angular.forEach(data,function (f,index) {
                        f.style=String("未启用");
                    });
                    $scope.users=data;
                }).error(function () {
                alert("服务端错误");
            });
        }
    };
    //批量操作
    $scope.checkAll=false;
    $scope.checkBoxAllChanged=function () {
        angular.forEach($scope.users,function (f,index) {
            f.check=$scope.checkAll;
        })
    };
    $scope.checkBoxChanged=function () {
        $scope.checkAll=false;
    };
    //批量删除
    $scope.deleteManyUser=function () {
        let deleteUsers=[];

        angular.forEach($scope.users,function (f,index) {
            if (f.check){
                deleteUsers.push(f.id);
            }
        });
        if (deleteUsers.length==0){
            alert("至少选择一项删除");
        }else {
            $http.post('deleteManyUser',$.param({deleteUsers:deleteUsers}),
                {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    if (data == "success") {
                        for (let i = 0; i < deletUsers.length; i++) {
                            for (let y=0;y<$scope.users.length;y++){
                                if ($scope.users[y].id==deletUsers[i]){
                                    $scope.users.splice(y,1);
                                    break;
                                }
                            }
                        }
                    } else {
                        alert("删除用户失败");
                    }
                }).error(function () {
                alert("服务端错误");
            });
        }
    };
    //删除单个user
    $scope.deleteSingleUser=function (paramId) {
      let id=Number(paramId);
        $http.post('deleteSingleUser',$.param({user_id:id}),
            {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
            .success(function (data) {
                if (data == "success") {
                    for (let i = 0; i < $scope.users.length; i++) {
                        if ($scope.users[i].id == id) {
                            $scope.users.splice(i, 1);
                            break;
                        }
                    }
                } else {
                    alert("删除用户失败");
                }
            }).error(function () {
            alert("服务端错误");
        });
    }
});
app.controller('UserAddController',function ($scope,$rootScope,$http,$state) {
    //获取店的所有职务
    $http.post('duties',$.param({storeNumber:$rootScope.storeNumber}),
        {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data) {
            $scope.duties=data;
        }).error(function () {
        alert("服务端错误");
    });
    //获取店的所有岗位
    $http.post('workstations',$.param({storeId:$rootScope.storeId}),
        {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data) {
            $scope.workstations=data;
        }).error(function () {
        alert("服务端错误");
    });
    //获取这个店铺所有的role
    $http.post('getRoles',$.param({id:$rootScope.storeId}),
        {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data) {
            $scope.roles=data;
        }).error(function () {
        alert("服务端错误");
    });
    //跳转到下一步
    $scope.save=function () {
      $("#tabs").tabs('open',1);
    };
    $scope.user={};
    $scope.userInformation={};
    $scope.showStore=false;
    $scope.cancel=function () {
        $state.go("user");
    };
    $scope.duty={};
    $scope.workstation={};
    //点击提交
    $scope.addUserAndInformation=function () {
        if (!$scope.showStore){
            $scope.user.store=$rootScope.storeNumber;
        }
        $scope.userInformation.dutyId=$scope.duty.id;
        $scope.userInformation.departmentId=$scope.workstation.departmentId;
        $scope.userInformation.workstationId=$scope.workstation.id;
        $scope.userInformation.storeId=$rootScope.storeId;
        $http.post('addUserInformation',$.param($scope.userInformation),
            {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
            .success(function (data){
                if(data!="defeat"){
                    $http.post('addUser',$.param({username:$scope.user.username,password:$scope.user.password,role:$scope.user.role.id,
                            store:$scope.user.store,userInformation: data}),
                        {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
                        .success(function (data){
                            if (data=="success"){
                                alert("添加用户信息成功");
                                $state.go("user");
                            }
                        }).error(function () {
                        alert("服务端错误");
                    });
                }else{
                    alert("添加UserInformation失败");
                }
            }).error(function () {
            alert("服务端错误");
        });
    }
});
app.controller('UserDetailsController',function ($stateParams,$http,$scope,$rootScope,$state) {
    let showStore=false;//将决定是否显示店铺的选项
    let id=Number($stateParams.id);
    let users=$rootScope.users;
    for (let i=0;i<users.length;i++){
        if(users[i].id==id){
            $scope.user=users[i];
            break;
        }
    }
    $scope.roles=[];
    $scope.roles.push($scope.user.role);
    //获取这个店铺所有的role
    $http.post('getRoles',$.param({id:$rootScope.storeId}),
        {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data) {
            $scope.roles.concat(data);
        }).error(function () {
        alert("服务端错误");
    });
    if(showStore){
        $http.post('enabledStoresByOrganization',$.param({organization:$rootScope.organizationId}),
            {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
            .success(function (data) {
                $scope.stores=data;
            }).error(function () {
            alert("服务端错误");
        });
    }
    //点击选择 触发函数
    $scope.checked=function (id) {
        $scope.user.enabled=Number(id);
    };
    $scope.changeUser=function () {
        if (showStore){//若显示店铺，则为店铺之上的管理者
            $http.post('changeUser',$.param({id:$scope.user.id,username:$scope.user.username,password:$scope.user.password,roleId:$scope.user.role.id,
                    store:$scope.user.store,userInformation:$scope.user.user.id,enabled:$scope.user.enabled}),
                {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    if(data=="success"){
                        $state.go('user');
                        alert("修改成功")
                    }else{
                        alert("更改失败");
                    }
                }).error(function () {
                alert("服务端错误");
            });
        }else{
            $http.post('changeUser',$.param({id:$scope.user.id,username:$scope.user.username,password:$scope.user.password,roleId:$scope.user.role.id,
                 userInformation:$scope.user.user.id,enabled:$scope.user.enabled}),
                {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    $scope.stores=data;
                    $state.go('user');
                }).error(function () {
                alert("服务端错误");
            });
        }
    }
});
app.controller('RoleController',function ($scope,$rootScope,$http,$state) {
    let user_id = $rootScope.user_id;
    let storeId=$rootScope.storeId;
    $http.post('getRoles',$.param({id:storeId}),
        {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data){
            angular.forEach(data,function (f,index) {
                if(f.state==0){
                    f.style=String("启用");
                }else {
                    f.style=String("未启用");
                }
                f.check=false;//初始化所有用户没有被选定
            });
            $scope.roles=data;
            $rootScope.roles=$scope.roles;
        }).error(function () {
        alert("服务端错误");
    });
    //当选则不同类别时，显示的数据不同
    $scope.changeData=function (style) {
        if(style=="option1"){
            return;
        }
        let parameter=Number(style);
        //获取启用的数据
        if (parameter==0){
            $http.post('EnabledRoles',$.param({storeId:storeId}),
                {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    angular.forEach(data,function (f,index) {
                        f.style=String("启用");
                    });
                    $scope.roles=data;
                }).error(function () {
                alert("服务端错误");
            });
        }else{
            $http.post('DisabledRoles',$.param({storeId:storeId}),
                {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    angular.forEach(data,function (f,index) {
                        f.style=String("未启用");
                    });
                    $scope.roles=data;
                }).error(function () {
                alert("服务端错误");
            });
        }
    };
    //批量操作
    $scope.checkAll=false;
    $scope.checkBoxAllChanged=function () {
        angular.forEach($scope.users,function (f,index) {
            f.check=$scope.checkAll;
        })
    };
    $scope.checkBoxChanged=function () {
        $scope.checkAll=false;
    };
    //批量删除
    $scope.deleteManyRole=function () {
        let deleteRoles=[];
        angular.forEach($scope.roles,function (f,index) {
            if (f.check){
                deleteRoles.push(f.id);
            }
        });
        if (deleteRoles.length==0){
            alert("至少选择一项删除");
        }else {
            $http.post('deleteManyRole',$.param({deleteRoles:deleteRoles}),
                {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    if (data == "success") {
                        for (let i = 0; i < deleteRoles.length; i++) {
                            for (let y=0;y<$scope.roles.length;y++){
                                if ($scope.roles[y].id==deleteRoles[i]){
                                    $scope.roles.splice(y,1);
                                    break;
                                }
                            }
                        }
                    } else {
                        alert("删除角色失败");
                    }
                }).error(function () {
                alert("服务端错误");
            });
        }
    };
    //删除单个user
    $scope.deleteSingleRole=function (paramId) {
        let id=Number(paramId);
        $http.post('deleteSingleRole',$.param({id:id}),
            {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
            .success(function (data) {
                if (data == "success") {
                    for (let i = 0; i < $scope.roles.length; i++) {
                        if ($scope.roles[i].id == id) {
                            $scope.roles.splice(i, 1);
                            break;
                        }
                    }
                } else {
                    alert("删除角色失败");
                }
            }).error(function () {
            alert("服务端错误");
        });
    }
});
app.controller('MenuController',function ($scope,$rootScope,$http) {
    let zNodes = [
        {id: 1, pId: 0, name: "父节点 1", open: true},
        {id: 11, pId: 1, name: "叶子节点 1-1"},
        {id: 12, pId: 1, name: "叶子节点 1-2"},
        {id: 13, pId: 1, name: "叶子节点 1-3"},
        {id: 2, pId: 0, name: "父节点 2", open: true},
        {id: 21, pId: 2, name: "叶子节点 2-1"},
        {id: 22, pId: 2, name: "叶子节点 2-2"},
        {id: 23, pId: 2, name: "叶子节点 2-3"},
        {id: 3, pId: 0, name: "父节点 3", open: true},
        {id: 31, pId: 3, name: "叶子节点 3-1"},
        {id: 32, pId: 3, name: "叶子节点 3-2"},
        {id: 33, pId: 3, name: "叶子节点 3-3"}
    ];
    $http.post('noNestFunctions',$.param({}),{headers:{'Content-Type':'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data) {
            zNodes=data;
            angular.forEach(zNodes,function (f,index) {
                if (f.pId==0){
                    f.open=true;
                }
            });
            $(document).ready(function(){
                $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            });
        }).error(function () {
            alert("错误");
    });
    let setting = {
        view: {
            addHoverDom: addHoverDom,
            removeHoverDom: removeHoverDom,
            selectedMulti: false
        },
        edit: {
            enable: true,
            editNameSelectAll: true,
            showRemoveBtn: showRemoveBtn,
            showRenameBtn: showRenameBtn
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeDrag: beforeDrag,
            beforeEditName: beforeEditName,
            beforeRemove: beforeRemove,
            beforeRename: beforeRename,
            onRemove: onRemove,
            onRename: onRename
        }
    };
    var log, className = "dark";
    function beforeDrag(treeId, treeNodes) {
        return false;
    }
    function beforeEditName(treeId, treeNode) {
        className = (className === "dark" ? "":"dark");
        showLog("[ "+getTime()+" beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.selectNode(treeNode);
        setTimeout(function() {
            if (confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？")) {
                setTimeout(function() {
                    zTree.editName(treeNode);
                }, 0);
            }
        }, 0);
        return false;
    }
    //返回true执行删除，false不执行
    function beforeRemove(treeId, treeNode) {
        className = (className === "dark" ? "":"dark");
        showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.selectNode(treeNode);
        if(confirm("确认删除 节点 -- " + treeNode.name + " 吗？")){
            $http.post('deleteSingleFunction',$.param({"function_id":treeNode.id}),{headers:
                {'Content-Type':'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    if (data=="success"){
                        return true;
                    }else{
                        alert("删除失败");
                        return false;
                    }
                }).error(function () {
                alert("失败，服务器端错误");
                return false;
            });
        }else{
            return false;
        }
    }
    function onRemove(e, treeId, treeNode) {
        showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = treeObj.getNodes();
        console.log(nodes);
    }
    function beforeRename(treeId, treeNode, newName, isCancel) {
        className = (className === "dark" ? "":"dark");
        showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
        if (newName.length == 0) {
            setTimeout(function() {
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                zTree.cancelEditName();
                alert("节点名称不能为空.");
            }, 0);
            return false;
        }
        $http.post('changeFunctionName',$.param({"function_id":treeNode.id,"newName":newName}),{headers:
            {'Content-Type':'application/x-www-form-urlencoded;charset=utf-8'}})
            .success(function (data) {
                if (data=="success"){
                    return true;
                }else{
                    alert("修改失败");
                    return false;
                }
            }).error(function () {
            alert("失败，服务器端错误");
            return false;
        });
    }
    function onRename(e, treeId, treeNode, isCancel) {
        showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
    }
    function showRemoveBtn(treeId, treeNode) {
        return !treeNode.isFirstNode;
    }
    function showRenameBtn(treeId, treeNode) {
        return !treeNode.isLastNode;
    }
    function showLog(str) {
        if (!log) log = $("#log");
        log.append("<li class='"+className+"'>"+str+"</li>");
        if(log.children("li").length > 8) {
            log.get(0).removeChild(log.children("li")[0]);
        }
    }
    function getTime() {
        var now= new Date(),
            h=now.getHours(),
            m=now.getMinutes(),
            s=now.getSeconds(),
            ms=now.getMilliseconds();
        return (h+":"+m+":"+s+ " " +ms);
    }

    var newCount = 1;
    function addHoverDom(treeId, treeNode) {
        var sObj = $("#" + treeNode.tId + "_span");
        if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
        var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
            + "' title='添加菜单' onfocus='this.blur();'></span>";
        sObj.after(addStr);
        var btn = $("#addBtn_"+treeNode.tId);
        if (btn) btn.bind("click", function(){
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            $http.post('addFunction',$.param({"name":"新功能"+ (newCount++),"pId":treeNode.id}),{headers:
                {'Content-Type':'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    zTree.addNodes(treeNode, {id:data, pId:treeNode.id, name:"新功能" + newCount});
                }).error(function () {
                alert("失败，服务器端错误");
            });
            return false;
        });
    }
    function removeHoverDom(treeId, treeNode) {
        $("#addBtn_"+treeNode.tId).unbind().remove();
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
    }
});
app.controller('OrganizationController',function ($scope,$rootScope,$http,$state) {
    let zNodes = [
        {id: 1, pId: 0, name: "父节点 1", open: true},
        {id: 11, pId: 1, name: "叶子节点 1-1"},
        {id: 12, pId: 1, name: "叶子节点 1-2"},
        {id: 13, pId: 1, name: "叶子节点 1-3"},
        {id: 2, pId: 0, name: "父节点 2", open: true},
        {id: 21, pId: 2, name: "叶子节点 2-1"},
        {id: 22, pId: 2, name: "叶子节点 2-2"},
        {id: 23, pId: 2, name: "叶子节点 2-3"},
        {id: 3, pId: 0, name: "父节点 3", open: true},
        {id: 31, pId: 3, name: "叶子节点 3-1"},
        {id: 32, pId: 3, name: "叶子节点 3-2"},
        {id: 33, pId: 3, name: "叶子节点 3-3"}
    ];
    $http.post('organizations',$.param({}),{headers:{'Content-Type':'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data) {
            zNodes=data;
            angular.forEach(zNodes,function (f,index) {
                if (f.pId==0){
                    f.open=true;
                }
            });
            $(document).ready(function(){
                $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            });
        }).error(function () {
        alert("错误");
    });
    let setting = {
        view: {
            addHoverDom: addHoverDom,
            removeHoverDom: removeHoverDom,
            selectedMulti: false
        },
        edit: {
            enable: true,
            editNameSelectAll: true,
            showRemoveBtn: showRemoveBtn,
            showRenameBtn: showRenameBtn
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeDrag: beforeDrag,
            beforeEditName: beforeEditName,
            beforeRemove: beforeRemove,
            beforeRename: beforeRename,
            onRemove: onRemove,
            onRename: onRename
        }
    };
    var log, className = "dark";
    function beforeDrag(treeId, treeNodes) {
        return false;
    }
    function beforeEditName(treeId, treeNode) {
        className = (className === "dark" ? "":"dark");
        showLog("[ "+getTime()+" beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.selectNode(treeNode);
        setTimeout(function() {
            if (confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？")) {
                setTimeout(function() {
                    zTree.editName(treeNode);
                }, 0);
            }
        }, 0);
        return false;
    }
    //返回true执行删除，false不执行
    function beforeRemove(treeId, treeNode) {
        className = (className === "dark" ? "":"dark");
        showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.selectNode(treeNode);
        if(confirm("确认删除 节点 -- " + treeNode.name + " 吗？")){
            $http.post('deleteSingleOrganization',$.param({"organization_id":treeNode.id}),{headers:
                {'Content-Type':'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    if (data=="success"){
                        return true;
                    }else{
                        alert("删除失败");
                        return false;
                    }
                }).error(function () {
                alert("失败，服务器端错误");
                return false;
            });
        }else{
            return false;
        }
    }
    function onRemove(e, treeId, treeNode) {
        showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = treeObj.getNodes();
        console.log(nodes);
    }
    function beforeRename(treeId, treeNode, newName, isCancel) {
        className = (className === "dark" ? "":"dark");
        showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
        if (newName.length == 0) {
            setTimeout(function() {
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                zTree.cancelEditName();
                alert("节点名称不能为空.");
            }, 0);
            return false;
        }
        $http.post('changeOrganizationName',$.param({"organization_id":treeNode.id,"newName":newName}),{headers:
            {'Content-Type':'application/x-www-form-urlencoded;charset=utf-8'}})
            .success(function (data) {
                if (data=="success"){
                    return true;
                }else{
                    alert("修改失败");
                    return false;
                }
            }).error(function () {
            alert("失败，服务器端错误");
            return false;
        });
    }
    function onRename(e, treeId, treeNode, isCancel) {
        showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
    }
    function showRemoveBtn(treeId, treeNode) {
        return !treeNode.isFirstNode;
    }
    function showRenameBtn(treeId, treeNode) {
        return !treeNode.isLastNode;
    }
    function showLog(str) {
        if (!log) log = $("#log");
        log.append("<li class='"+className+"'>"+str+"</li>");
        if(log.children("li").length > 8) {
            log.get(0).removeChild(log.children("li")[0]);
        }
    }
    function getTime() {
        var now= new Date(),
            h=now.getHours(),
            m=now.getMinutes(),
            s=now.getSeconds(),
            ms=now.getMilliseconds();
        return (h+":"+m+":"+s+ " " +ms);
    }

    var newCount = 1;
    function addHoverDom(treeId, treeNode) {
        var sObj = $("#" + treeNode.tId + "_span");
        if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
        var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
            + "' title='添加菜单' onfocus='this.blur();'></span>";
        sObj.after(addStr);
        var btn = $("#addBtn_"+treeNode.tId);
        if (btn) btn.bind("click", function(){
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            //在添加之前要确保，同一个节点下的子节点的名字不能重复
            $http.post('addOrganization',$.param({"name":"新功能"+ (newCount++),"pId":treeNode.id}),{headers:
                {'Content-Type':'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    zTree.addNodes(treeNode, {id:data, pId:treeNode.id, name:"新功能" + newCount});
                }).error(function () {
                alert("失败，服务器端错误");
            });
            return false;
        });
    }
    function removeHoverDom(treeId, treeNode) {
        $("#addBtn_"+treeNode.tId).unbind().remove();
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
    }
});
app.controller('UserInformationController',function ($scope,$rootScope,$http,$state) {
    let store_id = $rootScope.storeId;
    $http.post('AllUserInformation',$.param({store_id:store_id}),
        {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data){
            angular.forEach(data,function (f,index) {
                if(f.enabled==0){
                    f.style=String("启用");
                }else {
                    f.style=String("未启用");
                }
                f.check=false;//初始化所有用户没有被选定
            });
            $scope.userInformation=data;
            $rootScope.userInformation=$scope.userInformation;
        }).error(function () {
        alert("服务端错误");
    });
    //当选则不同类别时，显示的数据不同
    $scope.changeData=function (style) {
        if(style=="option1"){
            return;
        }
        let parameter=Number(style);
        //获取启用的数据
        if (parameter==0){
            $http.post('EnabledUserInformation',$.param({store_id:$rootScope.storeId,state:0}),
                {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    angular.forEach(data,function (f,index) {
                        f.style=String("启用");
                    });
                    $scope.users=data;
                }).error(function () {
                alert("服务端错误");
            });
        }else{
            $http.post('DisabledUserInformation',$.param({store_id:$rootScope.storeId,state:1}),
                {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    angular.forEach(data,function (f,index) {
                        f.style=String("未启用");
                    });
                    $scope.users=data;
                }).error(function () {
                alert("服务端错误");
            });
        }
    };
    //批量操作
    $scope.checkAll=false;
    $scope.checkBoxAllChanged=function () {
        angular.forEach($scope.userInformation,function (f,index) {
            f.check=$scope.checkAll;
        })
    };
    $scope.checkBoxChanged=function () {
        $scope.checkAll=false;
    };
    //批量删除
    $scope.deleteManyUserInformation=function () {
        let deleteUserInformation=[];
        angular.forEach($scope.userInformation,function (f,index) {
            if (f.check){
                deleteUserInformation.push(f.id);
            }
        });
        if (deleteUserInformation.length==0){
            alert("至少选择一项删除");
        }else {
            $http.post('deleteManyUserInformation',$.param({deleteUsers:deleteUserInformation}),
                {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
                .success(function (data) {
                    if (data == "success") {
                        for (let i = 0; i < deleteUserInformation.length; i++) {
                            for (let y=0;y<$scope.userInformation.length;y++){
                                if ($scope.userInformation[y].id==deletUsers[i]){
                                    $scope.userInformation.splice(y,1);
                                    break;
                                }
                            }
                        }
                    } else {
                        alert("删除用户失败");
                    }
                }).error(function () {
                alert("服务端错误");
            });
        }
    };
    //删除单个user_information
    $scope.deleteSingleUserInformation=function (paramId) {
        let id=Number(paramId);
        $http.post('deleteSingleUserInformation',$.param({userInformationId:id}),
            {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
            .success(function (data) {
                if (data == "success") {
                    for (let i = 0; i < $scope.userInformation.length; i++) {
                        if ($scope.userInformation[i].id == id) {
                            $scope.userInformation.splice(i, 1);
                            break;
                        }
                    }
                } else {
                    alert("删除用户失败");
                }
            }).error(function () {
            alert("服务端错误");
        });
    }
});
app.controller('UserInformationAddController',function ($scope,$rootScope,$http,$state) {
    //获取店的所有职务
    $http.post('duties',$.param({storeNumber:$rootScope.storeNumber}),
        {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data) {
            $scope.duties=data;
        }).error(function () {
        alert("服务端错误");
    });
    //获取店的所有岗位
    $http.post('workstations',$.param({storeId:$rootScope.storeId}),
        {headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data) {
            $scope.workstations=data;
        }).error(function () {
        alert("服务端错误");
    });
    //获取这个店铺所有的role
    $http.post('getRoles',$.param({id:$rootScope.storeId}),
        {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
        .success(function (data) {
            $scope.roles=data;
        }).error(function () {
        alert("服务端错误");
    });
    //跳转到下一步
    $scope.save=function () {
        $("#tabs").tabs('open',1);
    };
    $scope.userInformation={};
    $scope.showStore=false;
    $scope.cancel=function () {
        $state.go("user_information");
    };
    $scope.duty={};
    $scope.workstation={};
    //点击提交
    $scope.addUserAndInformation=function () {
        $scope.userInformation.dutyId=$scope.duty.id;
        $scope.userInformation.departmentId=$scope.workstation.departmentId;
        $scope.userInformation.workstationId=$scope.workstation.id;
        $scope.userInformation.storeId=$rootScope.storeId;
        $http.post('addUserInformation',$.param($scope.userInformation),
            {headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}})
            .success(function (data){
                if(data!="defeat"){
                    alert("添加用户信息成功");
                    $state.go("user_information_add");
                }else{
                    alert("添加UserInformation失败");
                }
            }).error(function () {
            alert("服务端错误");
        });
    }
});
