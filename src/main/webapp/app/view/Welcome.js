Ext.define("EMIS.view.Welcome", {

    extend: 'Ext.panel.Panel',

    xtype: 'welcome',

    requires: ['Ext.XTemplate'],

    initComponent: function(){

        var me = this;

        var tpl = new Ext.XTemplate('<tpl for=".">','<p>Welcome ' +
            '<b>{firstName}</b>!</p>','<p>You are logged on as {username} [{email}]</p>',
            '</tpl>');

        var welcomeHtml = tpl.apply(EMIS.getApplication().getUser());

        Ext.applyIf(me,{
            items: [{
                xtype: 'container',
                padding: 10,
                html: welcomeHtml
            }]
        });
        me.callParent(arguments);
    }
});