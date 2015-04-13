Ext.define('EMIS.model.CorpAnniv', {
    extend: 'Ext.data.Model',
    
    fields: [
        { name: 'idCorpAnniv', type: 'int', useNull:true },
        { name: 'idCorporate', type: 'int' },
        { name: 'idIntermediary', type: 'int' },
        { name: 'anniv', type: 'int' },
        { name: 'startDate', type: 'date',dateFormat:'Ymd' },
        { name: 'endDate', type: 'date',dateFormat:'Ymd' },
        { name: 'renewalDate', type: 'date',dateFormat:'Ymd' },
        { name: 'corporateName', type: 'string', persist: false },
        { name: 'intermediaryName', type: 'string', persist:false }

    ] ,

    idProperty: 'idCorpAnniv',

    proxy:{
        type: 'ajax',
        idParam: 'idCorpAnniv',
        api: {
            create: 'corporate/anniv/store.json',
            read: 'corporate/anniv/find.json',
            update: 'corporate/anniv/store.json',
            remove: 'corporate/anniv/remove.json'
        } ,
        reader: {
            type: 'json',
            root: 'data'
        } ,
        writer: {
            type: 'json',
            allowSingle: true,
            root: 'data',
            encode: true,
            writeAllFields:true
        }
    } ,

    validations: [
        {type: 'presence', field: 'idCorporate' },
        {type: 'presence', field: 'idIntermediary'},
        {type: 'presence', field: 'anniv'},
        {type: 'presence', field: 'startDate'},
        {type: 'presence', field: 'endDate'},
        {type: 'presence', field: 'renewalDate'}
    ]

});
