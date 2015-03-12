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
        selector: 'manageusers #addUserBtn'
    },{
        ref: 'saveUserButton',
        selector: 'manageusers userform #saveBtn'
    },{
        ref: 'deleteUserButton',
        selector: 'manageusers userform #deleteBtn'
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
                click: this.doAddUser
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
            },
            'manageusers userform #deleteBtn': {
                click: this.doDeleteUser
            },
            'manageusers userform #saveBtn': {
                click: this.doSaveUser
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
    },
    doDeleteUser: function(){
        var me = this;
        var rec = me.getUserForm().getRecord();
        Ext.Msg.confirm('Confirm Delete User','Are you sure you want to delete user ' +
        rec.get('firstName')+'?',function
            (btn){
            if(btn ==='yes'){
                rec.destroy({
                    success: function(rec,operation){
                        Ext.Msg.alert('Delete success',operation.request.scope.reader.jsonData.msg);
                    },
                    failure: function(rec,operation){
                        Ext.Msg.alert('Delete Failure', operation.request.scope.reader.jsonData.msg);
                    }
                });
            }
        });
    },
    doSelectUser: function(grid,record){
        var me = this;
        me.getUserForm().loadRecord(record);
        me.getUserFormFieldset().setTitle('Edit User ' + record.data.username);
        me.getUsernameField().disable();
        me.getDeleteUserButton().enable();
    },
    doSaveUser: function(){
        var me = this;
        var rec = me.getUserForm().getRecord();
        if(rec !== null){
            me.getUserForm().updateRecord();
            var errs = rec.validate();
            if (errs.isValid()){
                rec.save({
                    success: function(record, operation){
                        if(typeof record.store === 'undefined'){
                            me.getUserList().getStore().add(record);
                            me.getUserList().getSelectionModel().select(record,true);
                        }
                        me.getUserFormFieldset().setTitle('Edit User ' + record.data.username);
                        me.getUsernameField().disable();
                        me.getDeleteUserButton().enable();
                    },
                    failure: function(rec,operation){
                        Ext.Msg.alert('Save Failure', operation.request.scope.reader.jsonData.msg);
                    }
                });
            } else {
                me.getUserForm().getForm().markInvalid(errs);
                Ext.Msg.lert('Invalid Fields','Please fix the invalid entries');
            }
        }
    }
});
