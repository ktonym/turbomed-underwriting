Ext.define('EMIS.store.CorpAnniv',{
    extend: 'Ext.data.Store',
    requires: ['EMIS.model.CorpAnniv'],
    model: 'EMIS.model.CorpAnniv',
    proxy:{
        type: 'ajax',
        url: 'corporate/anniv/findAll.json',
        reader: {
            type: 'json',
            root: 'data'
        }
    }
});
