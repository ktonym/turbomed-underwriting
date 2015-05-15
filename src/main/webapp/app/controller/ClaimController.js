Ext.define("EMIS.controller.ClaimController",{

    extend: 'Ext.app.Controller',

    stores: ['ClaimNavTree'],

    views: ['claims.ManageClaims'],

    init: function(application){
        this.control({
            'claimnavtree' : {
                itemclick: this.doMenuSelect
            }
        });
    },

    doMenuSelect: function(tree, record){
        var me = this;
        EMIS.console(record.data);
    }

});
