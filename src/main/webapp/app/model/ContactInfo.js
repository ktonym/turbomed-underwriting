Ext.define('EMIS.model.ContactInfo', {
    extend: 'Ext.data.Model',
    
    fields: [
        { name: 'idContactInfo', type: 'int', useNull:true },
        { name: 'firstName', type: 'string' },
        { name: 'surname', type: 'string' },
        { name: 'jobTitle', type: 'string' },
        { name: 'email', type: 'string' },
        { name: 'tel', type: 'string' },
        { name: 'idCorporate', type: 'int',useNull:true},
        { name: 'corporateName', type: 'string', persist:false}

    ],

    idProperty: 'idContactInfo',

    proxy: {
        type: 'ajax',
        idParam: 'idContactInfo',
        api:{
            create: 'contactinfo/store.json',
            read: 'contactinfo/find.json',
            update: 'contactinfo/store.json',
            destroy: 'contactinfo/remove.json'
        },
        reader: {
            type: 'json',
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
        {type: 'presence', field: 'firstName'},
        {type: 'length', field: 'firstName', min: 2},
        {type: 'presence', field: 'surname'},
        {type: 'length', field: 'surname', min: 2},
        {type: 'presence', field: 'email'},
        {type: 'email',field: 'email'},
        {type: 'presence', field: 'tel'},
        {type: 'presence', field: 'idCorporate'}
    ]

});
