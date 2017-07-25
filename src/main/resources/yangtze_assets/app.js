/**
 * Created by Administrator on 2017/6/2 0002.
 */
var app = angular.module('app',['ui.router']);
app.run(function ($state) {

});
app.config(['$stateProvider', function ($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('user_information_add', {//添加员工信息
            controller: 'UserInformationAddController',
            controllerAs: 'user_information_add',
            url: '/add_user_information',
            templateUrl: "yangtze_assets/templates/user_information_add.html"})
        .state('user_information', {//员工信息管理
            controller: 'UserInformationController',
            controllerAs: 'user_information',
            url: '/user_information',
            templateUrl: "yangtze_assets/templates/user_information.html"})
        .state('user', {//用户管理
            controller: 'UserController',
            controllerAs: 'user',
            url: '/user',
            templateUrl: "yangtze_assets/templates/user.html"})
        .state('user_add', {//添加用户
            controller: 'UserAddController',
            controllerAs: 'user_add',
            url: '/add_user',
            templateUrl: "yangtze_assets/templates/user_add.html"})
        .state('user_details', {//用户编辑
            controller: 'UserDetailsController',
            controllerAs: 'user_details',
            url: '/user_details/:id',
            templateUrl: "yangtze_assets/templates/user_details.html"})
        .state('role_details', {//角色编辑
            controller: 'RoleDetailsController',
            controllerAs: 'role_details',
            url: '/role_details/:id',
            templateUrl: "yangtze_assets/templates/role_details.html"})
        .state('role_add', {//添加角色
            controller: 'RoleAddController',
            controllerAs: 'role_add',
            url: '/role_add',
            templateUrl: "yangtze_assets/templates/role_add.html"})
        .state('role', {//角色管理
            controller: 'RoleController',
            controllerAs: 'role',
            url: '/role',
            templateUrl: "yangtze_assets/templates/role.html"})
        .state('organization', {//组织管理
            controller: 'OrganizationController',
            controllerAs: 'organization',
            url: '/organization',
            templateUrl: "yangtze_assets/templates/organization.html"})
        .state('menu', {//菜单管理
            controller: 'MenuController',
            controllerAs: 'menu',
            url: '/menu',
            templateUrl: "yangtze_assets/templates/menu.html"});
}]);