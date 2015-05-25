Ext.define('EMIS.model.BenefitRef', {
    extend: 'Ext.data.Model',
    
    fields: [
        { name: 'benefitCode', type: 'integer' },
        { name: 'benefitName', type: 'string' },
        { name: 'description', type: 'string' }

    ],
    idProperty: 'benefitCode',

    proxy: {
        type: 'ajax',
        idParam: 'benefitCode',
        api: {
            create: 'ref/benefit/store.json',
            read: 'ref/benefit/find.json',
            update: 'ref/benefit/store.json',
            remove: 'ref/benefit/remove.json'
        },
        reader: {
            type: 'json',
            root: 'data'
        },
        writer: {
            type: 'json',
            writeAllFields: true,
            allowSingle: true,
            encode: true,
            root: 'data'
        }
    },
    validations: [
        {type: 'presence', field: 'benefitName'},
        {type: 'length', field: 'benefitName', min:4}
    ]
});
