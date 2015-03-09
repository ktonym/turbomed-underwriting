Ext.define("EMIS.view.MainHeader", {
    extend: 'Ext.container.Container',
    xtype: 'mainheader',
    requires: ['Ext.toolbar.Toolbar'],
    layout: {
        align: 'stretch',
        type: 'hbox'
    },
    initComponent: function(){
        var me = this;
        Ext.applyIf(me,{
            items: [{
                xtype: 'container',
                cls: 'logo',
                width: 300
            },{
                xtype: 'toolbar',
                flex: 1,
                ui: 'footer',
                layout: {
                    pack: 'end',
                    padding: '20 20 0 0',
                    type: 'hbox'
                },
                items: [{
                    xtype: 'button',
                    itemId: 'corpAdminBtn',
                    iconCls: 'tasklog',
                    text: 'Scheme Administration'
                },{
                    xtype: 'button',
                    itemId: 'indivAdminBtn',
                    iconCls: 'tasklog',
                    text: 'Individual Plan Admin'
                },{
                    xtype: 'button',
                    itemId: 'financialAdminBtn',
                    iconCls: 'tasklog',
                    text: 'Finance Admin'
                },{
                    xtype: 'button',
                    itemId: 'careMgtBtn',
                    iconCls: 'tasklog',
                    text: 'Care Management'
                },{
                    xtype: 'button',
                    itemId: 'claimAdminBtn',
                    iconCls: 'tasklog',
                    text: 'Claims Administration'
                },{
                    xtype: 'button',
                    itemId: 'userAdminBtn',
                    iconCls: 'users',
                    text: 'Users'
                },'->',
                    {
                    xtype: 'button',
                    itemId: 'logoffBtn',
                    iconCls: 'logoff',
                    text: 'Logoff'
                }]
            }]
        });
        me.callParent(arguments);
    }
});