Ext.define('EMIS.store.Principal',{

    extend: 'Ext.data.Store',

    requires: ['EMIS.model.Principal'],

    model: 'EMIS.model.Principal',

    proxy: {
        type: 'ajax',
        url: 'principal/findByCategory.json',
        reader: {
            type: 'json',
            root: 'data'
        }
    },

    doFindByCategory: function(idCategory){
       this.load({
           url: 'principal/findByCategory.json',
           params: {
               idCategory: idCategory
           }
       });
    }

});
