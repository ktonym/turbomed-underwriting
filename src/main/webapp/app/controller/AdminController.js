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
        },{
            ref: 'addBenefitButton',
            selector: 'manageadmin benefitgrid #add'
        },{
            ref: 'saveBenefitButton',
            selector: 'manageadmin benefitgrid #save'
        },{
            ref: 'cancelBenChanges',
            selector: 'manageadmin benefitgrid #cancel'
        }

    ],

    init: function(application){

        this.control({
            'manageadmin adminnavtree': {
               itemclick: this.doSelectMenuItem
            },
            'manageadmin benefitgrid': {
                edit: this.doEditBenefit
            },
            'manageadmin benefitgrid #add': {
                click: this.doAddBenefit
            },
            'manageadmin benefitgrid #save':{
                click: this.doSaveBenefit
            },
            'manageadmin benefitgrid #cancel':{
                click: this.doCancelEdit
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

    },

    doAddBenefit: function(button, e, options){

        var grid =  button.up('benefitgrid'),
            store = grid.getStore(),
            modelName = store.getModel().getName(),
            cellEditing = grid.getPlugin('cellplugin');

        store.insert(0,Ext.create(modelName));

        cellEditing.startEditByPosition({row: 0, column: 1});
    },

//    doEditBenefit: function(editor, context, options){
//        context.record.set()
//    },

    doSaveBenefit: function(button, e, options){

        var grid = button.up('benefitgrid'),
            store = grid.getStore(),
            errors = grid.validate();

        if (errors === undefined){
            store.sync();
        } else {
            Ext.Msg.alert(errors);
        }

    },

    doAddProvider: function(){

    },

    doSaveProvider: function(){

    }


});
