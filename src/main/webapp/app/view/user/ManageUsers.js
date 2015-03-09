Ext.define("EMIS.view.user.ManageUsers", {

    extend: 'Ext.panel.Panel',

    xtype: 'manageusers',

    requires: ['Ext.toolbar.Toolbar','EMIS.view.user.UserForm','EMIS.view.user.UserList'],

    layout: {
        type: 'hbox',
        align: 'stretch'
    },

    initComponent: function(){

        var me = this;

        Ext.applyIf(me,{
            dockedItems: [{
                xtype: 'toolbar',
                dock: 'top',
                items: [{
                    xtype: 'button',
                    itemId: 'addUserBtn',
                    iconCls: 'addnew',
                    text: 'Add user'
                }]
            }],
            items: [{
                xtype: 'userlist',
                width: 400,
                margin: 1
            },{
                xtype: 'userform',
                flex: 1
            }]
        });

        me.callParent(arguments);
    }
});