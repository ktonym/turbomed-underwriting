Ext.define('EMIS.store.AdminNavTree',{
    extend:'Ext.data.TreeStore',
    root: {
        expanded: true,
        children: [
            {
                text: 'Account Mapping',
                leaf: true
            },
            {
                text: 'Intermediaries',
                leaf: true
            },
            {
                text: 'Premium Rates',
                leaf: true
            }
        ]
    }
});
