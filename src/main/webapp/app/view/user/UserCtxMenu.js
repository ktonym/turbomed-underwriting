Ext.define("EMIS.view.user.UserCtxMenu", {

    extend: 'Ext.menu.Menu',

    alias: 'widget.userctxmenu',

    width: 120,

    initComponent: function(){

        var me = this;

        Ext.applyIf(me,{

            items: [

                {
                    xtype: 'menuitem',
                    text: 'unlock',
                    iconCls: 'icon-add'
                },

                {
                    xtype: 'menuitem',
                    text: 'disable',
                    iconCls: 'disable'
                },

                {
                    xtype: 'menuitem',
                    text: 'Edit',
                    iconCls: 'edit'
                },

                {
                    xtype: 'menuitem',
                    text: 'Delete',
                    iconCls: 'icon-delete'
                }

            ]

        });

        me.callParent(arguments);

    }

});