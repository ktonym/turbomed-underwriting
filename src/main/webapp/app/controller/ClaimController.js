Ext.define("EMIS.controller.ClaimController",{

    extend: 'Ext.app.Controller',

    stores: ['ClaimNavTree'],

    views: ['claims.ManageClaims'],

    refs: [
        {
            ref: 'claimCards',
            selector: 'manageclaims #clmCards'
        },
        {
            ref: 'claimEntryForm',
            selector: 'manageclaims claimentry'
        },
        {
            ref: 'claimVetForm',
            selector: 'manageclaims claimvetting'
        },
        {
            ref: 'claimPayForm',
            selector: 'manageclaims claimpayment'
        }
    ],

    init: function(application){
        this.control({
            'claimnavtree' : {
                itemclick: this.doMenuSelect
            }
        });
    },

    doMenuSelect: function(tree, record){

        var me = this;

        var selItem = record.get('text');

        if (selItem === 'Enter Bill') {
            me.getClaimCards().getLayout().setActiveItem(me.getClaimEntryForm());
        } else if (selItem === 'Vet Bill') {
            me.getClaimCards().getLayout().setActiveItem(me.getClaimVetForm());
        } else if (selItem === 'Pay Claim') {
            me.getClaimCards().getLayout().setActiveItem(me.getClaimPayForm());
        } else if (selItem === 'Reconcilliation') {
            Ext.Msg.alert('Coming soon!','Work in progress..');
        } else if (selItem === 'Dashboard') {
            Ext.Msg.alert('Coming soon!','Work in progress..');
        }
    }

});
