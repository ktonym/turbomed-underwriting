Ext.define("EMIS.view.admin.AdminNavTree", {
    extend: 'Ext.tree.Panel',
    xtype: 'adminnavtree' ,
    title: 'Navigation',
    requires: ['EMIS.store.AdminNavTree'],
    store: 'AdminNavTree',
    rootVisible: false,
    animate: false
});