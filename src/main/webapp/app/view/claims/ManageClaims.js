Ext.define("EMIS.view.corporate.claims.ManageClaims", {

    extend: 'Ext.panel.Panel',

    xtype: 'manageclaims',

    requires: ['Ext.toolbar.Toolbar',
        'EMIS.view.claims.ClaimEntry',
        'EMIS.view.claims.ClaimVetting',
         'EMIS.view.claims.ClaimPayment'
    ],

    layout: {
        type: 'hbox',
        align: 'stretch'
    },

    initComponent: function(){
        var me = this;
        Ext.applyIf(me,{
            dockedItems: [
                {
                    xtype: 'toolbar',
                    dock: 'top',
                    items: [
                        {
                            xtype:'button',
                            text: 'Enter Claim',
                            iconCls: 'tasklog',
                            itemId: 'enterClmBtn'
                        },
                        {
                            xtype:'button',
                            text: 'Search Claim',
                            iconCls: 'search',
                            itemId: 'searchClmBtn'
                        },
                        {
                            xtype:'button',
                            text: 'Vet Claim',
                            iconCls: '',
                            itemId: 'vetClmBtn'
                        }
                    ]
                }
            ],
            items: [
                {
                    xtype: 'container',
                    itemId: 'claimCards',
                    activeItem: 0,
                    layout: {
                        type: 'card'
                    },
                    items: [
                        {
                            xtype: 'container',
                            padding: 10,
                            html: 'Please select an item from the menu...'
                         },
                        {
                            xtype: 'claimentry'
                        },
                        {
                            xtype: 'claimvetting'
                        },
                        {
                            xtype: 'claimpayment'
                        }
                    ]
                }
            ]
        });
        me.callParent(arguments);
    }
});