Ext.define('EMIS.model.Category', {
    extend: 'Ext.data.Model',
    
    fields: [
        { name: 'idCorporate', type: 'int' },
        { name: 'idCorpAnniv', type: 'int' },
        { name: 'cat', type: 'string'},
        { name: 'description', type: 'string'}

    ]

    //TODO finish setup
});
