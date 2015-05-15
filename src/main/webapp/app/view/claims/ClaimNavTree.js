Ext.define("EMIS.view.claims.ClaimNavTree", {
    extend: 'Ext.tree.Panel',
    xtype: 'claimnavtree',
    title: 'Navigation',
    requires: ['EMIS.store.ClaimNavTree'],
    store: 'ClaimNavTree',
    rootVisible: false,
    animate: false
});