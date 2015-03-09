Ext.define('EMIS.view.Viewport', {

    extend: 'Ext.container.Viewport',

    cls: 'x-border-layout-ct',

    requires:[
        'Ext.layout.container.VBox',
        'EMIS.view.MainHeader',
        'EMIS.view.MainCards'
    ],

    padding: 5,

    layout: {
        type: 'vbox',
        align: 'stretch'
    },

    items: [{
        xtype: 'mainheader',
        height: 80
    },{
        xtype: 'maincards',
        flex: 1
    }]
});
