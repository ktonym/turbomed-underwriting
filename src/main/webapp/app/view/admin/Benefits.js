Ext.define("EMIS.view.admin.Benefits", {

    extend: 'Ext.ux.LiveSearchGridPanel',

    xtype: 'benefitgrid' ,

    columnLines: true,

    viewConfig: {
        stripeRows: true
    },

    store: 'BenefitRef',

    initComponent: function(){
        var me=this;

        me.selModel = {
            selType: 'cellmodel'
        };

        me.plugins = [
            {
                ptype: 'cellediting',
                clicksToEdit: 2,
                pluginId: 'cellplugin'
            },
            {
                ptype: 'gridfilters'
            }
        ];

        me.dockedItems = [
            {
                xtype: 'toolbar',
                dock: 'top',
                itemId: 'topToolbar',
                items: [
                    {
                        xtype: 'button',
                        itemId: 'add',
                        text: 'Add'
                        //glyph: EMIS.util.Glyphs.getGlyph('add')
                    },
                    {
                        xtype: 'tbseparator'
                    },
                    {
                        xtype: 'button',
                        itemId: 'save',
                        text: 'Save Changes'
                        //glyph: EMIS.util.Glyphs.getGlyph('saveAll')
                    },
                    {
                        xtype: 'button',
                        itemId: 'cancel',
                        text: 'Cancel Changes'
                        //glyph: EMIS.util.Glyphs.getGlyph('cancel')
                    },
                    {
                        xtype: 'tbseparator'
                    },
                    {
                        xtype: 'button',
                        itemId: 'clearFilter',
                        text: 'Clear Filters'
                        //glyph: EMIS.util.Glyphs.getGlyph('clearFilter')
                    }
                ]
            }
        ];

        columns: [
            {

            }
        ]


        me.callParent(arguments);
    }
});