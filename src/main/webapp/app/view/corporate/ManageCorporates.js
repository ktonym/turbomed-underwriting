Ext.define("EMIS.view.corporate.ManageCorporates", {

    extend: 'Ext.panel.Panel',

    xtype: 'managecorporates',

    requires: ['Ext.toolbar.Toolbar',
//        'EMIS.view.corporate.CorpList',
        'EMIS.view.corporate.CorpTree',
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
            items: [{
                xtype: 'corptree',
                flex: 1,
                margin: 1

            },{
                xtype: 'container',
                itemId: 'adminCards',
                activeItem: 0,
                flex: 1,
                layout: {
                    type: 'card'
                },
                items: [{
                    xtype: 'container',
                    padding: 10,
                    html: 'Please select an item from the tree...'
                },{
                    xtype: 'corporateform'
                },{
                    xtype: 'annivform'
                },{
                    xtype: 'categoryform'
                }]
            }]
        });
        me.callParent(arguments);
    }
});