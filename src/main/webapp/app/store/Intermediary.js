Ext.define('EMIS.store.Intermediary',{
    extend: 'Ext.data.Store',
    requires: ['EMIS.model.Intermediary'],
    model: 'EMIS.model.Intermediary',
    proxy: {
        type: 'ajax',
        url: 'intermediary/findAll.json',
        reader: {
            type: 'json',
            root: 'data'
        }
    }

});
