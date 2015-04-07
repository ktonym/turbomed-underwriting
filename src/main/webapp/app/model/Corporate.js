Ext.define('EMIS.model.Corporate', {
    extend: 'Ext.data.Model',
    
    fields: [
        { name: 'idCorporate', type: 'int', useNull:true },
        { name: 'corporateName', type: 'string' },
        { name: 'abbreviation', type: 'string' },
        { name: 'tel', type: 'string' },
        { name: 'email', type: 'string' },
        { name: 'postalAddress', type: 'string' },
        { name: 'joined', type: 'date', dateFormat: 'Ymd' }

    ],
    idProperty: 'idCorporate',

    proxy: {
        type: 'ajax',
        idParam: 'idCorporate',
        api: {
            create: 'corporate/store.json',
            read: 'corporate/find.json',
            update: 'corporate/store.json',
            destroy: 'corporate/remove.json'
        },
        reader: {
            type:'json',
            root: 'data'
        },
        writer: {
            type: 'json',
            allowSingle: true,
            encode: true,
            root: 'data',
            writeAllFields: true
        }
    },

    validations: [
        {type: 'presence', field:'corporateName'},
        {type: 'length', field: 'corporateName', min:4},
        {type: 'presence', field:'abbreviation'},
        {type: 'length', field:'abbreviation', min:3, max:3},
        {type: 'presence', field:'tel'},
        {type: 'presence', field:'email'},
        {type: 'email', field:'email'},
        {type: 'presence', field:'postalAddress'}
    ]


});
