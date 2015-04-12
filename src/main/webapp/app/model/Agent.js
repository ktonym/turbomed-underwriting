Ext.define('EMIS.model.Agent', {
    extend: 'Ext.data.Model',
    
    fields: [
        { name: 'idIntermediary', type: 'int' },
        { name: 'PIN', type: 'string' },
        { name: 'type', type: 'string' },
        { name: 'joinDate', type: 'date' },
        { name: 'email', type: 'string' },
        { name: 'tel', type: 'string' },
        { name: 'firstName', type: 'string' },
        { name: 'surname', type: 'string' },
        { name: 'otherNames', type: 'string' },
        { name: 'intermediaryName', type: 'string' }

    ]
});
