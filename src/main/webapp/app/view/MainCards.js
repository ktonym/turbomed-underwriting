Ext.define("EMIS.view.MainCards", {

    extend: 'Ext.container.Container',

    xtype: 'maincards',

    requires: ['Ext.layout.container.Card','EMIS.view.Welcome','EMIS.view.user.ManageUsers'],

    layout: 'card',

    initComponent: function(){
        var me = this;
        Ext.applyIf(me,{
            items: [{
                xtype: 'welcome',
                itemId: 'welcomeCard'
            },{
                xtype: 'manageusers',
                itemId: 'manageUsersCard'
            }]
        });
        me.callParent(arguments);
    }

});