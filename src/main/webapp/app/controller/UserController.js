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
    }],
    init: function(application){
        this.control({
            'manageusers #addUserBtn': {
                click: this.addUser
            },
            'userlist': {
                itemclick: this.doSelectUser,
                viewready: this.doInitStore
            },
            'manageusers userform': {
                afterrender: this.doAddUser
            },
            'manageusers userform fieldset': {
                click: this.doRefreshUserList
            }
        });
    },
    doInitStore: function(){
        this.getUserList().getStore().load();
    },
    doRefreshUserList: function(){
        this.getUserList().getStore().load();
    },
    doAddUser: function(){
        var me = this;
        me.getUserFormFieldset().setTitle('Add New User');
        me.getUsernameField().enable();
        var newUserRec = Ext.create('EMIS.model.User');
        me.getUserForm().loadRecord(newUserRec);
        me.getDeleteUserButton().disable();
    }
});
