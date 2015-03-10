Ext.define('EMIS.controller.UserController', {
    extend: 'Ext.app.Controller',
    views: ['user.ManageUsers'],
    refs: [{
        ref: 'userForm',
        selector: 'manageusers userform'
    },{
        ref: 'userList',
        selector: 'manageusers userlist'
    },{
        ref: 'addUserButton',
        selector: 'manageusers button #addUserBtn'
    },{
        ref: 'saveUserButton',
        selector: 'manageusers userform button #saveBtn'
    },{
        ref: 'deleteUserButton',
        selector: 'manageusers userform button #deleteBtn'
    },{
        ref: 'userFormFieldset',
        selector: 'manageusers userform fieldset'
    },{
        ref: 'usernameField',
        selector: 'manageusers userform textfield[name=username]'
    }]
});
