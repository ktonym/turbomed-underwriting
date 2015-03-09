Ext.define('EMIS.store.User',{
    extend: 'Ext.data.Store',
    requires: [
        'EMIS.model.User'
    ],
    model: 'EMIS.model.User',
    proxy: {
        type: 'ajax',
        url: 'user/findAll.json',
        reader: {
            type: 'json',
            root: 'data'
        }
    }
});
