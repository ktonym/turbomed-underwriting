Ext.define("EMIS.store.ClaimNavTree",{
    extend: 'Ext.data.TreeStore',
    root: {
        expanded: true,
        children: [
            {
                text: 'Enter Bill',
                leaf: true
            },
            {
                text: 'Vet Bill',
                leaf: true
            },
            {
                text: 'Batch',
                leaf: true
            },
            {
                text: 'Reconciliation',
                leaf: true
            },
            {
                text: 'Dashboard',
                leaf: true
            }
        ]
    }
});
