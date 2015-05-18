Ext.define("EMIS.view.admin.ManageAdmin", {

    extend: 'Ext.panel.Panel',

    xtype: 'manageadmin',

    requires: [
        'EMIS.view.admin.AdminNavTree',
        'EMIS.view.admin.AccountMapping',
        'EMIS.view.admin.PremiumRates',
        'EMIS.view.admin.Intermediaries'
    ],

    layout: {
        type: 'hbox',
        align: 'stretch'
    },

    initComponent: function(){
        var me = this;
        Ext.applyIf(me,{
            items: [

                {
                    xtype: 'adminnavtree',
                    width: 100
                },
                {
                    xtype: 'container',
                    itemId: 'manageAdminCards',
                    activeItem: 0,
                    flex: 1,
                    layout: {
                        type: 'card'
                    },
                    items: [

                        {
                            xtype: 'container',
                            padding: 10,
                            html: 'Please select an item from the menu'
                        },{
                            xtype: 'accountmapping'
                        },{
                            xtype: 'premiumrates'
                        },{
                            xtype: 'intermediaries'
                        }

                    ]
                }

            ]
        });
        me.callParent(arguments);
    }

});