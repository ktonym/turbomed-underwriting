Ext.define('EMIS.model.Intermediary', {
    extend: 'Ext.data.Model',
    
    fields: [
        { name: 'idIntermediary', type: 'int', useNull:true },
        { name: 'PIN', type: 'string' },
        { name: 'type', type: 'string' },
        { name: 'joinDate', type: 'date', dateFormat:'Ymd' },
        { name: 'email', type: 'string' },
        { name: 'tel', type: 'string' },
        { name: 'name', type: 'string' },
        { name: 'street', type: 'string' },
        { name: 'town', type: 'string' },
        { name: 'postalAddress', type: 'string' },
        { name: 'firstName', type: 'string' },
        { name: 'surname', type: 'string' },
        { name: 'otherNames', type: 'string' },
        { name: 'intermediaryName', type: 'string', persist: false }

    ] ,

    idProperty: 'idIntermediary',

    proxy:{
        type: 'ajax',
        idParam: 'idIntermediary',
        api: {
            create: 'intermediary/store.json',
            read: 'intermediary/find.json',
            update: 'intermediary/store.json',
            destroy: 'intermediary/remove.json'
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
        {type: 'presence', field:'tel'}
    ]


});
