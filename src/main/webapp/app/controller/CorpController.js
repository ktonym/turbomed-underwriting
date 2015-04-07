Ext.define('EMIS.controller.CorpController', {

    extend: 'Ext.app.Controller',

    views: ['corporate.ManageCorporates'],

    refs: [{
        ref: 'corporateForm',
        selector: 'managecorporates corporateform'
    },
      {
        ref: 'corpList',
        selector: 'managecorporates corplist'
    },
      {
        ref: 'corpFormFieldset',
        selector: 'managecorporates corporateform fieldset'
    },{
        ref: 'addCorpButton',
        selector: 'managecorporates #addCorpBtn'
    },{
        ref: 'delCorpButton',
        selector: 'managecorporates corporateform #deleteBtn'
    },{
        ref: 'saveCorpButton',
        selector: 'managecorporates corporateform #saveBtn'
    },{
        ref: 'corpNameField',
            selector: 'managecorporates corporateform textfield[name=corporateName]'
    }],
    init: function(application){
        this.control({
            'managecorporates #addCorpBtn': {
                click: this.doAddCorporate
            },
            'managecorporates corplist':{
                itemclick: this.doSelectCorporate,
                viewready: this.doInitStore
            },
            'managecorporates corporateform': {
                afterrender: this.doAddCorporate
            },
            'managecorporates corporateform fieldset': {
                click: this.doRefreshCorpList
            },
            'managecorporates corporateform #saveBtn': {
                click: this.doSaveCorporate
            },
            'managecorporates corporateform #deleteBtn': {
                click: this.doDeleteCorporate
            }
        });
    },

    doInitStore: function(){
        this.getCorpList().getStore().load()
    },

    doRefreshCorpList: function(){
        this.getCorpList().getStore().load()
    },

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

    doSelectCorporate: function(grid, record){
        var me = this;
        me.getCorporateForm().loadRecord(record);
        me.getCorpFormFieldset().setTitle('Edit corporate ' + record.data.corporateName);
        me.getCorpNameField().disable();
        me.getDelCorpButton().enable();
    },

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
    }


});
