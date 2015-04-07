Ext.define("EMIS.view.corporate.CorpList", {

    extend: 'Ext.grid.Panel',

    xtype: 'corplist',

    store: 'Corporate',

    title: 'Corporate List',

    viewConfig: {
        markDirty: false,
        stripeRows: false
    },

    initComponent: function(){
        var me = this;
        Ext.applyIf(me,{
            tools: [{
                type: 'refresh',
                tooltip: 'Refresh list'
            }],
            columns: [{
                xtype: 'gridcolumn',
                dataIndex: 'idCorporate',
                flex: 1,
                text: 'Corp ID'
            },{
                xtype: 'gridcolumn',
                dataIndex: 'corporateName',
                flex: 2,
                text: 'Name'
            },{
                xtype: 'gridcolumn',
                dataIndex: 'abbreviation',
                flex: 1,
                text: 'Abbreviation'

            },{
                xtype: 'gridcolumn',
                dataIndex: 'tel',
                flex: 1,
                text: 'Telephone'
            },{
                xtype: 'gridcolumn',
                dataIndex: 'email',
                flex: 1,
                text: 'Email'
            },{
                xtype: 'gridcolumn',
                dataIndex: 'postalAddress',
                flex: 1,
                text: 'Postal Address'
            },{
                xtype: 'gridcolumn',
                dataIndex: 'joined',
                flex: 1,
                text: 'Join Date'
            }]
        });
        me.callParent(arguments);
    }
});