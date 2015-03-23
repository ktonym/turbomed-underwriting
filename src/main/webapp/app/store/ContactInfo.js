Ext.define('EMIS.store.ContactInfo',{
    extend: 'Ext.data.Store',
    requires: [
        'EMIS.model.ContactInfo'
    ],
    model: 'EMIS.model.ContactInfo',
    proxy: {
        type: 'ajax',
        url: 'contactinfo/findAll.json',
        reader: {
            type: 'json',
            root: 'data'
        }
    }
});