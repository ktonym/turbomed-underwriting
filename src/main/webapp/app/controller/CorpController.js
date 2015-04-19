Ext.define('EMIS.controller.CorpController', {

    extend: 'Ext.app.Controller',

    stores: ['Corporate','CorpTree','CorpAnniv','Category'],

    views: ['corporate.ManageCorporates'],

    refs: [{
        ref: 'corporateForm',
        selector: 'managecorporates corporateform'
    },{
        ref: 'annivForm',
        selector: 'managecorporates annivform'
    },{
        ref: 'categoryForm',
        selector: 'managecorporates categoryform'
    },{
        ref: 'annivFormFieldset',
        selector: 'managecorporates annivform fieldset'
    },{
        ref: 'corpTree',
        selector: 'managecorporates corptree'
    },{
        ref: 'corpFormFieldset',
        selector: 'managecorporates corporateform fieldset'
    },{
        ref: 'categoryFormFieldset',
        selector: 'managecorporates categoryform fieldset'
    },{
        ref: 'addCorpButton',
        selector: 'managecorporates #addCorpBtn'
    },{
        ref: 'delCorpButton',
        selector: 'managecorporates corporateform #deleteBtn'
    },{
        ref: 'deleteCatButton',
        selector: 'managecorporates categoryform #deleteBtn'
    },{
        ref: 'deleteAnnivButton',
        selector: 'managecorporates annivform #deleteBtn'
    },{
        ref: 'saveCorpButton',
        selector: 'managecorporates corporateform #saveBtn'
    },{
        ref: 'corpNameField',
        selector: 'managecorporates corporateform textfield[name=corporateName]'
    },{
        ref: 'adminCards',
        selector: 'managecorporates #adminCards'
    }],
    init: function(application){
        this.control({
            'managecorporates #addCorpBtn': {
                click: this.doAddCorporate
            },
            'managecorporates corptree':{
                itemclick: this.doSelectTreeItem
            },
            'managecorporates corporateform': {
                afterrender: this.doAddCorporate
            },
            'managecorporates corporateform #saveBtn': {
                click: this.doSaveCorporate
            },
            'managecorporates corporateform #deleteBtn': {
                click: this.doDeleteCorporate
            }
        });
    },

//    doInitStore: function(){
//        this.getCorpList().getStore().load()
//    },
//
//    doRefreshCorpList: function(){
//        this.getCorpList().getStore().load()
//    },

    doAddCorporate: function(){
        var me = this;
        me.getCorpFormFieldset().setTitle('Add New Corporate');
        var newCorpRec = Ext.create('EMIS.model.Corporate');
        me.getCorporateForm().loadRecord(newCorpRec);
        me.getDelCorpButton().disable();
    },

    doDeleteCorporate: function(){
        var me = this;
        var rec = me.getCorporateForm().getRecord();
        Ext.Msg.confirm('Confirm Delete Corporate', 'Are you sure you want to delete corporate ' +
            rec.get('corporateName') + '?', function(btn){
                if(btn ===  'yes'){
                    rec.destroy({
                        success: function(rec,operation){
                            Ext.Msg.alert('Delete success', operation.request.scope.reader.jsonData.msg);
                        },
                        failure: function(rec,operation){
                            Ext.Msg.alert('Delete failure', operation.request.scope.reader.jsonData.msg);
                        }
                    });
                }
        });
    },

    doSetTreeIcon: function(store, node, refNode, eOpts){
        var nodeType = node.getId().subString(0,1);
        if(nodeType === 'S'){
            node.set('iconCls','company');
        } else if(nodeType === 'A'){
            node.set('iconCls','project');
        } else if(nodeType === 'C'){
            node.set('iconCls', 'task');
        }
    },

    doSelectTreeItem: function(tree, record){
        var me = this;
        var recIdSplit = record.getId().split('_');
        EMIS.console(recIdSplit);
        if(recIdSplit[0]==='C'){
            var idCategory = Ext.Number.from(recIdSplit[1]);
            var rec = me.getCategoryStore().getById(idCategory);
            if (!Ext.isEmpty(rec)){
                me.getCategoryForm().loadRecord(rec);
                me.getCategoryFormFieldset().setTitle('Edit Category for ' + rec.get('anniv'));
                me.getDeleteCatButton().enable();
                me.getAdminCards().getLayout().setActiveItem(me.getCategoryForm());
            }
        } else if (recIdSplit[0]==='A'){
            var idAnniversary = Ext.Number.from(recIdSplit[1]);
            var rec = me.getCorpAnnivStore().getById(idAnniversary);
            if (!Ext.isEmpty(rec)){
                me.getAnnivForm().loadRecord(rec);
                me.getAnnivFormFieldset().setTitle('Edit Cover Period for ' + rec.get('corporateName'));
                me.getDeleteAnnivButton().enable();
                me.getAdminCards().getLayout().setActiveItem(me.getAnnivForm());
            }
        } else if (recIdSplit[0]==='S'){
            var idCorporate = Ext.Number.from(recIdSplit[1]);
            var rec = me.getCorporateStore().getById(idCorporate);
            if (!Ext.isEmpty(rec)){
                me.getCorporateForm().loadRecord(rec);
                me.getCorpFormFieldset().setTitle('Edit Scheme ');
                me.getDelCorpButton().enable();
                me.getAdminCards().getLayout().setActiveItem(me.getCorporateForm());
            }
        }
    },

//    doSelectCorporate: function(grid, record){
//        var me = this;
//        me.getCorporateForm().loadRecord(record);
//        me.getCorpFormFieldset().setTitle('Edit corporate ' + record.data.corporateName);
//        me.getCorpNameField().disable();
//        me.getDelCorpButton().enable();
//    },

    doSaveCorporate: function(){
        var me = this;
        var rec = me.getCorporateForm().getRecord();
        if (rec !== null){
            me.getCorporateForm().updateRecord();
            var errs = rec.validate();
            if(errs.isValid()){
                rec.save({
                    success: function(record,operation){
//                        if(typeof record.store === 'undefined'){
//                            me.getCorpList().getStore().add(record);
//                            me.getCorpList().getSelectionModel().select(record,true);
//                        }
                        me.getCorpFormFieldset().setTitle('Edit corporate ' + record.data.corporateName);
                        me.getDelCorpButton().enable();
                        Ext.Msg.alert('Save success','Created ' + record.data.corporateName);
                    },
                    failure: function(rec,operation){
                        Ext.Msg.alert('Save failed', operation.request.scope.reader.jsonData.msg);
                    }
                });
            } else {
                me.getCorporateForm().getForm().markInvalid(errs);
                Ext.Msg.alert('Invalid Fields','Please fix the invalid entries');
            }
        }
    },

    doRefreshTree: function() {
        var me = this;
        me.getCorpTreeStore().load();
    },
    doExpandTree: function() {
        this.getCorpTree().expandAll();
    },
    doCollapseTree: function() {
        this.getCorpTree().collapseAll();
    },
    doDeselectAll: function() {
        var me = this;
        var recs = me.getCorpTree().getView().getSelectionModel().getSelection();
        me.getCorpTree().getView().deselect(recs, false);
    }


});
