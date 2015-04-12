Ext.define('EMIS.model.Agency', {
    extend: 'Ext.data.Model',
    
    fields: [
        { name: 'idIntermediary', type: 'int', useNull:true },
        { name: 'PIN', type: 'string' },
        { name: 'type', type: 'string' },
        { name: 'joinDate', type: 'date' },
        { name: 'email', type: 'string' },
        { name: 'tel', type: 'string' },
        { name: 'name', type: 'string' },
        { name: 'street', type: 'string' },
        { name: 'town', type: 'string' },
        { name: 'postalAddress', type: 'string' },
        { name: 'intermediaryName', type: 'string', persist: false }

    ] ,

    idProperty: 'idIntermediary',

    proxy:{
        type: 'ajax',
        idParam: 'idIntermediary',
        api: {
            create: 'intermediary/agency/store.json',
            read: 'intermediary/agency/find.json',
            update: 'intermediary/agency/store.json',
            destroy: 'intermediary/agency/remove.json'
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
    }   ,

    validations: [
        {type: 'presence', field:'PIN'},
        {type: 'presence', field:'type'},
        {type: 'presence', field:'joinDate'},
        {type: 'email',field: 'email'},
        {type: 'presence', field:'tel'},
        {type: 'presence', field:'street'},
        {type: 'presence', field:'town'},
        {type: 'presence', field:'postalAddress'}
    ]


});
