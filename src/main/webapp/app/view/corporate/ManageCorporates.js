Ext.define("EMIS.view.corporate.ManageCorporates", {

    extend: 'Ext.panel.Panel',

    xtype: 'managecorporates',

    requires: ['Ext.toolbar.Toolbar',
//        'EMIS.view.corporate.CorpList',
        'EMIS.view.corporate.CorporateForm'],

    layout: {
        type: 'hbox',
        align: 'stretch'
    },

    initComponent: function(){
        var me = this;
        Ext.applyIf(me,{
            dockedItems:[{
                xtype: 'toolbar',
                dock: 'top',
                items: [{
                    xtype: 'button',
                    iconCls: 'addnew',
                    itemId: 'addCorpBtn',
                    text: 'Add New'
                }]
            }] ,
            items: [
//                {
//                xtype: 'corplist',
//                width: 400,
//                margin: 1
//
//            },
                {
                xtype: 'corporateform',
                flex: 1
            }]
        });
        me.callParent(arguments);
    }
});