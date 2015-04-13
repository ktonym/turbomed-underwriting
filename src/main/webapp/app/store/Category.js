Ext.define('EMIS.store.Category',{
    extend: 'Ext.data.Store',
    requires: ['EMIS.model.Category'],
    model: 'EMIS.model.Category',
    proxy: {
        type: 'ajax',
        url: 'category/findByAnniv.json',
        reader: {
            type: 'json',
            root: 'data'
        }
    },
    doFindByAnniv: function(idCorpAnniv){
        this.load({
            url: 'category/findByAnniv.json',
            params: {
                idCorpAnniv: idCorpAnniv
            }
        });
    }
});
