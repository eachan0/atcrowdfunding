<%--
  Created by IntelliJ IDEA.
  User: zhuyc
  Date: 2020/4/21
  Time: 17:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="/WEB-INF/include-header.jsp" %>
    <link rel="stylesheet" href="css/pagination.css"/>
    <script type="text/javascript" src="jquery/jquery.pagination.js"></script>
    <script type="text/javascript">
        $(function () {
            initPagination();
        });

        function initPagination() {
            // 获取总记录数
            let totalRecord = ${requestScope.adminPageInfo.total};

            // 声明一个JSON对象存储Pagination要设置的属性
            let properties = {
                num_edge_entries: 3,								// 边缘页数
                num_display_entries: 5,								// 主体页数
                callback: pageSelectCallback,						// 指定用户点击“翻页”的按钮时跳转页面的回调函数
                items_per_page: ${requestScope.adminPageInfo.size},	// 每页要显示的数据的数量
                current_page: ${requestScope.adminPageInfo.current-1},	// Pagination内部使用pageIndex来管理页码，pageIndex从0开始，pageNum从1开始，所以要减一
                prev_text: "上一页",									// 上一页按钮上显示的文本
                next_text: "下一页"									// 下一页按钮上显示的文本
            };

            // 回调函数的含义：声明出来以后不是自己调用，而是交给系统或框架调用
            // 用户点击“上一页、下一页、1、2、3……”这样的页码时调用这个函数实现页面跳转
            // pageIndex是Pagination传给我们的那个“从0开始”的页码
            function pageSelectCallback(pageIndex, jQuery) {
                // 根据pageIndex计算得到pageNum
                let pageNum = pageIndex + 1;
                // 跳转页面
                window.location.href = "admin/get/page.html?pageNum=" + pageNum + "&keyword=${param.keyword}";
                // 由于每一个页码按钮都是超链接，所以在这个函数最后取消超链接的默认行为
                return false;
            }

            // 生成页码导航条
            $("#Pagination").pagination(totalRecord, properties);
        }
    </script>
</head>
<body>
<%@include file="/WEB-INF/include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="/WEB-INF/include-sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form action="admin/get/page.html" method="get" class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input name="keyword" class="form-control has-success" type="text" placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询
                        </button>
                    </form>
                    <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i
                            class=" glyphicon glyphicon-remove"></i> 删除
                    </button>
                    <a style="float: right;" href="admin/to/add/page.html" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i> 新增</a>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th width="30"><input type="checkbox"></th>
                                <th>账号</th>
                                <th>名称</th>
                                <th>邮箱地址</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${empty requestScope.adminPageInfo.records}">
                                <tr>
                                    <td colspan="6" style="text-align: center;">抱歉,没有查询到数据</td>
                                </tr>
                            </c:if>
                            <c:if test="${!empty requestScope.adminPageInfo.records}">
                                <c:forEach items="${requestScope.adminPageInfo.records}" var="admin" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td><input type="checkbox"></td>
                                        <td>${admin.loginAcct }</td>
                                        <td>${admin.userName }</td>
                                        <td>${admin.email }</td>
                                        <td>
                                            <a href="assign/to/assign/role/page.html?id=${admin.id }&pageNum=${requestScope.adminPageInfo.current }&keyword=${param.keyword }" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></a>
                                            <a href="admin/to/edit/page.html?id=${admin.id }&pageNum=${requestScope.adminPageInfo.current }&keyword=${param.keyword }" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></a>
                                            <a href="admin/remove/${admin.id }/${requestScope.adminPageInfo.current }/${param.keyword }.html" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="6" align="center">
                                    <div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
                                </td>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
