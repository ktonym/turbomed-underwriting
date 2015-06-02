Ext.define('EMIS.controller.AdminController',{

    extend: 'Ext.app.Controller',

    stores: ['AdminNavTree'],

    views: ['admin.ManageAdmin'],

    refs: [
        {
            ref: 'intermediaryForm',
            selector: 'manageadmin intermediaries'
        },{
            ref: 'premRatesForm',
            selector: 'manageadmin premiumrates'
        },{
            ref: 'accountMappingForm',
            selector: 'manageadmin accountmapping'
        },{
            ref: 'adminCards',
            selector: 'manageadmin #manageAdminCards'
        },{
            ref: 'benefitGrid',
            selector: 'manageadmin benefitgrid'
        }

    ],

    init: function(application){

        this.control({
            'manageadmin adminnavtree': {
               itemclick: this.doSelectMenuItem
            }
        });

    },

    doSelectMenuItem: function(tree, record){

        var me = this;

        var selItem = record.data.text;

        if (selItem === 'Account Mapping'){
            me.getAdminCards().getLayout().setActiveItem(me.getAccountMappingForm());
        } else if (selItem === 'Intermediaries'){
            me.getAdminCards().getLayout().setActiveItem(me.getIntermediaryForm());
        } else if (selItem === 'Premium Rates'){
            me.getAdminCards().getLayout().setActiveItem(me.getPremRatesForm());
        } else if (selItem === 'Benefits'){
            me.getAdminCards().getLayout().setActiveItem(me.getBenefitGrid());
        }

    }

});
