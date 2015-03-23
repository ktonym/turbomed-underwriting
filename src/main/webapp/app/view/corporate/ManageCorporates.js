Ext.define("EMIS.view.corporate.ManageCorporates", {
    extend: 'Ext.panel.Panel',
    xtype: 'managecorporates',
    requires: ['Ext.toolbar.Toolbar', 'Ext.layout.container.Border',
    'Ext.form.field.Date','EMIS.view.corporate.CorporateForm','EMIS.view.corporate.CorporateList'],
    layout: {
        type: 'border'
    },
    initComponent: function(){
        var me = this;
        var now = new Date();
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
                xtype: 'corporatelist',
                region: 'center',
                margin: 1

            },{
                xtype: 'corporateform',
                region: 'east',
                split: true,
                width: 400
            }]
        });
        me.callParent(arguments);
    }
});