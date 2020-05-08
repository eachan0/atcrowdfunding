// 声明专门的函数显示确认模态框
function showConfirmModal(roleArray) {

    // 打开模态框
    $("#confirmModal").modal("show");

    let roleNameDiv = $("#roleNameDiv");
    // 清除旧的数据
    roleNameDiv.empty();

    // 在全局变量范围创建数组用来存放角色id
    window.roleIdArray = [];

    // 遍历roleArray数组
    for (let i = 0; i < roleArray.length; i++) {
        let role = roleArray[i];
        let roleName = role.roleName;
        roleNameDiv.append(roleName + "<br/>");

        let roleId = role.roleId;

        // 调用数组对象的push()方法存入新元素
        window.roleIdArray.push(roleId);
    }

}

// 执行分页，生成页面效果，任何时候调用这个函数都会重新加载页面
function generatePage() {

    // 1.获取分页数据
    let pageInfo = getPageInfoRemote();

    // 2.填充表格
    fillTableBody(pageInfo);

}

// 远程访问服务器端程序获取pageInfo数据
function getPageInfoRemote() {

    // 调用$.ajax()函数发送请求并接受$.ajax()函数的返回值
    let ajaxResult = $.ajax({
        "url": "role/get/page/info.json",
        "type": "get",
        "data": {
            "pageNum": window.pageNum,
            "pageSize": window.pageSize,
            "keyword": window.keyword
        },
        "async": false,
        "dataType": "json"
    });

    // 判断当前响应状态码是否为200
    let statusCode = ajaxResult.status;

    // 如果当前响应状态码不是200，说明发生了错误或其他意外情况，显示提示消息，让当前函数停止执行
    if (statusCode !== 200) {
        layer.msg("失败！响应状态码=" + statusCode + " 说明信息=" + ajaxResult.statusText);
        return null;
    }

    // 如果响应状态码是200，说明请求处理成功，获取pageInfo
    let result = ajaxResult.responseJSON;

    // 判断result是否成功
    if (result.status !== 200) {
        layer.msg(result.message);
        return null;
    }

    // 确认result为成功返回pageInfo
    return result.data;
}

// 填充表格
function fillTableBody(pageInfo) {

    // 清除tbody中的旧的内容
    let rolePageBody = $("#rolePageBody");
    rolePageBody.empty();

    // 这里清空是为了让没有搜索结果时不显示页码导航条
    $("#Pagination").empty();

    // 判断pageInfo对象是否有效
    if (!pageInfo || !pageInfo.records || pageInfo.records.length === 0) {
        rolePageBody.append("<tr><td colspan='4' align='center'>抱歉！没有查询到您搜索的数据！</td></tr>");
        return;
    }

    // 使用pageInfo的list属性填充tbody
    pageInfo.records.forEach((data, index) => {
        let roleId = data.id;
        let roleName = data.name;

        let tr = "<tr><td>" + (index + 1) + "</td>" +
            "<td><input id='" + roleId + "' class='itemBox' type='checkbox'></td>" +
            "<td>" + roleName + "</td><td>" +
            "<button id='" + roleId + "' type='button' class='btn btn-success btn-xs checkBtn'><i class=' glyphicon glyphicon-check'></i></button>" +
            // 通过button标签的id属性（别的属性其实也可以）把roleId值传递到button按钮的单击响应函数中，在单击响应函数中使用this.id
            "<button id='" + roleId + "' type='button' class='btn btn-primary btn-xs pencilBtn'><i class=' glyphicon glyphicon-pencil'></i></button>" +
            // 通过button标签的id属性（别的属性其实也可以）把roleId值传递到button按钮的单击响应函数中，在单击响应函数中使用this.id
            "<button id='" + roleId + "' type='button' class='btn btn-danger btn-xs removeBtn'><i class=' glyphicon glyphicon-remove'></i></button>" +
            "</td></tr>";

        $("#rolePageBody").append(tr);
    })

    // 生成分页导航条
    generateNavigator(pageInfo);
}

