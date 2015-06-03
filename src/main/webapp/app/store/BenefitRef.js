Ext.define('EMIS.store.BenefitRef',{
    extend: 'Ext.data.Store',
    requires: ['EMIS.model.BenefitRef'],
    model: 'EMIS.model.BenefitRef',
    proxy: {
        type: 'ajax',
        url: '/ref/benefits/find.json',
        reader: {
            type: 'json',
            root: 'data'
        }
    }
});
