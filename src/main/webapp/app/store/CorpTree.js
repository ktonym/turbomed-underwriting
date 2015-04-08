Ext.define('EMIS.store.CorpTree',{
    extend: 'Ext.data.TreeStore',
    proxy: {
        type: 'ajax',
        url: 'corporate/treenode.json'
    }
});