// 生成分页页码导航条
function generateNavigator(pageInfo) {

    // 获取总记录数
    let totalRecord = pageInfo.total;

    // 声明相关属性
    let properties = {
        "num_edge_entries": 3,
        "num_display_entries": 5,
        "callback": paginationCallBack,
        "items_per_page": pageInfo.size,
        "current_page": pageInfo.current - 1,
        "prev_text": "上一页",
        "next_text": "下一页"
    }

    // 调用pagination()函数
    $("#Pagination").pagination(totalRecord, properties);
}

// 翻页时的回调函数
function paginationCallBack(pageIndex, jQuery) {

    // 修改window对象的pageNum属性
    window.pageNum = pageIndex + 1;

    // 调用分页函数
    generatePage();

    // 取消页码超链接的默认行为
    return false;

}

// 声明专门的函数用来在分配Auth 的模态框中显示Auth 的树形结构数据
function fillAuthTree() {
    // 1.发送Ajax 请求查询Auth 数据
    let ajaxReturn = $.ajax({
        "url": "assign/get/all/auth.json",
        "type": "get",
        "dataType": "json",
        "async": false
    });
    if (ajaxReturn.status !== 200) {
        let data = ajaxReturn.responseJSON;
        let msg = data ? (data.message || "系统错误") : res.statusText;
        layer.msg(" 请求处理出错！ 响应状态码是： " + ajaxReturn.status + " 说明是： " + msg);
        return;
    }
    // 2.从响应结果中获取Auth 的JSON 数据
    // 从服务器端查询到的list 不需要组装成树形结构，这里我们交给zTree 去组装
    let authList = ajaxReturn.responseJSON.data;
    // 3.准备对zTree 进行设置的JSON 对象
    const setting = {
        "data": {
            "simpleData": {
                // 开启简单JSON 功能
                "enable": true,
                // 使用categoryId 属性关联父节点，不用默认的pId 了
                "pIdKey": "categoryId"
            },
            "key": {
                // 使用title 属性显示节点名称，不用默认的name 作为属性名了
                "name": "title"
            }
        },
        "check": {
            "enable": true
        }
    };
    // 4.生成树形结构
    // <ul id="authTreeDemo" class="ztree"></ul>
    $.fn.zTree.init($("#authTreeDemo"), setting, authList);
    // 获取zTreeObj 对象
    let zTreeObj = $.fn.zTree.getZTreeObj("authTreeDemo");
    // 调用zTreeObj 对象的方法，把节点展开
    zTreeObj.expandAll(true);
    // 5.查询已分配的Auth 的id 组成的数组
    ajaxReturn = $.ajax({
        "url": "assign/get/authIdByRoleId.json",
        "type": "get",
        "data": {
            "id": window.roleId
        },
        "dataType": "json",
        "async": false
    });
    if (ajaxReturn.status !== 200) {
        let data = ajaxReturn.responseJSON;
        let msg = data ? (data.message || "系统错误") : res.statusText;
        layer.msg(" 请求处理出错！ 响应状态码是： " + ajaxReturn.status + " 说明是： " + msg);
        return;
    }
    // 从响应结果中获取authIdArray
    const authIdArray = ajaxReturn.responseJSON.data;
    // 6.根据authIdArray 把树形结构中对应的节点勾选上
    // ①遍历authIdArray
    authIdArray.forEach(authId => {
        // ②根据id 查询树形结构中对应的节点
        let treeNode = zTreeObj.getNodeByParam("id", authId);
        // ③将treeNode 设置为被勾选
        // checked 设置为true 表示节点勾选
        let checked = true;
        // checkTypeFlag 设置为false，表示不“联动”，不联动是为了避免把不该勾选的勾选上
        let checkTypeFlag = false;
        // 执行
        zTreeObj.checkNode(treeNode, checked, checkTypeFlag);
    })
    /*for (let i = 0; i < authIdArray.length; i++) {
        let authId = authIdArray[i];
        // ②根据id 查询树形结构中对应的节点
        let treeNode = zTreeObj.getNodeByParam("id", authId);
        // ③将treeNode 设置为被勾选
        // checked 设置为true 表示节点勾选
        let checked = true;
        // checkTypeFlag 设置为false，表示不“联动”，不联动是为了避免把不该勾选的勾选上
        let checkTypeFlag = false;
        // 执行
        zTreeObj.checkNode(treeNode, checked, checkTypeFlag);
    }*/
}
