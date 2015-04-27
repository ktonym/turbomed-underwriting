Ext.define("EMIS.view.CtxMenu", {

    extend: 'Ext.menu.Menu',

    alias: 'widget.ctxmenu',

    width: 120,

    initComponent: function(){

        var me = this;

        Ext.applyIf(me,{

            items: [

                {
                    xtype: 'menuitem',
                    text: 'Add Item',
                    iconCls: 'icon-add'
                },

                {
                    xtype: 'menuitem',
                    text: 'Edit',
                    iconCls: 'icon-edit'
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