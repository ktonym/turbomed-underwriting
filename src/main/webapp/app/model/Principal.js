Ext.define('EMIS.model.Principal', {
    extend: 'Ext.data.Model',
    
    fields: [
        { name: 'idPrincipal', type: 'int', useNull:true },
        { name: 'idCategory', type: 'int' },
        { name: 'cat', type: 'string', persist:false},
        { name: 'familyNo', type: 'string' },
        { name: 'firstName', type: 'string' },
        { name: 'surname', type: 'string' },
        { name: 'otherNames', type: 'string' },
        { name: 'fullName', type: 'string', persist:false}

    ],

    idProperty: 'idPrincipal',

    proxy:{
        type: 'ajax',
        idParam: 'idPrincipal',
        api: {
            create: 'principal/store.json',
            read: 'principal/find.json',
            update: 'principal/store.json',
            remove: 'principal/remove.json'
        },
        reader: {
            type: 'json',
            root: 'data'
        },
        writer: {
            type: 'json',
            root: 'data',
            writeAllFields: true,
            allowSingle: true,
            encode: true
        }
    },

    validations: [
        {type: 'presence', field: 'idCategory'},
        {type: 'presence', field: 'firstName'},
        {type: 'length', field: 'firstName', min: 2},
        {type: 'presence', field: 'surname'},
        {type: 'length', field: 'surname', min: 2}
    ]
});
