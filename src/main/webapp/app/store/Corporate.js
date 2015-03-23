Ext.define('EMIS.store.Corporate',{
    extend: 'Ext.data.Store',
    requires: [
        'EMIS.model.Corporate'
    ],
    model: 'EMIS.model.Corporate',
    proxy: {
        type: 'ajax',
        url: 'corporate/findAll.json',
        reader: {
            type: 'json',
            root: 'data'
        }
    }
});
