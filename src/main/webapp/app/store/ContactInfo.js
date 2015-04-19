Ext.define('EMIS.store.ContactInfo',{
    extend: 'Ext.data.Store',
    requires: [
        'EMIS.model.ContactInfo'
    ],
    model: 'EMIS.model.ContactInfo',
    proxy: {
        type: 'ajax',
        url: 'corporate/contact/findAll.json',
        reader: {
            type: 'json',
            root: 'data'
        }
    },
    doFindByCorporate: function(idCorporate){
        this.load({
            url: 'corporate/contact/findAll.json',
            params: {
                idCorporate: idCorporate
            }
        });
    }
});