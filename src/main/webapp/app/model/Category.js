Ext.define('EMIS.model.Category', {
    extend: 'Ext.data.Model',
    
    fields: [
        { name: 'idCategory', type: 'int', useNull: true},
        { name: 'cat', type: 'string'},
        { name: 'description', type: 'string'},
        { name: 'idCorpAnniv', type: 'int', useNull:true },
        { name: 'anniv', type: 'int', persist: false }
    ],

    idProperty: 'idCategory',

    proxy: {
        type: 'ajax',
        idParam: 'idCategory',
        api:{
            create: 'category/store.json',
            read: 'category/findByAnniv.json',
            update: 'category/store.json',
            remove: 'category/remove.json'
        },
        reader: {
            type: 'json',
            root: 'data'
        },
        writer: {
            type: 'json',
            root: 'data',
            writeAllFields: true,
            encode: true,
            allowSingle: true
        }
    },

    validations: [
        {type: 'presence', field: 'cat'},
        {type: 'length', field: 'cat', min:1,max:2},
        {type: 'presence', field: 'idCorpAnniv'},
        {type: 'length', field: 'idCorpAnniv', min:1}
    ]
});
