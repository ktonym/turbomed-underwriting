Ext.define('EMIS.view.corporate.CorpTree',{
    extend: 'Ext.tree.Panel',
    xtype: 'corptree',
    title: 'Corporates -> Anniversaries -> Categories',
    requires: ['EMIS.store.CorpTree'],
    store: 'CorpTree',
    lines: true,
    rootVisible: false,
    hideHeaders: true,
    viewConfig: {
        preserveScrollOnRefresh: true
    },
    initComponent: function(){
        var me = this;
        Ext.applyIf(me,{
            tools: [{
                type: 'expand',
                qtip: 'Expand All'
            },{
                type: 'collapse',
                qtip: 'Collapse All'
            },{
                type: 'refresh',
                qtip: 'Refresh Tree'
            }],
            columns: [{
                xtype: 'treecolumn',
                dataIndex: 'text',
                flex: 1
            }]
        });
        me.callParent(arguments);
    }
});
