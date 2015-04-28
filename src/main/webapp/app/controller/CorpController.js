Ext.define('EMIS.controller.CorpController', {

    extend: 'Ext.app.Controller',

    stores: ['Corporate','CorpTree','CorpAnniv','Category','Principal'],

    views: ['corporate.ManageCorporates','corporate.PrincipalWindow', 'CtxMenu'],

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
        ref: 'principalForm',
        selector: 'principalwindow #principalform'
    },{
        ref: 'principalFormFieldset',
        selector: 'principalwindow fieldset'
    },{
        ref: 'deletePrinButton',
        selector: 'principalwindow #deleteBtn'
    },{
        ref: 'savePrincButton',
        selector: 'principalwindow #saveBtn'
    },{
        ref: 'addMemberButton',
        selector: 'principalwindow #addMemberBtn'
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
        ref: 'addAnnivButton',
        selector: 'managecorporates corporateform #addAnnivBtn'
    },{
        ref: 'addCategoryButton',
        selector: 'managecorporates annivform #addCategoryBtn'
    },{
        ref: 'delCorpButton',
        selector: 'managecorporates corporateform #deleteBtn'
    },{
        ref: 'deleteCatButton',
        selector: 'managecorporates categoryform #deleteBtn'
    },{
        ref: 'addPrincipalButton',
        selector: 'managecorporates categoryform #addPrincipalBtn'
    },{
        ref: 'deleteAnnivButton',
        selector: 'managecorporates annivform #deleteBtn'
    },{
        ref: 'saveAnnivButton',
        selector: 'managecorporates annivform #saveBtn'
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
            'managecorporates corporateform #addAnnivBtn': {
                click: this.doAddAnniv
            },
            'managecorporates annivform #saveBtn': {
                click: this.doSaveAnniv
            },
            'managecorporates annivform #deleteBtn': {
                click: this.doDeleteAnniv
            },
            'managecorporates annivform #addCategoryBtn':{
                click: this.doAddCategory
            },
            'managecorporates categoryform #addPrincipalBtn':{
                click: this.doAddPrincipal
            },
            'managecorporates corptree':{
                itemclick: this.doSelectTreeItem,
                itemcontextmenu: this.doRightClick
            },
            'managecorporates corporateform': {
                afterrender: this.doAddCorporate
            },
            'managecorporates corporateform #saveBtn': {
                click: this.doSaveCorporate
            },
            'managecorporates corporateform #deleteBtn': {
                click: this.doDeleteCorporate
            },
            'ctxMenu menuitem[text=Edit]' : {
                click : this.doEditItem
            },
        });
    },

    doAddCorporate: function(){
        var me = this;
        me.getCorpFormFieldset().setTitle('Add New Corporate');
        var newCorpRec = Ext.create('EMIS.model.Corporate');
        me.getCorporateForm().loadRecord(newCorpRec);
        me.getDelCorpButton().disable();
        me.getAddAnnivButton().disable();
        me.getAdminCards().getLayout().setActiveItem(me.getCorporateForm());
    },

    doSaveCorporate: function(){
        var me = this;
        var rec = me.getCorporateForm().getRecord();
        if (rec !== null){
            me.getCorporateForm().updateRecord();
            var errs = rec.validate();
            if(errs.isValid()){
                rec.save({
                    success: function(record){
                        me.getCorpFormFieldset().setTitle('Edit corporate ' + record.get('corporateName'));
                        me.getDelCorpButton().enable();
                        me.getAddAnnivButton().enable();
                        me.getCorporateStore().load();
                        me.doRefreshTree();
                        //Ext.Msg.alert('Save success','Created ' + record.get('corporateName'));
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

    doAddAnniv: function(){
        var me = this;
        var corporate = me.getCorporateForm().getRecord();
        var newRec = Ext.create('EMIS.model.CorpAnniv',{
            'idCorporate': corporate.get('idCorporate')
        });
        me.getAnnivForm().loadRecord(newRec);
        me.getAnnivFormFieldset().setTitle('Add Anniversary to ' + corporate.get('corporateName'));
        me.getDeleteAnnivButton().disable();
        me.getAddCategoryButton().disable();
        me.getAdminCards().getLayout().setActiveItem(me.getAnnivForm());
    },

    doSaveAnniv: function(){
        var me = this;
        var rec = me.getAnnivForm().getRecord();
        EMIS.console(rec);
        if (rec !== null){
            me.getAnnivForm().updateRecord();
            var errs = rec.validate();
            if (errs.isValid()){
                rec.save({
                    success: function(record){
                        me.getAnnivFormFieldset().setTitle('Edit Anniversary for ' + record.get('corporateName'));
                        me.getDeleteAnnivButton().enable();
                        me.getAddCategoryButton().enable();
                        me.getCorpAnnivStore().load();
                        me.doRefreshTree();
                    },
                    failure: function(rec,operation){
                        Ext.Msg.alert('Save Failure', operation.request.scope.reader.jsonData.msg);
                    }
                });
            } else {
                me.getAnnivForm().getForm().markInvalid(errs);
                Ext.Msg.alert('Invalid Fields', 'Please fix the invalid entries!');
            }
        }
    },

    doDeleteAnniv: function(){
        var me = this;
        var rec = me.getAnnivForm().getRecord();
        Ext.Msg.confirm('Confirm Delete', 'Are you sure you want to delete this anniversary?', function(btn) {
            if(btn === 'yes'){
                rec.destroy({
                   success: function(){
                       me.getCorpAnnivStore().load();
                       me.getAdminCards().getLayout().setActiveItem(0);
                       me.doRefreshTree();
                   } ,
                   failure: function(){
                       Ext.Msg.alert('Delete Failure', operation.request.scope.reader.jsonData.msg);
                   }
                });
            }
        });
    },

    doAddCategory: function(){
        var me = this;
        var corpAnniv = me.getAnnivForm().getRecord();
        var newRec = Ext.create('EMIS.model.Category',{
           'idCorpAnniv': corpAnniv.get('idCorpAnniv')
        });
        me.getCategoryForm().loadRecord(newRec);
        me.getCategoryFormFieldset().setTitle('Add Category to anniversary:' + corpAnniv.get('anniv'));
        me.getDeleteCatButton().disable();
        me.getAddPrincipalButton().disable();
        me.getAdminCards().getLayout().setActiveItem(me.getCategoryForm());
    },

    doSaveCategory: function(){
        var me = this;
        var rec = me.getCategoryForm().getRecord();
        EMIS.console(rec);
        if(rec !== null ){
            me.getCategoryForm().updateRecord();
            var errs = rec.validate();
            if (errs.isValid()){
                rec.save({
                    success: function(record){
                        me.getCategoryFormFieldset().setTitle('Edit Category for anniversary ' + record.get('anniv'));
                        me.getDeleteCatButton().enable();
                        me.getAddPrincipalButton().enable();
                        // TODO add lower-level entity
                        me.getCategoryStore().load();
                        me.doRefreshTree();
                    },
                    failure: function(rec, operation){
                        Ext.Msg.alert('Save Failure', operation.request.scope.reader.jsonData.msg);
                    }
                });
            } else {
                me.getCategoryForm().getForm().markInvalid(errs);
                Ext.Msg.alert('Save Failure', 'Please fix the invalid entries!');
            }
        }
    },

    doDeleteCategory: function(){
        var me = this;
        var rec = me.getCategoryForm().getRecord();
        Ext.Msg.confirm('Confirm Delete', 'Are you sure you want to delete this category?', function(btn){
           if (btn === 'yes'){
               rec.destroy({
                   success: function(){
                       me.getCategoryStore().load();
                       me.getAdminCards().getLayout().setActiveItem(0);
                       me.doRefreshTree();
                   },
                   failure: function(rec, operation){
                       Ext.Msg.alert('Delete Failure', operation.request.scope.reader.jsonData.msg);
                   }
               });
           }
        });
    },

    doAddPrincipal: function(){
        var me = this;
        var categoryRec = me.getCategoryForm().getRecord();
        var newRec = Ext.create('EMIS.model.Principal',{
           'idCategory': categoryRec.get('idCategory')
        });
        me.getPrincipalForm().loadRecord(newRec);
        me.getPrincipalFormFieldset().setTitle('Add Principal to Category ' + categoryRec.get('cat'));
        me.getDeletePrinButton().disable();
        me.getAddMemberButton().disable();

    },

    doSavePrincipal: function(){
        var me = this;
        var rec = me.getPrincipalForm().getRecord();
        EMIS.console(rec);
        if (rec !== null){
            me.getPrincipalForm().updateRecord();
            var errs = rec.validate();
            if(errs.isValid()){
                 rec.save({
                     success: function(record){
                         me.getPrincipalFormFieldset().setTitle('Edit Principal: ' + record.get('fullName'));
                         me.getDeletePrinButton().enable();
                         me.getAddMemberButton().enable();
                         me.getPrincipalStore().load();
                     },
                     failure: function(rec, operation){
                          Ext.Msg.alert('Save Failure', operation.request.scope.reader.jsonData.msg);
                     }
                 });
            }
        } else {
            me.getPrincipalForm().getForm().markInvalid(errs);
            Ext.Msg.alert('Save Failure','Fix the invalid entries');
        }
    },

    doDeletePrincipal: function(){
        var me = this;
        var rec = me.getPrincipalForm().getRecord();
        Ext.Msg.confirm('Confirm Delete', 'Are you sure you want to delete this principal?',function(btn){
            if(btn === 'yes'){
                rec.destroy({
                    success: function(){
                        me.getPrincipalStore().load();
                        //TODO loop through the whole process again, upon acceptance by user
                    },
                    failure: function(rec,operation){
                        Ext.Msg.alert('Delete Failure', operation.request.scope.reader.jsonData.msg);
                    }
                });
            }
        });
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
                me.getCategoryFormFieldset().setTitle('Edit Category to anniversary ' + rec.get('anniv'));
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
    doRightClick: function(view, record, item, index, e){
        //stop the default action
        e.stopEvent();
        //save the current selected record
        //this.application.currentRecord = record;
        EMIS.console(record);
        //if (record.get('depth') === 2 ) {
        // addMenu = 'addmenu';
        ctxmenu = Ext.widget('ctxmenu')
        // addMenu.showAt(e.getXY());
        ctxmenu.showAt(e.getXY());
    },
    doEditItem: function(){
        EMIS.console('Edit chosen!');
    }


});
